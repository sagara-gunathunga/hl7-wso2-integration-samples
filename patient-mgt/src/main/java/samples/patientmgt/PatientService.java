
package samples.patientmgt;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/patientmgt")
public class PatientService {

    private static Map<String, Patient> patients = new HashMap<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatient() {
        return Response.status(Response.Status.ACCEPTED).entity(patients.values()).build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatient(@PathParam("id") String id) {
        Patient patient = patients.get(id);
        if (patient != null) {
            return Response.status(Response.Status.ACCEPTED).entity(patient).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        Random random = new Random();
        int id = random.nextInt(900) + 100;
        patient.setId(String.valueOf(id));
        patients.put(patient.getId(), patient);
        return Response.status(Response.Status.CREATED).entity(patient).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifyPatient(Patient patient) {
        patients.put(patient.getId(), patient);
        return Response.status(Response.Status.ACCEPTED).build();

    }

    @DELETE
    @Path("/{id}")
    public Response removePatient(@PathParam("id") String id) {
        patients.remove(id);
        return Response.status(Response.Status.ACCEPTED).build();

    }
}
