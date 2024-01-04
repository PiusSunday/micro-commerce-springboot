# micro-commerce-springboot

This is a simple microservice project to understand the principle of Microservices architecture using the java SpringBoot framework

### Define the issues and needs
With the rise in the use of resource-intensive applications (video streaming, banks, music, e-commerce, etc.), companies are faced with challenges linked to the performance of these services and the cost of infrastructure. technical and the cost of development and maintenance.

#### Problem #1
_*** How can we ensure that the applications offered online are always available and never suffer from interruptions or slowdowns, regardless of the number of users on them? ***_

**Let's take an example**: if a company is in the clothing e-commerce business, how can it cope with the explosion in the number of users connecting to its site at 8 a.m. on the first day of sales? Add 200 servers to support the traffic for 2 hours? This is not feasible, or at least it is very expensive.

One solution is to use the cloud . This allows you to increase and decrease the number of resources necessary for the operation of an on-demand application. This solution seems ideal, because our e-commerce business only needs to increase resources at 8 a.m. and decrease them at 10 a.m., without having to purchase new servers, install and maintain them, to finally no longer have any use for it when the crowds decrease.

However, as you can imagine, there is a problem: the application must be designed in such a way that it can be scalable , that is to say capable of extending over more resources (more servers, hard drives, databases), while maintaining perfect consistency in its data and consistency in its behavior. However, this company's application, designed on a more traditional architecture ( 3-tier , for example) is very difficult to scale.

It is therefore necessary to consider, from the start, another approach in the design of the application, so that it is " Cloud-native ", that is to say designed to function and take full advantage of the advantages offered by the cloud.

#### Problem #3
The technologies used to develop these applications **are evolving very quickly** , and new developments sometimes offer enormous advantages. How can businesses adapt quickly to take advantage of these developments?

Imagine a business that allows you to place trades on stock markets. We are talking about millions of operations per second here. You must therefore be able to sell and buy very quickly, to the microsecond, when the fluctuation of a stock is favorable. This company's application is based on a powerful algorithm written in Java. One fine morning, if it does not adapt, it will lose customers because it will be overtaken by the competition, which will implement a very fast algorithm in Node.js in the following weeks...

To avoid this type of situation, the company must adopt an architecture that will allow it to **switch from one technology to another on individual portions** of its application, very easily.

_*** To these problems, we must add those linked to security, which becomes very complicated to manage in complex applications, as well as the difficulties linked to coordination between developers, and many others! ***_

Companies must therefore design their applications from the start using architectures that meet these needs, and which are perfectly suited to the cloud . This is how the Microservices architecture appeared, providing a concrete response to all these concerns and the promise of ultimately obtaining so-called “ Cloud-native ” applications.

### Understand the principle of Microservices architecture

The Microservices architecture offers a solution that is in principle simple: divide an application into small services , called Microservices, perfectly autonomous , which expose a REST API that other microservices can consume.

Each microservice is perfectly autonomous: it has its own database, its own application server (Tomcat, Jetty, etc.), its own libraries and so on. Most of the time, these microservices are each in a Docker container , so they are completely independent, including from the machine on which they run.

Microservices are mainly based on the **REST** architecture , but can work with any type of architecture, such as SOAP (Simple Object Access Protocol).

### In summary
Microservices make it possible to make an application scalable to adapt to the number of users.

Microservices are based on loose coupling between components.

Microservices communicate with each other via HTTP/HTTPS requests using the REST protocol.

The size of services in an MSA is often much smaller than in an SOA. In MSA, loose coupling is essential, i.e. **each microservice must be very independent at all levels**. Each microservice has its own database, while in **SOA it is common to find a database common to several services**. 
