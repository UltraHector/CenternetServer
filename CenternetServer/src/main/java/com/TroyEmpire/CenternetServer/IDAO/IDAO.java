package com.TroyEmpire.CenternetServer.IDAO;



import java.io.Serializable;
import java.util.List;

public interface IDAO <T, ID extends Serializable>{
	public void save(T entity);
	 
	public void update(T entity);
 
    public void delete(T entity);
 
    public List<T> findAll(Class<T> clazz);
 
    public T findByID(Class<T> clazz, Long id);
}
