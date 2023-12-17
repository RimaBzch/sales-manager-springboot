package com.esprims.mediatech.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity implements Serializable {

	@Id
	private Integer roleId;

	@Column(nullable = false)
	private String name;

	@ManyToMany()
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "roleId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<UserEntity> users;

}
