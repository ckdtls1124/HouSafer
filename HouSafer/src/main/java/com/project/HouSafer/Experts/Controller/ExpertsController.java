package com.project.HouSafer.Experts.Controller;

import com.project.HouSafer.Dto.Experts.ExpertsDto;
import com.project.HouSafer.Experts.Service.ExpertsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/experts")
public class ExpertsController {

    private final ExpertsService expertsService;

    @GetMapping("/expertsMain")
    public String expertsMainGet(Model model){
        model.addAttribute("ExpertsDto");
        return "/experts/expertsMain";
    }

    // 전문가 회원가입
    @GetMapping("/expertsSignUp")
    public String expertsSignUpGet(Model model){
        model.addAttribute("ExpertsDto",new ExpertsDto());
        return "experts/expertsSignUp";
    }

    @PostMapping("/expertsSignUp")
    public String expertsSignUpPost(@RequestParam("imgFile") MultipartFile imgFile,
                                   @RequestParam("certificateFile") MultipartFile certificateFile,
                                   ExpertsDto expertsDto, Principal principal) throws IOException{

        expertsService.insertExperts(expertsDto);

        return "redirect:/experts/expertsMain";
    }

    // 전문가 목록
    @GetMapping("/expertsList")
    public String paging(@RequestParam("expertsType") String expertsType,
                         @PageableDefault(page = 0, size = 8, sort = "expertsId",
                         direction = Sort.Direction.DESC) Pageable pageable,
                         Model model){
        
        // 변호사
        if(expertsType.equals("Lawyer")||expertsType.equals("lawyer")){
            List<ExpertsDto> expertsDtoList = expertsService.LawyerExpertsList(expertsType);
            model.addAttribute("expertsList",expertsDtoList);

            Page<ExpertsDto> expertsList = expertsService.expertsPagingList(expertsType, pageable);

            Long total=expertsList.getTotalElements();
            int bockNum=4;
            int nowPage=expertsList.getNumber()+1;
            int startPage=Math.max(1,expertsList.getNumber()-bockNum);
            int endPage=expertsList.getTotalPages();

            model.addAttribute("total",total);
            model.addAttribute("expertsList",expertsList);
            model.addAttribute("nowPage",nowPage);
            model.addAttribute("startPage",startPage);
            model.addAttribute("endPage",endPage);

            return "experts/expertsList";
        }
        
        // 심리상담가
        if(expertsType.equals("Psy")||expertsType.equals("psy")){
            List<ExpertsDto> expertsDtoList = expertsService.PsyExpertsList(expertsType);
            model.addAttribute("expertsList",expertsDtoList);

            Page<ExpertsDto> expertsList = expertsService.expertsPagingList(expertsType, pageable);

            Long total=expertsList.getTotalElements();
            int bockNum=4;
            int nowPage=expertsList.getNumber()+1;
            int startPage=Math.max(1,expertsList.getNumber()-bockNum);
            int endPage=expertsList.getTotalPages();

            model.addAttribute("total",total);
            model.addAttribute("expertsList",expertsList);
            model.addAttribute("nowPage",nowPage);
            model.addAttribute("startPage",startPage);
            model.addAttribute("endPage",endPage);

            return "experts/expertsList1";
        }
        return null;
    }
}
