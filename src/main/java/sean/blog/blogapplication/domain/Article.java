package sean.blog.blogapplication.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter // getter 자동 생성
@NoArgsConstructor // 접근 제어자가 protected 인 인자 없는 기본 생성자 자동 생성
// => 롬복 어노테이션 활용하여 반복 코드 필요 없어짐 -> 가독성 향상
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", updatable = false)
    private Long id;

    @Column(name ="title", nullable=false)
    private String title;

    @Column(name="content", nullable=false)
    private String content;

    @Builder // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
