package jjfactory.boardthymeleaf.business.dto.board;

import jjfactory.boardthymeleaf.business.domain.board.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardResponse {
    private String title;
    private String content;

    public BoardResponse(Board board) {
        this.title = title;
        this.content = content;
    }
}
