package AutomationOnboarding;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

	public static WebDriver driver;
	static Object data[][];

	static ChromeOptions opt = new ChromeOptions();

	// headless parameter

	// /////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////
	// /////////////// Registration Group ///////////////////
	// //////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"D:/AutomationProject/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver(); // initialize driver

		driver.manage().window().maximize();

		// UseCase1: opening the website
		driver.get("http://10.40.230.109:8080/portal/login");

		// Login Usecase2: Entering Credentials

		driver.findElement(By.xpath("//*[@id='user']")).sendKeys("muzairmaker");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(
				"lahore123");

		driver.findElement(
				By.xpath("//*[@id='consumerForm']/li[3]/table/tbody/tr/td[1]/input"))
				.click();

		// opt.addArguments("--headless");

	}

	@Test(dataProvider = "registrationGroup", dataProviderClass = dataProvider.class)
	public static void registrationSelectionFunction(String dataValues[])
			throws InterruptedException, IOException {

		// Test Common

		System.out.println("*** Into the CustomerRegistration ***");
		System.out.println("length of string : " + dataValues.length);

		String customerType = dataValues[dataValues.length - 1];

		System.out.println("*** Into the CustomerRegistration ***"
				+ customerType);

		// calling classes

		CustomerOnboarding cstOnboard;
		cstOnboard = new CustomerOnboarding();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		if (customerType.equalsIgnoreCase("L0")
				|| customerType.equalsIgnoreCase("L1 Corporate SimSim User")
				|| customerType.equalsIgnoreCase("L1 Guest Corporate SimSim User")
				|| customerType.equalsIgnoreCase("L0 BVS CORPORATE USER")
				|| customerType.equalsIgnoreCase("Remote Zero - Digital Transaction")
				|| customerType.equalsIgnoreCase("Remote Zero - Corporate Sim Sim User")
				|| customerType.equalsIgnoreCase("Guest D/C Block User")
				|| customerType.equalsIgnoreCase("L1")
				|| customerType.equalsIgnoreCase("L0 BVS User")
				|| customerType.equalsIgnoreCase("Merchant Headquarter")) {

			cstOnboard.onBoarding(driver, dataValues[0], dataValues[1],
					dataValues[2], dataValues[3], dataValues[4], dataValues[5],
					dataValues[6], dataValues[7], dataValues[8], dataValues[9],
					dataValues[10], dataValues[11], dataValues[12],
					dataValues[13], dataValues[14], dataValues[15],
					dataValues[16]);

		}

		else if (customerType.equalsIgnoreCase("L2-Individual")
				|| customerType.equalsIgnoreCase("L2 Existing Customer")
				|| customerType.equalsIgnoreCase("L2-Individual-10000")
				|| customerType.equalsIgnoreCase("L2-Individual-250000")
				|| customerType.equalsIgnoreCase("L2-Individual-500000")
				|| customerType.equalsIgnoreCase("L2-Individual-99999")
				|| customerType.equalsIgnoreCase("L2 Individual Staff")
				|| customerType.equalsIgnoreCase("L2 Individual Staff-100000")
				|| customerType.equalsIgnoreCase("L2 Individual Staff-2500000")
				|| customerType.equalsIgnoreCase("L2 Individual Staff-700000")) {

			cstOnboard.onBoardingL2Group(driver, dataValues[0], dataValues[1],
					dataValues[2], dataValues[3], dataValues[4], dataValues[5],
					dataValues[6], dataValues[7], dataValues[8], dataValues[9],
					dataValues[10], dataValues[11], dataValues[12],
					dataValues[13], dataValues[14], dataValues[15],
					dataValues[16], dataValues[17], dataValues[18],
					dataValues[19], dataValues[20], dataValues[21],
					dataValues[22], dataValues[23], dataValues[24],
					dataValues[25], dataValues[26], dataValues[27],
					dataValues[28], dataValues[29], dataValues[30],
					dataValues[31]);

		}

		else if (customerType.equalsIgnoreCase("Corporate Account Master Wallet")
				|| customerType.equalsIgnoreCase("Corporate Sim Sim Account User")
				|| customerType.equalsIgnoreCase("Agent FINJA")
				|| customerType.equalsIgnoreCase("Agent Finca")) {

			cstOnboard.onboardingCorporateGroup(driver, dataValues[0],
					dataValues[1], dataValues[2], dataValues[3], dataValues[4],
					dataValues[5], dataValues[6], dataValues[7], dataValues[8],
					dataValues[9], dataValues[10], dataValues[11],
					dataValues[12], dataValues[13], dataValues[14],
					dataValues[15], dataValues[16], dataValues[17],
					dataValues[18], dataValues[19], dataValues[20],
					dataValues[21], dataValues[22], dataValues[23],
					dataValues[24], dataValues[25], dataValues[26],
					dataValues[27], dataValues[28], dataValues[29],
					dataValues[30]);

		}

		// Utility.Submit(driver);
		// driver.findElement(By.partialLinkText("/html/body/div[1]/div[3]/div[1]/ul/li[2]/a")).click();

		((JavascriptExecutor) driver).executeScript("scroll(0,0)");
		Utility.W2F(driver);

	}

	@AfterMethod
	public static void testBrowserClose() {

		driver.quit();

	}

}

// //////////////////////////////////////////////////////
// //////////////////////////////////////////////////////

