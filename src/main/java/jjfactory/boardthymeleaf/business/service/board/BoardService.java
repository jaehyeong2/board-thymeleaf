package jjfactory.boardthymeleaf.business.service.board;


import jjfactory.boardthymeleaf.business.domain.board.Board;
import jjfactory.boardthymeleaf.business.domain.user.User;
import jjfactory.boardthymeleaf.business.dto.board.BoardDto;
import jjfactory.boardthymeleaf.business.dto.board.BoardResponse;
import jjfactory.boardthymeleaf.business.repository.board.BoardQueryRepository;
import jjfactory.boardthymeleaf.business.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardQueryRepository boardQueryRepository;

    @Transactional(readOnly = true)
    public Page<BoardResponse> findBoards(Pageable pageable){
        boardQueryRepository.findBoards(pageable);
    }

    @Transactional
    public BoardDto findBoard(Long id) {
        Board board = getBoard(id);

        return new BoardDto(board);
    }

    @Transactional
    public Long create(BoardDto boardDto, User user) {
        Board board = Board.createBoard(boardDto, user);
        boardRepository.save(board);
        return board.getId();
    }

    @Transactional
    public void delete(Long id) {
        Board board = getBoard(id);
        board.delete();
    }

    private Board getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("조회 실패");
        });
        return board;
    }
}
