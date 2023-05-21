package com.project.HouSafer.Entity.Experts;

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

    @Column(nullable = false)
    private String expertise;

//    증빙 서류 입력을 위한 MultipartFile 데이터의 정보 입력
    @OneToMany(mappedBy = "expertsId", cascade = CascadeType.ALL)
    private List<Certificate> expertsCertificateFiles =new ArrayList<>();

//    전문가 게시판 테이블과 다대일 관계
    @OneToMany(mappedBy = "expertsId", cascade = CascadeType.ALL)
    private List<ExpertsBoard> expertsBoardDetail = new ArrayList<>();

//    전문가 의견 테이블과 다대일 관계
     @OneToMany(mappedBy = "expertsId", cascade = CascadeType.ALL)
    private List<ExpertsComment> eachExpertComment = new ArrayList<>();

}
