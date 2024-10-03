# TODOAutomationFC

1.) Java library API Automation for testing RestFul API


## Framework Structure

1.) Maven Framework tool for building and Managing Java RestAPI Project
2.) Rest Assured Library for testing and validating REST services in java
3.) TestNg testing Framework for Testing API's like JUnit
4.) Jackson java Library for Serialization and Deserialization
5.) Owner library for Config handling

### Quick Start

  -Prerequisites
	- Java (version 8 or higher)
	- Eclipse
	- Maven
	- TestNG

# Setup for TODOAutomationFC on your machine

## Initial Setup

### Clone TODOAutomationFC on your machine

This will take some time .Let it run in the background

### Install JAVA Version if not installed(Maven version compatibility)

Maven 3.9.9 is compatible with the following Java versions:
- **Java 8**
- **Java 9**
- **Java 11 (LTS)**
- **Java 17 (LTS)**
- **Java 21 (LTS)**

For most projects, it is recommended to use **Java 11 or later** since these versions are Long-Term Support (LTS) releases.

### Verify Java Installation
To verify if Java is installed on your machine and check its version, use the following command:

```bash
java -version
```

For Java installation refer online.

### Eclipse Setup - Run Tests on Eclipse

- Install Eclipse IDE for Java Developers and Projects. You can download it from the Eclipse website [here](https://eclipse.org/downloads/).
- Go to File > Import.
- Select Existing Maven Projects under the Maven folder.
- Click Next, and browse to the location where your TODOAutomationFC project is located.
- Select the project folder and click Finish.
- Configure the project Structure (JavaBuildPath => Java version as given above)
- Maven clean the project
- Install Testng from the Eclipse MarketPlace
- Accept agreements and certificates for Testng
- Eclipse will restart for Applying effects for Testng
- Go to testng.xml in root project
- Right click and Run as Testng.xml


### Run Test cases from the Terminal(only Maven)

- Install Maven zip for Apache Maven Community from (here)(https://maven.apache.org/download.cgi)
- Add path to the Env Variables so that maven cli is accessible to the terminal(Check online to add path)
- Check whether Maven is installed
  
  ```bash
  mvn -version
  ```
- To Run the Tests on the terminal , Open terminal and go to the Project root directory
- Run the following command to run the tests through maven
  
  ```bash
  mvn clean test
  ```

### NOTE: Following Services are not included in the project

- Listeners Service (Listens to every event that occurs in testng)
- Extent Reporters Service (Reporters for the Test Results - Currently we have default reporter)
- Assertions Service (Inbuilt Assertions for better Readability)











