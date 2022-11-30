package com.xavo.finance.transactions.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

	@Id
	@SequenceGenerator(name = "category_id_sequence", sequenceName = "category_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_sequence")
	private Integer id;
	
	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<com.xavo.finance.transactions.entities.Service> services;

}
