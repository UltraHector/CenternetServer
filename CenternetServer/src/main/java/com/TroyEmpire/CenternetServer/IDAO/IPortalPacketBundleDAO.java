package com.TroyEmpire.CenternetServer.IDAO;

import com.TroyEmpire.CenternetServer.Entity.PortalPacketBundle;

public interface IPortalPacketBundleDAO extends IDAO<PortalPacketBundle, Long> {
	
	PortalPacketBundle getLatestPorcletBundle();
}
