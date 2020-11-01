@Booking
Feature: Declined Payment
  Background:
    Given "https://www.ryanair.com/ie/en/" is open


  Scenario Outline: Search for trip for 2 Adults and a child
    Given I enter "<departure>" as departure and "<arrival>" as arrival
    And  I selected "<departureDate>" as departure and "<returnDate>" as return of travel
    And  I select "<numberOfAdults>" as number of adults and "<numberOfChildren>" as number of children
    And I choose flights
    And I click on login button
    And I login with "<username>" as username and "<password>" as password
    And Input flight detail for first adult "<firstName1>" and "<lastName1>"
    And Input flight detail for second adult "<firstName2>" and "<lastName2>"
    And Input flight detail for child "<firstName3>" and "<lastName3>"
    And I select flight seat for "<size>"
    And I select luggage type
    And I select insurance type
    And I select mode of payment
    And I input telephone number as "<telephone>"
    And Input failed card detail "<card-number>", "<cvv>", "<name>", "<address>", "<country>", "<city>", "<zip>"
    When Payment is made with invalid card
    Then Display error "Oops, something went wrong. Please check your payment details and try again"


    Examples:
      | departure | arrival | numberOfAdults | numberOfChildren | departureDate | returnDate | username               | password  | firstName1 | lastName1 | firstName2 | lastName2 | firstName3 | lastName3 | size | telephone | card-number       | cvv | name       | address | country | city   | zip |
      | Dublin    | Hamburg | 2              | 1                | 2020-11-08    | 2020-11-29 | maryannbnj25@gmail.com | Qazwsx123 | Chris      | Ovie      | James      | Bond      | Cyp        | Omens     | 3    | 123456789 | 1232 43235 454656 | 123 | Chris Ovie | UK 555  | Germany | London | 234 |
