package com.easyone.travelance.domain.member.respository;

import com.easyone.travelance.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
