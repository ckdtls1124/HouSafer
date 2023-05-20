package com.project.HouSafer.Entity.Experts;

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
@Table(name = "Certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificateId;

//    증명서 파일
//    @Column(nullable = false)
//    private MultipartFile certificateFile;

    @ManyToOne
    @JoinColumn(name = "experts_id")
    private Experts expertsId;

}
