package com.TroyEmpire.CenternetServer.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TroyEmpire.CenternetServer.Constant.RequestMappingConstant;
import com.TroyEmpire.CenternetServer.Entity.CenternetCentralUnit;
import com.TroyEmpire.CenternetServer.IService.ICenternetCentralUnitService;

@Controller
public class CenternetCentralUnitController {

	@Autowired
	private ICenternetCentralUnitService ccuService;

	@RequestMapping(value = "/getAllCcu")
	public ModelAndView getAllCCUs() {
		Map<String, List<CenternetCentralUnit>> model = new HashMap<String, List<CenternetCentralUnit>>();
		model.put("ccus", ccuService.getAllCCUs());
		return new ModelAndView("ccu", model);
	}
}
