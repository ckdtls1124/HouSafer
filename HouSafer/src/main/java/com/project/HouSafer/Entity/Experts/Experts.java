package com.project.HouSafer.Entity.Experts;

import com.project.HouSafer.Dto.Experts.ExpertsDto;
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

    // 전문가 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expertsId;

    // 전문가 변호사(lawyer)/상담가(psy)
    @Column(name = "experts_type",nullable = false)
    private String expertsType;

    // 전문가 이메일
    @Column(nullable = false)
    private String expertsEmail;

    // 전문가 비밀번호
    @Column(nullable = false)
    private String expertsPassword;

    // 전문가 이름
    @Column(nullable = false)
    private String expertsName;

    // 전문가 전화번호
    @Column(nullable = false)
    private String expertsContactNumber;

    // 전문가 주소
    @Column(nullable = false)
    private String expertsAddress;

    // 전문가 입문
    @Column(nullable = false)
    private String expertsIntroductory;

    // 전문가 경험
    @Column(nullable = false)
    private String expertsWorkExperience;

    // 전문가 전문지식
    @Column(nullable = false)
    private String expertise;

    // 증빙 서류 입력을 위한 MultipartFile 데이터의 정보 입력
    @OneToMany(mappedBy = "expertsId", cascade = CascadeType.ALL)
    private List<Certificate> expertsCertificateFiles =new ArrayList<>();

    // 전문가 게시판 테이블과 다대일 관계
    @OneToMany(mappedBy = "expertsId", cascade = CascadeType.ALL)
    private List<ExpertsBoard> expertsBoardDetail = new ArrayList<>();

    // 전문가 의견 테이블과 다대일 관계
    @OneToMany(mappedBy = "expertsId", cascade = CascadeType.ALL)
    private List<ExpertsComment> eachExpertComment = new ArrayList<>();

    // 전문가 사진 유무(0,1)
    @Column(name = "expertAttach", nullable = false)
    private int expertAttach;

    // 첨부 사진
    @OneToMany(mappedBy = "experts", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ExpertsImg> imgEntities = new ArrayList<>();

    // 전문가 등록
    public static Experts toNoExperts(ExpertsDto expertsDto){

        Experts experts = new Experts();
        experts.setExpertsType(expertsDto.getExpertsType());
        experts.setExpertsEmail(expertsDto.getExpertsEmail());
        experts.setExpertsPassword(expertsDto.getExpertsPassword());
        experts.setExpertsName(expertsDto.getExpertsName());
        experts.setExpertsContactNumber(expertsDto.getExpertsContactNumber());
        experts.setExpertsAddress(expertsDto.getExpertsAddress());
        experts.setExpertsIntroductory(expertsDto.getExpertsIntroductory());
        experts.setExpertsWorkExperience(expertsDto.getExpertsWorkExperience());
        experts.setExpertise(expertsDto.getExpertise());
        experts.setExpertAttach(0); // 사진 없을 때
        return experts;
    }

    public static Experts toYesExperts(ExpertsDto expertsDto){

        Experts experts = new Experts();
        experts.setExpertsType(expertsDto.getExpertsType());
        experts.setExpertsEmail(expertsDto.getExpertsEmail());
        experts.setExpertsPassword(expertsDto.getExpertsPassword());
        experts.setExpertsName(expertsDto.getExpertsName());
        experts.setExpertsContactNumber(expertsDto.getExpertsContactNumber());
        experts.setExpertsAddress(expertsDto.getExpertsAddress());
        experts.setExpertsIntroductory(expertsDto.getExpertsIntroductory());
        experts.setExpertsWorkExperience(expertsDto.getExpertsWorkExperience());
        experts.setExpertise(expertsDto.getExpertise());
        experts.setExpertAttach(1); // 사진 있을 때
        return experts;
    }

    // 전문가 수정
    public static Experts toNoUpdateExperts(ExpertsDto expertsDto){

        Experts experts = new Experts();
        experts.setExpertsType(expertsDto.getExpertsType());
        experts.setExpertsEmail(expertsDto.getExpertsEmail());
        experts.setExpertsPassword(expertsDto.getExpertsPassword());
        experts.setExpertsName(expertsDto.getExpertsName());
        experts.setExpertsContactNumber(expertsDto.getExpertsContactNumber());
        experts.setExpertsAddress(expertsDto.getExpertsAddress());
        experts.setExpertsIntroductory(expertsDto.getExpertsIntroductory());
        experts.setExpertsWorkExperience(expertsDto.getExpertsWorkExperience());
        experts.setExpertise(expertsDto.getExpertise());
        experts.setExpertAttach(0); // 사진 없을 때
        return experts;
    }

    public static Experts toYesoUpdateExperts(ExpertsDto expertsDto){

        Experts experts = new Experts();
        experts.setExpertsType(expertsDto.getExpertsType());
        experts.setExpertsEmail(expertsDto.getExpertsEmail());
        experts.setExpertsPassword(expertsDto.getExpertsPassword());
        experts.setExpertsName(expertsDto.getExpertsName());
        experts.setExpertsContactNumber(expertsDto.getExpertsContactNumber());
        experts.setExpertsAddress(expertsDto.getExpertsAddress());
        experts.setExpertsIntroductory(expertsDto.getExpertsIntroductory());
        experts.setExpertsWorkExperience(expertsDto.getExpertsWorkExperience());
        experts.setExpertise(expertsDto.getExpertise());
        experts.setExpertAttach(1); // 사진 있을 때
        return experts;
    }

}
