package com.esprims.mediatech.models;

import java.io.Serializable;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile implements Serializable {

	@Id
	@GeneratedValue
	private Integer id ;
	private String avatar;
	private String telephone;
	
	@OneToOne()
	@JoinColumn(name="user_id")
	private UserEntity user;
}
