package study.querydsl.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA는 기본생성자가 필요하다.
@ToString(of = {"id", "name"}) // toString에서는 연관관계가 없는 내부 필드만 찍어주도록 하자
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}
