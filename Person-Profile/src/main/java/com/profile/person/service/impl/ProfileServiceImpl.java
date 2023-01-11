package com.profile.person.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.profile.person.common.entity.Profile;
import com.profile.person.repository.IProfileRepository;
import com.profile.person.service.IProfileService;

@Service
public class ProfileServiceImpl implements IProfileService {

	@Autowired
	private IProfileRepository profileRepository;

	@Override
	public String addProfile(Profile profile) {
		System.out.println("inside add profile method");
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(profile.getEmailId());
		if (matcher.matches() && profile.getPhoneNumber().toString().length() == 10) {
			profileRepository.save(profile);
			return "Data added";
		}
		return "Email or Mobile number is not valid";

	}

	@Override
	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	@Override
	public String deleteById(int id) {
		profileRepository.deleteById(id);
		return "Profile deleted";

	}

	@Override
	public Optional<Profile> getProfileById(int id) {
		return profileRepository.findById(id);
	}

	@Override
	public String updatePersonProfile(Profile updatedProfile) {
		Optional<Profile> optProfile = profileRepository.findById(updatedProfile.getId());
		
		String existingEmail =  optProfile.get().getEmailId();
		deleteById(updatedProfile.getId());
		updatedProfile.setEmailId(existingEmail);
		if (addProfile(updatedProfile).equals("Data added")) {
			return "Profile Updated";
		}
		else {
			return "Invalid Phone Number";
		}
		

	}

}
