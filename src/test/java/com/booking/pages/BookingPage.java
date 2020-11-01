package com.booking.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookingPage extends CommonPage {


	private WebElementFacade firstName;
	private WebElementFacade lastName;

	@FindBy(xpath = "//fare-card[@class='fare-card-item__component ng-star-inserted']")
	private List<WebElementFacade> tickets;
	@FindBy(xpath = "//flight-card[@data-e2e='flight-card--outbound']")
	private WebElementFacade flightOutBound;
	@FindBy(xpath = "//flight-card[@data-e2e='flight-card--inbound']")
	private WebElementFacade flightInBound;

	@FindAll({
			@FindBy(xpath = "//div[@class='dropdown b2']"),
	})
	private List<WebElementFacade> titleDropDown;

	@FindAll({
			@FindBy(xpath = "//div[@class='dropdown-item__label b2']"),
	})
	private List<WebElementFacade> titles;

	@FindBy(xpath = "//button[@class='continue-flow__button ry-button--gradient-yellow']")
	private WebElementFacade continueBtn;

	@FindBy(xpath = "//button[@class='seats-modal__cta ry-button--gradient-blue']")
	private WebElementFacade popupBtn;


	@FindAll({
			@FindBy(xpath = "//label[@class='ry-radio-circle-button__label']")
	})
	private List<WebElementFacade> luggages;


	public void myFlights() {
		awaitVisibility(flightOutBound).click();
		awaitVisibility(tickets).get(0).click();
		awaitVisibility(flightInBound).click();
		awaitVisibility(tickets).get(0).click();
	}

	public void adultInfo(int position, String firstName, String lastName) {
		setTitle(position);
		this.firstName = element(By.id("formState.passengers.ADT-" + position + ".name"));
		this.lastName = element(By.id("formState.passengers.ADT-" + position + ".surname"));
		fillForm(firstName, lastName);
	}

	public void teenInfo(int position, int index, String firstName, String lastName) {
		setTitle(position);
		this.firstName = element(By.id("formState.passengers.TEEN-" + index + ".name"));
		this.lastName = element(By.id("formState.passengers.TEEN-" + index + ".surname"));
		fillForm(firstName, lastName);
	}

	public void childInfo(int index, String firstName, String lastName) {
		this.firstName = element(By.id("formState.passengers.CHD-" + index + ".name"));
		this.lastName = element(By.id("formState.passengers.CHD-" + index + ".surname"));
		fillForm(firstName, lastName);
	}

	public void activateContinueBtn() {
		awaitVisibility(continueBtn).click();
	}

	private void fillForm(String fName, String lName) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		awaitVisibility(firstName).clear();
		firstName.click();
		firstName.sendKeys(fName);
		awaitVisibility(lastName).clear();
		lastName.click();
		lastName.sendKeys(lName);
	}

	private void setTitle(int position) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		awaitVisibility(titleDropDown.get(position)).click();
		awaitVisibility(titles).get(0).click();
	}
}



