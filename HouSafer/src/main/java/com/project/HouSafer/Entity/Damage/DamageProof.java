package com.project.HouSafer.Entity.Damage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "DamageProof")
public class DamageProof {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long damageProofId;

//    피해 사례 증명 첨부 파일

//    피해 사례 테이블 일대다 관계 설정
    @ManyToOne
    @JoinColumn(name = "damage_id")
    private Damage damageId;

}
