Lab 2: Starfleet Fleet Management System

Overview

This Java-based project simulates a fleet management system for a fictional Starfleet. The program reads crew and starship data from CSV files within a specified directory and displays the details of the fleet. It demonstrates object-oriented programming concepts such as encapsulation, composition, and file I/O.

Files

CrewMember.java: Defines the CrewMember class representing an individual member of a starship's crew.

Fleet.java: Defines the Fleet class responsible for managing multiple starships.

Starship.java: Defines the Starship class representing an individual starship.

Lab2.java: The main entry point to run the program.

Gradle Files:

build.gradle: Configures the Gradle build process.

gradle.properties: Contains JVM and AndroidX settings.

gradle-wrapper.properties: Specifies the Gradle distribution.

gradlew & gradlew.bat: Gradle wrapper scripts for Unix and Windows.

settings.gradle: Configures project settings.

Android Components:

AndroidManifest.xml: Declares app components, permissions, and settings.

ExampleInstrumentedTest.java: Contains instrumented tests for Android devices.

ExampleUnitTest.java: Contains unit tests for local development.

Class Descriptions

1. CrewMember.java

Attributes: Name, Position, Rank, Species, Assignment

Methods:

Constructors for initializing CrewMember objects

Getters and setters for each attribute

toString() for a readable representation

2. Fleet.java

Attributes: Name, List of Starships

Methods:

Add and retrieve starships

Load starships from CSV files in a specified directory

toString() for displaying fleet information

3. Starship.java

Attributes: Name, Registry, Starship Class, List of Crew Members

Methods:

Add crew members

Retrieve the number of personnel

toString() to print ship and crew details

4. Lab2.java

Contains the main method to initialize a Fleet, load starships from the data directory, and print fleet details.

Setup and Execution

Ensure the CSV files are stored in a folder named data.

Compile the code:

./gradlew build

Run the program:

java -cp build/classes/java/main Lab2

Directory Structure

.
├── data/
│   └── [CSV files for starships and crew]
├── src/
│   └── main/
│       └── java/
│           └── [Java source files]
├── src/
│   └── androidTest/
│       └── java/
│           └── ExampleInstrumentedTest.java
├── src/
│   └── test/
│       └── java/
│           └── ExampleUnitTest.java
├── AndroidManifest.xml
├── build.gradle
├── gradle.properties
├── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
├── Lab2.java
└── README.md

Sample Output

United Federation of Planets
Starship[name=USS Enterprise, registry=NCC-1701-A, starshipClass=Constitution, crewMembers=CrewMember[Name=James T. Kirk, Rank=Captain, Position=Commanding Officer, Species=Human]
CrewMember[Name=Spock, Rank=Commander, Position=Science Officer, Species=Vulcan]]

Notes

Ensure the CSV files contain valid data with columns for crew name, position, rank, and species.

The Fleet.loadStarships method reads .csv files in the data directory.

Error messages are printed if file loading fails.

Android instrumentation tests can be run using Android Studio or command line.
