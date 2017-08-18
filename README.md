WORA
Write Once Run Anywhere

Not have haredcoded strings for environment / tools, whatnot.



`apple, alt, shift, L` => format code


`Extract Interface` => extracts the interface


The point of spring is dependency injection => to get testing going / separation of concearns

configures via XML (first method, and the most used still)

applicationContext.xml contains the hashMap of the injection in the resources.

a bean in the spring xml defines the injection in the classes. Defining a bean is like using the keyword `new`, mentioning the interface that it is used.


# XML
## injection
Setter and injection

### Setter injection
when injection add a setter for the class you want to inject
the XML is a hashmap <identifierOfClass: implementation >
e.g. <my_awesome_class : fully_qualified_path_of_implementation>

In the case the fully_qualified_path_implementation has as well an inection, add a property  -getting the implementation of what you are injecting via the 
name of the class in the XML file.

don't like this a lot, as it leaves you with a public setter for somethign that shoudl be assigned only at creation...



### constructor injection

The idea is very similar, but inject in the contstructo, passing the index in the constructor. It's nice that you can control how - you can use them together.


#### Autowire!

byType - if there is a single implementation of a certain contract. If there are two implementation  it throws.
byName - the name of the setter
constructor - if there is only one 
no - cannot be autowire. 


# XML annotations


* amend the xml file

* annotate the implementations with one of the following:

@Component - anything that is a POHJO
@Service - anything that is a biz logic
@Repository - data layer

e.g. `@Repository("mockRepository")` - this is in lieu of annotating in the xml file

* Then do autowiring

** Option 1**

```    
    @Autowired
       private CustomerRepository customerRepository;
```



