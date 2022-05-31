package com.example.basics.exceptions.handler;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionFilters {
    private String title;
    private Integer status;
    private String details;
    private LocalDateTime timestamp;
    private String devMsg;
}
