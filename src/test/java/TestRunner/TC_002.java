package TestRunner;

import BaseRunner.BaseClass;
import PageObjects.DemoLogin;
import Utilites.ReadConfig;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_002 extends BaseClass {

    public static ReadConfig readConfig;

    //demoUser

    @Test(priority = 1)
      public void  NavigateToDemoUser(){

        driver.navigate().to(ReadConfig.DemoApplicationURL());

        DemoLogin demoLogin = new DemoLogin(driver);
        demoLogin.getDemoLogin().click();

        String dEMOuSERlLogin = driver.getCurrentUrl();

        System.out.println(dEMOuSERlLogin);
        Assert.assertEquals(dEMOuSERlLogin,"https://phptravels.org/index.php?rp=/login");

        }
        @Parameters({"demoUser","demoPassword"})
        @Test(priority = 2)
     public void LoginFunction(String demouser,String demoPassword){

            DemoLogin demoLogin = new DemoLogin(driver);

            demoLogin.getDemoEmail().sendKeys(demouser);
            demoLogin.getDemoPassword().sendKeys(demoPassword);
            demoLogin.getrObotButton().click();
            demoLogin.getDemoUserLoginButton().click();




        }

    }

