====================================================================
 ModStack, A simple way to build real modular webapps using Angular and Java.
====================================================================

```
What the needs? 
* Build a modern HTML5 webapp using a Java/Spring backend and AngularJS for UI.
* Each module/plugin must have its own lifecycle.
* Hot-deploy is not a key-feature.

So what's the problem?  
* We have many solutions for building modular backend (services layer) using Maven
* But there is no real standard way to build modular UI frontend stuff [see][4].
* Existing JEE solutions for this concern like Portlet or OSGi are complex and doesn't fit the real needs (I'm not interrested bu
* AngularJS doesn't provide a real and asynchronous module system.


Ok what's your solution?
* Exploit servlet 3.0 capabilities to exposes web resources from jars.
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
