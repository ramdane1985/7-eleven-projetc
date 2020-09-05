package home;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static home.HomePageWebElements.*;

public class HomePage extends CommonAPI {

    @FindBy(how = How.XPATH,using = logoXP)
    public WebElement logo;

    @FindBy(how = How.XPATH,using = sevenRewardsXP)
    public WebElement sevenRewards;
    @FindBy(how = How.XPATH,using = sevenRewardsValidationXP)
    public WebElement sevenRewardsValidation;

    @FindBy(how = How.XPATH,using = foodButtonXP)
    public WebElement foodButton;
    @FindBy(how = How.XPATH,using = hotFoodButtonXP)
    public WebElement hotFoodButton;
    @FindBy(how = How.XPATH,using = hotFoodButtonValidationXP)
    public WebElement hotFoodButtonValidation;

    @FindBy(how = How.XPATH,using = findStoreXP)
    public WebElement findStore;
    @FindBy(how = How.XPATH,using = searchLocationXP)
    public WebElement searchLocation;
    @FindBy(how = How.CLASS_NAME,using = searchButtonClass)
    public WebElement searchButton;
    @FindBy(how = How.XPATH,using = locationValidationXP)
    public WebElement locationValidation;


    public void setLogo(){
        logo.click();
    }
    public void setSevenRewards(){
        sevenRewards.click();
        String actualText=sevenRewardsValidation.getText();
        String expectText="Earn points on everyday purchases.";
        Assert.assertEquals(actualText,expectText,"text doesn't match");
        sleepFor(3);
    }
    public void setFoodButton(){
        Actions actions =new Actions(driver);
        actions.moveToElement(foodButton).build().perform();
        sleepFor(5);
        hotFoodButton.click();
        sleepFor(3);
        String actualText=hotFoodButtonValidation.getText();
        String expectedText="Tasty Hot Foods";
        Assert.assertEquals(actualText,expectedText,"text doesn't match");
    }
    public void setFindStore(){
        findStore.click();
        sleepFor(3);
        searchLocation.sendKeys(zipCode);
        sleepFor(3);
        searchButton.click();
        sleepFor(3);
        String actualText=locationValidation.getText();
        String expectedText="Get Directions";
        Assert.assertEquals(actualText,expectedText,"text doesn't match");
        sleepFor(3);
    }
}
