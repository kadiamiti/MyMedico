/**
 * 
 */
package com.sjsu.finalproj.mymedico.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sjsu.finalproj.mymedico.domain.User;
import com.sjsu.finalproj.mymedico.dto.UserDto;
import com.sjsu.finalproj.mymedico.repository.UserRepositoryInterface;
import com.yammer.metrics.annotation.Timed;



/**
 * @author mitikadia
 * 
 * 
 * 
 *register
 * login
 * logout
 * submitMedicalDetails
 * updateMedicalDetails
 * dashboard , newsfeed
 * getMedicalStats
 * getGeneralStats
 * getStateStats
 * 
 * 
 * 
 */

@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
	
	private final UserRepositoryInterface userRepository;
	
	public UserResource(UserRepositoryInterface userRepository) {
		this.userRepository = userRepository;
	}
	
	
	

	@POST
	@Timed(name = "register-user")
	public Response createBook(User request) {
		// Store the new book in the BookRepository so that we can retrieve it.
		int responseCode = userRepository.registerUser(request);

		

		return Response.status(201).build();
	}
	

}
