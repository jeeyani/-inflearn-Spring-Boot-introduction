package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class SpringConfig {

	/*
	 * private final DataSource dataSource; private final EntityManager em;
	 * 
	 * public SpringConfig(DataSource dataSource, EntityManager em) {
	 * this.dataSource = dataSource; this.em = em; }
	 * 
	 * private final MemberRepository memberRepository;
	 * 
	 * public SpringConfig(MemberRepository memberRepository) {
	 * this.memberRepository = memberRepository; }
	 * 
	 * @Bean public MemberService memberService() { return new
	 * MemberService(memberRepository()); }
	 * 
	 * @Bean public MemberRepository memberRepository() { // return new
	 * MemoryMemberRepository();
	 * 
	 * // return new JdbcMemberRepository(dataSource); //순수JDBC
	 * 
	 * // return new JdbcTemplateMemberRepository(dataSource); //JDBC템플릿사용
	 * 
	 * return new JpaMemberRepository(em); // JPA사용 }
	 */

	
	/*스프링 데이터 JPA*/
	/* 스프링 데이터 JPA가 extends JpaRepository 되어 있다면 자동으로 빈을 생성한다. 따라서 별도의 호출이 필요없음*/
	private final MemberRepository memberRepository;

	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

}
