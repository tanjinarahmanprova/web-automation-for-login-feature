package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "invalidLoginCredentials")
    public static Object[][] invalidLoginData()
    {
        Object[][] data ={{"rijofo6757@javnoi.com","hysa@y&24$tf","Your email or password is incorrect!"},
                          {"rijofo6757@jav.co","eyxTSnAQu8CiBX@",""},
                          {"rijofo6757@jav.com","hysa@y&24$tf","Your email or password is incorrect!"},
                          {"rijofo6757@","eyxTSnAQu8CiBX@",""},
                          {"rijofo6757@javnoi.com","",""},
                          {"","eyxTSnAQu8CiBX@",""},
                          {"","",""}};
        return data;
    }

}
