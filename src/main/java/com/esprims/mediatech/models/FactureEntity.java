package com.esprims.mediatech.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="factures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactureEntity implements Serializable {
	


	@Id
	private Integer id;
	
	@Column(nullable =false)
	private String ref;
	
	@Column(nullable =false,name="date_creation_facture")
	private Date date;
	
	@ManyToOne()
	private ClientEntity client;
	
	@OneToMany(mappedBy="facture",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<LigneFactureEntity> ligneFactures;
	
}
