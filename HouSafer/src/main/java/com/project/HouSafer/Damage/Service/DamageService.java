package com.project.HouSafer.Damage.Service;

import com.project.HouSafer.Damage.Repository.DamageRepository;
import com.project.HouSafer.Dto.Damage.DamageDto;
import com.project.HouSafer.Entity.Damage.Damage;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DamageService {

    private final DamageRepository damageRepository;

    // 피해사례 작성시
    @Transactional
    public void insertDamage(DamageDto damageDto) throws IOException{

        Damage damage = Damage.toDamage(damageDto);
        damageRepository.save(damage);
    }
}
