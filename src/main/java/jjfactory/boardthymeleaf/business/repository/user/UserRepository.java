package jjfactory.boardthymeleaf.business.repository.user;

import jjfactory.boardthymeleaf.business.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
