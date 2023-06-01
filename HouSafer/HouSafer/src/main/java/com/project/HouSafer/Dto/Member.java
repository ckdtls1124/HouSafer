package com.project.HouSafer.Dto;

import lombok.*;

import javax.management.relation.Role;
import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

    private Long memberId;

    private String memberEmail;

    private String memberPassword;

    private String memberName;

    private String memberContactNumber;

    private String memberAddress;

    private Role role;

}
