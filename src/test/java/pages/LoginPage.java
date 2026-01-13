package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    By emailInput = By.name("email");
    By passwordInput = By.name("password");
    By loginButton = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("https://automationexercise.com/login");
    }

    public void login(String email, String password) {

        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);

        WebElement loginBtn = driver.findElement(loginButton);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", loginBtn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));

        loginBtn.click();
    }
}
