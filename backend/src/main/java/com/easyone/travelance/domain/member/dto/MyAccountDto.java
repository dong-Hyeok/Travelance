package com.easyone.travelance.domain.member.dto;

import lombok.Data;

@Data
public class MyAccountDto {
    private Long id;
    private String account;
    private String accountName;
    private Long idx;

    // 생성자, getter, setter 등 필요한 메소드 추가
}
