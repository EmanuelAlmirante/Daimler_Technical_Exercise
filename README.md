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
- Hibernate
- Swagger
- MySQL 8
- JUnit
- Mockito
- Postman

### Setup (Note: this setup is for a machine running Linux Ubuntu):

- Install database following the instructions in this link -> https://computingforgeeks.com/how-to-install-mysql-8-0-on-ubuntu-linux/
- Clone project to a folder
- Change the line _LOAD DATA LOCAL INFILE '~/Desktop/Personal_Projects/Daimler_Technical_Exercise/database_resources/siri.20121123.csv'_ in the _data_loader_script.sql_ to match the path where you have your CSV file
- Access the database through a terminal using _mysql --local_infile=1 -u root -p_ where password is equal to _root_ and execute the commancd _set global local_infile=true;_ 
- Run the command _source [path_to_script]/data_loader_script.sql_ and the database will be populated with the information in the CSV file
- Run the application with:
  - _mvn clean install_
  - _mvn spring-boot:run_
- Test the application with:
  - _mvn test_ -> run all tests
  - _mvn -Dtest=TestClass test_ -> run a single test class
  - _mvn -Dtest=TestClass1,TestClass2 test_ -> run multiple test classes
- Package the application with _mvn package_
- Test using Postman


## Endpoints:

The documentation of this API can be found at _http://localhost:8080/swagger-ui.html/_ (Note: you need to initialize the application to access this link).

The API endpoints are also documented below, as well as some examples requests made to the API.

Note that the datime format is the following -> _yyyyMMddHHmmssSSS_

* List of running operators:
      
     **Given a time frame [start-time, end-time], what is the list of running operators?**
     
      GET daimler/api/gps-data/running-operators?starttime={startime}&endtime={endtime}
      
     URL: 
     
      http://localhost:8080/daimler/api/gps-data/running-operators?starttime=20121123080000000&endtime=20121123080001000
      
     Response status:
     
      200 OK
      
     Body:
      
      Empty
      
     Return:
     
      [
          {
              "operator": "HN"
          },
          {
              "operator": "CF"
          },
          {
              "operator": "D1"
          },
          {
              "operator": "PO"
          },
          {
              "operator": "SL"
          },
          ...
      ]
      
* List of vehicle IDs:

     **Given a time frame [start-time, end-time] and an Operator, what is the list of vehicle IDs?**
     
      GET daimler/api/gps-data/vehicle-ids?starttime={startime}&endtime={endtime}&operator={operator}
      
     URL:
     
      http://localhost:8080/daimler/api/gps-data/vehicle-ids?starttime=20121123080000000&endtime=20121123080001000&operator=PO
      
     Response status:
     
      200 OK
      
     Body:
      
      Empty
      
     Return:
     
      [
          {
              "operator": "PO",
              "vehicleId": 33568
          },
          {
              "operator": "PO",
              "vehicleId": 36063
          },
          {
              "operator": "PO",
              "vehicleId": 33573
          },
          {
              "operator": "PO",
              "vehicleId": 33588
          },
          {
              "operator": "PO",
              "vehicleId": 33314
          },
          ...
      ]
      
* List of vehicles at a stop:

     **Given a time frame [start-time, end-time] and a fleet, which vehicles are at a stop?**
     
      GET daimler/api/gps-data/at-stop?starttime={startime}&endtime={endtime}&operator={operator}
      
     URL:
     
      http://localhost:8080/daimler/api/gps-data/at-stop?starttime=20121123080000000&endtime=20121123080001000&operator=PO
      
     Response status:
     
      200 OK
      
     Body:
      
      Empty
      
     Return:
     
      [
          {
              "atStop": true,
              "operator": "PO",
              "vehicleId": 33568,
              "stopId": 1715
          },
          {
              "atStop": true,
              "operator": "PO",
              "vehicleId": 36063,
              "stopId": 4496
          },
          {
              "atStop": true,
              "operator": "PO",
              "vehicleId": 33314,
              "stopId": 73
          },
          {
              "atStop": true,
              "operator": "PO",
              "vehicleId": 33600,
              "stopId": 1829
          },
          {
              "atStop": true,
              "operator": "PO",
              "vehicleId": 33431,
              "stopId": 4747
          }
      ]
      
* List of vehicle GPS coordinates ordered by timestamp:

     **Given a time frame [start-time, end-time] and a vehicle, return the trace of that vehicle (GPS entries, ordered by timestamp).**
     
      GET daimler/api/gps-data/gps-tracing?starttime={startime}&endtime={endtime}&vehicleid={vehicleid}
      
     URL:
     
      http://localhost:8080/daimler/api/gps-data/gps-tracing?starttime=20121123080000000&endtime=20121123080100000&vehicleid=33568
      
     Response status:
     
      200 OK
      
     Body:
      
      Empty
      
     Return:
     
      [
          {
              "timestamp": 1353657601000000,
              "lat": 53.347733,
              "vehicleId": 33568,
              "lon": -6.28225
          },
          {
              "timestamp": 1353657624000000,
              "lat": 53.347733,
              "vehicleId": 33568,
              "lon": -6.28225
          },
          {
              "timestamp": 1353657642000000,
              "lat": 53.347275,
              "vehicleId": 33568,
              "lon": -6.282392
          },
          {
              "timestamp": 1353657660000000,
              "lat": 53.347275,
              "vehicleId": 33568,
              "lon": -6.282392
          }
      ]
