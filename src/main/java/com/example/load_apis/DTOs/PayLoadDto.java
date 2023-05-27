package com.example.load_apis.DTOs;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayLoadDto {
    private String loadingPoint;

    private String unloadingPoint;

    private String productType;
    private String truckType;

    private int noOfTrucks;

    private int weight;

    private String comment;

    private String shipperId;

}
