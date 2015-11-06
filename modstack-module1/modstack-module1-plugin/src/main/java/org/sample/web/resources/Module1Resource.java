package org.sample.web.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.sample.module1.model.Model1Item1;
import org.sample.module1.model.Model1Item2;

@Path("module1")
public class Module1Resource {

    @GET
    @Path("/item1/model")
    @Produces("application/json;charset=utf-8")
    public Model1Item1 getModelItem1() {
        return new Model1Item1();
    }

    @GET
    @Path("/item2/model")
    @Produces("application/json;charset=utf-8")
    public Model1Item2 getModelItem2() {
        return new Model1Item2();
    }

}
