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

//    북마크 테이블과 일대일 관계 / 북마크 테이블에서 외래키 설정
    @OneToOne(mappedBy = "bookmarkContainerId")
    private Bookmark bookmarkId;



    //    피해사례 테이블과 다대일 관계
    @OneToMany(mappedBy = "bookmarkContainerId", cascade = CascadeType.ALL)
    private List<Damage> eachBookmarkContainer = new ArrayList<>();
}
