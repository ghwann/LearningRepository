package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Car;
import com.ssafy.util.DBUtil;

public class CarDAOImpl implements CarDAO {
	// 1.
	private static CarDAO instance = new CarDAOImpl();
	// 2. ★기본생성자 만들어야하는 이유?★
	private CarDAOImpl() {};
	// 3.
	public static CarDAO getInstance() {
		return instance;
	}

	public static void main(String[] args) throws SQLException {
		CarDAO dao = new CarDAOImpl();
		
		System.out.println(dao.login("ssafy", "1111"));
		
//		dao.insert(new Car("123456","모델Test",1000,"10",""));
//		dao.update(new Car("123456","모델Updt",2222,"20",""));
		dao.delete("123456");
		
		List<Car> cars = dao.search();
		for (Car c : cars) {
			System.out.println(c);
		}
		
		System.out.println(dao.search("S20JUN"));
	}
	
	@Override
	public String login(String id, String pw) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select pw from user where id=?";
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (pw.equals(rs.getString(1))) {	// rs.getString("pw");
					return id;
				}
			}
		} finally {
			rs.close(); /* ★DBUtil.close(rs);★ 두 개가 같은지? */
			ps.close();
			conn.close();
		}
		
		return null;
	}

	@Override
	public void insert(Car car) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into car values(?, ?, ?, ?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, car.getNum());
			ps.setString(2, car.getModel());
			ps.setInt(3, 	car.getPrice());
			ps.setString(4, car.getVcode());
			ps.executeUpdate();
		} finally {
			ps.close();
			conn.close();
		}
	}

	@Override
	public List<Car> search() throws SQLException {
		List<Car> cars = new ArrayList<Car>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select num,model,price,c.vcode,vname from car c,vendor v where c.vcode=v.vcode";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				cars.add(new Car(rs.getString("num"),rs.getString("model"),rs.getInt("price"),
						rs.getString("vcode"),rs.getString("vname")));
				
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		
		return cars;
	}

	@Override
	public Car search(String num) throws SQLException {
		Car car = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select num,model,price,c.vcode,vname from car c,vendor v where c.vcode=v.vcode and num=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {
				car = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),
						rs.getString(4),rs.getString(5));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		
		return car;
	}

	@Override
	public void update(Car car) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update car set model=?, price=?, vcode=? where num=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, car.getModel());
			ps.setInt(2, 	car.getPrice());
			ps.setString(3, car.getVcode());
			ps.setString(4, car.getNum());
			ps.executeUpdate();
		} finally {
			ps.close();
			conn.close();
		}
	}

	@Override
	public void delete(String num) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from car where num=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			ps.executeUpdate();
		} finally {
			ps.close();
			conn.close();
		}
	}
}
