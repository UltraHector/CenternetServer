package com.TroyEmpire.CenternetServer.IDAO;

import java.util.List;

import com.TroyEmpire.CenternetServer.Entity.PortalPacketImage;


public interface IPortalPacketImageDAO extends IDAO<PortalPacketImage, Long>{
	
	 List<PortalPacketImage> getImagesByPortalPacketId(long portalPacketId);

}
