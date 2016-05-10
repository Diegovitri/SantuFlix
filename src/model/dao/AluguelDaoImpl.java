package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Aluguel;

public class AluguelDaoImpl implements AluguelDao {

	@PersistenceContext(unitName="SantuFlixPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Aluguel> getFilmes(Aluguel Aluguel) {
		StringBuffer hql = new StringBuffer("from Aluguel c"
				+ " where 1 = 1");		
		if (Aluguel.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (Aluguel.getCodigo() != null) {
			query.setParameter("codigo",Aluguel.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Aluguel Aluguel) {
		Aluguel = entityManager.merge(Aluguel);
		entityManager.remove(Aluguel);
	}

	@Override
	@Transactional
	public Aluguel salvar(Aluguel Aluguel) {
		entityManager.persist(Aluguel);
		return Aluguel;
	}

	@Override
	@Transactional
	public void atualizar(Aluguel Aluguel) {
		Aluguel = entityManager.merge(Aluguel);
		entityManager.persist(Aluguel);		
	}

}
