package com.profile.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.profile.person.common.entity.Profile;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, Integer>{
	
	
}
