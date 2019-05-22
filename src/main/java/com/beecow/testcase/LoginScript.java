package com.beecow.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beecow.actions.HomePage;
import com.beecow.actions.LoginPage;

import CommonPage.Commontestcase;
import ObjectPageJson.JsonData;

public class LoginScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	JsonData data;
	String emailAndSdtorPasswordIncorrectMsg, emailSdtOrPasswordWrongMsg, PhoneNumberIncorrectMsg, phoneIncorrect,
			emailIncorrectMsg, emailCorrect, emailIncorrect, passwordNotEnoughtCharacterMsg,
			passwordNotEnoughtCharacter, passwordWrong, passwordCorrect, displayUserName;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
//		emailAndSdtorPasswordIncorrectMsg = "Hãy nhập email / số điện thoại và mật khẩu";
//		PhoneNumberIncorrectMsg = "Số điện thoại không đúng";
//		emailIncorrectMsg = "Email không đúng";
//		emailSdtOrPasswordWrongMsg = "Sai email / số điện thoại hoặc mật khẩu";
//		passwordNotEnoughtCharacterMsg = "Tối thiểu 6 ký tự";
//		passwordNotEnoughtCharacter = "123";
//		passwordWrong = "123456";
//		passwordCorrect = "1234@abcd";
//		emailCorrect = "genymotionios@gmail.com";
//		phoneIncorrect = "1234";
//		emailIncorrect = "1234abcd";
		// displayUserName = "genymotionios";
		data = getDataJson(".\\Data\\BeeCow.json");
		inititalReport("Login.html");
	}

	@Test
	public void TC_01_LoginEmptyEmailAndPassWord() throws InterruptedException {
		logTestCase("TC_01_LoginEmptyEmailAndPassWord");
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = homePage.clickdangnhap();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inputEmailorSdt("");
		loginPage.iputMatkhau("");
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(data.LoginPage().getEmailAndSdtorPasswordIncorrectMsg()),
				data.ExpectedMsgPage().getEmailAndSdtorPasswordIncorrectMsg());
	}

	@Test
	public void TC_02_LoginWrongSDT() {
		logTestCase("TC_02_LoginWrongSDT");
		loginPage.inputEmailorSdt(data.LoginPage().getPhoneIncorrect());
		loginPage.iputMatkhau("");
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(data.LoginPage().getPhoneNumberIncorrectMsg()),
				data.ExpectedMsgPage().getPhoneNumberIncorrectMsg());
		verifyEqual(loginPage.getDynamicText(data.LoginPage().getEmailAndSdtorPasswordIncorrectMsg()),
				data.ExpectedMsgPage().getEmailAndSdtorPasswordIncorrectMsg());
		loginPage.clearByJs("$('input#usr').val('')");

	}

	@Test
	public void TC_03_LoginWrongEmail() throws InterruptedException {
		logTestCase("TC_03_LoginWrongEmail");
		loginPage.inputEmailorSdt(data.LoginPage().getEmailIncorrect());
		loginPage.iputMatkhau("");
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(data.LoginPage().getEmailIncorrectMsg()),
				data.ExpectedMsgPage().getEmailIncorrectMsg());
		verifyEqual(loginPage.getDynamicText(data.LoginPage().getEmailAndSdtorPasswordIncorrectMsg()),
				data.ExpectedMsgPage().getEmailAndSdtorPasswordIncorrectMsg());
		loginPage.clearByJs("$('input#usr').val('')");

	}

	@Test
	public void TC_04_LogincorrectEmailBlankPassword() throws InterruptedException {
		logTestCase("TC_04_LogincorrectEmailBlankPassword");
		loginPage.inputEmailorSdt(data.LoginPage().getEmailCorrect());
		loginPage.iputMatkhau("");
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(data.LoginPage().getEmailAndSdtorPasswordIncorrectMsg()),
				data.ExpectedMsgPage().getEmailAndSdtorPasswordIncorrectMsg());
	}

	@Test
	public void TC_05_LogincorrectEmailPasswordNotEnoughtCharracter() throws InterruptedException {
		logTestCase("TC_05_LogincorrectEmailPasswordNotEnoughtCharracter");
		loginPage.iputMatkhau(data.LoginPage().getPasswordNotEnoughtCharacter());
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(data.LoginPage().getPasswordNotEnoughtCharacterMsg()),
				data.ExpectedMsgPage().getPasswordNotEnoughtCharacterMsg());
		verifyEqual(loginPage.getDynamicText(data.LoginPage().getEmailAndSdtorPasswordIncorrectMsg()),
				data.ExpectedMsgPage().getEmailAndSdtorPasswordIncorrectMsg());
		loginPage.clearByJs("$('input#pwd').val('')");
	}

	@Test
	public void TC_06_LogincorrectEmailWrongPassword() throws InterruptedException {
		logTestCase("TC_06_LogincorrectEmailWrongPassword");
		loginPage.iputMatkhau(data.LoginPage().getPasswordWrong());
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(data.LoginPage().getEmailSdtOrPasswordWrongMsg()),
				data.ExpectedMsgPage().getEmailSdtOrPasswordWrongMsg());
		loginPage.clearByJs("$('input#pwd').val('')");
	}

//	TC7. Navigate to url: https://www.beecow.com
//		2. Click button: Đăng nhập
//		3. Input username: "genymotionios@gmail.com"
//		4. Input password: "1234@abcd"
//		5. Click button: Đăng nhập.Verify label username "genymotionios" is displayed on the top right screen
	@Test
	public void TC_07_LoginCorrectEmailSdtAndPassword() throws InterruptedException {
		logTestCase("TC_07_LoginCorrectEmailSdtAndPassword");
		loginPage.iputMatkhau(data.LoginPage().getPasswordCorrect());
		loginPage.clickbuttonDangnhap();
		Thread.sleep(3000);
		verifyEqual(loginPage.getTextUserName(), data.ExpectedMsgPage().getDisplayUserName());
		Thread.sleep(3000);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}

	@AfterClass
	public void afterClass() {
		exportReport();
		closeBrowser();
	}

}
