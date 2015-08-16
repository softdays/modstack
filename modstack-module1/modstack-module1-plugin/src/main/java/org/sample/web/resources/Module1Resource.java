package org.sample.web.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.sample.module1.model.Model1;

@Path("module1")
public class Module1Resource {

    @GET
    @Path("model")
    @Produces("application/json;charset=utf-8")
    public Model1 getModel() {
        return new Model1();
    }

}
