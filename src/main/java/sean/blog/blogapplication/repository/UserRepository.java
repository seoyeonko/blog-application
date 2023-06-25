package sean.blog.blogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sean.blog.blogapplication.domain.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // email 로 사용자 정보 가져옴
    // findByEmail() 메서드가 요청하는 쿼리 예시: from users where email = #{email}
}
