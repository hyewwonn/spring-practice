package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findBuName(String name);
    List<Member> findAll();
}
