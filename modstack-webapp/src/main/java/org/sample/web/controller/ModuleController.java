package org.sample.web.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

import org.sample.web.ModuleConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

@Controller
public class ModuleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleController.class);

    private static final String CHARSET = "UTF-8";

    @Autowired
    private ModuleConfig appConfig;

    @RequestMapping(value = "modules.js"/*, method = RequestMethod.GET,
                                        produces = "application/javascript;charset=UTF-8"*/)
    // @ResponseBody
    public void modulesDescriptor(final ServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(CHARSET);
        // try {
        this.buildWithMustache(response.getOutputStream());
        // } catch (Exception e) {
        // LOGGER.error("Error when write modules.js", e);
        // }
    }

    private void buildWithMustache(final ServletOutputStream output) {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("modules.tpl");
        Writer writer = mustache.execute(new OutputStreamWriter(output)/*new StringWriter()*/,
                this.appConfig);
        try {
            writer.flush();
        } catch (IOException e) {
            LOGGER.error("Error flushing modules descriptor", e);
        }
    }

    // private void buildWithoutTemplateEngine(final ServletOutputStream output) throws IOException
    // {
    //
    // String jsSript = "console.log('Modules loading...');\n";
    // String arrayModulesNames = "[";
    //
    // jsSript += "define(function(require){\n";
    // for (Module module : this.appConfig.getModules()) {
    // arrayModulesNames += "'" + module.getNgModuleName() + "',";
    // jsSript += "\t" + "require('" + module.getScriptUrl() + "');\n";
    // }
    //
    // arrayModulesNames = arrayModulesNames.replaceFirst(",$", "]");
    //
    // jsSript += "\t" + "return function () {\n";
    // jsSript += "\t\t" + "return " + arrayModulesNames + ";\n";
    // jsSript += "\t" + "};\n";
    // jsSript += "});\n";
    //
    // output.write(jsSript.getBytes(CHARSET));
    // }

}
