package at.htl.library.boundary;

import at.htl.library.entity.PublishingHouse;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
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
        System.err.println("LibraryEndpoint created *****");
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PublishingHouse getPublishingHouse(@PathParam("id") long id) {
        return em.find(PublishingHouse.class, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PublishingHouse> getAll() {
        return em
                .createNamedQuery("PublishingHouse.findall", PublishingHouse.class)
                .getResultList();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePublishingHouse(@PathParam("id") long id) {
        em.remove(em.find(PublishingHouse.class, id));
        System.out.println("Deleted publishing house with id " + id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPublishingHouse(PublishingHouse publishingHouse) {
        em.persist(publishingHouse);
        System.out.println("Added " + publishingHouse);
    }
}