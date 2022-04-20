package testdata.datasources;

import library.ExcelManager;
import org.testng.annotations.DataProvider;

public class SearchData {
    @DataProvider(name = "searchData",parallel=true)
    public static Object[][] getSearchData() throws Exception {
        return new ExcelManager("src/test/java/testdata/resources/Search String.xlsx").getData();
    }
}
