package com.example.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class TodoDtoEntity {
    private long id;
    private String title;
    private String content;
}
