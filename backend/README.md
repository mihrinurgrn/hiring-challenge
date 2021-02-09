# hiring-challenge
## Getting Started ##
First of all you should change username, password and db name with your username password and db name for Postgresql (Line 3,4,5 in application.properties)
and you should run the project after that you should go to  http://localhost:8080/

### Run project ##

You can run the project with the following command

`mvn spring-boot:run`

### Rest endpoints ###
There are two endpoints in this project. 
`/address` 
`/address`

The one of them is for Post request and the other one for Get request.
You can use Post `/address`  for add a new address
and You can use Get `/address` for list of all addresses

Also you have to a body for post request. You can see an example body for this request in the below.
`
{
	"city":"sample data",
	"district":"sample data"
}`

### For run tests ###
 Run all the unit test classes.
`mvn test`


### Dependencies ###
* JAVA 11
* Spring Boot 2.4.2





