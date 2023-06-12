package sean.blog.blogapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sean.blog.blogapplication.domain.Article;
import sean.blog.blogapplication.dto.AddArticleRequest;
import sean.blog.blogapplication.service.BlogService;

@RequiredArgsConstructor
@RestController // HTTP Response Body 에 객체 데이터를 JSON 형식으로 변환하는 컨트롤러
public class BlogApiController {
    private final BlogService blogService;

    // HTTP 메서드가 POST 일 때 전달받은 URL 과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    // 요청 본문 값 매핑
    // @RequestBody: HTTP 요청시 응답에 해당하는 값을 @RequestBody 어노테이션이 붙은 대상 객체인 AddArticleRequest 에 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        // 응답코드 201
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
}
