package hyuk.playground.springbootdataredis.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;

@DataRedisTest
class PersonRedisRepositoryTest {

	@Autowired
	private PersonRedisRepository repo;

	@Test
	void test() {
		Person person = new Person("Pang", 20);

		//저장
		repo.save(person);

		//'keyspace:id' 값을 가져옴
		repo.findById(person.getId());

		//Person Entity 의 @RedisHash에 정의돼 있는 keyspace (people) 에 속한 키의 갯수를 구
		repo.count();

		// 삭제
		// repo.delete(person);
	}
}
