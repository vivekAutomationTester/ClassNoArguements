package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import testdata.datasources.SearchData;

import java.io.IOException;

public class LoginTestWithExcel extends BaseTest {

//    @Test(dataProvider = "searchData", dataProviderClass = SearchData.class)
//    public void performSearch(String username, String password) throws Exception {
//        LoginPage loginPage = new LoginPage(webdriver.get(), reportManager);
//        loginPage.openPage();
//        loginPage.login(username, password);
//    }


    public static void main(String args[]) throws IOException {
        for (int i=0; i<=20; i++)
            Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
    }
}
