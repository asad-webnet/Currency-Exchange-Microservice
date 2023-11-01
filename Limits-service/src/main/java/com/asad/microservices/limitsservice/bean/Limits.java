package com.asad.microservices.limitsservice.bean;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Limits {
    private int minimum;
    private int maximum;


}
