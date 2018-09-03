import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class EventHandler implements WebDriverEventListener {

    private static final Logger LOG = LogManager.getLogger(EventHandler.class);

    @Override
    public void beforeChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3) {
    }

    @Override
    public void afterChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3) {
    }

    @Override
    public void beforeAlertAccept(WebDriver var1) {
    }

    @Override
    public void afterAlertAccept(WebDriver var1) {
    }

    @Override
    public void afterAlertDismiss(WebDriver var1) {
    }

    @Override
    public void beforeAlertDismiss(WebDriver var1) {
    }

    @Override
    public void beforeNavigateRefresh(WebDriver var1) {
    }

    @Override
    public void afterNavigateRefresh(WebDriver var1) {
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOG.info("Should be " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        LOG.info("Element found");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOG.info("Should click " + element.getTagName());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        LOG.info("Clicked successfull");
    }
}