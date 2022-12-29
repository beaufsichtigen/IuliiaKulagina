Feature: User can login

Scenario: User Authenticated Page test
Given: I open JDI GitHub site
When I login with login and password
And I see page URL "https://jdi-testing.github.io/jdi-light/index.html"
Then I see "ROMAN IOVLEV" name is displayed in the left-top side of screen
