package com.project.HouSafer.Damage.Repository;

import com.project.HouSafer.Entity.Damage.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageRepository extends JpaRepository<Damage, Long> {
}
