package com.albo.comic.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.albo.comic.db.entities.MemberDTO;

public interface MemberRepository extends JpaRepository <MemberDTO, Long> {

	@Query("SELECT m FROM MemberDTO m WHERE character_id = ?1")
    Optional<List<MemberDTO>> findByCharacterId(Long characterId);
	
	@Query("SELECT m FROM MemberDTO m WHERE character_id = ?1 AND comic_id = ?2 AND name = ?3 AND role = ?4")
    Optional<MemberDTO> findMember(Long characterId, Long comicId, String name, String role);
	
	@Query("SELECT m FROM MemberDTO m WHERE character_id = ?1 AND comic_id = ?2")
    Optional<List<MemberDTO>> findMembersByComic(Long characterId, Long comicId);
	
	@Query("SELECT m FROM MemberDTO m WHERE character_id = ?1 AND role = ?2")
    Optional<List<MemberDTO>> findPartners(Long character_id, String role);
	
	@Query("SELECT DISTINCT m.name FROM MemberDTO m WHERE character_id = ?1 AND role = ?2")
    Optional<List<String>> nameMembersByRole(Long character_id, String role);

	@Query("SELECT DISTINCT m.name FROM MemberDTO m WHERE character_id = ?1 AND role NOT IN ?2")
	Optional<List<String>> nameMembersByExcludeRole(Long characterId, String[] excludesRole);
	
}
