Feature: User can open anauthenticated Home Page

  Scenario Outline: User Anauthenticated Page test
  Given: I open JDI GitHub site
    When I login with login and password
    And I open through the header menu Service -> Different Elements Page
    And Select checkbox "<checkbox>"
    Then I see log line of checkbox "<checkbox>" with "<value>"
    Examples:
      | checkbox | value |
      | Water    | true  |
      | Water    | false  |








#And Click on each checkbox, radio button, dropdown value


#And There is individual log row and value is corresponded to the status of checkbox, radio button, dropdown value.






#Feature: User can open anauthenticated Home Page
#
#  Scenario: User Anauthenticated Page test
#  Given: I open JDI GitHub site
#    When I see Anauthenticated Home page opens
#    Then I see "Home Page" Browser title
#    And I see page URL "https://jdi-testing.github.io/jdi-light/index.html"


