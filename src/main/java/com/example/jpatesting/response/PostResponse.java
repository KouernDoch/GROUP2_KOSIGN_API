package com.example.jpatesting.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse<T> {
    private Integer statusCode;
    private T payload;
    private LocalDateTime date;
    private boolean success;
}
