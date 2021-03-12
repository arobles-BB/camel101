# camel101

Apache Camel is an integration framework for Java. It’s most suited for situations where you want to fetch data from files or applications, process and combine it with other data, and then move it to another application. The specific process is called a "route". A route in Apache Camel is a sequence of steps, executed in order by Camel, that consume and process a message.

Becasue of this "route" abstraction, Camel is also an excelent way to understand queues. A Camel route starts with a consumer, and is followed by a chain of endpoints and processors.

So firstly, a route receives a message, using a consumer – perhaps from a file on disk, or a message queue. Then, Camel executes the rest of the steps in the route, which either process the message in some way, or send it to endpoints (which can include other routes) for further processing.

This project aims to provide a maven template to start using Camel. 
