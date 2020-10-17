package com.booking.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookingPage extends CommonPage {


	private WebElementFacade firstName;
	private WebElementFacade lastName;

	@FindAll({
		@FindBy(xpath = "//div[@class='dropdown b2']"),
	})
	private List<WebElementFacade> titleDropDown;

	@FindAll({
		@FindBy(xpath = "//div[@class='dropdown-item__label b2']"),
	})
	private List<WebElementFacade> titles;

	@FindBy(xpath = "//button[@class='continue-flow__button ry-button--gradient-yellow']")
	private WebElementFacade submitBtn;

	@FindBy(xpath = "//button[@class='seats-modal__cta ry-button--gradient-blue']")
	private WebElementFacade popupBtn;

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

	@FindAll({
		@FindBy(xpath = "//label[@class='ry-radio-circle-button__label']")
	})
	private List<WebElementFacade> luggages;

	public void setPassengerDetail(String[] firstNames, String[] lastNames, String[] ageGrade) {
		for(int i = 0, j =0, k = 0; i < ageGrade.length; i++){
			switch (ageGrade[i]){
				case "adult":
					adultInfo(i, firstNames[i], lastNames[i]);
					break;
				case "teen":
					teenInfo(i, j, firstNames[i], lastNames[i]);
					j++;
					break;
				case "child":
					childInfo(k, firstNames[i], lastNames[i]);
					k++;
					break;
			}
		}
		awaitVisibility(submitBtn).click();
	}

	private void adultInfo(int position, String firstName, String lastName) {
		setTitle(position);
		this.firstName = element(By.id("formState.passengers.ADT-" + position + ".name"));
		this.lastName = element(By.id("formState.passengers.ADT-" + position + ".surname"));
		fillForm(firstName, lastName);
	}

	private void teenInfo(int position, int index, String firstName, String lastName) {
		setTitle(position);
		this.firstName = element(By.id("formState.passengers.TEEN-" + index + ".name"));
		this.lastName = element(By.id("formState.passengers.TEEN-" + index + ".surname"));
		fillForm(firstName, lastName);
	}

	private void  setTitle(int position){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		awaitVisibility(titleDropDown.get(position)).click();
		awaitVisibility(titles).get(0).click();
	}

	private void childInfo(int index, String firstName, String lastName) {
		this.firstName = element(By.id("formState.passengers.CHD-" + index + ".name"));
		this.lastName = element(By.id("formState.passengers.CHD-" + index + ".surname"));
		fillForm(firstName, lastName);
	}

	private void fillForm(String fName, String lName) {

		awaitVisibility(firstName).clear();
		firstName.click();
		firstName.sendKeys(fName);
		awaitVisibility(lastName).clear();
		lastName.click();
		lastName.sendKeys(lName);
	}

	public void setPassengerSeat(String size) {
		for(int i = 0; i < Integer.parseInt(size); i++)
			awaitVisibility(flightSeats).get(i).click();
	}

	public void clickToSelectArrivalSeats() {
		awaitVisibility(nextBtn).get(0).click();
	}

	public void clickToContinue() {
		awaitVisibility(continueBtn).click();
		awaitVisibility(noThanksLinks).click();
		awaitVisibility(luggages).get(0).click();
		awaitVisibility(continueBtn2).click();
		awaitVisibility(continueBtn3).click();
	}
}



