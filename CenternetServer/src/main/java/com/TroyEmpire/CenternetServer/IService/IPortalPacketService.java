package com.TroyEmpire.CenternetServer.IService;

import java.io.File;
import java.io.InputStream;

import com.TroyEmpire.CenternetServer.Entity.PortalPacketBundle;

public interface IPortalPacketService {

	/**
	 * retrieve the data from database and make a zip file which contains
	 * index.html
	 */
	void configurePortalPacket();

	/**
	 * the newest portalpacketbody is formed into zip file and stored in the
	 * file system
	 * 
	 * @param ccuPortalPacketVersion
	 *            the packet version in the requesting ccu
	 * @return null if no data is in the zip file saved or the request ccu
	 *         already has the latest portal packet
	 */
	File getLatestPortalPacket(String ccuPortalPacketVersion);

	/**
	 * @param portalPacketBundleFile
	 *            the portalPacketBundleFile which will be saved into the
	 *            portalpacket file system
	 * @param portalPacketBundle
	 *            the entity for the portalPacketBundle, which will be saved
	 *            into the database
	 */
	void savePortalPacketBundle(File portalPacketBundleFile,
			PortalPacketBundle portalPacketBundle);

}
