package org.springframework.samples.petclinic.interfaces;

import java.util.List;

public interface IBaseDAO<T, Id> {
	T findOne(Id id);

	List<T> findAll();

	void create(T entity);

	T update(T entity);

	void delete(T entity);

	void deletebyId(Id entityId);
}
