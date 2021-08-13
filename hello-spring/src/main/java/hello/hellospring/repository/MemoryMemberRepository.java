package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.*;

import org.springframework.stereotype.Repository;


public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
				.filter(member -> member.getName().equals(name))
				.findAny();
	}

	@Override
	public List<Member> findAll() {
		
		return new ArrayList<>(store.values());
	}
	
	//테스트케이스에서 메소드 초기화 용
	public void clearStore() {
		store.clear();
	}

}
