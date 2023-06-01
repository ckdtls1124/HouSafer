package com.project.HouSafer.Dto.Damage;

import com.project.HouSafer.Entity.Damage.Damage;
import com.project.HouSafer.Entity.Damage.DamageStatus;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DamageDto {

    private Long damageId;

    // 제목
    private String damageTitle;

    // 진행상황에 대한 DamageStatus enum 객체를 이용
    // 진행상태 (0 : 진행 중(기본값, 수정가능), 1 : 진행완료(수정불가))
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
    private String damageType;

    // 내용
    private String damageDetail;

    // 피해 금액
    private String damageCost;

    // 피해지원 신청 여부에 대해서 Yes or No를 표시
    private String damageSupportStatus;

    // 피해매물 주소 => 지도 api에 활용, 선택가능
    private String damageAddress;

    // 피해매물 우편번호
    private String damageZipcode;

    // 조회수
    private int damageCount;

    public static DamageDto toDamageDto(Damage damage){
        DamageDto damageDto = new DamageDto();
        damageDto.setDamageId(damage.getDamageId());
        damageDto.setDamageTitle(damage.getDamageTitle());
        damageDto.setDamageStatus(damage.getDamageStatus());
        damageDto.setDamageType(damage.getDamageType());
        damageDto.setDamageDetail(damage.getDamageDetail());
        damageDto.setDamageCost(damage.getDamageCost());
        damageDto.setDamageSupportStatus(damage.getDamageSupportStatus());
        damageDto.setDamageAddress(damage.getDamageAddress());
        damageDto.setDamageZipcode(damage.getDamageZipcode());
        damageDto.setDamageCount(damage.getDamageCount());
        return damageDto;
    }
}
