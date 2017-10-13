package org.soltysh.blast.video;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("video")
public class VideoREST {

    @Inject
    PersistenceHelper helper;

    @GET
    @Path("{title}")
    @Produces("application/json")
    public List<Video> findAll(@PathParam("title") String title) {
        try {
            return helper.getEntityManager().createNamedQuery("Video.findAll").setParameter("title", "%" + title + "%").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
