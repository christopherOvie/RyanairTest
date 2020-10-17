package com.booking.steps;

import com.booking.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchFlightSteps extends ScenarioSteps {


	private SearchPage page;

	@Given("I enter {string} as departure and {string} as arrival")
	public void i_enter_as_departure_and_as_arrival(String departure, String arrival) {
		page.departureTxtField.click();
		page.departureTxtField.clear();

		page.selectTravelPlan(departure, arrival);

	}

	@And("I selected {string} as departure and {string} as return of travel")
	public void i_selected_as_departure_and_as_return_of_travel(String departureDate, String arrivalDate) {
		page.setDates(departureDate, arrivalDate);
	}

	@And("I select {string} as number of adults and {string} as number of children")
	public void i_select_as_number_of_adults_and_as_number_of_children(String numberOfAdults, String numberOfChildren) {

		page.setNumberOfPassengers(numberOfAdults, numberOfChildren);
	}

	@And("I choose flights")
	public void i_choose_flights() {

		page.myFlights();
	}

}
