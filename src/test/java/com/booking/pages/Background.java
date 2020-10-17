package com.booking.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class Background extends PageObject {

	@FindBy(className = "cookie-popup__button")
	public List<WebElementFacade> cookieBtns;

	public void openHomePage(String url) {
		openUrl(url);
	}

}
