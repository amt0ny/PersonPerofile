package com.profile.person.service;

import java.util.List;
import java.util.Optional;
import com.profile.person.common.entity.Profile;

public interface IProfileService {

	public String addProfile(Profile profile);

	public List<Profile> getAllProfiles();

	public String deleteById(int id);

	public Optional<Profile> getProfileById(int id);

	public String updatePersonProfile(Profile profile);

}
