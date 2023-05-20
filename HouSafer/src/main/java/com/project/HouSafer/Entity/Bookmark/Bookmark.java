package com.project.HouSafer.Entity.Bookmark;

import com.project.HouSafer.Entity.Damage.Damage;
import com.project.HouSafer.Entity.Member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Bookmark")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

//    회원 아이디 참조와 일대일 관계 / 회원 테이블에서 외래키 설정
    @OneToOne(mappedBy = "bookmarkId")
    private Member memberId;


// 북마크 컨테이너 테이블과 일대일 관계 / 복마크 테이블에서 외래키 설정
    @OneToOne
    @JoinColumn(name = "bookmarkContainer_id")
    @UniqueElements
    private BookmarkContainer bookmarkContainerId;

}
