package dao;

import java.util.HashMap;

public abstract class DAO<T> {
	
	protected final HashMap<Integer, T> donnees = new HashMap<Integer, T>();
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T read(int id);

}
