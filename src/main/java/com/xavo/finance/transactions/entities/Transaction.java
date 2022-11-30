package com.xavo.finance.transactions.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "transaction_type", discriminatorType = DiscriminatorType.INTEGER)
public class Transaction {

	@Id
	@SequenceGenerator(name = "transaction_id_sequence", sequenceName = "transaction_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_sequence")
	private Integer id;

	private Integer accountId;
	private String description;
	private java.sql.Date date;
	private Float amount;
	private Integer counterpart;
}
