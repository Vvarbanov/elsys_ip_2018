package org.elsys.ip.rest.resource;

import org.elsys.ip.rest.model.AirConditioner;
import org.elsys.ip.rest.service.AirConditionerService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.util.HashSet;
import java.util.List;

@Path("airConditioners")
public class AirConditionerResource {

    private AirConditionerService airConditionerService = new AirConditionerService();

    /**
     * Returns all the available objects.
     *
     * @return List<AirConditioner>
     */
    @GET
    @Produces("application/json")
    @Path("allAirConditioners")
    public List<AirConditioner> getAllAirConditioners() {
        return airConditionerService.getAirConditioners();
    }

    /**
     * Returns an object with the given ID.
     *
     * @param id unique identifier of an object
     * @return AirConditioner
     */
    @GET
    @Produces("application/json")
    @Path("{id}")
    public AirConditioner getAirConditioner(@PathParam("id") Integer id) {
        return airConditionerService.getAirConditionerById(id);
    }


    @GET
    @Produces("application/json")
    public List<AirConditioner> getByMultipleIds(@QueryParam("id") final List<Integer> listOfIds) {
        return airConditionerService.getByMultipleIds(new HashSet<>(listOfIds));
    }

    @GET
    @Produces("application/json")
    @Path("byFields")
    public List<AirConditioner> getByMultipleFields(
            @Context UriInfo uriInfo
    ) {
        MultivaluedMap<String, String> params = uriInfo.getQueryParameters();
        return airConditionerService.getByMultipleFields(params);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("multiple")
    public List<AirConditioner> bulkCreateAirConditioners(List<AirConditioner> airConditioners) {

        airConditionerService.addList(airConditioners);

        return airConditioners;
    }


    /**
     * Endpoint, which when accessed by a browser enables file download.
     *
     * @return Response
     */
    @GET
    @Path("download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadAirConditioner() throws Exception {
        airConditionerService.writeCSVFile();
        File file = new File("D:\\data.csv");
        return Response
                .ok(file)
                .header("Content-Disposition", "attachment; filename=" + file.getName())
                .build();
    }

    /**
     * Save endpoint
     *
     * @param airConditioner - JSON object with id and name - the fields of AirConditioner
     * @return the saved object
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public AirConditioner saveAirConditioner(AirConditioner airConditioner) {
        return airConditionerService.saveAirConditioner(airConditioner);
    }

    /**
     * Updates (in this case replaces) AirConditioner object with the given ID with the one in the parameters list.
     *
     * @param id
     * @param airConditioner
     * @return
     */
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public AirConditioner updateAirConditioner(@PathParam("id") Integer id, AirConditioner airConditioner) {
        return airConditionerService.updateAirConditioner(id, airConditioner);
    }

    /**
     * Deletes AirConditioner with the given ID
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void deleteAirConditioner(@PathParam("id") Integer id) {
        airConditionerService.deleteAirConditioner(id);
    }
}
