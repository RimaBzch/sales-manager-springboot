package com.esprims.mediatech.models;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="clients")
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements Serializable {
	


	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(name="client_telephone")
	private String telephone;
	
	@OneToMany(mappedBy="client",cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	
	private List<FactureEntity> factures;
	

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
