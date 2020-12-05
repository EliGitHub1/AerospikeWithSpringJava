# JavaMapImplementation

Version 0.1

Author:
Eli Aviv
eliaviv2@gmail.com


Goal:
=========
Java Map Implementation using Aerospike as data source

Install:
=========

1. Java jdk 11+
2. Aerospike local server 
3. Postman

Run:
=========

1. java -v , to verify java is ready 
2. Aerospike local server, verify by navigating Aerospike Monitoring Console 
3. Run JavaMapImplementation/map/src/main/java/com/eliaviv/map/MapApplication.java

Test:
=========

1. Import collection attached to Postman
2. Replace localhost value if need and run api/method/healthcheck
3. First create a map and keep map reference uuid. (Map reference uuid is the map "address")
4. use Put: 
  4.1 Paste map reference uuid to "mapRefuuid"
  4.2 send request

Examples:
=========
1. createMap
CTOR which support initiate with existing key and value:

request body:
				{
					"pairList":[
						{
							"key":"3",
							"value":4
						},
						{
							"key":"5",
							"value":65
						},
						{
							"key":"4564654",
							"value":4
						}
					]
				}

response body:
			
				{
				    "uuid": "3e16142d-3157-4d42-a977-17506553416a"
				}


2. put:
same uuid is used as returned from CTOR
				
				{
					"key":"MyKey",
					"value":"myValue",
					"mapRefuuid":"3e16142d-3157-4d42-a977-17506553416a"   
				}



Notes:
=========
2. Only put and CTOR have been implemented
3. This version has no test at the moment 
