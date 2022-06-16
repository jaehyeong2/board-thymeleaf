package jjfactory.boardthymeleaf.business.domain.user;

import jjfactory.boardthymeleaf.business.domain.BaseTimeEntity;
import jjfactory.boardthymeleaf.business.dto.user.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 30)
    private String email;

    @Column(length = 20)
    private String name;
    @Comment(value = "아이디")
    @Column(length = 30)
    private String username;

    private String password;

    @Column(length = 20)
    private String phone;

    @Comment("누적 경고 횟수")
    private int warningCount;

    @Comment("활동 점수")
    private int activePoint;

    @Comment("활동상태 : 활동 / 휴면")
    private Boolean activeState;

    @ElementCollection(fetch = FetchType.LAZY) //이거 없으면 에러남
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<>();

    @Builder
    public User(String name, String username, String password, String phone, String email, Boolean activeState, Gender gender, int warningCount, List<String> roles, int activePoint) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.activeState = activeState;
//        this.roles = roles;
        this.gender = gender;
        this.warningCount = warningCount;
        this.activePoint = activePoint;
    }

    public static User createUser(UserDto dto, String password){
        return builder()
                .name(dto.getName())
                .username(dto.getUsername())
                .password(password)
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .warningCount(0)
//                .roles(Collections.singletonList("ROLE_USER"))
                .gender(dto.getGender())
                .activeState(true)
                .activePoint(0)
                .build();
    }
}
