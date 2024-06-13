package com.amalitech.lab5.exeception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConstrainViolation {
    private String fieldName;
    private String message;
    private String rejectedValue;
}
