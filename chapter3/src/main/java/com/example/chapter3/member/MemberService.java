package com.example.chapter3.member;

import com.example.chapter3.domain.Member;
import com.example.chapter3.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);
}