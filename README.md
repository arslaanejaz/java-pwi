Development Technologies:
Spring 4, Hibernate 4, MySql 5, Tomcat 8, Java 8, Maven, TestNG, Mockito.

Change accordingly src/main/resources/application.properties file for database connection

Architecture Design
Product&Warehouse&Inventory (PWI)
Introduction:
Purpose:
This document provides a very basic  architectural overview of the system. I will also try to suggest the future improvements in the system, security of the system and efficiency of the application and will explain about few things that where the part of my development plan but left out because of by busy schedule.
Solution Overview:
Problem statement:
Company A has two brands Brand1 and Brand2 where each brand has multiple products with multiple sizes. Company has their offices in different locations. In future, they can start a new office in some other location as well. They have warehouses where they manage their inventory. Each warehouse can have all products or some products and they manage their inventory according to the warehouse inventory. Company A requires to implement a solution so that they could manage their products, components, packaging material and their sizes and their inventory per warehouse and per office.
Problem Solving:
On company can have many countries and one country can have many Warehouses . Each Warehouse can have many products and each product is associated with the brand. In this solution all the entities are interconnected and can be fetched according to any criteria. And I set products as inventory so we can apply complex formulas to manage inventory. (The formulas and reports I didn't get much time to work on them but easily achievable on current structure) 
Architecture Goals and Constraints:
Architectural goal is to have efficient development and have full control on the architecture of the solution. I also added service layer so we can handle complexity of the problem in future.
Exception Handling
I used ControllerAdvice for exception handling but not parsed error messages in detail. 

Suggestions: 
Need formulas/solution to change the status of an individual product.
Reports section need to be developed.



