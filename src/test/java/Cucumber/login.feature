@tag
Feature: Ordering Products in the E-commerce

  Background: 
    Given I Landed on the E-commerce page

  @tag1
  Scenario Outline: Purchasing product in the E-commerce
    Given logged in to the E-commerce application with user name "<email>" and password "<password>"
    When Adding the product "<productName>" to the cart
    And Checkout the product "<productName>" place the order
    Then confirmation message "THANKYOU FOR THE ORDER." visible

    Examples: 
      | email            | password     | productName     |
      | abcdabcd@abc.com | Password@123 | ZARA COAT 3     |
      | xyzxyz@xyz.com   | Password@123 | ADIDAS ORIGINAL |
