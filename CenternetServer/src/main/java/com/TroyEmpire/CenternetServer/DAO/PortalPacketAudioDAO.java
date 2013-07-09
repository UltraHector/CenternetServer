package com.TroyEmpire.CenternetServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.CenternetServer.Entity.PortalPacketAudio;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketAudioDAO;

@Component
public class PortalPacketAudioDAO extends DAO<PortalPacketAudio, Long>
		implements IPortalPacketAudioDAO {
	@Override
	public List<PortalPacketAudio> getAudiosByPortalPacketId(long portalPacketId) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<PortalPacketAudio> query = em
				.createQuery(
						"SELECT p FROM PortalPacketAudio p where p.portalPacketId=:portalPacketId",
						PortalPacketAudio.class);
		query.setParameter("portalPacketId", portalPacketId);
		List<PortalPacketAudio> results = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return results;
	}
}
