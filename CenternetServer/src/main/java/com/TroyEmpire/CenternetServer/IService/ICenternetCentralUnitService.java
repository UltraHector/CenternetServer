package com.TroyEmpire.CenternetServer.IService;

import java.util.List;

import com.TroyEmpire.CenternetServer.Entity.CenternetCentralUnit;

public interface ICenternetCentralUnitService {
	/**
	 * retrieve all the CCUs from the database
	 */
	List<CenternetCentralUnit> getAllCCUs();
}
