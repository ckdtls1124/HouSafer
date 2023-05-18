package com.project.HouSafer.Entity.Experts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Experts")
public class Experts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expertsId;

    @Column(nullable = false)
    private String expertsEmail;

    @Column(nullable = false)
    private String expertsPassword;

    @Column(nullable = false)
    private String expertsName;

    @Column(nullable = false)
    private String expertsContactNumber;

    @Column(nullable = false)
    private String expertsAddress;

    @Column(nullable = false)
    private String expertsIntroductory;

    @Column(nullable = false)
    private String expertsWorkExperience;

//    증빙 서류 입력을 위한 MultipartFile 데이터의 정보 입력
    @OneToMany(mappedBy = "expertsId", cascade = CascadeType.ALL)
    private List<EvidenceFiles> expertsEvidenceFiles=new ArrayList<>();



}
