package com.central.pages;

import com.central.utilis.logger.ILogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage implements ILogger {

    WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath="//a[normalize-space()='HITLER']")
    private WebElement hitlerTag;

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    private WebElement signIn;

    @FindBy(xpath = "//a[@class='nav-link active ng-binding']")
    private WebElement tagFeed;

    @FindBy(xpath = "//a[normalize-space()='2']")
    private WebElement pageNumber2;

    @FindBy(xpath="//a[normalize-space()='Global Feed']")
    private WebElement globalFeed;

    @FindAll({@FindBy(xpath = "//a[@class='tag-default tag-pill ng-binding ng-scope']")})
    private List<WebElement> allTagsInList;






    public HomePage hoverFilterTag (){
        Actions actions = new Actions(driver);
        String color = hitlerTag.getCssValue("color");
        actions.moveToElement(hitlerTag).perform();
        String backgroundColor = hitlerTag.getCssValue("background-color");
        System.out.println("TextColor : " + color );
        System.out.println("Background Color : " + backgroundColor);
        Assert.assertNotEquals(color,backgroundColor,"Hovered Tag is not highlighted");
        return new HomePage(driver);
    }

    public HomePage selectTag (){
        hitlerTag.click();
        String selectedTagFeedTitle = tagFeed.getText();
        Assert.assertEquals(selectedTagFeedTitle,"HITLER","Selected Tag Feed is not displayed");
        return new HomePage(driver);
    }

    public HomePage pageNavigationForSelectedFilter() throws InterruptedException {
      selectTag();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageNumber2);
        pageNumber2.click();
        String selectedTagFeedTitle = tagFeed.getText();
        Assert.assertEquals(selectedTagFeedTitle,"HITLER","Selected Tag Feed is not displayed");
        return new HomePage(driver);
    }


    public HomePage VerifySelectedTagIsDismissed() throws InterruptedException {
        selectTag();
        String color = hitlerTag.getCssValue("color");
        globalFeed.click();
        String onDismissColor = hitlerTag.getCssValue("color");
        System.out.println("TextColor : " + color );
        System.out.println("onDismiss Color : " + onDismissColor);
        Assert.assertNotEquals(color,onDismissColor,"Selected Tag Feed is not displayed");
        return new HomePage(driver);
    }


}
