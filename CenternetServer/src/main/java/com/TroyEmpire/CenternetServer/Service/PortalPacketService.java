package com.TroyEmpire.CenternetServer.Service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.TroyEmpire.CenternetServer.Constant.Constant;
import com.TroyEmpire.CenternetServer.Entity.PortalPacketBundle;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketBundleDAO;
import com.TroyEmpire.CenternetServer.IService.IPortalPacketService;

@Component
@Service
public class PortalPacketService implements IPortalPacketService {

	@Autowired
	private IPortalPacketBundleDAO portalPacketBundleDAO;

	@Override
	public void configurePortalPacket() {
		// TODO
	}

	@Override
	public File getLatestPortalPacket(String ccuPacketVersion) {
		// TODO? decide whether return something? if ccu already has newest
		// packet, return null
		String newestVersion = getNewestPortalPacketVersion();

		try {
			Ini configFile = new Ini();
			configFile.load(new File("CenternetServerConfig.ini"));
			if (configFile.containsKey(Constant.SECTION_CENTERNET_SERVER)) {
				Section centernetServerSection = configFile
						.get(Constant.SECTION_CENTERNET_SERVER);
				if (centernetServerSection
						.containsKey(Constant.PORTAL_PACKET_FILE_SYS_PATH)) {
					String localPacketFileDirec = centernetServerSection
							.get(Constant.PORTAL_PACKET_FILE_SYS_PATH);

					// The pocket file format is: Body_timeinmilli.zip
					// TODO configure the filepath based on newestVersion
					String packetFilePath = localPacketFileDirec + "/"
							+ "/Body_1234567.zip";
					File latestPacket = new File(packetFilePath);
					return latestPacket;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * get the newest portal packet version
	 */
	private String getNewestPortalPacketVersion() {
		// the hashcode of the created time of the latest bundle is used as the
		// version of this portalPacket
		return String.valueOf(portalPacketBundleDAO.getLatestPorcletBundle()
				.getCreatedTime().hashCode());
	}

	@Override
	public void savePortalPacketBundle(File portalPacketBundleFile,
			PortalPacketBundle portalPacketBundle) {
		portalPacketBundleDAO.save(portalPacketBundle);
		File portalPacketBundleFileFileSys = new File(
				portalPacketBundle.getPortalPacketBundlePath());
		try {
			portalPacketBundleFileFileSys.createNewFile();
			FileUtils.copyFile(portalPacketBundleFile,
					portalPacketBundleFileFileSys);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
