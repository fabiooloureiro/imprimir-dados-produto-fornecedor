package interfaces;

import java.util.List;

public interface IBaseRepository<T> {

	// T -- tipo generico pode receber qualquer coisa

	void create(T obj) throws Exception;

	void update(T obj) throws Exception;

	void delete(T obj) throws Exception;

	List<T> findAll() throws Exception;
	
	T findById(Integer id) throws Exception;

}
