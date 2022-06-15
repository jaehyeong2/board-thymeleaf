package jjfactory.boardthymeleaf.business.repository.comment;

import jjfactory.boardthymeleaf.business.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
