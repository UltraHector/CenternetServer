package com.TroyEmpire.CenternetServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.CenternetServer.Entity.PortalPacketImage;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketImageDAO;

@Component
public class PortalPacketImageDAO extends DAO<PortalPacketImage, Long>
		implements IPortalPacketImageDAO {

	@Override
	public List<PortalPacketImage> getImagesByPortalPacketId(long portalPacketId) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<PortalPacketImage> query = em
				.createQuery(
						"SELECT p FROM PortalPacketImage p where p.portalPacketId=:portalPacketId",
						PortalPacketImage.class);
		query.setParameter("portalPacketId", portalPacketId);
		List<PortalPacketImage> results = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return results;
	}
}
