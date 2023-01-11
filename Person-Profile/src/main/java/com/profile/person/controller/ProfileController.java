package com.profile.person.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.profile.person.common.entity.Profile;
import com.profile.person.service.IProfileService;


@RestController
@RequestMapping("/person")
public class ProfileController {
	
	@Autowired
	private Gson gson;
	
	@Autowired
	private IProfileService profileService;
	
	@PostMapping("/addProfile")
	public String addPersonProfile(@RequestBody Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@GetMapping("/getAllPerson")
	public List<Profile> getAll(){
		return profileService.getAllProfiles();
		
	}
	
	@PostMapping("/deleteById")
	public String deleteProfileById(int id) {
		return profileService.deleteById(id);
		
	}
	
	@GetMapping("/getById")
	public Optional<Profile> getById(int id){
		return profileService.getProfileById(id);
		
	}
	
	@PutMapping("/updateProfile")
	public String updateProfile(@RequestBody String id){
		Profile profile = gson.fromJson(id, Profile.class);
		return profileService.updatePersonProfile(profile);
		
	}

}
