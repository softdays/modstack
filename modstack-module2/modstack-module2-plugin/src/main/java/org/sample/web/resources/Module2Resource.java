package org.sample.web.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.sample.module2.model.Model2;

@Path("module2")
public class Module2Resource {

    @GET
    @Path("model")
    @Produces("application/json;charset=utf-8")
    public Model2 getModel() {
        return new Model2();
    }
}
