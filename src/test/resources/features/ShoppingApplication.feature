@AA

Feature: E-commerce website workflow

Scenario:  User search for item and buying it
Given      User navigated to application url
When       User search for "shoes"
And        Result display for shoes
And        User select item from list and new tab gets open with item description
Then       User add item to bag to buy