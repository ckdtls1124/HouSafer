package com.project.HouSafer.Entity.Member;

import com.project.HouSafer.Entity.Bookmark.Bookmark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.management.relation.Role;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String memberPassword;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String memberContactNumber;

    @Column(nullable = false)
    private String memberAddress;

    @Column(nullable = false)
    private String memberRole;

//    북마크와 일대일 관계 / 회원 테이블의 외래키를 가짐
    @OneToOne
    @JoinColumn(name = "bookmark_id")
//    일대일 관계에서, 주 테이블에 외래키를 설정할 경우, unique 설정이 필요(??)
    @UniqueElements
    private Bookmark bookmarkId;

}
