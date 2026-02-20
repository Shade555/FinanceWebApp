import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestLogin {

    // Constants for element locators
    private static final String USERNAME_LOCATOR = "username";
    private static final String PASSWORD_LOCATOR = "password";
    private static final String LOGIN_BTN_XPATH = "//html//body//div//div//div[2]//form//button";
    private static final String URL = "http://localhost:8081/FinanceWebApp/login.jsp";

    public static void main(String[] args) {

        // Setup WebDriver
        WebDriver driver = setupWebDriver();

        try {
            // Navigate to login page
            driver.get(URL);

            // Perform login
            performLogin(driver);

            // Validate login success (optional step depending on your app)
            validateLogin(driver);

            System.out.println("Test completed successfully!");

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
        } finally {
            // Quit the driver
            driver.quit();
        }
    }

    // Setup method to initialize WebDriver
    private static WebDriver setupWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    // Method to perform login
    private static void performLogin(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the username field to be visible before interacting with it
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(USERNAME_LOCATOR)));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(PASSWORD_LOCATOR)));

        // Filling in login credentials
        //username.sendKeys("abhi@123");
        //password.sendKeys("Abhishek@12345");
        username.sendKeys("");
        password.sendKeys("admin");
        // Wait for the login button to be clickable before clicking it
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGIN_BTN_XPATH)));
        loginBtn.click();
    }

    // Optional: Method to validate successful login (e.g., by checking some page element after login)
    private static void validateLogin(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Example: waiting for a specific element on the post-login page
            WebElement dashboardElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/nav/span"))); // Update with actual element
            System.out.println("Login successful, dashboard element found: " + dashboardElement.getText());
        } catch (Exception e) {
            //System.err.println("Login failed or dashboard element not found!");
            System.err.println("Login failed one or both of the fields are empty!");
        }
    }
}
