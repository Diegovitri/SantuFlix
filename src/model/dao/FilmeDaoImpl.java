package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Filme;

public class FilmeDaoImpl implements FilmeDao {
	
	@PersistenceContext(unitName="SantuFlixPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Filme> getFilmes(Filme Filme) {
		StringBuffer hql = new StringBuffer("from Filme c"
				+ " where 1 = 1");		
		if (Filme.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (Filme.getCodigo() != null) {
			query.setParameter("codigo",Filme.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Filme Filme) {
		Filme = entityManager.merge(Filme);
		entityManager.remove(Filme);
	}

	@Override
	@Transactional
	public Filme salvar(Filme Filme) {
		entityManager.persist(Filme);
		return Filme;
	}

	@Override
	@Transactional
	public void atualizar(Filme Filme) {
		Filme = entityManager.merge(Filme);
		entityManager.persist(Filme);		
	}

}
