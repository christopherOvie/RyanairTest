package com.booking.steps;

import com.booking.pages.PaymentPage;
import io.cucumber.java.en.Then;
import net.thucydides.core.steps.ScenarioSteps;

public class PaymentSteps extends ScenarioSteps {

	private PaymentPage page;

	@Then("I select mode of payment")
	public void i_select_mode_of_payment() {
		page.setModeOfPayment();
	}

	@Then("I input telephone number as {string}")
	public void i_input_telephone_number_as(String telephone) {
		page.setTelephone(telephone);
	}

	@Then("Input failed card detail {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void input_failed_card_detail(String card, String cvv, String name, String address, String country, String city, String zip) throws InterruptedException {
		page.debitCardDetail(card, cvv, name, address, country, city, zip);
	}
}
