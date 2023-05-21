package com.project.HouSafer.Entity.Experts;

import lombok.*;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "ExpertsBoard")
public class ExpertsBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expertsBoardId;

    @Column(nullable = false)
    private String expertsBoardDetail;

//    전문가 테이블과 일대다 관계
    @ManyToOne
    @JoinColumn(name = "experts_id")
    private Experts expertsId;




}
