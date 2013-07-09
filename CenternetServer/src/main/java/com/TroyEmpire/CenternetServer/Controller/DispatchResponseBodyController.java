package com.TroyEmpire.CenternetServer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TroyEmpire.CenternetServer.IService.IPortalPacketService;

@Controller
public class DispatchResponseBodyController {

	@Autowired
	private IPortalPacketService portalPacketService;

	/**
	 * return the latest response body in zip format
	 */
	@RequestMapping(value = "/getLatestResponseBody", method = RequestMethod.POST)
	public void dispatchResponseBody(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO verify the CCU
		String credential = request.getParameter("credential");
		// TODO need to send back something?
		String ccuPacketVersion = request.getParameter("portalPacketVersion");
		File portalPacketFile = portalPacketService
				.getLatestPortalPacket(ccuPacketVersion);
		if (portalPacketFile != null) {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ portalPacketFile.getName());
			try {
				ServletOutputStream out = response.getOutputStream();
				InputStream in = new FileInputStream(portalPacketFile);
				IOUtils.copy(in, out);
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// TODO no zip file founded.....
		}

	}
}
