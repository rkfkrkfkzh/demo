package com.example.demo.join;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberMapper mapper;
	
	public void addMember(Member m){
		mapper.addMember(m);
	}
	
	public Member getMember(String id){
		return mapper.getMember(id);
	}
	
	public ArrayList<Member> getMembers(){
		return mapper.getMembers();
	}
	
	public void editMember(Member m){
		mapper.editMember(m);
	}
	
	public void delMember(String id){
		mapper.delMember(id);
	}
}

