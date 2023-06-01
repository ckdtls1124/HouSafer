package com.project.HouSafer.Entity.Experts;


import com.project.HouSafer.Entity.Damage.Damage;
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
@Table(name = "ExpertsComment")
public class ExpertsComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ExpertsCommentId;

//    해당 부분은 없을 수도 있어서, nullable = true (?)
    private String ExpertsCommentDetail;

//    전문가 테이블과 일대다 관계
    @ManyToOne
    @JoinColumn(name = "experts_id")
    private Experts expertsId;

//    피해사례 테이블과 일대다 관계
    @ManyToOne
    @JoinColumn(name = "damage_id")
    private Damage damageId;

}
