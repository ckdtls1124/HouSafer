package com.project.HouSafer.Entity.Bookmark;

import com.project.HouSafer.Entity.Damage.Damage;
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
@Table(name = "BookmarkContainer")
public class BookmarkContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkContainerId;

    //    피해사례 테이블과 일대다 관계
    @ManyToOne
    @JoinColumn(name = "damage_id")
    private Damage damageId;

    //    북마크 테이블과 일대다 관계
    @ManyToOne
    @JoinColumn(name = "bookmark_id")
    private Bookmark bookmarkId;

}
