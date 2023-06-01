package com.project.HouSafer.Entity.Experts;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "img")
public class ExpertsImg {

    // 전문가 이미지 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imgId")
    private Long imgId;

    // 전문가 원본파일명
    @Column(name = "imgOldName", nullable = false)
    private String imgOldName;

    // 전문가 저장파일명
    @Column(name = "imgNewName", nullable = false)
    private String imgNewName;

    // Experts(Entity) 전문가 아이디와 조인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expertsId")
    private Experts experts;

    public static ExpertsImg toExpertsImg(Experts experts, String imgOldName, String imgNewName){
        ExpertsImg expertsImg = new ExpertsImg();
        expertsImg.setExperts(experts);
        expertsImg.setImgOldName(imgOldName);
        expertsImg.setImgNewName(imgNewName);
        return expertsImg;
    }
}
