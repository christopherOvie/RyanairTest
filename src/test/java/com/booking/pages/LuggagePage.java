package com.booking.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LuggagePage extends CommonPage {

	@FindBy(xpath = "//button[@class='ry-button--gradient-yellow']")
	private WebElementFacade continueBtn;

	@FindAll({
			@FindBy(xpath = "//label[@class='ry-radio-circle-button__label']")
	})
	private List<WebElementFacade> luggages;

	public void clickToContinue() {
		awaitVisibility(luggages).get(0).click();
		awaitVisibility(continueBtn).click();
	}

}
