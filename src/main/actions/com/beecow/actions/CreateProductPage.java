package com.beecow.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.beecow.ui.CreateProductPageUI;
import com.beecow.ui.HomePageUI;
import com.beecow.ui.LoginPageUI;

import CommonPage.commonFunction;

public class CreateProductPage extends commonFunction {

	public CreateProductPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage clickdangnhap() {
		waitVisible(HomePageUI.DANGNHAP_TXT);
		click(HomePageUI.DANGNHAP_TXT);
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public String getTextUserName() {
		waitVisible(LoginPageUI.USERNAME_LBL);
		return getText(LoginPageUI.USERNAME_LBL);
	}

	public void deleteProduct() {
		waitVisible(CreateProductPageUI.DELETE_BTN);
		click(CreateProductPageUI.DELETE_BTN);
		waitVisible(CreateProductPageUI.DELETE_CONFIRM_BTN);
		click(CreateProductPageUI.DELETE_CONFIRM_BTN);

	}

	public void clickPostProduct() {
		waitVisible(CreateProductPageUI.POST_PRODUCT_BTN);
		click(CreateProductPageUI.POST_PRODUCT_BTN);
	}

	// dynamic text
	public String getDynamicText(String value) {
		waitVisibleDynamicElement(LoginPageUI.DYNAMIC_MSG, value);
		return getTextDynamicElement(LoginPageUI.DYNAMIC_MSG, value);
	}

	public String getDynamicTextWidth(String value) {
		waitVisibleDynamicElement(CreateProductPageUI.DYNAMIC_WIDTH_MSG, value);
		return getTextDynamicElement(CreateProductPageUI.DYNAMIC_WIDTH_MSG, value);
	}

	public String getDynamicTextLength(String value) {
		waitVisibleDynamicElement(CreateProductPageUI.DYNAMIC_LENGTH_MSG, value);
		return getTextDynamicElement(CreateProductPageUI.DYNAMIC_LENGTH_MSG, value);
	}

	public String getDynamicTextHeight(String value) {
		waitVisibleDynamicElement(CreateProductPageUI.DYNAMIC_HEIGHT_MSG, value);
		return getTextDynamicElement(CreateProductPageUI.DYNAMIC_HEIGHT_MSG, value);
	}

	// name product
	public void inputNameProduct(String value) {
		waitVisible(CreateProductPageUI.NAME_PRODUCT_TXT);
		input(CreateProductPageUI.NAME_PRODUCT_TXT, value);
	}

	public String getTextDisplayNameProduct() {
		waitVisible(CreateProductPageUI.DISPLAY_NAME_PRODUCT_LBL);
		return getText(CreateProductPageUI.DISPLAY_NAME_PRODUCT_LBL);
	}

	public String getTextDisplayNameProductEdit() {
		waitVisible(CreateProductPageUI.DISPLAY_NAMEPRODUCT_EDIT_LBL);
		return getText(CreateProductPageUI.DISPLAY_NAMEPRODUCT_EDIT_LBL);
	}

	// description
	public void inputDescription(String value) {
		waitVisible(CreateProductPageUI.DESCCRIPTION_TXT);
		clear(CreateProductPageUI.DESCCRIPTION_TXT);
		input(CreateProductPageUI.DESCCRIPTION_TXT, value);
	}

	public String getTextEditDescription() {
		waitVisible(CreateProductPageUI.VIEW_EDIT_DESCRIPTTION_TXT);
		return getText(CreateProductPageUI.VIEW_EDIT_DESCRIPTTION_TXT);
	}

	public String getTextDesMsg() {
		waitVisible(CreateProductPageUI.DESCCRIPTION_MSG);
		return getText(CreateProductPageUI.DESCCRIPTION_MSG);
	}

	// SKU
	public void inputSKU(String value) {
		waitVisible(CreateProductPageUI.SKU_TXT);
		clear(CreateProductPageUI.SKU_TXT);
		input(CreateProductPageUI.SKU_TXT, value);
	}

	// Quantity
	public void inputQuantity(String value) {
		waitVisible(CreateProductPageUI.QUANTITY_TXT);
		clear(CreateProductPageUI.QUANTITY_TXT);
		input(CreateProductPageUI.QUANTITY_TXT, value);
	}

	public void clickEditQuantity() {
		waitVisible(CreateProductPageUI.QUANTITY_EDIT_BTN);
		click(CreateProductPageUI.QUANTITY_EDIT_BTN);
	}

	public void inputEditQuantity(String value) {
		waitVisible(CreateProductPageUI.QUANTITY_EDIT_TXT);
		clear(CreateProductPageUI.QUANTITY_EDIT_TXT);
		input(CreateProductPageUI.QUANTITY_EDIT_TXT, value);
	}

	public void clickConfirmQuantity() {
		waitVisible(CreateProductPageUI.QUANTITY_CONFIRM_BTN);
		click(CreateProductPageUI.QUANTITY_CONFIRM_BTN);
	}

// Price
	public void inputPrice(String value) {
		waitVisible(CreateProductPageUI.PRICE_TXT);
		clear(CreateProductPageUI.PRICE_TXT);
		input(CreateProductPageUI.PRICE_TXT, value);
	}

	public String getTextDisplayPrice() {
		waitVisible(CreateProductPageUI.DISPLAY_PRICE_LBN);
		return getText(CreateProductPageUI.DISPLAY_PRICE_LBN);
	}

	// Discount:
	public void inputDiscount(String value) {
		waitVisible(CreateProductPageUI.DISCOUNT_TXT);
		clear(CreateProductPageUI.DISCOUNT_TXT);
		input(CreateProductPageUI.DISCOUNT_TXT, value);
	}

//	 Weight
	public void inputWeight(String value) {
		waitVisible(CreateProductPageUI.WEIGHT_TXT);
		clear(CreateProductPageUI.WEIGHT_TXT);
		input(CreateProductPageUI.WEIGHT_TXT, value);
	}

//	 Width:
	public void inputWidth(String value) {
		waitVisible(CreateProductPageUI.WIDTH_TXT);
		clear(CreateProductPageUI.WIDTH_TXT);
		input(CreateProductPageUI.WIDTH_TXT, value);
	}

//	 Length
	public void inputLength(String value) {
		waitVisible(CreateProductPageUI.LENGTH_TXT);
		clear(CreateProductPageUI.LENGTH_TXT);
		input(CreateProductPageUI.LENGTH_TXT, value);
	}

//	 Height
	public void inputHeight(String value) {
		waitVisible(CreateProductPageUI.HEIGHT_TXT);
		clear(CreateProductPageUI.HEIGHT_TXT);
		input(CreateProductPageUI.HEIGHT_TXT, value);
	}

//Button
	public void clickPost() {
		waitVisible(CreateProductPageUI.POST_BTN);
		click(CreateProductPageUI.POST_BTN);
	}

	public void clickUpdate() {
		waitVisible(CreateProductPageUI.UPDATE_BTN);
		click(CreateProductPageUI.UPDATE_BTN);
	}

	public void clickCate1() {
		waitVisible(CreateProductPageUI.CATE1_BTN);
		click(CreateProductPageUI.CATE1_BTN);
	}

	public void clickRandomValueCate1() {
		waitVisible(CreateProductPageUI.CATE1_LIST);
		clickRandomCombobox(CreateProductPageUI.CATE1_LIST);
	}

	public void clickCate2() {
		waitVisible(CreateProductPageUI.CATE2_BTN);
		click(CreateProductPageUI.CATE2_BTN);
	}

	public void clickViewList() {
		waitVisible(CreateProductPageUI.VIEW_LIST_BTN);
		click(CreateProductPageUI.VIEW_LIST_BTN);
	}

	public void clickSeeProductDetail() {
		waitVisible(CreateProductPageUI.SEE_PRODUCT_DETAIL_BTN);
		click(CreateProductPageUI.SEE_PRODUCT_DETAIL_BTN);
	}

	public void clickEditProduct(String value) throws InterruptedException {
		Thread.sleep(2000);
		hoverDynamicElement(CreateProductPageUI.IMAGE_PRODUCT, value);
//		waitVisibleDynamicElement(CreateProductPageUI.EDIT_PRODUCT_BTN, value);
		clickDynamicElement(CreateProductPageUI.EDIT_PRODUCT_BTN, value);
	}

	public void clickEditProductSuccessful() {
		waitVisible(CreateProductPageUI.EDIT_PRODUCT_EDITSUCCESFUL_BTN);
		click(CreateProductPageUI.EDIT_PRODUCT_EDITSUCCESFUL_BTN);
	}

	public String getTextJS(String value) throws Exception {
		Thread.sleep(2000);
		return getTextJquery(value);
	}

	public void clickRandomValueCate2() {
		waitVisible(CreateProductPageUI.CATE2_LIST);
		clickRandomCombobox(CreateProductPageUI.CATE2_LIST);
	}

	public void clickRandomCat3() {
		if (checkElementDisplayed(CreateProductPageUI.CAT3)) {
			waitVisible(CreateProductPageUI.CAT3);
			click(CreateProductPageUI.CAT3);
			waitVisible(CreateProductPageUI.CAT3_LIST);
			clickRandomCombobox(CreateProductPageUI.CAT3_LIST);
		}
	}

	public String getTextImgMsg() {
		waitVisible(CreateProductPageUI.IMG_MSG);
		return getText(CreateProductPageUI.IMG_MSG);
	}

	public String getTextProductNameMsg() {
		waitVisible(CreateProductPageUI.PRODUCT_NAME_MSG);
		return getText(CreateProductPageUI.PRODUCT_NAME_MSG);
	}

//	public String getTextCatMsg() {
//		waitVisible(CreateProductPageUI.CAT_MSG);
//		return getText(CreateProductPageUI.CAT_MSG);
//	}
//
//	public String getTextQtyMsg() {
//		waitVisible(CreateProductPageUI.QTY_MSG);
//		return getText(CreateProductPageUI.QTY_MSG);
//	}

	public String getTextPriceMsg() {
		waitVisible(CreateProductPageUI.PRICE_MSG);
		return getText(CreateProductPageUI.PRICE_MSG);
	}

	public String getTextWeightMsg() {
		waitVisible(CreateProductPageUI.WEIGHT_MSG);
		return getText(CreateProductPageUI.WEIGHT_MSG);
	}

	public String getTextWidthMsg() {
		waitVisible(CreateProductPageUI.WIDTH_MSG);
		return getText(CreateProductPageUI.WIDTH_MSG);
	}

	public String getTextLengthMsg() {
		waitVisible(CreateProductPageUI.LENGTH_MSG);
		return getText(CreateProductPageUI.LENGTH_MSG);
	}

	public String getTextHeightMsg() {
		waitVisible(CreateProductPageUI.HEIGHT_MSG);
		return getText(CreateProductPageUI.HEIGHT_MSG);
	}

	public String getTextPostSucessMsg() {
		waitVisible(CreateProductPageUI.POST_SUCESS_MSG);
		return getText(CreateProductPageUI.POST_SUCESS_MSG);
	}

	public String getTextUpdateSucessMsg() {
		waitVisible(CreateProductPageUI.UPDATE_SUCESS_MSG);
		return getText(CreateProductPageUI.UPDATE_SUCESS_MSG);
	}

	public String getTextProductNameLbl() {
		waitVisible(CreateProductPageUI.PRODUCT_NAME_LBL);
		return getText(CreateProductPageUI.PRODUCT_NAME_LBL);
	}

	public void uploadIMG(String value) {
		uploadBySendKeys(CreateProductPageUI.IMG_UPLOAD, value);
	}
//	public String getTextCat3Txt() {
//		waitVisible(CreateProductPageUI.CAT3_TXT);
//		return getText(CreateProductPageUI.CAT3_TXT);
//	}

	// Get text in Edit Product

//	public String getTextDynamicJquery(String js) throws InterruptedException {
//		Thread.sleep(1000);
//		return getTextjQuery(js);
//	}

	public String getTextDesEdit() {
		waitVisible(CreateProductPageUI.DES_EDIT);
		return getText(CreateProductPageUI.DES_EDIT);
	}

	public String getTextDiscountEdit() {
		waitVisible(CreateProductPageUI.DISCOUNT_EDIT);
		return getText(CreateProductPageUI.DISCOUNT_EDIT);
	}

	public String gettextNewPriceEdit() {
		waitVisible(CreateProductPageUI.NEWPRICE_EDIT);
		return getText(CreateProductPageUI.NEWPRICE_EDIT);
	}

	public String gettextWeightEdit() {
		waitVisible(CreateProductPageUI.WEIGHT_EDIT);
		return getText(CreateProductPageUI.WEIGHT_EDIT);
	}

//	public String gettextDetailSoldout() {
//		waitVisible(CreateProductPageUI.DETAIL_SOLDOUT);
//		return getText(CreateProductPageUI.DETAIL_SOLDOUT);
//	}

}