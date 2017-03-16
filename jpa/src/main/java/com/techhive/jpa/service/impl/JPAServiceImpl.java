package com.techhive.jpa.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.techhive.jpa.dao.JPADao;
import com.techhive.jpa.service.JPAService;
import com.techhive.jpa.utils.JPAUtils;

@Named
public class JPAServiceImpl implements JPAService{
	
	@Inject
	private JPADao jpaDao;

	@SuppressWarnings("unchecked")
	@Transactional
	public <T> void save(T t) {
		if (JPAUtils.isObjectisNullOrEmpty(t)){
			return;
		}
		jpaDao.save(t);
	}

	public <T> void update(T t) {
		
	}

	public <T> T getById(Long id, T t) {
		
		if (JPAUtils.isObjectisNullOrEmpty(id , t)){
			return null;
		}
		
		return jpaDao.getById(id, t);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAllRecords(T t) {
		if (JPAUtils.isObjectisNullOrEmpty(t)){
			return null;
		}
		return jpaDao.getAllRecords(t);
	}
}
