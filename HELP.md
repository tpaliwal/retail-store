# Instructions and General Information

## Instructions
The project is a spring boot application for retail discounts which provide rest endpoint to calculate net payable amount, application is using following technologies:

* Sprint Boot
* Maven
* Java 1.8
* JUnit for Unit Tests
* Eclipse(IDE)

Since the application is created using Spring Boot and Maven we can boot application using below command in application root directory.
*  mvn spring-boot:run


Furthermore, unit tess are provided that can run by executing TestDiscounts and TestWithoutDiscounts which provides complete test coverage. Testcases can be run using below command.

* mvn test (For all test cases)
  or
* mvn -Dtest=TestDiscounts test
* mvn -Dtest=TestWithoutDiscounts test 

Comments are provided in the code and test cases for briefly describe the functionality and approach.

## Endpoint and sample input

After successful application bootup, application will expose below endpoint.

* http://localhost:8080/store/calculatePayableAmount

which will calculate net payable amount and type of request is **POST** which accepts **application/json** as a content type.

## Sample input

{
   "user" : {
		"type" : "EMPLOYEE",
		"userName" :"Tushar"
	},
	"products":[{
		"name" : "Rice",
		"unitPrice" : 20.0,
		"type" : "GROCERY",
		"units" : 4
	},{
		"name" : "TV",
		"unitPrice" : 222.0,
		"type" : "OTHER",
		"units" : 4
	}]
}
 

## General Information regarding the solution

- **Items** represent goods/products that can be placed in the cart.

- A **cart** contains a number of items, and can compute the total price of its contents.

- Cart items can either be actual **products** with a fixed unit price, or products with a **pricing policy** attached for any dicounts that are calculated based on items and not the overall discount policy of current cart.

- **DiscountPolicy** is used to calculate or apply different discounts based on overall cart value of contents.

