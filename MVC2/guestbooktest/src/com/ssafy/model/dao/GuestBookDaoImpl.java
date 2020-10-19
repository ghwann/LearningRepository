package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.GuestBookDto;
import com.ssafy.util.DBUtil;

public class GuestBookDaoImpl implements GuestBookDao {

	@Override
	public void writeArticle(GuestBookDto guestBookDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("insert into guestbook (userid, subject, content, regtime) \n");
			insertMember.append("values (?, ?, ?, now())");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, guestBookDto.getUserid());
			pstmt.setString(2, guestBookDto.getSubject());
			pstmt.setString(3, guestBookDto.getContent());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public List<GuestBookDto> listArticle(String key, String word) throws SQLException {
		List<GuestBookDto> list = new ArrayList<GuestBookDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select articleno, userid, subject, content, regtime \n");
			sql.append("from guestbook \n");
			if(!word.isEmpty()) {
				if("subject".equals(key)) {
					sql.append("where subject like ? \n");
				} else {
					sql.append("where " + key + " = ? \n");
				}
			}
			sql.append("order by articleno desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			if(!word.isEmpty()) {
				if("subject".equals(key))
					pstmt.setString(1, "%" + word + "%");
				else
					pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestBookDto guestBookDto = new GuestBookDto();
				guestBookDto.setArticleno(rs.getInt("articleno"));
				guestBookDto.setUserid(rs.getString("userid"));
				guestBookDto.setSubject(rs.getString("subject"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegtime(rs.getString("regtime"));
				
				list.add(guestBookDto);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return list;
	}

	@Override
	public GuestBookDto getArticle(int articleno) throws SQLException {
		GuestBookDto guestBookDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select articleno, userid, subject, content, regtime \n");
			sql.append("from guestbook \n");
			sql.append("where articleno = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, articleno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				guestBookDto = new GuestBookDto();
				guestBookDto.setArticleno(rs.getInt("articleno"));
				guestBookDto.setUserid(rs.getString("userid"));
				guestBookDto.setSubject(rs.getString("subject"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegtime(rs.getString("regtime"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return guestBookDto;
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("update guestbook \n");
			insertMember.append("set subject = ?, content = ? \n");
			insertMember.append("where articleno = ?");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, guestBookDto.getSubject());
			pstmt.setString(2, guestBookDto.getContent());
			pstmt.setInt(3, guestBookDto.getArticleno());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public void deleteArticle(int articleno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("delete from guestbook \n");
			insertMember.append("where articleno = ?");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setInt(1, articleno);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

}
