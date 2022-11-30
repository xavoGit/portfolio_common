package com.xavo.finance.wallet.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

	@Id
	@SequenceGenerator(name = "account_id_sequence", sequenceName = "account_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_sequence")
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bank_id", nullable = false)
	@JsonIgnore
	private Bank bank;

	private String name;

    private AccountType type;
    
    private java.sql.Date balance_on;
    
    private Float balance;
}
