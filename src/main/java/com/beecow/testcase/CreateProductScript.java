package com.beecow.testcase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beecow.actions.CreateProductPage;
import com.beecow.actions.HomePage;
import com.beecow.actions.LoginPage;

import CommonPage.Commontestcase;
import ObjectPageJson.JsonData;

public class CreateProductScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	JsonData data;
	CreateProductPage createProductPage;
	String imgUploadRequiredMsg, nameProductRequiredMsg, categoryRequiredMsg, descriptionRequiredMsg,
			quantityRequiredMsg, priceRequiredMsg, weightRequiredMsg, requiredMsg, locatorDataImage, nameProdMsg,
			postProductSuccessfulMsg, productName, description, sku, quantity, quantityEdit, priceInput,
			priceProductNoDiscount, priceDisplayProduct, priceNewDiscount, priceViewEdit, discount, weight,
			weightSmallerRange, weightBiggerRange, weightMustRangeMsg, weightMin, width, widthMustRangeMsg,
			widthSmallerRange, widthBiggerRange, widthMin, length, lenghtOne, lengthBiggerRange, lengthSmallerRange,
			lengthMustRangeMsg, height, heightOne, heightBiggerRange, heightSmallerRange, heightMustRangeMsg,
			outOfStock, updateProductSuccessfulMsg;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) throws Exception {
		driver = openMultiBrowser(browser, version, url);
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = homePage.clickdangnhap();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inputEmailorSdt("genymotionios@gmail.com");
		loginPage.iputMatkhau("1234@abcd");
		homePage = loginPage.clickbuttonDangnhap();
		Thread.sleep(3000);
		createProductPage = homePage.clickSellerPage();
		Thread.sleep(3000);
		// upload picture in foder project
		String userPath = System.getProperty("user.dir");
		String pathImage = userPath.concat("\\image\\2019259.jpg");
		locatorDataImage = pathImage;
		data = getDataJson(".\\Data\\BeeCow.json");
		inititalReport("CreateProduct.html");

//		// msg
//		imgUploadRequiredMsg = "Hãy chọn hình ảnh cho sản phẩm";
//		nameProductRequiredMsg = "Hãy điền tên sản phẩm";
//		categoryRequiredMsg = "Hãy chọn danh mục.";
//		descriptionRequiredMsg = "Hãy mô tả sản phẩm.";
//		quantityRequiredMsg = "Nhập số lượng.";
//		priceRequiredMsg = "Hãy điền giá.";
//		weightRequiredMsg = "Hãy điền cân nặng sản phẩm.";
//		requiredMsg = "Bắt buộc";
//		postProductSuccessfulMsg = "Bạn đã đăng thành công sản phẩm này";
//		updateProductSuccessfulMsg = "Bạn đã cập nhật thành công sản phẩm này";
//		outOfStock = "Hết hàng";
//		heightMustRangeMsg = "Từ 1cm tới 50cm";
//		lengthMustRangeMsg = "Từ 1cm tới 30cm";
//		weightMustRangeMsg = "Cân nặng từ 50g đến 10000g.";
//		widthMustRangeMsg = "Từ 1cm tới 50cm";
//		// description
//		description = "Description product";
//		// sku
//		sku = "SKUShirt";
//		// Quantity
//		quantity = "10";
//		quantityEdit = "0";
//		// Price:
//		priceInput = "8";
//		priceViewEdit = "8,000";
//		priceDisplayProduct = "đ 7,200";
//		priceProductNoDiscount = "đ 8,000";
//		priceNewDiscount = "7,200";
//		// Discount:
//		discount = "10";
//		// Weight
//		weightMin = "50";
//		weight = "10000";
//		weightSmallerRange = "49";
//		weightBiggerRange = "10001";
//		// Width: "50"
//		width = "50";
//		widthMin = "1";
//		widthSmallerRange = "0";
//		widthBiggerRange = "51";
//		// Length
//		length = "30";
//		lenghtOne = "1";
//		lengthBiggerRange = "31";
//		lengthSmallerRange = "0";
//		// Height
//		height = "50";
//		heightOne = "1";
//		heightSmallerRange = "0";
//		heightBiggerRange = "51";
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://www.beecow.com/page/upload-product");
		productName = "XuanHoang" + randomName();
	}

