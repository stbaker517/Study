package example.account_controll.repository;

import example.account_controll.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member) ;
    Optional<Member>findById(Long id);
    Optional<Member>findByName(String name);
    List<Member> findAll();



}
