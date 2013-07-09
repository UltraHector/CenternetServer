package com.TroyEmpire.CenternetServer.IDAO;

import java.util.List;

import com.TroyEmpire.CenternetServer.Entity.PortalPacketAudio;

public interface IPortalPacketAudioDAO extends IDAO<PortalPacketAudio, Long> {

	/**
	 * get a list of audio by the portalpacketid
	 */
	List<PortalPacketAudio> getAudiosByPortalPacketId(long portalPacketId);

}
