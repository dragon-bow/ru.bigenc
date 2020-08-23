package test;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.data.ElementNameData;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class BaseTest extends WebDriverSettings {

    @Test
    @Description("Проверяет работу поиска по слову \"футбол\" и то, что первый результат соответствует \"КОНФЕДЕРА́ЦИЯ ФУТБО́ЛА СЕ́ВЕРНОЙ...\".")
    public void assertSearch() throws InterruptedException {
        driver.get("https://bigenc.ru/");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(ElementNameData.TITLE, actualTitle);
        // Assert.assertTrue(actualTitle.equals(ElementNameData.title));
        WebElement element = driver.findElement(By.cssSelector(".description-inner .search-opener"));
        element.click();
        element = driver.findElement(By.cssSelector(".search-frame .search__field .text"));
        element.sendKeys(ElementNameData.RU_FOR_SEARCH_ITEM);
        element = driver.findElement(By.cssSelector(".btn-search"));
        element.click();
        String actualfirstResult = driver.findElements(By.cssSelector(".description .title")).get(1).getText();
        Assert.assertEquals(ElementNameData.FIRST_RESULT, actualfirstResult);
    }

    @Test
    @Description("Проверяет, что на странице отображаются 4 рубрики: \"РОССИЯ [2004]\", \"РУБРИКИ\", \"ПЕРСОНАЛИИ\", \"СЛОВАРЬ\"")
    public void assertHeadersOnPage() {
        driver.get("https://bigenc.ru/");
        WebElement element = driver.findElements(By.cssSelector(".item-container")).get(1);
        WebElement headersElement = element.findElements(By.cssSelector(".x-nav-opener")).get(0);
        Assert.assertEquals(ElementNameData.FIRST_HEADER, headersElement.getText());
        headersElement.isDisplayed();
        headersElement = element.findElement(By.cssSelector(".nav-opener"));
        Assert.assertEquals(ElementNameData.SECOND_HEADER, headersElement.getText());
        headersElement.isDisplayed();
        headersElement = element.findElements(By.cssSelector(".x-nav-opener")).get(1);
        Assert.assertEquals(ElementNameData.THIRD_HEADER, headersElement.getText());
        headersElement.isDisplayed();
        headersElement = element.findElements(By.cssSelector(".x-nav-opener")).get(2);
        Assert.assertEquals(ElementNameData.FOURTH_HEADER, headersElement.getText());
        headersElement.isDisplayed();
    }


    @Test
    @Description("Проверяет, что первая категория соотвествует \"Археология\", последняя - \"Языкознание\" и категории отображаются на сайте.")
    public void assertCategoriesOnCategories() {
        driver.get("https://bigenc.ru/");
        WebElement element = driver.findElements(By.cssSelector(".item-container")).get(1).findElement(By.cssSelector(".nav-opener"));
        element.click();
        element = driver.findElements(By.cssSelector(".rubrics a")).get(0);
        Assert.assertEquals(ElementNameData.FIRST_CATEGORIES, element.getText());
        element.isDisplayed();
        element = driver.findElements(By.cssSelector(".rubrics a")).get(27);
        Assert.assertEquals(ElementNameData.LAST_CATEGORIES, element.getText());
        element.isDisplayed();
    }


}
