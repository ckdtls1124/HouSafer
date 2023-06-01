package com.project.HouSafer.Damage.Controller;

import com.project.HouSafer.Damage.Service.DamageService;
import com.project.HouSafer.Dto.Damage.DamageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/damage")
public class DamageController {

    private final DamageService damageService;

    // 피해사례 작성
    @GetMapping("/damageWrite")
    public String damageWriteGet(Model model){
        model.addAttribute("DamageDto", new DamageDto());
        return "/damage/damageWrite";
    }

    @PostMapping("/damageWrite")
    public String damageWritePost(@Valid DamageDto damageDto, Principal principal, BindingResult bindingResult) throws IOException{

    damageService.insertDamage(damageDto);

    return "redirect:/damage/damageWrite";
    }
}
