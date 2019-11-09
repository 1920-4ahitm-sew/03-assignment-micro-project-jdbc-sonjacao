package at.htl.library.boundary;

import at.htl.library.entity.PublishingHouse;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Stateless
@Path("library")
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
    public Response deletePublishingHouse(@PathParam("id") long id) {
        em.remove(em.find(PublishingHouse.class, id));
        return Response.ok().build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createPublishingHouse(PublishingHouse publishingHouse, @Context UriInfo uriInfo) {
        PublishingHouse ph = em.merge(publishingHouse);
        Long id = ph.getId();
        URI uri = uriInfo.getAbsolutePathBuilder().path("/" + id).build();
        return Response
                .created(uri)
                .entity(publishingHouse)
                .build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updatePublishingHouse(@PathParam("id") long id, PublishingHouse updatedPublishingHouse) {
        PublishingHouse publishingHouse = em.find(PublishingHouse.class, id);

        publishingHouse.setPublisherName(updatedPublishingHouse.getPublisherName());
        publishingHouse.setStreet(updatedPublishingHouse.getStreet());
        publishingHouse.setPostalCode(updatedPublishingHouse.getPostalCode());
        publishingHouse.setCity(updatedPublishingHouse.getCity());
        publishingHouse.setCountry(updatedPublishingHouse.getCountry());

        em.merge(publishingHouse);

        return Response
                .ok()
                .entity(publishingHouse)
                .build();
    }
}