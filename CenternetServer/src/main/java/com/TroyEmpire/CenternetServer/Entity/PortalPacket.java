package com.TroyEmpire.CenternetServer.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author Hector the packet structure for the loaded html
 */
@Data
@Entity
@Table(name = "PortalPacket")
public class PortalPacket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	/**
	 * record the editedTime of this packet
	 */
	@Column(name = "editedTime")
	private Date editedTime;

	/**
	 * record the user who last edit this packet
	 */
	@Column(name = "editedUserId")
	private long editedUserId;



	@Embedded
	@Column(name = "portalPacketBody")
	private PortalPacketBody portalPacketBody;

	@Embedded
	@Column(name = "portalPacketHead")
	private PortalPacketHead portalPacketHead;
	
	@Transient
	private List<PortalPacketVideo> portalPacketVideos;
	@Transient
	private List<PortalPacketAudio> portalPacketAudios;
	@Transient
	private List<PortalPacketImage> portalPacketImages;

}
