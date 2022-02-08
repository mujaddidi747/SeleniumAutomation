package AutomationOnboarding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	
	static Workbook book;
	static Sheet sheet;
	public static String TestData_Sheet_Path = "D:/AutomationProject/SMP_3.1_Automation_Project/CustomerOnboarding/customerOnboarding.xlsx";
//	static URL TestData_Sheet_Path = getClass().getResource("customerOnboarding.xlsx");
	
	
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////

	public static Actions getActionsObject_submenu_homepage(WebDriver driver,WebElement sub_menu,WebElement sub_menu1){

		sub_menu = Login.driver.findElement(By.xpath("//*[@id='pageWrap']/div[3]/ul[1]/span/span[6]/li/span"));
		sub_menu1 = Login.driver.findElement(By.xpath("//*[@id='pageWrap']/div[3]/ul[1]/span/span[6]/li/ul/span[1]/li/a/span"));
		Actions act = new Actions(driver);
		act.moveToElement(sub_menu);
		act.click(sub_menu1);
		act.build().perform();
		return act;	
	}
	
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////

	public static void Submit(WebDriver driver) throws InterruptedException{
		
		 driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[4]/div/div/input")).click();
		 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
         driver.findElement(By.xpath("/html/body/div/div[3]/div[4]/div/div[2]/div/div/form/div[4]/div/input[1]")).click();
	 		
		//	driver.close();
	}
	
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////

	
	public static String[] getSheetNames(){
		
		System.out.println("*** Into the Sheets Name ***");
        
    	FileInputStream file = null;

		try {
			file = new FileInputStream(TestData_Sheet_Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Get No Of Sheets : "+book.getNumberOfSheets());
		
		String[] strName = new String [book.getNumberOfSheets()];  
		
		for (int i=0; i<book.getNumberOfSheets(); i++) { 
						
			strName[i] = book.getSheetAt(i).getSheetName();	
			System.out.println(strName[i]);  
		}  
		
		return strName;
	}

	public static Object[][] ReadSheet(String sheetName) throws IOException {
		
		System.out.println("*** Into the ReadFile ***");
    	
    	Object[][] data = null;
  	   
		sheet = book.getSheet(sheetName);
	  	
		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
    	System.out.println("Sheet Total Records:"+sheet.getLastRowNum());
 
    	try{
    	
    		for (int j = 0; j<sheet.getLastRowNum();j++){
    			for (int k = 0; k < sheet.getRow(0).getLastCellNum();k++){  				
    				
    				if((data[j][k]) == null){
    				//we have to add check here that if the array value contains the null values delete the array
    					data[j][k] = sheet.getRow(j+1).getCell(k).toString();  
    				}
    			}
    	   }
    	 }catch (Exception e){
    		e.printStackTrace();
    	 }
		return data;
	}
	
	///////////////////////////////////////////////////////
	////////////////////////////////////////////////////////

    public static void W2F(WebDriver driver){
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// Now you can do whatever you need to do with it, for example copy somewhere
	  try {
			FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
	  } catch (IOException e) {
		e.printStackTrace();
	  }

    }

    ///////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////

    public static void selectDate(WebDriver driver , String month_year, String select_day) throws InterruptedException {

	Random numberCalendar = new Random();
	int low = 1;
	int high = 10;
	int randomYear = numberCalendar.nextInt(high-low) + low;
	//System.out.println("randomYear: "+randomYear);
	List<WebElement> elementsYear = driver.findElements(By.xpath("/html/body/div[2]/div/div/select[2]/option[" + randomYear + "]"));
	//System.out.print("a");
	//System.out.println(elementsYear.get(0).getText());
	elementsYear.get(0).click();
	numberCalendar = new Random();
	low = 1;
	high = 12;
	int randomMonth = numberCalendar.nextInt(high-low) + low;
	//System.out.println("randomMonth: "+randomMonth);
	List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[2]/div/div/select[1]/option["+randomMonth+"]"));
	
	for (int i = 0; i < elements.size(); i++) {
		//System.out.println(elements.get(i).getText());
		elements.get(0).click();
	}
		// Selecting the month
		// Selecting the date
	numberCalendar = new Random();
	low = 2;
	high = 4;
	int randomDateRow = numberCalendar.nextInt(high-low) + low;
	//System.out.println("randomDateRow: "+randomDateRow);
	numberCalendar = new Random();
	low = 1;
	high = 7;
	int randomDateCol = numberCalendar.nextInt(high-low) + low;
	//System.out.println("randomDateCol: "+randomDateCol);

	List<WebElement> days = driver.findElements(By.xpath("/html/body/div[2]/table/tbody/tr["+randomDateRow+"]/td["+randomDateCol+"]/a"));
			
	for (WebElement d : days) {
	//		System.out.println(d.getText());
			d.click();
			return;
		}
    }	

	///////////////////////////////////////////////////////
	////////////////////////////////////////////////////////


    public static void riskTypes(){
    	
    	Select AccountOrganizationType = new Select(Login.driver.findElement(By.id("id6e")));
		AccountOrganizationType.selectByVisibleText("Low Risk");

		Select PoliticallyExposedPerson = new Select(Login.driver.findElement(By.id("id6f")));
		PoliticallyExposedPerson.selectByVisibleText("Low Risk");

		Select CustomerOwnership = new Select(Login.driver.findElement(By.id("id70")));
		CustomerOwnership.selectByVisibleText("Low Risk");

		Select CustomerRefuse = new Select(Login.driver.findElement(By.id("id71")));
		CustomerRefuse.selectByVisibleText("Low Risk");

		Select CustomerDealing = new Select(Login.driver.findElement(By.id("id72")));
		CustomerDealing.selectByVisibleText("Low Risk");

		Select IsResident = new Select(Login.driver.findElement(By.id("id73")));
		IsResident.selectByVisibleText("Low Risk");	

		Select IsActualOwner = new Select(Login.driver.findElement(By.id("id74")));
		IsActualOwner.selectByVisibleText("Low Risk");	

		Select IsCustomerDirector = new Select(Login.driver.findElement(By.id("id75")));
		IsCustomerDirector.selectByVisibleText("Low Risk");	

		Select IsCustomerHouseWife = new Select(Login.driver.findElement(By.id("id76")));
		IsCustomerHouseWife.selectByVisibleText("Low Risk");	

		Select IsMinorAccount = new Select(Login.driver.findElement(By.id("id77")));
		IsMinorAccount.selectByVisibleText("High Risk");	

		Select IsHighRiskBusiness = new Select(Login.driver.findElement(By.id("id78")));
		IsHighRiskBusiness.selectByVisibleText("Low Risk");	

		Select IsClientProfile = new Select(Login.driver.findElement(By.id("id79")));
		IsClientProfile.selectByVisibleText("Low Risk");	

		Select IsComplexStructure = new Select(Login.driver.findElement(By.id("id7a")));
		IsComplexStructure.selectByVisibleText("High Risk");			

		Select IsMailInstruction = new Select(Login.driver.findElement(By.id("id7b")));
		IsMailInstruction.selectByVisibleText("High Risk");			

		//RISK RATING
		Select RiskRating = new Select(Login.driver.findElement(By.id("riskRating")));
		RiskRating.selectByVisibleText("Low Risk");		
    	
    }

	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////

}
