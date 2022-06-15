package jjfactory.boardthymeleaf.business.dto.user;

import jjfactory.boardthymeleaf.business.domain.user.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private String name;
    private String username;
    private String password;
    private String email;
    private Gender gender;
    private String phone;
}
