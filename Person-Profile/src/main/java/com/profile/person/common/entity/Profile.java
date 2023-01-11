package com.profile.person.common.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String emailId;
	private Long phoneNumber;
	@ElementCollection(targetClass=String.class)
	private List<String> address = new ArrayList<>();
	
}
