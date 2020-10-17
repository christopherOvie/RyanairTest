package com.booking.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;
import java.util.List;


public class CommonPage extends PageObject {

	final static Duration TIME_OUT = Duration.ofMillis(5000);

	WebElementFacade awaitVisibility(WebElementFacade facade){
		return withTimeoutOf(TIME_OUT)
				.waitFor(facade);
	}

	List<WebElementFacade> awaitVisibility(List<WebElementFacade> facades){
		return withTimeoutOf(TIME_OUT)
				.waitFor(facades);
	}

}
