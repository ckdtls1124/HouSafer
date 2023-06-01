package com.project.HouSafer.Entity.Damage;

import com.project.HouSafer.Dto.Damage.DamageDto;
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

    // 제목
    @Column(nullable = false)
    private String damageTitle;

    // 진행상황에 대한 DamageStatus enum 객체를 이용
    // 진행상태 (0 : 진행 중(기본값, 수정가능), 1 : 진행완료(수정불가))
//    @Column(nullable = false)
    private DamageStatus damageStatus;

    // 사기 유형 테이블을 참조 하여 사기유형
    // 유형 :
    // a(깡통주택)
    // b(가짜임대인)
    // c(계약무효)
    // d(공인중개사 사기)
    // e(임대인변경-바지집주인)
    // f(이중계약)
    // g(특약조건 불이행)
    // h(임대인의 체납)
    // i(전출신고 악용)
    // j(보증금 미반환)
    // k(새로운 사기 방법)
    @Column(nullable = false)
    private String damageType;

    // 내용
    @Column(nullable = false)
    private String damageDetail;

    // 피해 금액
    @Column(nullable = false)
    private String damageCost;


    // 피해지원 신청 여부에 대해서 Yes or No를 표시
    @Column(nullable = false)
    private String damageSupportStatus;

    // 피해매물 주소 => 지도 api에 활용, 선택가능
    @Column(nullable = false)
    private String damageAddress;

    // 피해매물 우편번호
    @Column(nullable = false)
    private String damageZipcode;

    // 조회수
    @Column()
    private int damageCount;

    // 피해 사례 증거(DamageProof)와 다대일 관계 설정
    @OneToMany(mappedBy = "damageId", cascade = CascadeType.ALL)
    private List<DamageProof> damageProofFiles = new ArrayList<>();

    // 계약 테이블과 다대일 관계
    @OneToMany(mappedBy = "damageId", cascade = CascadeType.ALL)
    private List<Contract> contractFileEachDamage = new ArrayList<>();

    // 북마크 컨테이너 테이블과 다대일 관계
    @OneToMany(mappedBy = "damageId", cascade = CascadeType.ALL)
    private List<BookmarkContainer> eachbookmarkContainer = new ArrayList<>();

    // 사기 유형 테이블과 다대일 관계
    @OneToMany(mappedBy = "damageId", cascade = CascadeType.ALL)
    private List<Fraud> eachFraud = new ArrayList<>();

    // 전문가 의견 테이블과 다대일 관계
    @OneToMany(mappedBy = "damageId", cascade = CascadeType.ALL)
    private List<ExpertsComment> eachExpertsComment = new ArrayList<>();

    // 회원 테이블과 일대다 관계
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;

    // 피해사례 등록
    public static Damage toDamage(DamageDto damageDto){
        Damage damage = new Damage();
        damage.setDamageTitle(damageDto.getDamageTitle());
        damage.setDamageStatus(damageDto.getDamageStatus());
        damage.setDamageType(damageDto.getDamageType());
        damage.setDamageDetail(damageDto.getDamageDetail());
        damage.setDamageCost(damageDto.getDamageCost());
        damage.setDamageSupportStatus(damageDto.getDamageSupportStatus());
        damage.setDamageAddress(damageDto.getDamageAddress());
        damage.setDamageZipcode(damageDto.getDamageZipcode());
        damage.setDamageCount(0);
        return damage;
    }
}
