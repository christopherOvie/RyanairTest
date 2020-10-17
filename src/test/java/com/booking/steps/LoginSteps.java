package com.booking.steps;

import com.booking.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

	private LoginPage page;

	@And("I click on login button")
	public void i_click_on_login_button() {
		page.loinForm();
	}

	@Then("I login with {string} as username and {string} as password")
	public void i_login_with_as_username_and_as_password(String username, String password) {
		page.login(username, password);
	}
}
