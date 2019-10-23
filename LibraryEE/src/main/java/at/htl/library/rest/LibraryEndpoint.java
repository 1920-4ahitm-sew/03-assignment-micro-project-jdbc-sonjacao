package at.htl.library.rest;

import at.htl.library.database.Database;
import at.htl.library.model.PublishingHouse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("library")
public class LibraryEndpoint {

    static Database db = new Database();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public PublishingHouse findPublishingHouse(@PathParam("id") long id) {
        return db.selectPublishingHouse(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PublishingHouse> findAllPublishingHouses() {
        return db.selectAllPublishingHouses();
    }

    @DELETE
    @Path("{id}")
    public void deletePublishingHouse(@PathParam("id") long id) {
        db.deletePublishingHouse(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertPublishingHouse(PublishingHouse publishingHouse) {
        if (publishingHouse != null) {
            db.insertPublishingHouse(publishingHouse);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePublishingHouse(@PathParam("id") long id, PublishingHouse otherPublishingHouse) {
        if (otherPublishingHouse != null) {
            PublishingHouse publishingHouse = db.selectPublishingHouse(id);

            publishingHouse.setPublisherName(otherPublishingHouse.getPublisherName());
            publishingHouse.setStreet(otherPublishingHouse.getStreet());
            publishingHouse.setPostalCode(otherPublishingHouse.getPostalCode());
            publishingHouse.setCity(otherPublishingHouse.getCity());
            publishingHouse.setCountry(otherPublishingHouse.getCountry());

            db.updatePublishingHouse(publishingHouse);
        }

    }
}
