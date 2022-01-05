package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.Member;

import java.util.List;

// 이렇게 커스텀한(MemberRepositoryCustom) 인터페이스를 상속받고 해당 인터페이스를 구현(MemberRepositoryImpl)해 놓으면 접근하여 사용할 수 있다.
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    // select m from Member m where m.username= ?
    List<Member> findByUsername(String username);
}
