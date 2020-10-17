package com.ssafy.svc;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dao.CarDAO;
import com.ssafy.dao.CarDAOImpl;
import com.ssafy.dto.Car;

public class CarServiceImpl implements CarService {
	//1
	private static CarService instance=new CarServiceImpl();
	//2
	private CarServiceImpl() {}
	//3
	public static CarService getInstance() {
		return instance;
	}	
	
	private CarDAO dao=CarDAOImpl.getInstance();

	@Override
	public String login(String id, String pw) throws SQLException {
		return dao.login(id, pw);
	}
	@Override
	public void insert(Car car) throws SQLException {
		dao.insert(car);
	}
	@Override
	public List<Car> search() throws SQLException {
		return dao.search();
	}
	@Override
	public Car search(String num) throws SQLException {
		return dao.search(num);
	}
	@Override
	public void update(Car car) throws SQLException {
		dao.update(car);
	}
	@Override
	public void delete(String[] num) throws SQLException {
		for(String n:num) {
			dao.delete(n);
		}
	}
}
