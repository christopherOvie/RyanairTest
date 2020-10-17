@Booking
Feature: Declined Payment
  Background:
    Given "https://www.ryanair.com/ie/en/" is open


  Scenario Outline: Search for trip
    Given I enter "<departure>" as departure and "<arrival>" as arrival
    And  I selected "<departureDate>" as departure and "<returnDate>" as return of travel
    And  I select "<numberOfAdults>" as number of adults and "<numberOfChildren>" as number of children
    And I choose flights
    And I click on login button
    And I login with "<username>" as username and "<password>" as password
    And Input flight detail "<firstName>" and "<lastName>" is an adult "<passenger>"
    And Select flight seat for "<size>"
    And I select mode of payment
    And I input telephone number as "<telephone>"
    And Input failed card detail "<card-number>", "<cvv>", "<name>", "<address>", "<country>", "<city>", "<zip>"
    When Payment is made with invalid card
    Then Display error "Oops, something went wrong. Please check your payment details and try again"


    Examples:
      | departure |  arrival  | numberOfAdults | numberOfChildren  | departureDate |  returnDate |  username  |  password  |firstName |  lastName  | passenger | size | telephone |   card-number   |  cvv  |       name   | address  |  country| city  | zip |
      | Dublin    |  Hamburg  |    2   |  1  |    2020-11-08 |  2020-11-29 | christest95@yahoo.com | Tkogl1979 | Chris,James,John |  Ovie,Cyp,Doe | adult,adult,teen | 3 | 123456789 | 1232 43235 454656  |  123  |  Chris Ovie  | UK 555 | Germany  | London | 234 |