//	TC8_ "1. At Home Page, click label ""Kênh bán hàng""
//	2. Click label: ""Đăng sản phẩm mới""".Verify current url is \"https://www.beecow.com/page/upload-product\"

	@Test
	public void TC_08_VerifyCurrentUrL() {
		logTestCase("TC_08_VerifyCurrentUrL");
		String currrentUrl = driver.getCurrentUrl();
		assertEquals(currrentUrl, "https://www.beecow.com/page/upload-product");
	}

	@Test
	public void TC_09_DontInputFieldAndPost() throws Exception {
		logTestCase("TC_09_DontInputFielAndPost");
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getImgUploadRequiredMsg()),
				data.ExpectedMsgPage().getImgUploadRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getNameProductRequiredMsg()),
				data.ExpectedMsgPage().getNameProductRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getCategoryRequiredMsg()),
				data.ExpectedMsgPage().getCategoryRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getDescriptionRequiredMsg()),
				data.ExpectedMsgPage().getDescriptionRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getQuantityRequiredMsg()),
				data.ExpectedMsgPage().getQuantityRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPriceRequiredMsg()),
				data.ExpectedMsgPage().getPriceRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightRequiredMsg()),
				data.ExpectedMsgPage().getWeightRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());

	}

////    TC10 : Upload image
	@Test
	public void TC_10_OnlyUploadImgAndPost() throws Exception {
		logTestCase("TC_10_OnlyUploadIMGAndPost");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getNameProductRequiredMsg()),
				data.ExpectedMsgPage().getNameProductRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getCategoryRequiredMsg()),
				data.ExpectedMsgPage().getCategoryRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getDescriptionRequiredMsg()),
				data.ExpectedMsgPage().getDescriptionRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getQuantityRequiredMsg()),
				data.ExpectedMsgPage().getQuantityRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPriceRequiredMsg()),
				data.ExpectedMsgPage().getPriceRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightRequiredMsg()),
				data.ExpectedMsgPage().getWeightRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());

	}

//TC 11 : 1. Upload image 2. Input random product name
	@Test
	public void TC_11_OnlyUploadImgAndNameproduct() throws Exception {
		logTestCase("TC_11_OnlyUploadImgAndNameproduct");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getCategoryRequiredMsg()),
				data.ExpectedMsgPage().getCategoryRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getDescriptionRequiredMsg()),
				data.ExpectedMsgPage().getDescriptionRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getQuantityRequiredMsg()),
				data.ExpectedMsgPage().getQuantityRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPriceRequiredMsg()),
				data.ExpectedMsgPage().getPriceRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightRequiredMsg()),
				data.ExpectedMsgPage().getWeightRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

//	TC12 : 1. Upload image 2. Input random product name 3. Select random combobox "Chọn danh mục"(1)
	@Test
	public void TC_12_PostWithUploadImgAndNameproductAndClickRandomCategory1() throws Exception {
		logTestCase("TC_12_PostWithUploadImgAndNameproductAndClickRandomCategory1");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getCategoryRequiredMsg()),
				data.ExpectedMsgPage().getCategoryRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getDescriptionRequiredMsg()),
				data.ExpectedMsgPage().getDescriptionRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getQuantityRequiredMsg()),
				data.ExpectedMsgPage().getQuantityRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPriceRequiredMsg()),
				data.ExpectedMsgPage().getPriceRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightRequiredMsg()),
				data.ExpectedMsgPage().getWeightRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

//	TC13 : 1. Upload image2. Input random product name3. Select random combobox "Chọn danh mục"(1)3. Select random combobox "Chọn danh mục"(2)
	@Test
	public void TC_13_PostWithInputFieldValidToCategoryRandomProductName3() throws Exception {
		logTestCase("TC_13_PostWithInputFieldValidToCategoryRandomProductName3");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getDescriptionRequiredMsg()),
				data.ExpectedMsgPage().getDescriptionRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getQuantityRequiredMsg()),
				data.ExpectedMsgPage().getQuantityRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPriceRequiredMsg()),
				data.ExpectedMsgPage().getPriceRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightRequiredMsg()),
				data.ExpectedMsgPage().getWeightRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

