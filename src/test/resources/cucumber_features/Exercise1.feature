Scenario: User Anauthenticated Page test
Given: I open JDI GitHub site
When I wait till Home page opens
Then I see "Home Page" Browser title
And I see page URL https://jdi-testing.github.io/jdi-light/index.html


Scenario: User Authenticated Page test
Given: I open JDI GitHub site
When I login as user "Roman Iovlev"
And I see page URL https://jdi-testing.github.io/jdi-light/index.html
Then I see ROMAN IOVLEV name is displayed in the left-top side of screen


Scenario: User Different Elements Page test
Given: I open JDI GitHub site
When I open through the header menu Service -> Different Elements Page
And Select checkboxes Water, Wind
And Select radio Selen
And Select in dropdown Yellow
And Click on each checkbox, radio button, dropdown value
Then I see Water, Wind	Elements are checked
And I see Selen metal is checked
And I see Yellow color is selected
And There is individual log row and value is corresponded to
the status of checkbox, radio button, dropdown value.
