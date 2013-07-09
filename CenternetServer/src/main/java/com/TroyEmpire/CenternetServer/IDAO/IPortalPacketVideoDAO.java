package com.TroyEmpire.CenternetServer.IDAO;

import java.util.List;

import com.TroyEmpire.CenternetServer.Entity.PortalPacketVideo;

public interface IPortalPacketVideoDAO extends IDAO<PortalPacketVideo, Long> {

	/**
	 * get a list of videos by portalpacketid
	 */
	List<PortalPacketVideo> getVideosByPortalPacketId(long portalPacketId);

}
