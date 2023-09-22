package com.easyone.travelance.domain.travel.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeUpdateRequestDto {
    private String title;
    private String content;
    private String link;
}