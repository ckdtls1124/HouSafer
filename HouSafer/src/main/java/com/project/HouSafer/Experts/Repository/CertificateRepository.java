package com.project.HouSafer.Experts.Repository;

import com.project.HouSafer.Entity.Experts.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
