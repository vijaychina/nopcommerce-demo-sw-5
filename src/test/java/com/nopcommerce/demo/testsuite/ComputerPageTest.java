package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {
    ComputerPage computerPage;
    DesktopPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        computerPage = new ComputerPage();
        desktopsPage = new DesktopPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }
    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        //  Click on Computer tab
        computerPage.clickOnComputerTab();
        //   Verify "Computer" text
        String expectedText = "Computers";
        Assert.assertEquals(computerPage.verifyTextComputer(),expectedText,"Text not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
//Click on Computer tab
        computerPage.clickOnComputerTab();
//   Click on Desktops link
        computerPage.clickOnDesktopsLink();
//   Verify "Desktops" text
        String expectedMessage = "Desktops";
        Assert.assertEquals(desktopsPage.verifyTextDesktops(),expectedMessage,"error message");
    }

    @Test(groups = {"smoke","regression"},dataProvider = "buildyourowncomputer", dataProviderClass = TestData.class)

    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram,
                                                                                    String hdd, String os, String software) {
        //Click on Computer tab
        computerPage.clickOnComputerTab();
        //   Click on Desktops link
        computerPage.clickOnDesktopsLink();
        //   Click on product name "Build your own computer"
        buildYourOwnComputerPage.clickOnBuildYourOwnComputerProduct();
        //   Select processor "processor"
        buildYourOwnComputerPage.selectProcessor();
        buildYourOwnComputerPage.selectRAM();
        buildYourOwnComputerPage.selectHDD();
        buildYourOwnComputerPage.selectOsRadioButton();
//        buildYourOwnComputerPage.selectOsRadioButton();

        //   Select RAM "ram"
        //   Select HDD "hdd"
        //   Select OS "os"
        //   Select Software "software"
        //buildYourOwnComputerPage.differentSelection("radioButtonSelection");
        //   Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartButton();
        //   Verify message "The product has been added to your shopping cart"
        String expectedMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(expectedMessage, buildYourOwnComputerPage.verifyTheProductHasBeenAddedToYourShoppingCart());
    }

}