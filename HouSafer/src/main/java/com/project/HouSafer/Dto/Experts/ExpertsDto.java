package com.project.HouSafer.Dto.Experts;

import com.project.HouSafer.Entity.Experts.Certificate;
import com.project.HouSafer.Entity.Experts.Experts;
import com.project.HouSafer.Entity.Experts.ExpertsBoard;
import com.project.HouSafer.Entity.Experts.ExpertsComment;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ExpertsDto {

    // 전문가 아이디
    private Long expertsId;

    // 전문가 변호사(lawyer)/상담가(psy)
    private String expertsType;

    // 전문가 이메일
    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 맞지 않습니다." )
    private String expertsEmail;

    // 전문가 비밀번호
    @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
    private String expertsPassword;

    // 전문가 이름
    @NotBlank(message = "이름은 필수 입력 사항입니다.")
    private String expertsName;

    // 전문가 전화번호
    @NotBlank(message = "전화번호는 필수 입력 사항입니다")
    @Pattern(regexp = "[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}", message = "전화번호 형식이 맞지 않습니다.")
    private String expertsContactNumber;

    // 전문가 주소
    private String expertsAddress;

    // 전문가 입문
    private String expertsIntroductory;

    // 전문가 경험
    private String expertsWorkExperience;

    // 전문가 전문지식
    private String expertise;

    //    증빙 서류 입력을 위한 MultipartFile 데이터의 정보 입력
    private List<Certificate> expertsCertificateFiles =new ArrayList<>();

    //    전문가 게시판 테이블과 다대일 관계
    private List<ExpertsBoard> expertsBoardDetail = new ArrayList<>();

    //    전문가 의견 테이블과 다대일 관계
    private List<ExpertsComment> eachExpertComment = new ArrayList<>();

    // 전문가 사진 유무(0,1)
    private int expertAttach;

    private MultipartFile imgFile;
    private String imgOldName;
    private String imgNewName;

    // 증빙서류
    private MultipartFile certificateFile;
    // 원본파일명
    private String certificateOldName;
    // 저장파일명
    private String certificateNewName;

    public static ExpertsDto toExpertsDto(Experts experts){
        ExpertsDto expertsDto = new ExpertsDto();
        expertsDto.setExpertsType(experts.getExpertsType());
        expertsDto.setExpertsId(experts.getExpertsId());
        expertsDto.setExpertsPassword(experts.getExpertsPassword());
        expertsDto.setExpertsName(experts.getExpertsName());
        expertsDto.setExpertsContactNumber(experts.getExpertsContactNumber());
        expertsDto.setExpertsAddress(experts.getExpertsAddress());
        expertsDto.setExpertsIntroductory(experts.getExpertsIntroductory());
        expertsDto.setExpertsWorkExperience(experts.getExpertsWorkExperience());
        expertsDto.setExpertise(experts.getExpertise());

        // 증빙서류 불러오기
        expertsDto.setCertificateOldName(experts.getExpertsCertificateFiles().get(0).getCertificateOldName());
        expertsDto.setCertificateNewName(experts.getExpertsCertificateFiles().get(0).getCertificateNewName());


        if (experts.getExpertAttach() == 0) {
            expertsDto.setExpertAttach(experts.getExpertAttach());
        }else {
            expertsDto.setExpertAttach(experts.getExpertAttach());

            // 이미지 불러오기
            expertsDto.setImgOldName(experts.getImgEntities().get(0).getImgOldName());
            expertsDto.setImgNewName(experts.getImgEntities().get(0).getImgNewName());
        }
        return expertsDto;
    }
}
