package com.booking.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;


public class SearchPage extends CommonPage {

	@FindBy(xpath = "//button[@class='list__clear-selection ry-button--anchor-blue ry-button--anchor'")
	private WebElementFacade clearSelection;
	@FindBy(id = "input-button__departure")
	public WebElementFacade departureTxtField;
	@FindBy(id = "input-button__destination")
	private WebElementFacade arrivalTxtField;
	@FindBy(xpath = "//span[@data-ref='airport-item__name']")
	private WebElementFacade activateDate;
	@FindBy(xpath = "//div[@data-ref='input-button__display-value']")
	private List<WebElementFacade> datePicker;
	@FindBy(xpath = "//button[@data-ref='flight-search-widget__cta']")
	private WebElementFacade searchBtn;
	@FindBy(className = "counter__button-wrapper--enabled")
	private List<WebElementFacade> counters;
	@FindBy(xpath = "//fare-card[@class='fare-card-item__component ng-star-inserted']")
	private List<WebElementFacade> tickets;
	@FindBy(xpath = "//flight-card[@data-e2e='flight-card--outbound']")
	private WebElementFacade flightOutBound;
	@FindBy(xpath = "//flight-card[@data-e2e='flight-card--inbound']")
	private WebElementFacade flightInBound;
	
	public void selectTravelPlan(String departure, String arrival){

		departureTxtField.sendKeys(departure);

		awaitVisibility(arrivalTxtField).sendKeys(arrival);
		arrivalTxtField.deselect();

		activateDate.click();
	}

	public void setDates(String departureDate, String arrivalDate) {
		datePicker.get(0).click();
		withTimeoutOf(TIME_OUT)
				.find(By.xpath("//div[@data-id='"+ departureDate +"']"))
				.click();
		withTimeoutOf(TIME_OUT)
				.find(By.xpath("//div[@data-id='"+ arrivalDate +"']"))
				.click();

	}

	public void setNumberOfPassengers(String numberOfAdults, String numberOfChildren) {
		for(int i =1; i< Integer.parseInt(numberOfAdults); i++)
			awaitVisibility(counters).get(0).click();
		for(int i =0; i < Integer.parseInt(numberOfChildren); i++)
			awaitVisibility(counters).get(2).click();

		awaitVisibility(searchBtn).click();
	}

	public void myFlights() {
		awaitVisibility(flightOutBound).click();
		awaitVisibility(tickets).get(0).click();
		awaitVisibility(flightInBound).click();
		awaitVisibility(tickets).get(0).click();
	}
}



