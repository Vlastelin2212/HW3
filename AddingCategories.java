import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static java.lang.Thread.sleep;

class AddingCategories {
    public static final String BROWSER = "Firefox";

    public static void shortSleep() throws InterruptedException {
        sleep(1000);
    }

    public static void mediumSleep() throws InterruptedException {
        sleep(2500);
    }

    public static void longSleep() throws InterruptedException {
        sleep(5000);
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver",
                AddingCategories.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

    public static WebDriver initFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver",
                AddingCategories.class.getResource("geckodriver.exe").getPath());
        return new FirefoxDriver();
    }

    public static void login(WebDriver driver) throws InterruptedException {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
        // shortSleep();
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        shortSleep();
        WebElement button = driver.findElement(By.name("submitLogin"));
        shortSleep();
        button.click();
        mediumSleep();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver initedDriver;
        if (BROWSER.equals("Chrome")) {
            initedDriver = initChromeDriver();
        } else if (BROWSER.equals("Firefox")) {
            initedDriver = initFirefoxDriver();
        } else {
            System.out.println("Unavailable webdriver");
            return;
        }

        EventFiringWebDriver driver = new EventFiringWebDriver(initedDriver);
        driver.register(new EventHandler());
        driver.manage().window().maximize();
        login(driver);
        // Выбрать пункт меню Каталог -> категории и дождаться загрузки страницы управления категориями.
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subtab-AdminCatalog\"]"))).build().perform();
        mediumSleep();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subtab-AdminCategories\"]")))
                .click().build().perform();
        mediumSleep();
        // Нажать «Добавить категорию» для перехода к созданию новой категории.
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"page-header-desc-category-new_category\"]")))
                .build().perform();
        mediumSleep();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"page-header-desc-category-new_category\"]")))
                .click().build().perform();
        mediumSleep();
        // После загрузки страницы ввести название новой категории и сохранить изменения
        String categoryName = "джинсы";
        driver.findElement(By.id("name_1")).sendKeys(categoryName);
        WebElement saveButton = driver.findElement(By.id("category_form_submit_btn"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        mediumSleep();
        action.moveToElement(saveButton).click().build().perform();
        mediumSleep();
        // Отфильтровать таблицу категорий по имени и дождаться там появления записи созданной категории
        driver.findElement(By.cssSelector(
                "#table-category > thead > tr.nodrag.nodrop.filter.row_hover > th:nth-child(3) > input")
        ).sendKeys(categoryName);
        shortSleep();
        action.moveToElement(driver.findElement(By.id("submitFilterButtoncategory")))
                .build().perform();
        mediumSleep();
        action.moveToElement(driver.findElement(By.id("submitFilterButtoncategory")))
                .click().build().perform();
        mediumSleep();
        System.out.println("OK");
        mediumSleep();
        driver.quit();
    }
}
