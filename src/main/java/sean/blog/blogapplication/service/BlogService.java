package sean.blog.blogapplication.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sean.blog.blogapplication.domain.Article;
import sean.blog.blogapplication.dto.AddArticleRequest;
import sean.blog.blogapplication.dto.UpdateArticleRequest;
import sean.blog.blogapplication.repository.BlogRepository;

import java.util.List;

@RequiredArgsConstructor // final 이 붙거나 @NotNull 이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    // save(): JpaRepository 에서 지원하는 저장 메서드 AddArticleRequest 클래스에 저장되는 값들을 article 데이터베이스에 저장
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 블로그 모든 글 조회 메서드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 블로그 글 하나 조회 메서드
    public Article findById(long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(("not found: "+ id)));
    }

    // 블로그 글 삭제 메서드
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 블로그 글 수정 메서드
    @Transactional // 트랜잭션 메서드: 매칭한 메서드를 하나의 트랜잭션으로 묶는 역할
    // 즉, update()에서 엔티티의 필드 값이 바뀌면 중간에 에러가 발생해도 제대로된 값 수정을 보장
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
