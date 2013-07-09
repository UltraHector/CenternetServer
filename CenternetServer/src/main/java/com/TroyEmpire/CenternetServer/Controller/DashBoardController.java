package com.TroyEmpire.CenternetServer.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TroyEmpire.CenternetServer.Constant.RequestMappingConstant;
import com.TroyEmpire.CenternetServer.Entity.PortalPacket;
import com.TroyEmpire.CenternetServer.Entity.PortalPacketAudio;
import com.TroyEmpire.CenternetServer.Entity.PortalPacketBody;
import com.TroyEmpire.CenternetServer.Entity.PortalPacketHead;
import com.TroyEmpire.CenternetServer.Entity.PortalPacketImage;
import com.TroyEmpire.CenternetServer.Entity.PortalPacketVideo;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketAudioDAO;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketDAO;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketImageDAO;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketVideoDAO;

@Controller
public class DashBoardController {

	@Autowired
	private IPortalPacketDAO portalPacketDao;
	@Autowired
	private IPortalPacketImageDAO portalPacketImageDao;
	@Autowired
	private IPortalPacketVideoDAO portalPacketVideoDao;
	@Autowired
	private IPortalPacketAudioDAO portalPacketAudioDao;

	@RequestMapping(value = RequestMappingConstant.DASHBOARD)
	public ModelAndView dashBoard() {
		// retrieve all the contents
		PortalPacket portalPacket = portalPacketDao.getNewestPortalPacket();
		if (portalPacket != null) {
//
//			List<PortalPacketAudio> portalPacketAudios = portalPacketAudioDao
//					.getAudiosByPortalPacketId(portalPacket.getId());
//			List<PortalPacketVideo> portalPacketVideos = portalPacketVideoDao
//					.getVideosByPortalPacketId(portalPacket.getId());
//
//			// set the audio, video and images
//			portalPacket.setPortalPacketAudios(portalPacketAudios);
//			portalPacket.setPortalPacketVideos(portalPacketVideos);

		}

		// pass the packet to the jsp template
		Map<String, PortalPacket> model = new HashMap<String, PortalPacket>();
		model.put("portalPacket", portalPacket);
		return new ModelAndView("dashboard", model);
	}

	@RequestMapping(value = "/getPortalImage/{portalPacketId}", method = RequestMethod.GET)
	public void getPortalImage(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable(value = "portalPacketId") long portalPacketId) {
		List<PortalPacketImage> portalPacketImages = portalPacketImageDao
				.getImagesByPortalPacketId(portalPacketId);
		byte[] thumb = portalPacketImages.get(0).getImageContent();

		response.setContentType("image/jpeg");
		response.setContentLength(thumb.length);

		OutputStream output = null;

		try {
			output = response.getOutputStream();
			IOUtils.write(thumb, output);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null)
				try {
					output.close();
				} catch (IOException ignore) {
				}
		}
	}

	@RequestMapping(value = "/editPortalPacketForm", method = RequestMethod.POST)
	public ModelAndView updatePortalPacket(HttpServletRequest request) {
		PortalPacket portalPacket = new PortalPacket();
		PortalPacketHead portalPacketHead = new PortalPacketHead();
		PortalPacketBody portalPacketBody = new PortalPacketBody();
		PortalPacketVideo portalPacketVideo = new PortalPacketVideo();
		PortalPacketImage portalPacketImage = new PortalPacketImage();
		PortalPacketAudio portalPacketAudio = new PortalPacketAudio();
		InputStream audioFilecontent = null;
		InputStream visualFilecontent = null;

		String visualFileType = "";
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(request);

			for (FileItem item : items) {
				if (item.isFormField()) {
					// Process regular form field (input
					// type="text|radio|checkbox|etc", select, etc).
					switch (item.getFieldName()) {
					case "portalPacketTitle":
						portalPacketHead.setPortalPacketTitle(item
								.getString("utf-8"));
						break;
					case "portalPacketTitleColor":
						portalPacketHead.setPortalPacketTitleColor(item
								.getString("utf-8"));
						break;
					case "portalPacketTitleFontStyle":
						portalPacketHead.setPortalPacketTitleFontStyle(item
								.getString("utf-8"));
						break;
					case "portalPacketFooter":
						portalPacketBody.setPortalPacketFooter(item
								.getString("utf-8"));
						break;
					case "portalPacketContent":
						portalPacketBody.setPortalPacketContent(item
								.getString("utf-8"));
						break;
					case "videoOrImageType":
						visualFileType = item.getString("utf-8");
						break;
					}
					// ... (do your job here)
				} else {
					switch (item.getFieldName()) {
					case "audioFileName": {
						audioFilecontent = item.getInputStream();
					}
						break;
					case "videoOrImageFileName": {
						visualFilecontent = item.getInputStream();
					}
					}
				}
			}

			portalPacket.setEditedTime(new Date());
			// TODO fix the userid
			portalPacket.setEditedUserId(1);

			portalPacket.setPortalPacketHead(portalPacketHead);
			portalPacket.setPortalPacketBody(portalPacketBody);
			portalPacketDao.save(portalPacket);

			portalPacketAudio.setPortalPacketId(portalPacket.getId());
			portalPacketAudio.setAudioContent(IOUtils
					.toByteArray(audioFilecontent));

			if (visualFileType.equals("image")) {
				portalPacketImage.setPortalPacketId(portalPacket.getId());
				portalPacketImage.setImageContent(IOUtils
						.toByteArray(visualFilecontent));
				portalPacketImageDao.save(portalPacketImage);
			} else {
				portalPacketVideo.setPortalPacketId(portalPacket.getId());
				portalPacketVideo.setVideoContent(IOUtils
						.toByteArray(visualFilecontent));
				portalPacketVideoDao.save(portalPacketVideo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("dashboard");
	}
}
