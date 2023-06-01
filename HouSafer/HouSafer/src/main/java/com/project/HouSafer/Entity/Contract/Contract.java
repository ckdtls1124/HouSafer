package com.project.HouSafer.Entity.Contract;

import com.project.HouSafer.Entity.Damage.Damage;
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
@Table(name = "Contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @Column(nullable = false)
    private String contractDuration;

    @Column(nullable = false)
    private String contractResidenceType;

    @Column(nullable = false)
    private String contractRegion;

    @Column(nullable = false)
    private String contractCondition;

//    피해 사례 테이블과 일대다 관계
    @ManyToOne
    @JoinColumn(name = "damage_id")
    private Damage damageId;



}
