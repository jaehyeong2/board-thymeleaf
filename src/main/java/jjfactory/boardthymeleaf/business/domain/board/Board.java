package jjfactory.boardthymeleaf.business.domain.board;

import jjfactory.boardthymeleaf.business.domain.BaseTimeEntity;
import jjfactory.boardthymeleaf.business.domain.user.User;
import jjfactory.boardthymeleaf.business.dto.board.BoardDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Comment("제목")
    @Column(length = 100)
    private String title;
    @Comment("내용")
    private String content;

    @Comment("활성화 여부: 활성화 / 숨김")
    private Boolean isView;

    @Comment("조회수")
    private int viewCount;

    @Comment("좋아요 갯수")
    private int likeCount;

    @Builder
    public Board(User user, String title, String content, Boolean isView, int viewCount, int likeCount) {
        this.user = user;
//        this.category = category;
//        this.imageList = imageList;
        this.title = title;
        this.content = content;
        this.isView = isView;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
    }

    public static Board createBoard(BoardDto dto){
        return builder()
                .title(dto.getTitle())
                .content(dto.getContent())
//                .user(user)
//                .category(category)
                .likeCount(0)
                .viewCount(0)
                .isView(true)
                .build();
    }

    public void delete() {
        isView = false;
    }
}
