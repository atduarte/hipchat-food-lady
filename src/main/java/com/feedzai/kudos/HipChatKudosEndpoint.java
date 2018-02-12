package com.feedzai.kudos;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import java.util.Map;

@Path("/")
public class HipChatKudosEndpoint {
    @POST
    @Path("/kudos")
    @Produces({ "application/json" })
    @Consumes({ "application/json" })
    public String kudos(String dataStr) {
        System.err.println(dataStr);
        return "{\"message\":\"hello\"}";
    }
}

