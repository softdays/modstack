package org.sample.web.resources;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sample.web.ModuleConfig;
import org.sample.web.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("modules")
public class ModuleResource {

    /** The Constant ENCODING. */
    public static final String ENCODING = "utf-8";

    /** The CHARSET. */
    public static final String CHARSET = ";charset=" + ENCODING;

    /** The MIME type JSON with UTF8. */
    public static final String JSON_UTF8 = MediaType.APPLICATION_JSON + CHARSET;

    @Autowired
    private ModuleConfig appConfig;

    @GET
    @Produces(JSON_UTF8)
    public List<Module> getModules() throws URISyntaxException, IOException {
        return this.appConfig.getModules();

        // Module mod1 = new Module();
        // mod1.setName("Module 1");
        // mod1.setLocation("#module1");
        // Module mod2 = new Module();
        // mod2.setName("Module 2");
        // mod2.setLocation("#module2");
        // modules = Arrays.asList(mod1, mod2);

        // Reflections reflections = new Reflections("org.sample");
        // Set<Class<? extends MyInterface>> classes = reflections.getSubTypesOf(MyInterface.class);

    }
}
