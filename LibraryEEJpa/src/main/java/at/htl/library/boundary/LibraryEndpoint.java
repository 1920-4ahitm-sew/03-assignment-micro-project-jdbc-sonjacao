package at.htl.library.boundary;

import at.htl.library.entity.PublishingHouse;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/")
public class LibraryEndpoint {
    private int counter = 0;

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init() {
        System.err.println("VehicleEndpoint created *****");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PublishingHouse getPublishingHouse(@PathParam("id") long id) {
        return em.find(PublishingHouse.class,id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PublishingHouse> getAll() {
        return em
                .createNamedQuery("PublishingHouse.findall",PublishingHouse.class)
                .getResultList();
    }
}
