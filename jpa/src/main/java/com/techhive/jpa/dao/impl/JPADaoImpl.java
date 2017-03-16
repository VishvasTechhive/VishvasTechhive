package com.techhive.jpa.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.techhive.jpa.dao.JPADao;

@Named
public class JPADaoImpl implements JPADao {

	@PersistenceContext(unitName = "jpaPersistenceUnit")
	private EntityManager entityManager;

	public <T> void save(T t) {
		try {
			entityManager.persist(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public <T> void update(T t) {

	}

	@SuppressWarnings("unchecked")
	public <T> T getById(Long id, T t) {

		try {
			return (T) entityManager.find(t.getClass(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAllRecords(T t) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

    	CriteriaQuery<T> criteria = (CriteriaQuery<T>) builder.createQuery(t.getClass());

    	Root<T> criteriaRoot = (Root<T>) criteria.from(t.getClass());
    	criteria.select(criteriaRoot);

    	TypedQuery<T> typedQuery = entityManager.createQuery(criteria);
    	return typedQuery.getResultList();
    	
	}

}
