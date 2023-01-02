package com.gura.boot07.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.boot07.cafe.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao{

	@Autowired
	private SqlSession session;
	
	@Override //글 목록
	public List<CafeDto> getList(CafeDto dto) {
		/*
		 * 	검색기능은 
		 * 	1. 제목+내용
		 *  2. 제목
		 *  3. 작석자
		 *  검색 3가지 기능을 제공할 예정이다.
		 */
		return session.selectList("cafe.getList", dto);
	}

	@Override //글의 갯수
	public int getCount(CafeDto dto) {

		return session.selectOne("cafe.getCount", dto);
	}

	@Override //글 추가
	public void insert(CafeDto dto) {
		session.insert("cafe.insert", dto);
	}

	@Override //글 정보 얻어오기
	public CafeDto getData(int num) {
		
		return session.selectOne("cafe.getData", num);
	}
	//조회수 올리는 메소드
	@Override
	public void addViewCount(int num) {
		session.update("cafe.addViewCount", num);
	}

	@Override // 글 삭제
	public void delete(int num) {
		session.delete("cafe.delete", num);
		
	}

	@Override //글 수정
	public void update(CafeDto dto) {
		session.update("cafe.update",dto);
		
	}

	@Override
	public CafeDto getData(CafeDto dto) {
		
		return session.selectOne("cafe.getData2", dto);
	}

}
