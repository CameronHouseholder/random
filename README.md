# safensound-selenium

Selenium project for onsite interview at BoxView LLC.

## required software
Java and MVN executable.

This project was developed and complied with Java 1.11. If you are using a different JDK version you will have to edit the pom.xml to compile to a different version.

## running tests
Running the below command will run the SafeNSoundIT.xml in the project and execute a single testNG test in 2 different browsers (Chrome and Firefox).

```bash
mvn test
```

*This was developed and tested on a windows machine. I added some support for running this project on a linux machine but since I don't have access to one was unable to test it. If you wish to run this on linux you most likely will have to install the correct drivers.

```bash
mvn test -Dplatform=linux
```

## report
Once the tests have completed an Extent report is generated at "target/extent-report/ExtentReport.html"

