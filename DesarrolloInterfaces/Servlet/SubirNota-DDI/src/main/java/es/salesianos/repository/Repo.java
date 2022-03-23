package es.salesianos.repository;

import java.util.List;

public interface Repo<T> {

	String JDBC_URL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:/scripts/create.sql'";

	List<T> findAll();
	void update(T t);
	T findById(Integer i);
}
