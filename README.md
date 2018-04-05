
# Java Spring Playground

Notes on Java Spring dependency injection, see commit history for different types of injection


WORA
Write Once Run Anywhere



Three options:

* xml
* annotations
* in code


# Option 1 : XML
first method, and the most used still
configures all via XML
you can provide different behaviors for the application simply by swapping out the applicationContext.xml, instead of
having to recompile from scratch.
applicationContext.xml contains the hashMap of the injection in the resources.

## bean

A bean in the spring xml defines the injection in the classes. 
Defining a bean is like using the keyword `new`, mentioning the interface that it is used.
requires 
* name (of what you want to implement) 
* class (the class that provides the implementation)
* autowire (maybe)
* properties the arguments that are to be passed ot the constructor.


## injection

* Setter (add a <property /> element to the bean node, with reference to the bean you are injecting.)
* Constructor(add a <constructor-arg /> element to the bean node.)


#### Autowire for XML

This is instead of adding the setter or constructor the parameters in the xm file.

byType - if there is a single implementation of a certain contract. If there are two implementation  it throws.
byName - the name of the setter needs to match the name of the bean specified in the xml file. This sounds EVIL, as you 
        have a dependency between the name of the bean in the XML file and s setter in the code.
constructor - if there is only one 
no - cannot be autowired1. 

add these to the bean in the xml file.

NOTE THAT IF YOU HAVE MULTIPLE IMPLEMENTATIONS YOU NEED TO START NAMING THE SETTERS (IN CODE) WITH THE NAME OF THE BEAN
(in the XML) YUK!!!!!!


# Option 2 - annotations configurations

There is a xml file, but that has only scaffolding and where to start.
The xml only has the information regarding the fdact we are using annotations AND where to start to scan for beans.
Uses Stereotypes annotations + Autowire. Seems very weak in case of multiple implementations (does NOT THROW IN CASE
OF MULTIPLE IMPLEMENTATIONS?????)


## Stereotype annotations

These are all the same, they don't add functions or behavior, but they allow to separate among the various types of function.
You annotate the class ILO adding nodes to the xml file.

* @Component - anything that is a POHJO
* @Service - anything that is a biz logic
* @Repository - data layer


## Injection
*Autowire*
THIS IS DIFFERENT THAN AUTOWIRE IN XML METHOD!!!!
Can be done in three different ways.


* Member
    ```    
       @Autowired
       private CustomerRepository customerRepository;
    ```
* Setter
    ```
        @Autowired
        public void setCustomerRepository(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }
    ```

* Constructor
    ```
        @Autowired
        public CustomerServiceImp(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }
    ```


# Completely in code
Disentangle XML and code (see above) => no `applicationContext.xml`.

`@Configuration` class, that will bootstrap the bean ILO xml file.
This will have the `@Bean` inside to replace each config node in the xml file.
Use constructor OR setter then in that file.

NOTE -> the POJOS and all other class don't need any annotation in order to be wired.
THis is an advantage over the annotations method, that requires those POJOS to be amended, and also
to the XML method, that requires the methods to match the name of the beans!!!! 


## with autowire
@ComponentScan({"packageWHereToSearch"})
just provide the settter and let the autowire do the full magic

Also, you can remove all beans declarations, and let autowire do all the wiring (thhis sounds like a great way to loose control over the injection).

with the stereotype annotation you can start annotate the implementations and let the autowire do the magic for the injeciton. This is very powerful BUT it also
opens up the fact that the implementation "knows" above its scope.

Basically, the idea of Autowired is to remove the declaraton of the bean (either in XML or in the java config) and let the scanner find an implementation (!!!!!!!!!!!!!!!)
You still need to specify, in the annotation of the object, the name of the bean afterall, so you are effectively shifting the definition of the bean from A to B 
- from the AppConfig to the annotation itself.

**This seems to be very useful in case one implementation is provided per package (ex code VS test), and just providing the scope and @Autowired you don't need to reinvent the wheel**



# Bean lifecycle

the default is **Singleton**, if you want prototype (meaning, a different instance each time), you need to specify it. 

There are also additional scopes per web scopes: session (one instance per session), request (one instance per http request), global session (survives the app)