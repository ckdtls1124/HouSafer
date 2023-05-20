package com.project.HouSafer.Entity.Contract;

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

//    피해 사례 테이블 참조



}
