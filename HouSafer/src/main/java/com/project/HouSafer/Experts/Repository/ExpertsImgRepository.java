package com.project.HouSafer.Experts.Repository;

import com.project.HouSafer.Entity.Experts.ExpertsImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertsImgRepository extends JpaRepository<ExpertsImg, Long> {
}
