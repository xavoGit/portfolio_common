package com.xavo.finance.wallet.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Bank {

	@Id
	@SequenceGenerator(name = "bank_id_sequence", sequenceName = "bank_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_id_sequence")
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "bank", fetch = FetchType.LAZY)
	private List<Account> accounts = new ArrayList<Account>();
}
