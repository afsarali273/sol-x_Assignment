# Covi-Rox Assignment

**How to Run**

```cmd
1. git clone "https://github.com/afsarali273/IamPlus_Assignment.git"

2. cd /path/to/project/covirox_Assignment

3. mvn clean install
4. mvn test 

if you want to run for IOS then 

mvn test -DplatformType='IOS'
```

or you can also run test from feature file

*Go to /iamplus_Assignment/src/test/resources/features/
Run manually by right clicking and Run feature file.*

```html
Below Tests are covered:

Feature :
1.Open the Android App "CineFlutter"
2.Validate HomePage
3.Click on the First Movie in the List from Popular Section
4.Validate Movie Details in the Content Details Page
5.Validate Navigation to Casting details and Navigate back.

```

```gherkin
Feature: UpComing Movies Validation

  Scenario: Upcoming Movie Navigation
    Given I am on the HomePage
    When I click on the firstMovie Item from upcoming  movie list
    Then I shall see Movie details of that first movie

```

```gherkin
Feature: Popular Movies Validation

  Scenario: Popular Movie Navigation
    Given I am on the HomePage
    When I click on the firstMovie Item from popular movie list
    Then I shall see Movie details of that first movie

```
**Test Results**


