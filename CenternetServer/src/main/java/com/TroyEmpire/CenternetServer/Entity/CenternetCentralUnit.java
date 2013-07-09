package com.TroyEmpire.CenternetServer.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "CenternetCentralUnit")
public class CenternetCentralUnit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@Column(name = "unitName")
	private String unitName;
	
	@Column(name = "managerId")
	private long managerId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "credencial")
	private String credencial;
}
