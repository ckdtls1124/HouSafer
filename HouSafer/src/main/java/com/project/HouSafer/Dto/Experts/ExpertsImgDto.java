package com.project.HouSafer.Dto.Experts;

import com.project.HouSafer.Entity.Experts.Experts;
import com.project.HouSafer.Entity.Experts.ExpertsImg;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpertsImgDto {

    // 전문가 이미지 아이디
    private Long imgId;

    // 전문가 원본파일명
    private String imgOldName;

    // 전문가 저장파일명
    private String imgNewName;

    public static ExpertsImgDto toExpertsImgDto(ExpertsImg expertsImg){
        ExpertsImgDto expertsImgDto = new ExpertsImgDto();
        expertsImgDto.setImgNewName(expertsImg.getImgNewName());
        return expertsImgDto;
    }
}
