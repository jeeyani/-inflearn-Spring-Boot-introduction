package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

public class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	/* 각 메소드가 끝날때 마다 호출되어 객체를 초기화 시켜줌*/
	@AfterEach
	public void afterEach() {
		 repository.clearStore();
	}
	
	@Test
	public void save() {
		// given
		Member member = new Member();
		member.setName("spring");

		// when
		repository.save(member);
		// then
		Member result = repository.findById(member.getId()).get();
		assertThat(result).isEqualTo(member);
	}

	@Test
	public void findByName() {
		// given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		// when
		Member result = repository.findByName("spring1").get();
		
		//then
		assertThat(result).isEqualTo(member1);//result가 member1과 같은지 비교
	
	}
	
	@Test
	public void findAll() {
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		//when
		List<Member> result = repository.findAll();
		
		//then
		assertThat(result.size()).isEqualTo(2);
	}
	
	
	

}
