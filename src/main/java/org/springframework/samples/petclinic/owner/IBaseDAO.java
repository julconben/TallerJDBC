package org.springframework.samples.petclinic.owner;

import java.util.List;

public interface IBaseDAO <T, Id> {

	T findOne(Id id);
	
	List<T> findAll();
	
	void create(T entity);
	
	T update();
	
	void delete(T entity);
	
	void deleteById(Id entityId);
}
