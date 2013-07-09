package com.TroyEmpire.CenternetServer.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PortalPacketBody implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "portalPacketContent")
	private String portalPacketContent;

	@Column(name = "portalPacketFooter")
	private String portalPacketFooter;

}
