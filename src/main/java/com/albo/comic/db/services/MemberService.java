package com.albo.comic.db.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.comic.db.entities.MemberDTO;
import com.albo.comic.db.repository.MemberRepository;
import com.albo.comic.sync.entities.Member;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	MemberService(MemberRepository memberRepository){
		this.memberRepository = memberRepository;
	}
	
	public void createMember(Long characterId, Long comicId, Member member) {
		String role = member.getRole() != null && member.getRole() != "" ? member.getRole() : "partner";
		Optional<MemberDTO> optionalMemberDTO = memberRepository.findMember(characterId, comicId, member.getName(), role);
		if (!optionalMemberDTO.isPresent()) {
			MemberDTO memberDTO = new MemberDTO(characterId, comicId, member.getName(), role);
			memberRepository.save(memberDTO);
		}
	}
	
	
	
}
