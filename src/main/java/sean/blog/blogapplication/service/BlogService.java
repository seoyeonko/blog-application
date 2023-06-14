package sean.blog.blogapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sean.blog.blogapplication.domain.Article;
import sean.blog.blogapplication.dto.AddArticleRequest;
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
}
