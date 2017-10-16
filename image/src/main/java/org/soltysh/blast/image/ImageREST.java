package org.soltysh.blast.image;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("image")
public class ImageREST {

    @Inject
    PersistenceHelper helper;

    @GET
    @Path("{tag}")
    @Produces("application/json")
    public List<Image> findAll(@PathParam("tag") String tag) {
        try {
            return helper.getEntityManager().createNamedQuery("Image.findAll").setParameter("tag", tag).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
