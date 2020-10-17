package com.booking.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PaymentPage extends CommonPage {

	@FindBy(xpath = "//a[@data-ref='basket-tooltip__open-basket']")
	private WebElementFacade openBasket;

	@FindBy(xpath = "//button[@data-ref='basket-continue-flow__check-out']")
	private WebElementFacade checkoutBtn;

	@FindAll({
		@FindBy(xpath = "//div[contains(text(),'February')]"),
	})
	private WebElementFacade month;

	@FindAll({
		@FindBy(xpath = "//div[contains(text(),'2022')]"),
	})
	private WebElementFacade yearInput;

	@FindBy(xpath = "//ry-autocomplete//div//div//div[1]//input")
	private WebElementFacade countryTextField;

	@FindAll({
		@FindBy(xpath = "//div[@class='b2 ng-star-inserted']"),
	})
	private WebElementFacade declineMessage;

	@FindAll({
			@FindBy(xpath = "//div[@class='dropdown b2']"),
	})
	private List<WebElementFacade> dropDownList;

	@FindBy(xpath = "//input[@class='b2 date-placeholder']")
	private WebElementFacade telephoneTextField;

	@FindBy(xpath = "//*[@data-ref='verification-code__input']//div[@data-ref='ry-input-label']//input")
	private WebElementFacade cvvTextField;

	@FindBy(xpath = "//*[@data-ref='add-card-modal__account-name']//div[@data-ref='ry-input-label']//input")
	private WebElementFacade cardHolderTextField;

	@FindBy(xpath = "//*[@data-ref='add-card-modal__address-line-1']//div[@data-ref='ry-input-label']//input")
	private WebElementFacade addressTextField;

	@FindBy(xpath = "//ry-input-d[@data-ref='add-card-modal__city'] //input[@class='b2 date-placeholder']")
	private WebElementFacade cityTextField;

	@FindBy(xpath = "//*[@data-ref='add-card-modal__postcode']//div[@data-ref='ry-input-label']//input")
	private WebElementFacade zipTextField;

	@FindAll({
			@FindBy(xpath = "//input[@class='b2 date-placeholder']")
	})
	private List<WebElementFacade> inputTextList;


	@FindBy(xpath = "//ry-checkbox[@inputid='termsAndConditions']")
	private WebElementFacade termsAndCondition;

	@FindBy(xpath = "//ry-checkbox[@inputid='insurance-opt-out']")
	private WebElementFacade insurance;


	@FindBy(xpath = "//button[@class='pay-button ry-button--gradient-yellow']")
	private WebElementFacade payBtn;

	public PaymentPage() {

	}

	public void setModeOfPayment() {
		awaitVisibility(openBasket).click();
		awaitVisibility(checkoutBtn).click();
	}

	public void setTelephone(String tel) {
		awaitVisibility(telephoneTextField).sendKeys(tel);
		insurance.click();
	}

	public void debitCardDetail(String card, String cvv, String name, String address, String country, String city, String zip) {
		awaitVisibility(inputTextList).get(0).sendKeys(card);
		awaitVisibility(dropDownList).get(1).click();
		awaitVisibility(month).click();
		awaitVisibility(dropDownList).get(2).click();
		awaitVisibility(yearInput).click();
		awaitVisibility(cvvTextField).sendKeys(cvv);
		awaitVisibility(cardHolderTextField).sendKeys(name);
		awaitVisibility(addressTextField).sendKeys(address);
		awaitVisibility(cityTextField).sendKeys(city);
		awaitVisibility(countryTextField).click();
		countryTextField.sendKeys(country);
		countryTextField.sendKeys(Keys.ENTER);
		awaitVisibility(zipTextField).click();
		zipTextField.sendKeys(zip);

	}

	public void makePayment(){
		awaitVisibility(termsAndCondition).click();
		awaitVisibility(payBtn).click();
	}

	public void paymentDeclined(String errorMessage) {
		assertThat(declineMessage.getText(), is(errorMessage));
	}
}
