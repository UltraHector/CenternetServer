package com.TroyEmpire.CenternetServer.IDAO;

import com.TroyEmpire.CenternetServer.Entity.PortalPacket;


public interface IPortalPacketDAO extends IDAO<PortalPacket, Long>{
	
	/**
	 * get the newest version of portal packet 
	 * @return null if no result found
	 */
	public PortalPacket getNewestPortalPacket();

}
