package com.TroyEmpire.CenternetServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.CenternetServer.Entity.PortalPacketVideo;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketVideoDAO;

@Component
public class PortalPacketVideoDAO extends DAO<PortalPacketVideo, Long>
		implements IPortalPacketVideoDAO {

	@Override
	public List<PortalPacketVideo> getVideosByPortalPacketId(long portalPacketId) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<PortalPacketVideo> query = em
				.createQuery(
						"SELECT p FROM PortalPacketVideo p where p.portalPacketId=:portalPacketId",
						PortalPacketVideo.class);
		query.setParameter("portalPacketId", portalPacketId);
		List<PortalPacketVideo> results = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return results;
	}
}
