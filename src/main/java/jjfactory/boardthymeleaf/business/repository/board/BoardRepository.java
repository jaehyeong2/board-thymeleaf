package jjfactory.boardthymeleaf.business.repository.board;

import jjfactory.boardthymeleaf.business.domain.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Page<Board> findAll(Pageable pageable);
}