//TC 14 1. Upload image2. Input random product name3. Select random combobox "Chọn danh mục"(1)4. Select random combobox "Chọn danh mục"(2)5. Input description: "Description product"
	@Test
	public void TC_14_PostWithInputFieldValidToDescription() throws Exception {
		logTestCase("TC_14_PostWithInputFieldValidToDescription");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getQuantityRequiredMsg()),
				data.ExpectedMsgPage().getQuantityRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPriceRequiredMsg()),
				data.ExpectedMsgPage().getPriceRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightRequiredMsg()),
				data.ExpectedMsgPage().getWeightRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	// TC 15 1. Upload image2. Input random product name3. Select random combobox
	// "Chọn danh mục"(1)4. Select random combobox "Chọn danh mục"(2)5. Input
	// description: "Description product"
//	Input Quantity: "10"
	@Test
	public void TC_15_PostWithInputValidFieldToQuantity() throws Exception {
		logTestCase("TC_15_PostWithInputValidFieldToQuantity");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPriceRequiredMsg()),
				data.ExpectedMsgPage().getPriceRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightRequiredMsg()),
				data.ExpectedMsgPage().getWeightRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	// TC16 Input Quantity: "10"7. Input Price: "8"
	@Test
	public void TC_16PostWithInputValidFieldToPrice() throws Exception {
		logTestCase("TC_16PostWithInputValidFieldToPrice");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightRequiredMsg()),
				data.ExpectedMsgPage().getWeightRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

//	// TC17 Input Weight: "49"1. Weight: "Cân nặng từ 50g đến 10000g."
	@Test
	public void TC_17_PostValidFieldToWeightButSmallerRange() throws Exception {
		logTestCase("TC_17_PostValidFieldToWeightButSmallerRange");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeightSmallerRange());
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightMustRangeMsg()),
				data.ExpectedMsgPage().getWeightMustRangeMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}
//Tc18 8. Input Weight: "10001" weightBiggerRange

	@Test
	public void TC_18PostValidFieldToWeightButBiggerRange() throws Exception {
		logTestCase("TC_18_PostValidFieldToWeightButBiggerRange");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeightBiggerRange());
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWeightMustRangeMsg()),
				data.ExpectedMsgPage().getWeightMustRangeMsg());
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_19_PostValidFieldToWeightButWeightMin() throws Exception {
		logTestCase("TC_19_PostValidFieldToWeightButWeightMin");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeightMin());
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_20_PostAllFieldCorrectButBlankWidtLengthHeight() throws Exception {
		logTestCase("TC_20_PostAllFieldCorrectButBlankWidtLengthHeight");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicTextWidth(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_21_PostValidFieldToWidthButWidthSmallerRange() throws Exception {
		logTestCase("TC_21_PostValidFieldToWidthButWidthSmallerRange");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidthSmallerRange());
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWidthMustRangeMsg()),
				data.ExpectedMsgPage().getWidthMustRangeMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_22_PostValidFieldToWidthButWidthBiggerRange() throws Exception {
		logTestCase("TC_22_PostValidFieldToWidthButWidthBiggerRange");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidthBiggerRange());
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getWidthMustRangeMsg()),
				data.ExpectedMsgPage().getWidthMustRangeMsg());
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_23_PostValidFieldToWidthWidthMinAndButBlankLengthHeight() throws Exception {
		logTestCase("TC_23_PostValidFieldToWidthWidthMinAndButBlankLengthHeight");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidthMin());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_24_PostValidFieldButBlankLengthHeight() throws Exception {
		logTestCase("TC_24_PostValidFieldButBlankLengthHeight");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicTextLength(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_25_PostValidFieldToLengthButLengthSmallerRange() throws Exception {
		logTestCase("TC_25_PostValidFieldToLengthButLengthSmallerRange");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLengthSmallerRange());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getLengthMustRangeMsg()),
				data.ExpectedMsgPage().getLengthMustRangeMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_26_PostValidFieldToLengthButLengthBiggerRange() throws Exception {
		logTestCase("TC_26_PostValidFieldToLengthButLengthBiggerRange");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLengthBiggerRange());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getLengthMustRangeMsg()),
				data.ExpectedMsgPage().getLengthMustRangeMsg());
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_27_PostValidFieldToLengthAndLenghtOne() throws Exception {
		logTestCase("TC_27_PostValidFieldToLengthAndLenghtOne");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLenghtOne());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());
	}

	@Test
	public void TC_28_PostValidFieldToLengthButBlankHeight() throws Exception {
		logTestCase("TC_28_PostValidFieldToLengthButBlankHeight");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLength());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicTextHeight(data.CreateProductPage().getRequiredMsg()),
				data.ExpectedMsgPage().getRequiredMsg());

	}

	@Test
	public void TC_29_PostValidFieldToHeightButHeightSmallerRange() throws Exception {
		logTestCase("TC_29_PostValidFieldToHeightButHeightSmallerRange");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLength());
		createProductPage.inputHeight(data.CreateProductPage().getHeightSmallerRange());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getHeightMustRangeMsg()),
				data.ExpectedMsgPage().getHeightMustRangeMsg());

	}

	@Test
	public void TC_30_PostValidFieldToHeightButHeightBiggerRange() throws Exception {
		logTestCase("TC_30_PostValidFieldToHeightButHeightBiggerRange");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLength());
		createProductPage.inputHeight(data.CreateProductPage().getHeightBiggerRange());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getHeightMustRangeMsg()),
				data.ExpectedMsgPage().getHeightMustRangeMsg());
	}

	// TC31 . input height =1
	@Test
	public void TC_31_PostValidFieldToHeightAndHeightValua1() throws Exception {
		logTestCase("TC_31_PostValidFieldToHeightAndHeightValua1");
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLength());
		createProductPage.inputHeight(data.CreateProductPage().getHeightOne());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPostProductSuccessfulMsg()),
				data.ExpectedMsgPage().getPostProductSuccessfulMsg());
		createProductPage.clickViewList();
		verifyEqual(createProductPage.getTextDisplayNameProduct(), productName);
		verifyEqual(createProductPage.getTextDisplayPrice(), data.ExpectedMsgPage().getPriceProductNoDiscount());
		createProductPage.clickEditProduct(productName);
		createProductPage.deleteProduct();
		Thread.sleep(1000);

	}

