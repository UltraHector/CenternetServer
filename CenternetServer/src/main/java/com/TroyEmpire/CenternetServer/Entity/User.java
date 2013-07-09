package com.TroyEmpire.CenternetServer.Entity;

/**
 * the user of the centernet server system
 * it plays a administrator role 
 * which has top level privileges
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="addDate")
	private Date addDate;

	@Column(name = "password")
	private String password;

}
