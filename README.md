##Deviget SDET-Test challenge
The porpuse of this challenge is to demostrate the capabilities to create and Backend Framewoek from scratch using Java.
##Author 
Gonzalo Cervantes - Candidate for SDET BackEnd
###Application under test
* NASA OPEN API - https://api.nasa.gov/index.html#browseAPI

###Installation Required
* JDK 8
* IntelliJ IDEA
* Gradle 7.3
* Lombok


###Scenarios Tested:

* Retrieve the first 10 Mars photos made by "Curiosity" on 1000 Martian sol.
* Retrieve the first 10 Mars photos made by "Curiosity" on Earth date equal to 1000 Martian sol.
* Retrieve and compare the first 10 Mars photos made by "Curiosity" on 1000 sol and on Earth date equal to 1000 Martian sol.
* Validate that the amounts of pictures that each "Curiosity" camera took on 1000 Mars sol is not greater than 10 times the amount taken by other cameras on the same date.
* Write integration tests around the core functionality, not functional tests.

###Test Execution:
Test can be executed from the terminal with the following command:
```./gradlew clean test```

###Reporting
Execution Report can be consolidated into one file name _index.html_ and is placed under /target/site/serenity using the following command:

```gradle aggregate```

### References:
* Rest Assured - http://rest-assured.io
* Serenity - https://serenity-bdd.github.io



