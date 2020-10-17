package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.Car;

public interface CarDAO {
	String login(String id, String pw) throws SQLException;
	
	void insert(Car car) throws SQLException;
	List<Car> search() throws SQLException;
	Car search(String num) throws SQLException;
	void update(Car car) throws SQLException;
	void delete(String num) throws SQLException;
}
