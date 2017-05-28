package org.suyash.developer.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.suyash.developer.messenger.model.Profile;
import org.suyash.developer.messenger.service.ProfileService;


@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService profileService =new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{ProfileName}")
	public Profile getProfile(@PathParam("ProfileName") String profileName){
		return profileService.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile Profile){
		 return profileService.addProfile(Profile);
	}
	
	@PUT
	@Path("/{ProfileName}")
	public Profile updateProfile(@PathParam("ProfileName") String profileName, Profile Profile)
	{
		Profile.setProfileName(profileName);
		return profileService.updateProfile(Profile);
	}
	
	@DELETE
	@Path("/{ProfileName}")
	public void deleteProfile(@PathParam("ProfileName") String profileName)
	{
		profileService.deleteProfile(profileName);
	}

}
