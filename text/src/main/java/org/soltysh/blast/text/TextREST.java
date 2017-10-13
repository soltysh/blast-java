package org.soltysh.blast.text;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("text")
public class TextREST {

    @Inject
    PersistenceHelper helper;

    @GET
    @Path("{text}")
    @Produces("application/json")
    public List<Text> findAll(@PathParam("text") String text) {
        try {
            return helper.getEntityManager().createNamedQuery("Text.findAll").setParameter("text", "%" + text + "%").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
