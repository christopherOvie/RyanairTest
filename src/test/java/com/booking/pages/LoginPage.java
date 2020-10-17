package com.booking.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends CommonPage {

	@FindBy(xpath = "//button[@data-ref='login-touchpoint__log_in_button']")
	private WebElementFacade loginBtn;
	@FindBy(xpath = "//input[@name='email']")
	private WebElementFacade username;
	@FindBy(xpath = "//input[@name='password']")
	private WebElementFacade password;
	@FindBy(xpath = "//button[@class='auth-submit__button ry-button--full ry-button--flat-yellow']")
	private WebElementFacade submitBtn;
	@FindBy(xpath = "//a[contains(text(),'Dashboard')]")
	public WebElementFacade dashboard;


	public void loinForm() {
		awaitVisibility(loginBtn).click();
	}

	public void login(String user, String pass) {
		awaitVisibility(username).clear();
		username.sendKeys(user);

		awaitVisibility(password).clear();
		password.sendKeys(pass);

		awaitVisibility(submitBtn).click();
	}

}
