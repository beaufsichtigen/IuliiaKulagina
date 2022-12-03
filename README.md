# IuliiaKulagina

On our project, I came across 3 types of automated tests: Geb, API E2E, API point tests. 
UI is covered with Geb tests. API E2E cover the minimum number of scenarios that can only be tested at the intersection of several API calls. The rest is covered by point API tests. Manual testers, write scenarios and review final tests. 

Tests are built into CI/CD. Some of the tests are run with each new env deployment. All tests are run during weekly releases.