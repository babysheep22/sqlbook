package com.example.rebook.repository;

import com.example.rebook.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    @Override
    ArrayList<Member> findAll();

    Member findByEmail(String member_mail);
}
