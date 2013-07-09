package com.TroyEmpire.CenternetServer.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.CenternetServer.Entity.PortalPacket;
import com.TroyEmpire.CenternetServer.IDAO.IPortalPacketDAO;

@Component
public class PortalPacketDAO extends DAO<PortalPacket, Long> implements
		IPortalPacketDAO {

	@Override
	public PortalPacket getNewestPortalPacket() {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		PortalPacket result = null;
		try {
			TypedQuery<PortalPacket> query = em.createQuery(
					"SELECT p FROM PortalPacket p order by p.editedTime desc",
					PortalPacket.class);
			query.setMaxResults(1);
			result = query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
		em.getTransaction().commit();
		em.close();
		return result;
	}

}
