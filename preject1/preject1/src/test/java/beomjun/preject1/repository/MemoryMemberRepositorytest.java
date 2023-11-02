package beomjun.preject1.repository;

import beomjun.preject1.domain.Member;
import beomjun.preject1.repositorty.MemberRepository;
import beomjun.preject1.repositorty.MemoryMemberRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MemoryMemberRepositorytest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @Test
    public  void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//      System.out.println("result = " + (result == member));
//       Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public  void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(1);


    }


    @AfterEach // 할때 마다 초기화 하는것
    public void afterEach() {
        repository.clearStore();
    }


}
