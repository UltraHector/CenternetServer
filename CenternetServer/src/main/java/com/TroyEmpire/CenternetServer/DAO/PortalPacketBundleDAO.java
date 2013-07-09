package com.TroyEmpire.CenternetServer.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.CenternetServer.Entity.PortalPacketBundle;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketBundleDAO;

@Component
public class PortalPacketBundleDAO extends DAO<PortalPacketBundle, Long>
		implements IPortalPacketBundleDAO {

	@Override
	public PortalPacketBundle getLatestPorcletBundle() {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<PortalPacketBundle> query = em.createQuery(
				"SELECT p FROM PortalPacketBundle p order by createdTime desc",
				PortalPacketBundle.class);
		query.setMaxResults(1);
		
		PortalPacketBundle result = null;
		try {
			result = query.getSingleResult();
		} catch (Exception e) {
			// if no result
			return null;
		}
		em.getTransaction().commit();
		em.close();
		return result;
	}
}
