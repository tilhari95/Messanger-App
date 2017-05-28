package org.suyash.developer.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.suyash.developer.messenger.database.DatabaseClass;
import org.suyash.developer.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles=DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("searing", new Profile(1L , "searing" , "tilhari", "jss"));
		profiles.put("searing95", new Profile(2L , "searing95" , "tilhari95", "jss95"));
		}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile Profile)
	{
		Profile.setId(profiles.size()+1);
		profiles.put(Profile.getProfileName(), Profile);
		return Profile;
	}
	
	public Profile updateProfile(Profile Profile)
	{
	 	if(Profile.getProfileName().isEmpty())
			return null;
		profiles.put(Profile.getProfileName(), Profile);
		return Profile;
	}
	
	public Profile deleteProfile(String profileName)
	{
		return profiles.remove(profileName);
	}

}
