## Booking Automation

This test is focus on the automation on Ryan Air, which handled a booking for 2 adults and a child.

In this test BDD is demonstrated as well as a clean separation of concern between the pageobjects and steps. 

However this automation is limited to the requirements only, thorough edge cases are not covered.

### Prerequisite

Ensure Java is installed on your machine to be able to run this project, maven is used to manage the dependencies
[Java 1.8 +] ()
[Maven] () 

### Introduction

Before you begin kindly replace the email and password in the [feature file](src/test/resources/features/declined-booking.feature)

User information is parameterized and are read from there. An invalid card information is provided which is expected to fail.

When the test starts it supplies all the required information from the parameterized values in the feature file. 
Then a test is carried on the invalid card detail to determine that the status failed.

Also ensure a user with a valid credentials on ['Ryan  Air']('https://www.ryanair.com/ie/en/') is provided, only a valid user can run this automation e2e


### Technical Decisions

This automation is written with Java on maven, however it can be replicated in JavaScript.

The reason for favouring java is just for a preference take, although it is a very comfortable environment. 

This test design is focused on ensuring that components that are reusable are identified and abstracted in such a manner that
they don't get rewritten each time a new component is required. Some of the the identified reuseable components include
``Search
Login
Payment``

The steps definitions which implemented the scenarios are separated into different concerns so that they can be reused and grouped according to usages
One of the advantage of this decision is that any part of the component can be reused, for example the login steps are made reusable.

Also the PageObjects are made reusable, this is achieved by ensuring that each PageObject handles just one object only.
This design is based on ensuring that future components are duplicated and codes can easily be maintained.

In conclusion the step definitions are made to be oblivious of the actions they perform, which is solely assigned to the PageObject. 

Be sure you set the actual driver of your browser from the [webdriver](src/test/resources/webdriver) without setting this to match your
current machines driver, th browser will not start.

### Automation Requirements

`Please automate a booking up to a declined payment on • https://www.ryanair.com/ie/en/
Use any card number and verify the error message.`


## Feature file
This feature is generated from the usecase scenarios for booking a flight with some parameterised values and augmented 
for a thorough process flow

```
@Positive
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
      | Dublin    |  Hamburg  |    2   |  1  |    2020-11-08 |  2020-11-29 | chris.ovie95@gmail.com | Tkogl1979 | Chris,James,John |  Ovie,Cyp,Doe | adult,adult,teen | 3 | 123456789 | 1232 43235 454656  |  123  |  Chris Ovie  | UK 555 | Germany  | London | 234 |

```


### Steps to run

```./mvnw install``` for the first time to pull dependencies: for windows remove _./_ and run `mvnw install` instead

Then:

```./mvnw verify``` to execute and run cucumber e2e and on windows use `mvnw verify`


#### Note

 ```There might be some latency and test failures if the network is unstable, do rerun the test incase any test fails.```

### Reporting 


After every test run  a [report](target/site/serenity/index.html) is generated, you can navigate to it to have a full report view. 
