package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    //key =  id, value = Member
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // ID 수

    //싱글톤으로 생성
    private static final MemberRepository instance = new MemberRepository();

    //조회는 getInstance로만 가능
    public static MemberRepository getInstance(){
        return instance;
    }

    //private 아무나 생성하지 못하게 막는 용도
    private MemberRepository() {
    }

    //회원 저장
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    //회원 찾기
    public Member findById(Long id){
        return store.get(id);
    }

    //회원 전체 조회
    public List<Member> findAll(){
        return new ArrayList<>(store.values()); // store에 있는 모든 값을 꺼내서 새로운 ArrayList에 담아 둔다
    }

    //store를 다 날려버리는 메소드
    public void clearStore(){
        store.clear();
    }
}
