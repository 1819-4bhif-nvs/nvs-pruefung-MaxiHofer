import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Path("surname")
public class Endpoint {

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject findAll() {
        int male = 0;
        int female = 0;
        List<Surname> surnames = em.createNamedQuery("Surname.findAll", Surname.class).getResultList();
        for(Surname s : surnames) {
            if(s.getGender().equals(Gender.MALE)) {
                male++;
            }
            else {
                female++;
            }
        }
        JsonObject value = Json.createObjectBuilder()
                .add("male",male)
                .add("female", female)
                .add("all", male+female)
                .build();
        return value;
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/histogramm")
//    public JsonObject getHistogramm() {
//        List<Surname> surnames = em.createNamedQuery("Surname.findAll", Surname.class).getResultList();
//
//    }
}
