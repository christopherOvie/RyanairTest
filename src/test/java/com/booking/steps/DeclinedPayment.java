package com.booking.steps;

import com.booking.pages.PaymentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

public class DeclinedPayment extends ScenarioSteps {

	private PaymentPage page;

	@When("Payment is made with invalid card")
	public void payment_is_made_with_invalid_card() {
		page.makePayment();
	}
	@Then("Display error {string}")
	public void display(String errorMessage) {
		page.paymentDeclined(errorMessage);
	}
}
