Feature: User can open anauthenticated Home Page

  Scenario: User Anauthenticated Page test
  Given: I open JDI GitHub site
    When I see Anauthenticated Home page opens
    Then I see "Home Page" Browser title
    And I see page URL "https://jdi-testing.github.io/jdi-light/index.html"

    When I login as user "Roman Iovlev"
    And I see page URL "https://jdi-testing.github.io/jdi-light/index.html"
    Then I see "ROMAN IOVLEV" name is displayed in the left-top side of screen

    When I open through the header menu Service -> Different Elements Page
    Then I see page URL "https://jdi-testing.github.io/jdi-light/different-elements.html"

    When Select checkbox "Water"
    And Select checkbox "Wind"
    Then I see "Water" element is checked
    And I see "Wind" element is checked

    When Select radio "Selen"
    Then I see "Selen" metal is checked

    When Select in dropdown "Yellow"
    Then I see "Yellow" color is selected

    When I clear elements status
    Then I see an individual log row and value is corresponded to the status of checkbox
    And I see an individual log row and value is corresponded to the status of radio button
    And I see an individual log row and value is corresponded to the selected value for dropdown


#And Click on each checkbox, radio button, dropdown value


#And There is individual log row and value is corresponded to the status of checkbox, radio button, dropdown value.






#Feature: User can open anauthenticated Home Page
#
#  Scenario: User Anauthenticated Page test
#  Given: I open JDI GitHub site
#    When I see Anauthenticated Home page opens
#    Then I see "Home Page" Browser title
#    And I see page URL "https://jdi-testing.github.io/jdi-light/index.html"


