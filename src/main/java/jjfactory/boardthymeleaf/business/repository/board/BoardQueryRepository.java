package jjfactory.boardthymeleaf.business.repository.board;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.boardthymeleaf.business.dto.board.BoardResponse;
import jjfactory.boardthymeleaf.global.dto.QueryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jjfactory.boardthymeleaf.business.domain.board.QBoard.board;

@RequiredArgsConstructor
@Repository
public class BoardQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Page<BoardResponse> findBoards(Pageable pageable, QueryModel queryModel){
        List<BoardResponse> boards = queryFactory.select(Projections.constructor(BoardResponse.class, board))
                .from(board)
                .where(board.id.isNotNull(), query(queryModel.getQuery()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int count = queryFactory.select(Projections.constructor(BoardResponse.class, board))
                .from(board)
                .where(board.id.isNotNull(), query(queryModel.getQuery())).fetch().size();

        return new PageImpl<>(boards,pageable,count);
    }


    public BooleanExpression query(String query){
        if(StringUtils.isNullOrEmpty(query)) return null;
        return board.content.contains(query)
                .or(board.title.contains(query))
                .or(board.user.username.contains(query));
    }
}
