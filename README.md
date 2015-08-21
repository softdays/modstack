====================================================================
 ModStack, A simple way to build real modular webapps using AngularJS and Java.
====================================================================

```
*What the needs?* 
* Build a modern HTML5 webapp using AngularJS and a Java/Spring backend.
* This webapp would be a shell wherein come be plugged a number of modules.
* Each module/plugin must have its own lifecycle.
* Each module could be supported by different development team with minimum overlap

*What's the problem?*  
* Many JEE frameworks provide solutions for building pluggable backends and modularizing the service layer using Maven
* But there is no real standard way to build modular UI frontend stuff [see][4]
* The existing Java standards like Portlet or OSGi are complex and doesn't actually fit to my real needs
  - As architect we want something simple which doesn't force developers to master a new technology
  - We don't consider hot-deploy as a key-feature (even if we realize that it could be very interesting in high availibility context, but be serious: we code in Java and to regulary restart the JVM is just a matter of survival in our production environment)
* AngularJS doesn't provide a real and asynchronous module system.

*What's your solution?*
* Use Maven to package modules as jars et use them in a main webapp which acts as a views wrapper embedding cross-views features
* Exploit servlet 3.0 capabilities to exposes web resources (JS, CSS) packaging from jars.
* Dynamically load scripts and stylesheets using requireJS and Javascript hack.
```

## More Information

UI is powered by AngularJS and RequireJS.
The Java 8 backend uses Spring MVC and Mustache.

## Licensing

ModStack is licensed under the [GNU Affero General Public License][3].  
![alt AGPL](http://www.gnu.org/graphics/agplv3-155x51.png)

## Contact

Contact: [rpatriarche][2]  
Web site: [softdays.org][1]

[1]: http://www.softdays.org
[2]: mailto:rpatriarche@gmail.com
[3]: http://www.gnu.org/licenses/agpl-3.0.html
[4]: https://onlysoftware.wordpress.com/2011/07/19/why-there-is-no-standard-for-developing-real-modular-web-applications/
