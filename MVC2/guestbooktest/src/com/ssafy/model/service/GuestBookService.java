package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.GuestBookDto;

public interface GuestBookService {

	public void writeArticle(GuestBookDto guestBookDto) throws Exception;
	public List<GuestBookDto> listArticle(String key, String word) throws Exception;
	
	public GuestBookDto getArticle(int articleno) throws Exception;
	public void modifyArticle(GuestBookDto guestBookDto) throws Exception;
	public void deleteArticle(int articleno) throws Exception;
	
}
