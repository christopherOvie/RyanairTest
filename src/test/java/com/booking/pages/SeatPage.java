package com.booking.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SeatPage extends CommonPage {

	@FindAll({
			@FindBy(xpath = "//button[@class='ng-star-inserted seatmap__seat seatmap__seat--standard']")
	})
	private List<WebElementFacade> flightSeats;

	@FindAll({
			@FindBy(xpath = "//button[@class='ry-button ry-button--gradient-blue seats-action__button ry-button--flat-blue']"),
			@FindBy(xpath = "//button[@data-ref='seats-action__button-next']")
	})
	private List<WebElementFacade> nextBtn;

	@FindBy(xpath = "//button[@data-ref='seats-action__button-continue']")
	private WebElementFacade continueBtn;

	@FindBy(xpath = "//button[@data-ref='enhanced-takeover-beta-desktop__dismiss-cta']")
	private WebElementFacade noThanksLinks;

	@FindBy(xpath = "//button[@class='ry-button--gradient-yellow']")
	private WebElementFacade continueBtn2;

	@FindBy(xpath = "//button[@class='ry-button--full ng-tns-c167-1 ry-button--gradient-yellow ry-button--large']")
	private WebElementFacade continueBtn3;


	public void clickToContinue() {
		awaitVisibility(continueBtn).click();
		awaitVisibility(noThanksLinks).click();
	}


	public void setPassengerSeat(String size) {
		for (int i = 0; i < Integer.parseInt(size); i++)
			awaitVisibility(flightSeats).get(i).click();
	}


	public void clickToSelectArrivalSeats() {
		awaitVisibility(nextBtn).get(0).click();
	}


}
