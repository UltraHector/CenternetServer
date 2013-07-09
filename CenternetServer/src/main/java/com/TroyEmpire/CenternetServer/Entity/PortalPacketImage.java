package com.TroyEmpire.CenternetServer.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name = "PortalPacketImage")
public class PortalPacketImage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Lob
	@Column(name = "imageContent")
	private byte[] imageContent;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	/**
	 * the foreign key referenced the id of a portalpacket
	 */
	@Column(name = "portalPacketId")
	private long portalPacketId;
}
