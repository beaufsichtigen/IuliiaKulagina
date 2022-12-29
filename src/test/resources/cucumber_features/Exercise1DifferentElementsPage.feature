Feature: User can choose elements on Different Elements Page

Scenario: User Different Elements Page test
Given: I open JDI GitHub site
When I open through the header menu Service -> Different Elements Page
And Select checkbox "Water"
And Select checkbox "Wind"
And Select radio "Selen"
And Select in dropdown "Yellow"
#And Click on each checkbox, radio button, dropdown value
Then I see "Water" element is checked
And I see "Wind" element is checked
And I see "Selen" metal is checked
And I see "Yellow" color is selected
#And There is individual log row and value is corresponded to the status of checkbox, radio button, dropdown value.
