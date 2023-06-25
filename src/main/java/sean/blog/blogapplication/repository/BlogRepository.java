package sean.blog.blogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sean.blog.blogapplication.domain.Article;

// 해당 repository 사용시 JpaRepository 에서 제공하는 여러 메서드 사용 가능
public interface BlogRepository extends JpaRepository<Article, Long> {


}
