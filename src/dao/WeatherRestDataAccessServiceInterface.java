package dao;

import java.util.List;

public interface WeatherRestDataAccessServiceInterface<T> {
	public boolean create(T t);
	public List<T> read(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
