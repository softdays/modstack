package org.sample.web;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.PostConstruct;

import org.codehaus.jackson.map.ObjectMapper;
import org.sample.web.controller.ModuleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ModuleConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleController.class);

    private List<Module> modules;

    private List<String> modulesQuotedNames;

    @PostConstruct
    private void init() throws IOException {
        this.modules = new ArrayList<>();
        this.modulesQuotedNames = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> pluginUrls = classLoader.getResources("META-INF/resources/plugin.js");
        while (pluginUrls.hasMoreElements()) {

            URL pluginUrl = pluginUrls.nextElement();

            ObjectMapper mapper = new ObjectMapper();
            Module moduleDesc = mapper.readValue(pluginUrl.openStream(), Module.class);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(moduleDesc.toString());
            }

            this.modules.add(moduleDesc);
            this.modulesQuotedNames.add("'" + moduleDesc.getNgModuleName() + "'");
        }
    }

    public List<Module> getModules() {
        return this.modules;
    }

    /**
     * Returns a JSON representation of the modules.
     */
    public String getModulesAsJson() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(this.modules);
        } catch (IOException e) {
            LOGGER.error("Error writing modules as Json", e);
        }

        return null;
    }

    /**
     * Returns a comma separated list of quoted modules names.
     */
    public String getModulesNamesAsString() {

        return this.modulesQuotedNames.toString();
    }
}
