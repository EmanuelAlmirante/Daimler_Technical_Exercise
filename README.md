# Daimler Technical Exercise

The goal of this challenge is to build a web service that exposes Vehicle (Bus), Fleet (Operator), and Activity (Stop) data, for a given time frame.

The service exposes a RESTful API to answer the following questions:

1.    Given a time frame [start-time, end-time], what is the list of running operators?

2.    Given a time frame [start-time, end-time] and an Operator, what is the list of vehicle IDs?

3.    Given a time frame [start-time, end-time] and a fleet, which vehicles are at a stop?

4.    Given a time frame [start-time, end-time] and a vehicle, return the trace of that vehicle (GPS entries, ordered by timestamp).

Before implementing this exercise, you need to:

§    Choose a database management system that is more appropriate for building this web service (we value NoSQL databases, but a relational database may be also fine);

§    Choose a programming language that is type-safe and you are familiar with;

§    Choose a web toolkit that is able to handle high throughput in terms of number of requests (we are less worried about latency, but that's not to be neglected as well).

What to deliver:

·         A git code repo, public or private, that can be accessed by our team, with the following:

·         Instructions on how to install and/or access to the database;

·         A data loader script;

·         The code of the web service; 

·         Instructions on how to launch the HTTP service;

·         Documentation and/or examples on how to use the API.

Dataset to use:

At this moment there are some issues with this dataset from Dublin but we managed to extract the files and you should be able yo find some of the data in this link:

Name: Dublin Bus GPS sample data from Dublin City Council  

      URL: https://codechallengestracc.blob.core.windows.net/code-challenge/dublin-dataset.zip

      URL: https://data.gov.ie/dataset/dublin-bus-gps-sample-data-from-dublin-city-council-insight-project

 
Download one extract, and from that extract, use 1 example CSV as input



### Tech Stack:

- Java 11
- Spring Boot
- Spring Security
- Hibernate
- H2 Database (in-memory)
- JUnit
- Mockito

### Setup:

- Clone project to a folder
- Run the application with:
  - _mvn clean install_
  - _mvn spring-boot:run_
- Test the application with:
  - _mvn test_ -> run all tests
  - _mvn -Dtest=TestClass test_ -> run a single test class
  - _mvn -Dtest=TestClass1,TestClass2 test_ -> run multiple test classes
- Package the application with _mvn package_
- Test using Postman
