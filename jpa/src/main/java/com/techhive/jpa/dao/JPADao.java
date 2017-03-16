package com.techhive.jpa.dao;

import java.util.List;

public interface JPADao {
	
	public <T> void save(T t);
	
	public <T> void update(T t);
	
	public <T> T getById(Long id , T t);
	
	public <T> List<T> getAllRecords(T t);
}
