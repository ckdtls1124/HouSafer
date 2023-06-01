package com.project.HouSafer.Entity.Fraud;

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
@Table(name = "Fraud")
public class Fraud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fraudId;

    @Column(nullable = false)
    private String fraudName;

    @Column(nullable = false)
    private String fraudDetail;

//    피해 사례 테이블과 일대다 관계 설정
    @ManyToOne
    @JoinColumn(name = "damage_id")
    private Damage damageId;


}
