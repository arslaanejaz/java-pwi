<h2>Development Technologies and tools:</h2>
<p>Operating System: Ubuntu 16.04</p>
<p>IDE: Spring Tool Suite</p>
<p>Other Plugins: Test NG for Eclipse</p>
<p>Server: tomcat8</p>
<p>Spring 4, Hibernate 4, MySql 5, Tomcat 8, Java 8, Maven, TestNG, Mockito.</p>

<h2>configurations</h2>
<p>Change accordingly src/main/resources/application.properties file for database connection</p>

<h2>Architecture Design</h2>

<p>Product&Warehouse&Inventory (PWI)</p>

<h3>Introduction:</h3>

<h3>Purpose:</h3>

<p>This document provides a very basic  architectural overview of the system. I will also try to suggest the future improvements in the system, security of the system and efficiency of the application and will explain about few things that where the part of my development plan but left out because of by busy schedule.</p>


<h3>Solution Overview:</h3>

<h3>Problem statement:</h3>

<p>Company A has two brands Brand1 and Brand2 where each brand has multiple products with multiple sizes. Company has their offices in different locations. In future, they can start a new office in some other location as well. They have warehouses where they manage their inventory. Each warehouse can have all products or some products and they manage their inventory according to the warehouse inventory. Company A requires to implement a solution so that they could manage their products, components, packaging material and their sizes and their inventory per warehouse and per office.</p>


<h3>Problem Solving:</h3>

<p>One company can have many countries and one country can have many Warehouses . Each Warehouse can have many products and each product is associated with the brand. In this solution all the entities are interconnected and can be fetched according to any criteria. And I set products as inventory so we can apply complex formulas to manage inventory. (The formulas and reports I didn't get much time to work on them but easily achievable on current structure)</p> 


<h3>Architecture Goals and Constraints:</h3>

Architectural goal is to have efficient development and have full control on the architecture of the solution. I also added service layer so we can handle complexity of the problem in future.


<h3>Exception Handling:</h3>

<p>I used ControllerAdvice for exception handling but not parsed error messages in detail.</p>


<h2>Suggestions:</h2> 
<p>Error handling should me be in more detail</p>
<p>Error handling is not implemented for missing companies for country. And warehouse and brand for inventory. And country for warehouse</p>
<p>Need formulas/solution to change the status of an individual product.</p>
<p>Reports section need to be developed.</p>



<h2>Installation and usage:</h2>
<p>You can Maven Build project and deploy pwi.war file to tomcat server that will be generated in  /target folder.</p>

<h3>Example Link on my local system:</h3>
<p>http://localhost:9000/pwi/api/companies</p>
<p>Response: </p>
<p>[
    {
        "country": [
            {
                "warehouse": [
                    {
                        "id": 1,
                        "name": "warehouse1"
                    }
                ],
                "id": 1,
                "name": "USA"
            }
        ],
        "id": 1,
        "name": "A"
    }
]</p>
