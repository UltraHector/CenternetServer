package com.TroyEmpire.CenternetServer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.TroyEmpire.CenternetServer.Entity.CenternetCentralUnit;
import com.TroyEmpire.CenternetServer.IDAO.ICenternetCentralUnitDAO;
import com.TroyEmpire.CenternetServer.IService.ICenternetCentralUnitService;

@Component
public class CenternetCentralUnitService implements
		ICenternetCentralUnitService {

	@Autowired
	private ICenternetCentralUnitDAO ccuDao;

	@Override
	public List<CenternetCentralUnit> getAllCCUs() {
		return ccuDao.findAll(CenternetCentralUnit.class);
	}

}
