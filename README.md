# Scala-DI
----
This is a simple full stack example application that I used to try out the different types of scala (non framework) dependency patterns.

__Types:__

* Cake Pattern
* Implicit Constructor
* Normal Constructor

The "master" branch shows the example of just using constructor based injection. The other two have corresponding branches to show each flavors.

As an outcome...

I think the Cake Pattern feels natural to what the Scala language provides but you end up writing A LOT of boiling plate code, that being all classes need to be wrapped in a "module/component" type trait for cake injections, plus this sort of forces you into having .scala files with a lot of classes/traits...not sure is that is really a bad thing, in languages like Java that would be against the norm.

Removing all the boiler plate code I found that just using normal OO constructor based injection is simple, straight forward and easy to understand.  Implicit DI is just too magically and I think breaks the nature of what implicit(s) are intended to be used for.

With that all said I think the real answer here is to use a mix of implicit with normal constructor based DI.  When every object or object groups need the same dependency, like DAOs needing a Slick profile, then I think having an abstract DAO with an implicit parameter makes sense while all other dependencies are a normal parameter. I will likely give that a try and see how it looks/works.

In addition....

You could certainly use DI frameworks, Spring, Guice, others but they all seem to go against the nature of the language and when it comes down to it DI is just an object that takes parameters and it is simple to wire those together with out needing a heavy weight DI container framework.

If you really hate to wire together objects yourself then I would at least recommend using something light weight like [MacWire](https://github.com/adamw/macwire).

## Update...
In the end I found that using a combination of "Implicit" and "Normal" constructor di was the best approach. When you have use cases where a lot of classes need a component, in this case most table, daos and other need a Slick JdbcProfile, in those cases it seems natural to have them as implicit constructor parameters and then at a top level when you are wiring together classes you can set an implicit profile, much easier then passing it to many/many constructors.  Outside that if a class just needs a resource that is needed by a couple or no others then those should be just normal constructor parameters.