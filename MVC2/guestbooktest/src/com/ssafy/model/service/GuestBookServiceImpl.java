package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.GuestBookDto;
import com.ssafy.model.dao.GuestBookDao;
import com.ssafy.model.dao.GuestBookDaoImpl;

public class GuestBookServiceImpl implements GuestBookService {
	
	private GuestBookDao guestBookDao;
	
	public GuestBookServiceImpl() {
		guestBookDao = new GuestBookDaoImpl();
	}

	@Override
	public void writeArticle(GuestBookDto guestBookDto) throws Exception {
		if(guestBookDto.getSubject() == null || guestBookDto.getContent() == null) {
			throw new Exception();
		}
		guestBookDao.writeArticle(guestBookDto);
	}

	@Override
	public List<GuestBookDto> listArticle(String key, String word) throws Exception {
		key = key == null ? "" : key;
		word = word == null ? "" : word;
		return guestBookDao.listArticle(key, word);
	}

	@Override
	public GuestBookDto getArticle(int articleno) throws Exception {
		return guestBookDao.getArticle(articleno);
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws Exception {
		guestBookDao.modifyArticle(guestBookDto);
	}

	@Override
	public void deleteArticle(int articleno) throws Exception {
		guestBookDao.deleteArticle(articleno);
	}

}
