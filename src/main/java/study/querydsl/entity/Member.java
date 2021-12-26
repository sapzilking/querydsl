package study.querydsl.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA는 기본생성자가 필요하다.
@Entity
@ToString(of = {"id", "username", "age"}) // toString에서는 연관관계가 없는 내부 필드만 찍어주도록 하자
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this(username, 0);
    }

    public Member(String username, int age) {
        this(username, age, null);
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
