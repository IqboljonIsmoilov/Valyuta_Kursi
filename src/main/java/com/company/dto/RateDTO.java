package com.company.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RateDTO {

    private Integer id;
    private String Code;
    private String CcyNm_UZ;
    private Double Rate;
    private String Date;
}
