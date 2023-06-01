package com.project.HouSafer.Dto.Experts;

import com.project.HouSafer.Entity.Experts.Certificate;
import com.project.HouSafer.Entity.Experts.Experts;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificateDto {

    private Long certificateId;

    public String certificateOldName;

    public String certificateNewName;

    public static CertificateDto toCertificateDto(Certificate certificate){
        CertificateDto certificateDto = new CertificateDto();
        certificateDto.setCertificateNewName(certificate.getCertificateNewName());
        return certificateDto;
    }
}
