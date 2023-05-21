package com.project.HouSafer;

import com.project.HouSafer.Entity.Damage.Damage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HouSaferApplicationTests {

	@Test
	void contextLoads() {
		Damage damage = new Damage();

		damage.setDamageTitle("dd");

		System.out.println(damage.getDamageTitle());
	}

}
