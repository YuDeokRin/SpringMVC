package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {
    MemberRepository memberRepository =  MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        // Test끝날 때 마다 다 초기화
        memberRepository.clearStore();
    }


    @Test
    void save() {
        //given : ~ 가 주어 줬을 때
        Member member = new Member("hello", 20);


        //when : ~ 실행 했을 떄
        Member saveMember = memberRepository.save(member);


        //then : ~결과가 ~이여야된다.
        Member findMember =   memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){

        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2); // result 안에 member1, member2 가 들어있는지 확인

    }
}


