package com.project.HouSafer.Experts.Service;

import com.project.HouSafer.Dto.Experts.ExpertsDto;
import com.project.HouSafer.Entity.Experts.Certificate;
import com.project.HouSafer.Entity.Experts.Experts;
import com.project.HouSafer.Entity.Experts.ExpertsImg;
import com.project.HouSafer.Experts.Repository.CertificateRepository;
import com.project.HouSafer.Experts.Repository.ExpertsImgRepository;
import com.project.HouSafer.Experts.Repository.ExpertsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpertsService {

    private final ExpertsRepository expertsRepository;

    private final ExpertsImgRepository expertsImgRepository;

    private final CertificateRepository certificateRepository;

    // 전문가 회원가입시
    @Transactional
    public void insertExperts(ExpertsDto expertsDto) throws IOException {

        MultipartFile multipartFile1 = expertsDto.getCertificateFile();
        // 원본 파일 이름
        String originalFilename1 = multipartFile1.getOriginalFilename();
        // 랜덤 파일 이름
        UUID uuid1 = UUID.randomUUID();

        //새로운 파일 이름
        String newFilename = uuid1 + "_"+originalFilename1;
//            String newFilename = originalFilename;
        // 파일 저장 위치
        String filePath1 = "C:/saveFiles/" +newFilename;

        // 파일 경로 탐색
        multipartFile1.transferTo(new File(filePath1));

        Experts experts1 = Experts.toYesExperts(expertsDto);
        Long ExpertsId = expertsRepository.save(experts1).getExpertsId();

        Optional<Experts> certificateExperts = expertsRepository.findById(ExpertsId);
        Experts expertsCertificate = certificateExperts.get();

        Certificate certificate = Certificate.toCertificate(expertsCertificate,originalFilename1, newFilename);
        certificateRepository.save(certificate); // 파일 저장

        // 이미지가 없을 때
        if (expertsDto.getImgFile().isEmpty()) {

            Experts experts = Experts.toNoExperts(expertsDto);
            expertsRepository.save(experts);
        }

        //이미지가 있을 떄
        else {

            //1. 이미지 받아오기

            MultipartFile multipartFile2 = expertsDto.getImgFile();
            String originalImgName2 = multipartFile2.getOriginalFilename(); //원본파일이름
            UUID uuid = UUID.randomUUID(); // 랜덤 이미지 이름

            String newImgName = uuid + "_" + originalImgName2; //새로운 이미지 이름
            String filePath = "C:/saveFiles/" + newImgName; //이미지 경로

            multipartFile2.transferTo(new File(filePath)); // 이미지 경로 탐색

            Experts experts = Experts.toYesExperts(expertsDto);
            Long expertsId = expertsRepository.save(experts).getExpertsId();

            Optional<Experts> imgExperts = expertsRepository.findById(expertsId);
            Experts experts2 = imgExperts.get(); //id에 해당하는 상품

            ExpertsImg expertsImg = ExpertsImg.toExpertsImg(experts2, originalImgName2, newImgName);
            expertsImgRepository.save(expertsImg); // 파일저장
        }

    }

    // 전문가 목록(변호사)
    public List<ExpertsDto> LawyerExpertsList(String expertsType){

        List<Experts> LawyerExpertsEntity = expertsRepository.findByExpertsType(expertsType);
        List<ExpertsDto> LawyerExpertsDto = new ArrayList<>();

        for (Experts experts : LawyerExpertsEntity){
            LawyerExpertsDto.add(ExpertsDto.toExpertsDto(experts));
        }
        return LawyerExpertsDto;
    }

    // 전문가 목록(심리상담가)
    public List<ExpertsDto> PsyExpertsList(String expertsType){

        List<Experts> PsyExpertsEntity = expertsRepository.findByExpertsType(expertsType);
        List<ExpertsDto> PsyExpertsDto = new ArrayList<>();

        for (Experts experts : PsyExpertsEntity){
            PsyExpertsDto.add(ExpertsDto.toExpertsDto(experts));
        }
        return PsyExpertsDto;
    }

    // 전문가 목록 페이징
    public Page<ExpertsDto> expertsPagingList(String expertsType, Pageable pageable){

        Page<Experts> ExpertsEntityList = expertsRepository.findAllByExpertsType(expertsType, pageable);
        Page<ExpertsDto> ExpertsDtoList = ExpertsEntityList.map(ExpertsDto::toExpertsDto);

        return ExpertsDtoList;
    }
}
