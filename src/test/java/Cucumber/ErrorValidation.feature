@tag
Feature: Error Valdation
		  

  @ErrorValidation
  Scenario Outline: NEgative test for login
   Given I Landed on the E-commerce page
   Given logged in to the E-commerce application with user name "<email>" and password "<password>"
   Then "Incorrect email or password." message is displayed
  

    Examples: 
      | email            | password     |
      | abcdabcd@abc.com | Password@12t |

