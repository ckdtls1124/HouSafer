package com.project.HouSafer.Experts.Repository;

import com.project.HouSafer.Entity.Experts.Experts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertsRepository extends JpaRepository<Experts, Long> {

    // 전문가 목록 변호사/심리상담가 분리
    @Query(value = "select * from experts where experts_type",nativeQuery = true)
    List<Experts> findByExpertsType(String expertsType);

    // 전문가 목록 페이징
    Page<Experts> findAllByExpertsType(String expertsType, Pageable pageable);
}
