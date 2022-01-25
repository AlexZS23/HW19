import HomeWork19.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class WebSiteTestSuite extends BaseTest {
    //1. Написать тест для ресурса https://theautomationzone.blogspot.com/ который аплоадит файл
    @Test
    public void uploadFile() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        By selectFile = By.xpath("//input[@id='photo']");
        webDriver.findElement(selectFile).sendKeys("D:\\Lesha\\QA\\Hillel\\Automation\\My course\\Lesson 19\\HomeWork19\\src\\main\\resources\\fileForUpload.txt");
        webDriver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    // 2. написать тест для ресурса https://theautomationzone.blogspot.com/
    // который рандомно выбирает пункты из таблицы Sample Table of Div
    @Test
    public void randomCheckBox() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        List<WebElement> elementList = webDriver.findElements(By.xpath("//div[@class='divTableCell'][3]"));

        By checkBoxRelative = By.xpath(".//preceding-sibling::div/input");

        WebElement randomCheckBox;

        for (int i = 0; i <= elementList.size(); i++) {
            randomCheckBox = elementList.get(new Random().nextInt(elementList.size()));
            randomCheckBox.findElement(checkBoxRelative).click();

//              Включая проверку если элемент уже выбран
//            if (randomCheckBox.findElement(checkBoxRelative).isSelected()) {
//                continue;
//            } else {
//                randomCheckBox.findElement(checkBoxRelative).click();
//            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //3. Написать тест для ресурса https://www.gurock.com/testrail/ который рандомно
    // кликает один раз на одну из вкладок product, enterprise, pricing, recources
    @Test
    public void randomTab() {
        webDriver.get("https://www.gurock.com/testrail/");
        List<WebElement> tabs = webDriver.findElements(By.xpath("//ul[@class='gk-header-sticky-main-menu']/li[@class='gk-header-sticky-main-menu-item']"));
        WebElement randomTab = tabs.get(new Random().nextInt(tabs.size()));
        randomTab.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
