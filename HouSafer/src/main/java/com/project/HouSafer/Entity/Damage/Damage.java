package com.project.HouSafer.Entity.Damage;

import com.project.HouSafer.Entity.Bookmark.BookmarkContainer;
import com.project.HouSafer.Entity.Contract.Contract;
import com.project.HouSafer.Entity.Experts.ExpertsComment;
import com.project.HouSafer.Entity.Fraud.Fraud;
import com.project.HouSafer.Entity.Member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Damage")
public class Damage{

//    피해사례 : 제목, 진행상황(진행중, 완료, 미확인),
//    사기유형(테이블 참조), 피해 내용 상세경험담, 조회수, 피해금액,
//    피해지원신청여부(y/n), 회원아이디 참조)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long damageId;

    @Column(nullable = false)
    private String damageTitle;

//    진행상황에 대한 DamageStatus enum 객체를 이용
    @Column(nullable = false)
    private DamageStatus damageStatus;

//    사기 유형 테이블을 참조 하여 사기유형
//    @Column(nullable = false)
//    private String damageType;

    @Column(nullable = false)
    private String damageDetail;

//    조회수


    @Column(nullable = false)
    private String damageCost;


//    피해지원 신청 여부에 대해서 Yes or No를 표시
    @Column(nullable = false)
    private String damageSupportStatus;

//     피해 사례 증거(DamageProof)와 다대일 관계 설정
    @OneToMany(mappedBy = "damageId", cascade = CascadeType.ALL)
    private List<DamageProof> damageProofFiles = new ArrayList<>();

//    계약 테이블과 다대일 관계
    @OneToMany(mappedBy = "damageId", cascade = CascadeType.ALL)
    private List<Contract> contractFileEachDamage = new ArrayList<>();

//    북마크 컨테이너 테이블과 일대다 관계
    @ManyToOne
    @JoinColumn(name= "bookmarkContainer_id")
    private BookmarkContainer bookmarkContainerId;

//    사기 유형 테이블과 다대일 관계
    @OneToMany(mappedBy = "damageId", cascade = CascadeType.ALL)
    private List<Fraud> eachFraud = new ArrayList<>();

//    전문가 의견 테이블과 다대일 관계
    @OneToMany(mappedBy = "damageId", cascade = CascadeType.ALL)
    private List<ExpertsComment> eachExpertsComment = new ArrayList<>();

//    회원 테이블과 일대다 관계
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

}
