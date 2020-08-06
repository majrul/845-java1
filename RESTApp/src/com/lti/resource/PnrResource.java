package com.lti.resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.lti.resource.Passenger.Gender;
import com.lti.resource.Passenger.Status;

//assume you are working for IRCTC and responsible for developing this PNR API
@Path("/pnr")
public class PnrResource {

	@GET
	//@Produces("application/json") -- spelling mistake easily possible
	@Produces(MediaType.APPLICATION_JSON)
	public Pnr check(@QueryParam("pnrNo") int pnrNo, @Context HttpServletResponse response) {
		//try { Thread.sleep(5000); } catch(Exception e) { }
		//enabling CORS
		//response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		//for the time being we will return some hardcoded data
		//in a real app, from here we will hit the DB and fetch the data dynamically
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2020, 12, 25));
		
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(new Passenger("Majrul", Gender.MALE, Status.RAC));
		passengers.add(new Passenger("Dinesh", Gender.MALE, Status.RAC));
		passengers.add(new Passenger("Soumya", Gender.FEMALE, Status.CONFIRMED));
		pnr.setPassengers(passengers);
		
		return pnr;
	}
}
