package com.booking.steps;

import com.booking.pages.BookingPage;
import com.booking.pages.InsurancePage;
import com.booking.pages.LuggagePage;
import com.booking.pages.SeatPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.steps.ScenarioSteps;

public class BookingSteps extends ScenarioSteps {

	private BookingPage bookingPage;
	private SeatPage seatPage;
	private LuggagePage luggagePage;
	private InsurancePage insurancePage;

	@And("I choose flights")
	public void i_choose_flights() {
		bookingPage.myFlights();
	}

	@Then("Input flight detail for first adult {string} and {string}")
	public void input_flight_detail_for_first_adult(String name, String surname) {
		bookingPage.adultInfo(0, name, surname);
	}

	@Then("Input flight detail for second adult {string} and {string}")
	public void input_flight_detail_for_second_adult(String name, String surname) {
		bookingPage.adultInfo(1, name, surname);
	}

	@Then("Input flight detail for child {string} and {string}")
	public void input_flight_detail_for_child(String name, String surname) {
		bookingPage.teenInfo(2, 0, name, surname);
		bookingPage.activateContinueBtn();
	}

	@And("I select flight seat for {string}")
	public void select_flight_seat_for(String size) {
		seatPage.setPassengerSeat(size);
		seatPage.clickToSelectArrivalSeats();
		seatPage.setPassengerSeat(size);
		seatPage.clickToContinue();
	}

	@And("I select luggage type")
	public void select_luggage_type() {
		luggagePage.clickToContinue();
	}

	@And("I select insurance type")
	public void select_insurance_type() {
		insurancePage.clickToContinue();
	}

}
