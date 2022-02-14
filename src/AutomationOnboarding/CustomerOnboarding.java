
package AutomationOnboarding;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class  CustomerOnboarding {

	Date d = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy");
	String date = formatter.format(d);
	String splitter[] = date.split("-");
	String month_year = splitter[0];
	String day = splitter[1]; 
	WebElement sub_menu;
	WebElement sub_menu1;
	Select selectCustomerType=null;
	//String typeCustomer="Corporate Account Master Wallet";
	
	//////////////////////////
	//// corporate group /////
	//////////////////////////	
	//////////////////////////
	
	public boolean onboardingCorporateGroup(WebDriver driver, String accountTitle,
			String sellerCODE, String nameCnic, String motherName,
			String fatherName, String placeofBirth, String identityNumber ,String permanentAddress,
			String permanentCity, String mailingAddress, String mailingCity, String email,
			String accountHolderMN, String actualOwner, String beneficialCnic,
			String expectedCredit, String monthlyExpectedWithdrawal,
			String expectedDebit, String monthlyExpectedDeposit,
			String avergaeYearlyIncome, String averageYearlySales,
			String expectedMonthlyThroughPut, String expectedAvgBalance,
			String expectedMonthlyCreditSales,
			String expectedMaxAmountPerTransaction,
			String expectedNoOfTransaction, String annualTurnover,
			String natureOfBusiness, String noTinComments,String customerType) throws InterruptedException, IOException
			{


		Utility.getActionsObject_submenu_homepage(driver, sub_menu, sub_menu1);

		// selecting the dropdown	     

		try{
			WebElement dropdown_customerRegistration = driver.findElement(By.id("id7"));			
			dropdown_customerRegistration.click();
			selectCustomerType = new Select(dropdown_customerRegistration);
			selectCustomerType.selectByVisibleText(customerType) ;
			System.out.println("Selected Customer Type : "+selectCustomerType.getFirstSelectedOption().getText());
		}

		catch(Exception e){
			WebElement dropdown_customerRegistration = driver.findElement(By.id("id7"));				
			dropdown_customerRegistration.click();
			selectCustomerType = new Select(dropdown_customerRegistration);
			selectCustomerType.selectByVisibleText(customerType) ;
			System.out.println("Selected Customer Type : "+selectCustomerType.getFirstSelectedOption().getText());
		}

		if(selectCustomerType.getFirstSelectedOption().getText().equals("Corporate Account Master Wallet")){

			onboardingCorporateGroupMasterWallet(accountTitle,  sellerCODE	,
					nameCnic	, motherName, 	fatherName	,  placeofBirth, identityNumber, 	permanentAddress,	 permanentCity,	
					mailingAddress, 	mailingCity, email,	accountHolderMN,  actualOwner, 
					beneficialCnic, 
					expectedCredit, 	monthlyExpectedWithdrawal, 	expectedDebit	,  monthlyExpectedDeposit,
					avergaeYearlyIncome, 	averageYearlySales	,
					expectedMonthlyThroughPut,  expectedAvgBalance,	expectedMonthlyCreditSales, 	expectedMaxAmountPerTransaction, 	
					expectedNoOfTransaction,	 annualTurnover, 	natureOfBusiness, noTinComments, customerType);
		
		}else if(selectCustomerType.getFirstSelectedOption().getText().equals("Corporate Sim Sim Account User")){

			onboardingCorporateGroupMasterWallet(accountTitle,  sellerCODE	,
					nameCnic	, motherName, 	fatherName	,  placeofBirth, identityNumber, 	permanentAddress,	 permanentCity,	
					mailingAddress, 	mailingCity, email,	accountHolderMN,  actualOwner, 
					beneficialCnic, 
					expectedCredit, 	monthlyExpectedWithdrawal, 	expectedDebit	,  monthlyExpectedDeposit,
					avergaeYearlyIncome, 	averageYearlySales	,
					expectedMonthlyThroughPut,  expectedAvgBalance,	expectedMonthlyCreditSales, 	expectedMaxAmountPerTransaction, 	
					expectedNoOfTransaction,	 annualTurnover, 	natureOfBusiness, noTinComments,customerType);
		
		}else if(selectCustomerType.getFirstSelectedOption().getText().equals("Agent FINJA")){
		
			/// for different corporate groups	
			
			driver.findElement(By.id("workingWithOtherBank")).sendKeys("NO");
			driver.findElement(By.id("netWorth")).sendKeys("60000");
			driver.findElement(By.id("typeOfTransaction")).sendKeys("Business");
			driver.findElement(By.id("currentBusinessSince")).sendKeys("2000");
			Select premises = new Select(Login.driver.findElement(By.id("premises")));
			premises.selectByVisibleText("OWNED");
			
			onboardingCorporateGroupMasterWallet(accountTitle,  sellerCODE	,
					nameCnic	, motherName, 	fatherName	,  placeofBirth, identityNumber, 	permanentAddress,	 permanentCity,	
					mailingAddress, 	mailingCity, email,	accountHolderMN,  actualOwner, 
					beneficialCnic, 
					expectedCredit, 	monthlyExpectedWithdrawal, 	expectedDebit	,  monthlyExpectedDeposit,
					avergaeYearlyIncome, 	averageYearlySales	,
					expectedMonthlyThroughPut,  expectedAvgBalance,	expectedMonthlyCreditSales, 	expectedMaxAmountPerTransaction, 	
					expectedNoOfTransaction,	 annualTurnover, 	natureOfBusiness, noTinComments, customerType);
			
		}else if(selectCustomerType.getFirstSelectedOption().getText().equals("Agent finca")){
			
			onboardingCorporateGroupMasterWallet(accountTitle,  sellerCODE	,
					nameCnic	, motherName, 	fatherName	,  placeofBirth, identityNumber, 	permanentAddress,	 permanentCity,	
					mailingAddress, 	mailingCity, email,	accountHolderMN,  actualOwner, 
					beneficialCnic, 
					expectedCredit, 	monthlyExpectedWithdrawal, 	expectedDebit	,  monthlyExpectedDeposit,
					avergaeYearlyIncome, 	averageYearlySales	,
					expectedMonthlyThroughPut,  expectedAvgBalance,	expectedMonthlyCreditSales, 	expectedMaxAmountPerTransaction, 	
					expectedNoOfTransaction,	 annualTurnover, 	natureOfBusiness, noTinComments, customerType);
		}
		
		return true;

		}

		////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////
	
	// using data providers
		public boolean onboardingCorporateGroupMasterWallet(String accountTitle, String SellerCODE	,
			String NameCnic	,String motherName, String	FatherName	, String PlaceofBirth, String identityNumber, String 	PermanentAddress,	String PermanentCity,	
			String MailingAddress, String	MailingCity, String email, String	AccountHolderMN, String ActualOwner, 
			String	beneficialCnic, 
			String	expectedCredit, String	monthlyExpectedWithdrawal, String	expectedDebit	, String monthlyExpectedDeposit,
			String	avergaeYearlyIncome, String	averageYearlySales	,
			String expectedMonthlyThroughPut, String expectedAvgBalance,String	expectedMonthlyCreditSales, String	expectedMaxAmountPerTransaction, 	
			String expectedNoOfTransaction,	String annualTurnover, String	natureOfBusiness, String noTinComments,String customerType) throws InterruptedException, IOException{

		
		Login.driver.findElement(By.id("sellerCode")).sendKeys(SellerCODE);

		Select typeAccount = new Select(Login.driver.findElement(By.id("idd")));
		typeAccount.selectByVisibleText("Corporation");

		Select nationality = new Select(Login.driver.findElement(By.id("nationality2")));
		nationality.selectByVisibleText("PAKISTAN");

		Login.driver.findElement(By.id("id4")).sendKeys(accountTitle);
	//	Assert.assertTrue(accountTitle.matches("^[a-zA-Z\\s]*$"));
		
		Login.driver.findElement(By.id("nameAsPerCnic")).sendKeys(NameCnic);
		//Assert.assertTrue(NameCnic.matches("^(?=.*[1-9])[0-9+]{5}(-){1}[0-9+]{7}(-){1}[0-9]{1}$"));
		
		Login.driver.findElement(By.id("motherName")).sendKeys(motherName);
		//Assert.assertTrue(motherName.matches("^[a-zA-Z\\s]*$"));
		
		Login.driver.findElement(By.id("fatherHusbandName")).sendKeys(FatherName);
		//Assert.assertTrue(FatherName.matches("^[a-zA-Z\\s]*$"));
		
		Login.driver.findElement(By.id("placeOfBirth")).sendKeys(PlaceofBirth);
		Login.driver.findElement(By.id("permanentCity")).sendKeys(PermanentCity);

		//SELECTING RANDOM DATES
		
		try {
			Login.driver.findElement(By.id("birthDate")).click();;
			Thread.sleep(500);
			Utility.selectDate(Login.driver, month_year,day);

			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		try {
			Login.	driver.findElement(By.id("cnicExpiryDate")).click();;
			Thread.sleep(500);
			Utility.selectDate(Login.driver, month_year,day);

			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Login.driver.findElement(By.id("issuanceDate")).click();;
			Thread.sleep(500);
			Utility.selectDate(Login.driver, month_year,day);

			Thread.sleep(500);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		//SELECT STATEMENTS ARE USED FOR DROPDOWNS
		
		Select gender = new Select(Login.driver.findElement(By.id("kvGender")));
		gender.selectByVisibleText("Male");
		
		Login.driver.findElement(By.id("identityValue")).sendKeys(identityNumber);
		Login.driver.findElement(By.id("permanentAddress")).sendKeys(PermanentAddress);
		//Login.driver.findElement(By.id("permanentCity")).sendKeys(PermanentCity);
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		
		Login.driver.findElement(By.id("mailingOrBusinessAddress")).sendKeys(MailingAddress);
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		
		Login.driver.findElement(By.id("mailingOrBusinessCity")).sendKeys(MailingCity);
		Login.driver.findElement(By.id("email")).sendKeys(email);
		
		Select pOA = new Select(Login.driver.findElement(By.id("id46")));
		pOA.selectByVisibleText("Business");
		
		Login.driver.findElement(By.id("accountHolderMsisdn")).sendKeys(AccountHolderMN);
		
		Select province = new Select(Login.driver.findElement(By.id("permanentState")));
		province.selectByIndex(2);
		
		Select MailingProvince = new Select(Login.driver.findElement(By.id("mailingOrBusinessState")));
		MailingProvince.selectByIndex(5);


		Select BeneficialAccOwner = new Select(Login.driver.findElement(By.id("id4d")));
		BeneficialAccOwner.selectByVisibleText("No");

		Login.driver.findElement(By.id("actualBeneficialOwner")).sendKeys(ActualOwner);

		Select Relation = new Select(Login.driver.findElement(By.id("id51")));
		Relation.selectByVisibleText("Brother");

		Login.driver.findElement(By.id("cnicBeneficial")).sendKeys(beneficialCnic);

		Select TxnMode = new Select(Login.driver.findElement(By.id("modeOfTransaction")));
		TxnMode.selectByVisibleText("All");

		Login.driver.findElement(By.id("expectedCredit")).sendKeys(expectedCredit);
		Login.driver.findElement(By.id("monthlyExpectedWithdrawal")).sendKeys(monthlyExpectedWithdrawal);
		Login.driver.findElement(By.id("expectedDebit")).sendKeys(expectedDebit);				
		Login.driver.findElement(By.id("monthlyExpectedDeposit")).sendKeys(monthlyExpectedDeposit);									
		Login.driver.findElement(By.id("avergaeYearlyIncome")).sendKeys(avergaeYearlyIncome);
		Login.driver.findElement(By.id("averageYearlySales")).sendKeys(averageYearlySales);
		Login.driver.findElement(By.id("expectedMonthlyThroughPut")).sendKeys(expectedMonthlyThroughPut);
		Login.driver.findElement(By.id("expectedAvgBalance")).sendKeys(expectedAvgBalance);
		Login.driver.findElement(By.id("expectedMonthlyCreditSales")).sendKeys(expectedMonthlyCreditSales);
		Login.driver.findElement(By.id("expectedMaxAmountPerTransaction")).sendKeys(expectedMaxAmountPerTransaction);
		Login.driver.findElement(By.id("expectedNoOfTransaction")).sendKeys(expectedNoOfTransaction);
		Login.driver.findElement(By.id("annualTurnover")).sendKeys(annualTurnover);
		Login.driver.findElement(By.id("natureOfBusiness")).sendKeys(natureOfBusiness);

		Select businessType = new Select(Login.driver.findElement(By.id("typeOfBusiness")));
		businessType.selectByVisibleText("Service");

		Login.driver.findElement(By.id("noTinComments")).sendKeys(noTinComments);

		Utility.riskTypes();

		Select CountryOfBirth = new Select(Login.driver.findElement(By.id("id8e")));
		CountryOfBirth.selectByVisibleText("PAKISTAN");	


		Select TaxResidentYN = new Select(Login.driver.findElement(By.id("id8f")));
		TaxResidentYN.selectByVisibleText("Yes");

		WebElement UsPerson = Login.driver.findElement(By.id("id99"));
		UsPerson.click();
		
		//Utility.Submit(Login.driver);
		
		Login. driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[4]/div/div/input")).click();
		
	    Login.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	    	///////////////////////////////////////
	    	//////AUTOMATING DIRECTOR'S PAGE///////
	    	//////////////////////////////////////
	    
	    Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Absar ahmed Mujaddidi");
	  
		Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[3]/div/input")).sendKeys("lahore rehman gardens");

		Select ID = new Select(Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[4]/div/select")));
		ID.selectByIndex(2);
		
		Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[5]/div/input")).sendKeys("3001254");
	
		Select residentCountry = new Select(Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[6]/div/select")));
		residentCountry.selectByVisibleText("PAKISTAN");
		
		Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[7]/div/input")).sendKeys("Lahore");
		
			//////////////////////////////////////////
			//SELECTING RANDOM DATE FOR DIRECTOR DOB//
			//////////////////////////////////////////
		
		try {
			Login.driver.findElement(By.id("directorDateofBirth")).click();
			Thread.sleep(500);
			Utility.selectDate(Login.driver, month_year,day);

			Thread.sleep(500);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//for proceeding after adding director//
		Login.driver.findElement(By.id("idb8")).click();
		Login.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(250);
		//CLICKING ON CONTINUE BUTTON ON DIRECTOR'S PAGE//
		Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[3]/div/input[3]")).click();

		Thread.sleep(300);
		
		//CLICKING ON CONTINUE BUTTON ON CORPORATE CUSTOMER ONBOARDING PAGE AFTER ADDING DIRECTOR//
		Login.driver.findElement(By.xpath("/html/body/div/div[3]/div[4]/div/div[2]/div/div/form/div[4]/div/input[1]")).click();
		
		return true;

	}


	////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////

	public boolean onBoardingL2Group(WebDriver driver,String accountTitle, 
			String accountNumber, String nVerification, String motherName, 
			String fatherName, String POB, String gender,String nationality,String identityNumber, String permanentAddress,
			String permanentCity, String mailingAddress, String mailingCity, String Name, String CNIC, String contactNumber, String residency
			, String address,String ActualOwner, String BenificiaryCNIC, String ExpextedMonthlyNoTransactionCR, String ExpextedMonthlyAmtTransactionDB,
			String ExpextedMonthlyAmtTransactionCR, String ExpextedMonthlyNoTransactionDB, String AvgYearlyIncome, String AvgYearlySales, String ntn,
			String TaxIdentificationNumber,String customerType) throws InterruptedException, IOException{


		Utility.getActionsObject_submenu_homepage(driver, sub_menu, sub_menu1);

		// selecting the dropdown	     

		try{
			WebElement dropdown_customerRegistration = driver.findElement(By.id("id7"));			
			dropdown_customerRegistration.click();
			selectCustomerType = new Select(dropdown_customerRegistration);
			selectCustomerType.selectByVisibleText(customerType) ;
			System.out.println("Selected Customer Type : "+selectCustomerType.getFirstSelectedOption().getText());
		}catch(Exception e){
			WebElement dropdown_customerRegistration = driver.findElement(By.id("id7"));				
			dropdown_customerRegistration.click();
			selectCustomerType = new Select(dropdown_customerRegistration);
			selectCustomerType.selectByVisibleText(customerType) ;
			System.out.println("Selected Customer Type : "+selectCustomerType.getFirstSelectedOption().getText());
		}

		if(selectCustomerType.getFirstSelectedOption().getText().equals("L2 Existing Customer")){

			onBoardingL2(accountTitle, 
					accountNumber, nVerification,  motherName, 
					fatherName,  POB, gender,nationality, identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	

		}else if (selectCustomerType.getFirstSelectedOption().getText().equals("L2-Individual")){

			onBoardingL2(accountTitle, 
					accountNumber,nVerification,  motherName, 
					fatherName,  POB, gender,nationality, identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	

		}else if(selectCustomerType.getFirstSelectedOption().getText().equals("L2-Individual-10000")){
			onBoardingL2(accountTitle, 
					accountNumber,nVerification,  motherName, 
					fatherName,  POB, gender,nationality,identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	

		}else if(selectCustomerType.getFirstSelectedOption().getText().equals("L2-Individual-250000")){

			onBoardingL2(accountTitle, 
					accountNumber,nVerification,  motherName, 
					fatherName,  POB, gender, nationality,identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	


		}else if (selectCustomerType.getFirstSelectedOption().getText().equals("L2-Individual-500000")){

			onBoardingL2(accountTitle, 
					accountNumber,nVerification,  motherName, 
					fatherName,  POB, gender, nationality,identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	

		}else if (selectCustomerType.getFirstSelectedOption().getText().equals("L2-Individual-99999")){

			onBoardingL2(accountTitle, 
					accountNumber, nVerification, motherName, 
					fatherName,  POB, gender,nationality,identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	

		}else if (selectCustomerType.getFirstSelectedOption().getText().equals("L2 Individual Staff")){

			onBoardingL2(accountTitle, 
					accountNumber, nVerification, motherName, 
					fatherName,  POB, gender,nationality, identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	

		}else if (selectCustomerType.getFirstSelectedOption().getText().equals("L2 Individual Staff-100000")){

			onBoardingL2(accountTitle, 
					accountNumber, nVerification, motherName, 
					fatherName,  POB, gender, nationality,identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	

		}else if (selectCustomerType.getFirstSelectedOption().getText().equals("L2 Individual Staff-2500000")){

			onBoardingL2(accountTitle, 
					accountNumber, nVerification, motherName, 
					fatherName,  POB, gender, nationality,identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	

		}

		else if (selectCustomerType.getFirstSelectedOption().getText().equals("L2 Individual Staff-700000")){

			onBoardingL2(accountTitle, 
					accountNumber, nVerification,  motherName, 
					fatherName,  POB, gender,nationality,identityNumber,  permanentAddress,
					permanentCity,  mailingAddress,  mailingCity,  Name,  CNIC,  contactNumber,  residency
					,  address, ActualOwner,  BenificiaryCNIC,  ExpextedMonthlyNoTransactionCR,  ExpextedMonthlyAmtTransactionCR,
					ExpextedMonthlyAmtTransactionDB,  ExpextedMonthlyNoTransactionDB,  AvgYearlyIncome,  AvgYearlySales,  ntn,
					TaxIdentificationNumber);	

		}				
		return true;

	}

	////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////

	public boolean onBoardingL2(String accountTitle, 
			String accountNumber, String nVerification, String motherName, 
			String fatherName, String POB, String gender, String nationality, String identityNumber, String permanentAddress,
			String permanentCity, String mailingAddress, String mailingCity, String Name, String CNIC, String contactNumber, String residency
			, String address,String ActualOwner, String BenificiaryCNIC, String ExpextedMonthlyNoTransactionCR, String ExpextedMonthlyAmtTransactionCR,
			String ExpextedMonthlyAmtTransactionDB, String ExpextedMonthlyNoTransactionDB, String AvgYearlyIncome, String AvgYearlySales, String ntn,
			String TaxIdentificationNumber) throws IOException{

		

		Select typeAccount = new Select(Login.driver.findElement(By.id("idd")));
		typeAccount.selectByVisibleText("Corporation");
		
		
		Select PoliticalExposed = new Select(Login.driver.findElement(By.id("id27")));
		PoliticalExposed.selectByIndex(2);

		// Login.driver.findElement(By.id("politicallyExposedComments")).sendKeys(PoliticalComments);

		Login.driver.findElement(By.id("nextOfKinName")).sendKeys(Name);
		//	Assert.assertTrue(accountTitle.matches("^[a-zA-Z\\s]*$"));

		Login.driver.findElement(By.id("nextOfKinCnic")).sendKeys(CNIC);
		//Assert.assertTrue(CNIC.matches("^(?=.*[1-9])[0-9+]{5}(-){1}[0-9+]{7}(-){1}[0-9]{1}$"));

		Select nextofkinNationality = new Select(Login.driver.findElement(By.id("nextOfKinNationality")));
		nextofkinNationality.selectByVisibleText("PAKISTAN");

		Login.driver.findElement(By.id("nextOfKinContactNo")).sendKeys(contactNumber);

		Login.driver.findElement(By.id("nextOfKinResidency")).sendKeys(residency);

		Login.driver.findElement(By.id("nextOfKinAddress")).sendKeys(address);
		//Assert.assertTrue(address.matches("^[0-9]*|^[-0-9a-zA-ZÀ-ÿ .']*$"));

		WebElement OccupationType = Login.driver.findElement(By.id("id35"));
		Select occupationType = new Select(OccupationType);
		occupationType.selectByIndex(2);
		
		try{
		Select purAcc = new Select(Login.driver.findElement(By.id("id46")));
		purAcc.selectByVisibleText("Loan");
		}
		catch(Exception e){
			Select purAcc = new Select(Login.driver.findElement(By.id("id46")));
			purAcc.selectByVisibleText("Loan");
		}

		Select BeneficialAccOwner = new Select(Login.driver.findElement(By.id("id4d")));
		BeneficialAccOwner.selectByVisibleText("No");

		Select Relationship = new Select(Login.driver.findElement(By.id("id32")));
		Relationship.selectByVisibleText("Brother");

		Login.driver.findElement(By.id("actualBeneficialOwner")).sendKeys(ActualOwner);
		//Assert.assertTrue(accountTitle.matches("^[a-zA-Z\\s]*$"));

		Select Relation = new Select(Login.driver.findElement(By.id("id51")));
		Relation.selectByVisibleText("Brother");

		Login.driver.findElement(By.id("cnicBeneficial")).sendKeys(BenificiaryCNIC);
		//Assert.assertTrue(CNIC.matches("^(?=.*[1-9])[0-9+]{5}(-){1}[0-9+]{7}(-){1}[0-9]{1}$"));

		Select TxnMode = new Select(Login.driver.findElement(By.id("modeOfTransaction")));
		TxnMode.selectByVisibleText("All");

		Login.driver.findElement(By.id("expectedCredit")).sendKeys(ExpextedMonthlyNoTransactionCR);
		//Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

		Login.driver.findElement(By.id("monthlyExpectedWithdrawal")).sendKeys(ExpextedMonthlyAmtTransactionCR);
		//Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

		Login.driver.findElement(By.id("expectedDebit")).sendKeys(ExpextedMonthlyAmtTransactionDB);
		//Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

		Login.	driver.findElement(By.id("monthlyExpectedDeposit")).sendKeys(ExpextedMonthlyNoTransactionDB);
		//Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

		Login.  driver.findElement(By.id("avergaeYearlyIncome")).sendKeys(AvgYearlyIncome);
		//Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

		Login. driver.findElement(By.id("averageYearlySales")).sendKeys(AvgYearlySales);
		//Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

		Login. driver.findElement(By.id("ntn")).sendKeys(ntn);

		Select TypeOfCustomer = new Select(Login.driver.findElement(By.id("typeOfIncomingCustomer")));
		
		TypeOfCustomer.selectByVisibleText("Marketed");

		Select HearingMedium = new Select(Login.driver.findElement(By.id("bankHearingMedium")));
		HearingMedium.selectByVisibleText("Others");

		//RISK TYPES
		Utility.riskTypes();

		//RESIDENCE STATUS

		Select ResidenceStatus = new Select(Login.driver.findElement(By.id("residenceStatus")));
		ResidenceStatus.selectByVisibleText("Resident");

		// CRS

		Select CountryOfBirth = new Select(Login.driver.findElement(By.id("id8e")));
		CountryOfBirth.selectByVisibleText("PAKISTAN");	

		Select TaxIsResident = new Select(Login.driver.findElement(By.id("id8f")));
		TaxIsResident.selectByVisibleText("Yes");	

		if(TaxIsResident.getFirstSelectedOption().getText().equals("No")){
			Select TaxResidenceCountry = new Select(Login.driver.findElement(By.id("id91")));
			TaxResidenceCountry.selectByVisibleText("PAKISTAN");	

			Login.driver.findElement(By.id("id92")).sendKeys(TaxIdentificationNumber);
			
			Select Reason = new Select(Login.driver.findElement(By.id("id94")));
			Reason.selectByVisibleText("Reason A");	

			System.out.print("\n \t HI PLEASE ATTEST THAT I AM HERE");
		}else {

			WebElement UsPerson = Login.driver.findElement(By.id("id99"));
			UsPerson.click();
		}
		
		
		onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, 
				POB, gender,nationality,identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		
		return true;
	}


	////////////// L0 ////////////////////
	//////////////////////////////////////
	
	public boolean onBoarding(WebDriver driver, 
			String accountTitle, String accountNumber, String nVerification, String motherName,
			String fatherName, String POB, String gender, String nationality,String identityNumber, String permanentAddress, 
			String permanentCity, String mailingAddress, String mailingCity,String customerType) throws InterruptedException, IOException{

		sub_menu = Login.driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/ul[1]/span/span[6]/li/span"));
		sub_menu1 = Login.driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/ul[1]/span/span[6]/li/ul/span[1]/li/a/span"));
		Utility.getActionsObject_submenu_homepage(driver, sub_menu, sub_menu1);

		// selecting the dropdown	     

		try{
			WebElement dropdown_customerRegistration = driver.findElement(By.id("id7"));			
			dropdown_customerRegistration.click();
			selectCustomerType = new Select(dropdown_customerRegistration);
			selectCustomerType.selectByVisibleText(customerType) ;
			System.out.println("Selected Customer Type : "+selectCustomerType.getFirstSelectedOption().getText());
		}catch(Exception e){
			WebElement dropdown_customerRegistration = driver.findElement(By.id("id7"));				
			dropdown_customerRegistration.click();
			selectCustomerType = new Select(dropdown_customerRegistration);
			selectCustomerType.selectByVisibleText(customerType) ;
			System.out.println("Selected Customer Type : "+selectCustomerType.getFirstSelectedOption().getText());
		}

		//IF LO IS SELECTED
		if(selectCustomerType.getFirstSelectedOption().getText().equals("L0")){
		
			onBoardingcustomerl0(accountTitle, accountNumber,nVerification, motherName, fatherName, POB, gender,nationality,identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);	

		}else if(selectCustomerType.getFirstSelectedOption().getText().equals("L1 Corporate SimSim User")){
			
			OnBoardingL1CorporateUser(accountTitle, accountNumber,nVerification, motherName, fatherName, POB,gender,nationality, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		
		}else if(selectCustomerType.getFirstSelectedOption().getText().equals("L1 Guest Corporate SimSim User")){

			OnBoardingL1GuestCorporateSimSim (accountTitle,  accountNumber,  nVerification,  motherName,  fatherName,  POB, gender,nationality,identityNumber,  permanentAddress,  permanentCity,  mailingAddress,  mailingCity);
		}
		//IF L0 BVS CORPORATE USER IS SELECTED
		else if(selectCustomerType.getFirstSelectedOption().getText().equals("L0 BVS CORPORATE USER")){

			onBoardingL0bvsCorporateUser(accountTitle,  accountNumber,  nVerification,  motherName,  fatherName,  POB, gender,nationality, identityNumber,  permanentAddress,  permanentCity,  mailingAddress,  mailingCity);
		}
		// IF Remote Zero - Digital Transaction IS SELECTED
		else if(selectCustomerType.getFirstSelectedOption().getText().equals("Remote Zero - Digital Transaction")){

			onBoardingRemoteZeroDigitalTransaction(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender,nationality,identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		}
		//IF Remote Zero - Corporate Sim Sim User IS SELECTED
		else if(selectCustomerType.getFirstSelectedOption().getText().equals("Remote Zero - Corporate Sim Sim User")){

			onBoardingRemoteZeroCorporateSimSimUser(accountTitle,  accountNumber,  nVerification, motherName,  fatherName,  POB, gender,nationality, identityNumber,  permanentAddress,  permanentCity,  mailingAddress,  mailingCity);

		}else if (selectCustomerType.getFirstSelectedOption().getText().equals("Guest D/C Block User")){

			onBoardingGuestDCUser(accountTitle,  accountNumber, nVerification, motherName,  fatherName,  POB, gender,nationality,identityNumber,  permanentAddress,  permanentCity,  mailingAddress,  mailingCity);

		}else if (selectCustomerType.getFirstSelectedOption().getText().equals("L1")) {
		
			onBoardingL1( accountTitle,  accountNumber,  nVerification, motherName,  fatherName,  POB, gender,nationality, identityNumber,  permanentAddress,  permanentCity,  mailingAddress,  mailingCity);
		
		}else if(selectCustomerType.getFirstSelectedOption().getText().equals("L0 BVS User")){

			onBoardingL0bvs( accountTitle,  accountNumber, nVerification,  motherName,  fatherName, POB, gender, nationality,identityNumber,  permanentAddress,  permanentCity,  mailingAddress,  mailingCity);
		
		}else if(selectCustomerType.getFirstSelectedOption().getText().equals("Merchant Headquarter")){

			merchantHeadquarter( accountTitle,  accountNumber, nVerification, motherName,  fatherName,  POB, gender, nationality, identityNumber,  permanentAddress,  permanentCity,  mailingAddress,  mailingCity);
		}

		return true;
	}

	////////////////////////////////////////////////////////

	public boolean onBoardingcustomerl0(String accountTitle, String accountNumber, String nVerification,
			String motherName, String fatherName, String POB, String gender, String nationality,String identityNumber, String permanentAddress, 
			String permanentCity, String mailingAddress, String mailingCity) throws IOException{

		Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[1]/div[2]/input")).sendKeys(accountTitle);
		// Assert.assertTrue(accountTitle.matches("^[a-zA-Z]+$"));

		Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[1]/div[3]/div/input")).sendKeys(accountNumber);
		//Assert.assertTrue(accountNumber.matches("^(\\+){0,1}[0-9]+$"));

		Login.driver.findElement(By.id("motherName")).sendKeys(motherName);
		//Assert.assertTrue(motherName.matches("^[a-zA-Z]+$"));

		Login.driver.findElement(By.id("fatherHusbandName")).sendKeys(fatherName);
		//Assert.assertTrue(fatherName.matches("^[a-zA-Z]+$"));

		Login.driver.findElement(By.id("placeOfBirth")).sendKeys(POB);
		//Assert.assertTrue(POB.matches("^[a-zA-Z]+$"));

		Login. driver.findElement(By.id("identityValue")).sendKeys(identityNumber);
		//Assert.assertTrue(identityNumber.matches("^(?=.*[1-9])[0-9+]{5}(-){1}[0-9+]{7}(-){1}[0-9]{1}$"));

		Login.driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
		//Assert.assertTrue(permanentAddress.matches("^[a-zA-Z]+$"));

		Login.driver.findElement(By.id("permanentCity")).sendKeys(permanentCity);
		//Assert.assertTrue(permanentCity.matches("^[a-zA-Z]+$"));

		Login.driver.findElement(By.id("mailingOrBusinessAddress")).sendKeys(mailingAddress);
		//Assert.assertTrue(mailingAddress.matches("^[a-zA-Z]+$"));

		Login.driver.findElement(By.id("mailingOrBusinessCity")).sendKeys(mailingCity);
		//Assert.assertTrue(mailingCity.matches("^[a-zA-Z]+$"));

		WebElement DropdownVerificationType = Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[1]/div[5]/select"));
		Select dropdownVerification = new Select(DropdownVerificationType);
		dropdownVerification.selectByVisibleText(nVerification);

		// Picking gender
		Select Gender = new Select(Login.driver.findElement(By.id("kvGender")));
		Gender.selectByVisibleText(gender);

		// Picking Nationality
		Select Nationality = new Select(Login.driver.findElement(By.id("nationality2")));
		Nationality.selectByVisibleText(nationality);

		// Identity Information of USER
		Select ID = new Select(Login.driver.findElement(By.id("kvIdentityType")));
		ID.selectByIndex(2);

		Select education = new Select(Login.driver.findElement(By.id("education")));
		education.selectByIndex(2);

		//province
		Select province = new Select(Login.driver.findElement(By.id("permanentState")));
		province.selectByIndex(2);

		//mailing province
		Select MailingProvince = new Select(Login.driver.findElement(By.id("mailingOrBusinessState")));
		MailingProvince.selectByIndex(5);

		//informode
		Select InfoMode = new Select(Login.driver.findElement(By.id("id20")));
		InfoMode.selectByIndex(1);

		try {
			Login.driver.findElement(By.id("birthDate")).click();;
			Thread.sleep(500);
			Utility.selectDate(Login.driver, month_year,day);

			Thread.sleep(500);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		try {
			Login.	driver.findElement(By.id("cnicExpiryDate")).click();;
			Thread.sleep(500);
			Utility.selectDate(Login.driver, month_year,day);

			Thread.sleep(500);
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Login.driver.findElement(By.id("issuanceDate")).click();;
			Thread.sleep(500);
			Utility.selectDate(Login.driver, month_year,day);

			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		////////////////TO CONTINUE AND SUBMIT LO AND RELATED FORMS///////////////////
		//////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////
	    Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[4]/div/div/input")).click();
		 
		Login. driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
        Login. driver.findElement(By.xpath("/html/body/div/div[3]/div[4]/div/div[2]/div/div/form/div[4]/div/input[1]")).click();	 
		
		
		
		return true;
	}


	////////////////////////////////////////////////////////
	
	//L1 CORPORATE USER
	public boolean OnBoardingL1CorporateUser(String accountTitle, String accountNumber, String nVerification, String motherName, 
			String fatherName, String POB, String gender, String nationality,
			String identityNumber, String permanentAddress, 
			String permanentCity, String mailingAddress, 
			String mailingCity) throws InterruptedException, IOException{

		onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		
		Login.driver.findElement(By.id("employerName")).sendKeys("AutoSoft Dynamics");
		WebElement OtherCheckBox = Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[6]/div[4]/div[3]/div/div/div[1]/div/table/tbody/tr[2]/td/input"));
		boolean isSelected = OtherCheckBox.isSelected();

		if (isSelected){
			Login.driver.findElement(By.id("sourcesOfIncomeCBOther")).sendKeys("xyz");
		}else {
			Login.	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[6]/div[4]/div[3]/div/div/div[1]/div/table/tbody/tr[1]/td/input")).click();
		}
		
		return true;
	}

	////////////////////////////////////////////////////////
	
	//L1GUESTCORPORATESIMSIM USER
	public boolean OnBoardingL1GuestCorporateSimSim (String accountTitle, String accountNumber, 
			String nVerification,String motherName, String fatherName, String POB, String gender, String nationality,
			String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) throws IOException {

		onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);

		Login.driver.findElement(By.id("employerName")).sendKeys("AutoSoft Dynamics");
		WebElement OtherCheckBox = Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[6]/div[4]/div[3]/div/div/div[1]/div/table/tbody/tr[2]/td/input"));
		boolean isSelected = OtherCheckBox.isSelected();

		if (isSelected){
			Login.driver.findElement(By.id("sourcesOfIncomeCBOther")).sendKeys("xyz");
		}else {
			Login.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[6]/div[4]/div[3]/div/div/div[1]/div/table/tbody/tr[1]/td/input")).click();
		}

		return true;
	}
	
	////////////////////////////////////////////////////////
	
	//ON BOARDING RemoteZeroCorporateSimSimUser
	public boolean onBoardingRemoteZeroDigitalTransaction(String accountTitle, String accountNumber, String nVerification, String motherName, 
			String fatherName, String POB, String gender, String nationality,String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) throws IOException {
		onBoardingcustomerl0(accountTitle, accountNumber, nVerification , motherName, fatherName, POB, gender, nationality,identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		return true;

	}
	////////////////////////////////////////////////////////
	
	public boolean onBoardingGuestDCUser(String accountTitle, String accountNumber,  String nVerification,String motherName, String fatherName, String POB,String gender,
			String nationality,String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity ) throws IOException{

		onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		return true;
	} 

	////////////////////////////////////////////////////////
	
	public boolean onBoardingRemoteZeroCorporateSimSimUser( String accountTitle, String accountNumber, String nVerification, String motherName, String fatherName, String POB, String gender,
			String nationality,String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) throws IOException {

		onBoardingcustomerl0(accountTitle, accountNumber, nVerification,motherName, fatherName, POB, gender, nationality,identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		return true;

	}

	////////////////////////////////////////////////////////
	
	//ONBOARDING AGENT FINCA BRANCH
	public boolean onBoardingL1(String accountTitle, String accountNumber, String nVerification, String motherName, String fatherName, String POB, String gender,
			String nationality,String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) throws IOException{

		onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality,identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);			
		return true;

	}

	////////////////////////////////////////////////////////
	
	public boolean merchantHeadquarter(String accountTitle, String accountNumber, String nVerification,
			String motherName, String fatherName, String POB, String gender, String nationality,
			String identityNumber, String permanentAddress,
			String permanentCity, String mailingAddress, String mailingCity) throws IOException {

		onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		return true;

	}

	////////////////////////////////////////////////////////
	
	public boolean onBoardingL0bvs(String accountTitle, String accountNumber, String nVerification,
			String motherName, String fatherName, String POB, String gender, String nationality,
			String identityNumber, String permanentAddress,
			String permanentCity, String mailingAddress, String mailingCity) throws IOException {

		onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		return true;
	}

	////////////////////////////////////////////////////////
	
	public boolean onBoardingL0bvsCorporateUser(String accountTitle, 
			String accountNumber, String nVerification, String motherName, 
			String fatherName, String POB, String gender, String nationality,String identityNumber, String permanentAddress,
			String permanentCity, String mailingAddress, String mailingCity) throws IOException {

		onBoardingcustomerl0(accountTitle, accountNumber, nVerification,motherName, fatherName, POB, gender, nationality,  identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
		return true;	
	}

	////////////////////////////////////////////////////////

}



