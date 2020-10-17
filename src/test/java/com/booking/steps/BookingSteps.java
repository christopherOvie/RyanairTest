package com.booking.steps;

import com.booking.pages.BookingPage;
import io.cucumber.java.en.Then;
import net.thucydides.core.steps.ScenarioSteps;

public class BookingSteps extends ScenarioSteps {

	private BookingPage page;

	@Then("Input flight detail {string} and {string} is an adult {string}")
	public void input_flight_detail_and_is_an_adult(String names, String surnames, String grade) {
		page.setPassengerDetail(toArray(names), toArray(surnames), toArray(grade));
	}

	@Then("Select flight seat for {string}")
	public void select_flight_seat_for(String size) {
		page.setPassengerSeat(size);
		page.clickToSelectArrivalSeats();
		page.setPassengerSeat(size);
		page.clickToContinue();
	}

	private String[] toArray(String string){
		return string.split(",");
	}
}
