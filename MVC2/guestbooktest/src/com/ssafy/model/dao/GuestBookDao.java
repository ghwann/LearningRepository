package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.GuestBookDto;

public interface GuestBookDao {

	public void writeArticle(GuestBookDto guestBookDto) throws SQLException;
	public List<GuestBookDto> listArticle(String key, String word) throws SQLException;
	
	public GuestBookDto getArticle(int articleno) throws SQLException;
	public void modifyArticle(GuestBookDto guestBookDto) throws SQLException;
	public void deleteArticle(int articleno) throws SQLException;
	
}