//TC32 
	// 1. Upload image 2. Input random product name 3. Select random combobox "Chọn
	// danh mục"(1)
//	4. Select random combobox "Chọn danh mục"(2) 5. Input description: "Description product"
//	6. Input Quantity: "10" 7. Input Price: "8"  8. Input Weight: "10000"	9. Input Width: "50"	10. Input Length: "30"
//	11: Input Height: "50" 12. Click button: "Đăng"1. Verify message is displayed "Bạn đã đăng thành công sản phẩm này"
//	2. Click button: "Xem danh mục sản phẩm"3. Verify product name and price is displayed at shop page
	@Test
	public void TC_32_InputAllFieldCorrectButPriceProductNoDiscount() throws Exception {
		logTestCase("TC_32_InputAllFaildCorrectButPriceProductNoDiscount");
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLength());
		createProductPage.inputHeight(data.CreateProductPage().getHeight());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPostProductSuccessfulMsg()),
				data.ExpectedMsgPage().getPostProductSuccessfulMsg());
		createProductPage.clickViewList();
		verifyEqual(createProductPage.getTextDisplayNameProduct(), productName);
		verifyEqual(createProductPage.getTextDisplayPrice(), data.ExpectedMsgPage().getPriceProductNoDiscount());
		createProductPage.clickEditProduct(productName);
		createProductPage.deleteProduct();
		Thread.sleep(1000);
	}

//	TC33 B1. Upload image
//	B2. Input random product name
//	B3. Select random combobox "Chọn danh mục"(1)
//	B4. Select random combobox "Chọn danh mục"(2)
//	B5. Input description: "Description product"
//	B6. Input SKU: "SKUShirt"
//	B7. Input Quantity: "10"
//	B8. Input Price: "8"
//	B9. Input Discount: "10"
//	B10. Input Weight: "10000"
//	B11. Input Width: "50"
//	B12. Input Length: "30"
//	B13: Input Height: "50" 
//	B14. Click button: "Đăng"
	// Verify message is displayed "Bạn đã đăng thành công sản phẩm này"
	// 2. Click button: "Xem danh mục sản phẩm"
