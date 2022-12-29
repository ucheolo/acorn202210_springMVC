package com.gura.boot04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gura.boot04.member.dao.MemberDao;
import com.gura.boot04.member.dao.MemberDto;

@Controller
public class MemberRestController {
	
	@Autowired MemberDao dao;
	
	@GetMapping("/member/list")
	public List<MemberDto> list(){
		
		return dao.getList();
	}
}
