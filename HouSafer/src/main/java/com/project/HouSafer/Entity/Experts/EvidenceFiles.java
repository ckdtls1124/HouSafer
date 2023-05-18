package com.project.HouSafer.Entity.Experts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "EvidenceFiles")
public class EvidenceFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EvidenceFilesId;

//    @Column(nullable = false)
//    private MultipartFile evidenceFile;

    @ManyToOne
    @JoinColumn(name = "experts_id")
    private Experts expertsId;

}
