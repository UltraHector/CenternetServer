package com.TroyEmpire.CenternetServer.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PortalPacketHead implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "portalPacketTitle")
	private String portalPacketTitle;
	
	@Column(name = "portalPacketTitleColor")
	private String portalPacketTitleColor;
	
	@Column(name = "portalPacketTitleFontStyle")
	private String portalPacketTitleFontStyle;

}