//		3. Verify product name and price is displayed at shop page
//		4. Click button chỉnh sửa
//		5. Verify all fields like user have inputed

	@Test
	public void TC_33_CreatProductSuccessfulAfterVerifyAllValueFieldDisplayProduct() throws Exception {
		logTestCase("TC_33_CreatProductSuccessfulAfterVerifyAllValueFieldDisplayProduct");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputSKU(data.CreateProductPage().getSku());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputDiscount(data.CreateProductPage().getDiscount());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLength());
		createProductPage.inputHeight(data.CreateProductPage().getHeight());
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getPostProductSuccessfulMsg()),
				data.ExpectedMsgPage().getPostProductSuccessfulMsg());
		createProductPage.clickViewList();
		Thread.sleep(1000);
		// Verify product name and price is displayed at shop page
		verifyEqual(createProductPage.getTextDisplayNameProduct(), productName);
		verifyEqual(createProductPage.getTextDisplayPrice(), data.ExpectedMsgPage().getPriceDisplayProduct());
		createProductPage.clickEditProduct(productName);
		verifyEqual(createProductPage.getTextJS("return $('#name').val()"), productName);
		verifyEqual(createProductPage.getTextEditDescription(), data.ExpectedMsgPage().getDescription());
		verifyEqual(createProductPage.getTextJS("return $('#org-sku').val()"), data.ExpectedMsgPage().getSku());
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"totalItem\"]').val()"),
				data.ExpectedMsgPage().getQuantity());
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"orgPrice\"]').val()"),
				data.ExpectedMsgPage().getPriceViewEdit());
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"totalItem\"]').val()"),
				data.ExpectedMsgPage().getDiscount());
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"newPrice\"]').val()"),
				data.ExpectedMsgPage().getPriceNewDiscount());
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"weight\"]').val()"),
				data.ExpectedMsgPage().getWeight());
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"width\"]').val()"),
				data.ExpectedMsgPage().getWidth());
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"length\"]').val()"),
				data.ExpectedMsgPage().getLength());
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"height\"]').val()"),
				data.ExpectedMsgPage().getHeight());
		createProductPage.deleteProduct();
		Thread.sleep(1000);
	}

	@Test
	public void TC_34_CreatProductSuccessfulAfterEditAndVerifyPriceDisplayProductValue() throws Exception {
		logTestCase("TC_34_CreatProductSuccessfulAfterEditAndVerifyPriceDisplayProductValue");
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(data.CreateProductPage().getDescription());
		createProductPage.inputSKU(data.CreateProductPage().getSku());
		createProductPage.inputQuantity(data.CreateProductPage().getQuantity());
		createProductPage.inputPrice(data.CreateProductPage().getPriceInput());
		createProductPage.inputDiscount(data.CreateProductPage().getDiscount());
		createProductPage.inputWeight(data.CreateProductPage().getWeight());
		createProductPage.inputWidth(data.CreateProductPage().getWidth());
		createProductPage.inputLength(data.CreateProductPage().getLength());
		createProductPage.inputHeight(data.CreateProductPage().getHeight());
		createProductPage.clickPost();
		createProductPage.clickViewList();
		Thread.sleep(1000);
		createProductPage.clickEditProduct(productName);
		Thread.sleep(1000);
		createProductPage.clickEditQuantity();
		Thread.sleep(1000);
		createProductPage.inputEditQuantity(data.CreateProductPage().getQuantityEdit());
		createProductPage.clickConfirmQuantity();
		Thread.sleep(1000);
		createProductPage.clickUpdate();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getUpdateProductSuccessfulMsg()),
				data.ExpectedMsgPage().getUpdateProductSuccessfulMsg());
		createProductPage.clickSeeProductDetail();
		Thread.sleep(2000);
		verifyEqual(createProductPage.getTextDisplayNameProductEdit(), productName);
		verifyEqual(createProductPage.getTextDisplayPrice(), data.ExpectedMsgPage().getPriceDisplayProduct());
		verifyEqual(createProductPage.getDynamicText(data.CreateProductPage().getOutOfStock()),
				data.ExpectedMsgPage().getOutOfStock());
		Thread.sleep(2000);
		createProductPage.clickEditProductSuccessful();
		Thread.sleep(2000);
		createProductPage.deleteProduct();
		Thread.sleep(1000);

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