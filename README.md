WORA
Write Once Run Anywhere

Not have haredcoded strings for environment / tools, whatnot.



`apple, alt, shift, L` => format code


`Extract Interface` => extracts the interface


The point of spring is dependency injection => to get testing going / separation of concearns

configures via XML (first method, and the most used still)

applicationContext.xml contains the hashMap of the injection in the resources.

a bean in the spring xml defines the injection in the classes. Defining a bean is like using the keyword `new`, mentioning the interface that it is used.


# injection
Setter and injection

## Setter injection
when injection add a setter for the class you want to inject
the XML is a hashmap <identifierOfClass: implementation >
e.g. <my_awesome_class : fully_qualified_path_of_implementation>

In the case the fully_qualified_path_implementation has as well an inection, add a property  -getting the implementation of what you are injecting via the 
name of the class in the XML file.

