package library;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/*
 * Uses Apache POI api
 * Reads Excel
 * returns excel data as an object array
 */

/**
 * The type Excel manager.
 */
public class ExcelManager {

    private Workbook workbook;
    private Sheet worksheet;
    private DataFormatter formatter;

    /**
     * Instantiates a new Excel manager.
     *
     * @param workbookName the workbook name
     * @throws Exception the exception
     */
    public ExcelManager(String workbookName) throws Exception {
        this(workbookName, 0);
    }

    /**
     * Instantiates a new Excel manager.
     *
     * @param workbookName the workbook name
     * @param sheetIndex   the sheet index
     * @throws Exception the exception
     */
    public ExcelManager(String workbookName, int sheetIndex) throws Exception {

        String projecctPath = System.getProperty("user.dir")+  "/";
        workbookName = projecctPath + workbookName;
        File file = new File(workbookName);

        if(!file.exists())
        {
            System.out.println("The data file doesn't exist");
            throw new Exception("The file" + workbookName + " is not found");
        }

        FileInputStream inputStream = new FileInputStream(workbookName);

        // This will support only latest Excel Sheet
        // .xslx format only
        workbook = new XSSFWorkbook(inputStream);
        worksheet = workbook.getSheetAt(sheetIndex);
        formatter = new DataFormatter();
    }

    /**
     * Get data object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    // returns the data present in the Excel Sheet
    // This is the preferred method
    public Object[][] getData()
    { return getData(getLastRow(), getLastCol()); }


    // Get data until specific column
    public Object[][] getDataToSpecificCol(int col) {
        return getData(getLastRow(), col);
    }

    // returns the data present in the Excel Sheet
    private Object[][] getData(int lastRow, int lastCol)
    {
        // Extract the data from the excel and return it as object array

        Object[][] Data = new Object[lastRow-1][lastCol];

        for(int i=0; i<lastRow-1; i++)
        {
            Row row= worksheet.getRow(i+1);
            for (int j=0; j<lastCol; j++) //Loop work for colNum
            {
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    Cell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data
                    else
                    {
                        String value=formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }

        return Data;
    }

    /**
     * Gets last row.
     *
     * @return the last row
     */
    public int getLastRow()
    {
        // Find the last row of data in the excel sheet
        return worksheet.getPhysicalNumberOfRows();
    }

    /**
     * Gets last col.
     *
     * @return the last col
     */
    public int getLastCol()
    {
        // Find the last column of data in the excel sheet
        return worksheet.getRow(0).getLastCellNum();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
// Test the functionality
    public static void main(String[] args) throws Exception {
        // This code tests the library
        // Will not affect the project

        ExcelManager manager = new
                ExcelManager("src/test/java/resources/2020IdeasGrant.xlsx");
        Object[][] test = manager.getData();

        for(int i =0; i<test.length; i++)
        {
            for (int j=0; j<test[i].length; j++)
            {
                System.out.print(test[i][j].toString() + " ");
            }
            System.out.println();
        }
    }
}
