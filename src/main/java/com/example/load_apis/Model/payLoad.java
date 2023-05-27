package com.example.load_apis.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="payLoad")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class payLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loadId;

    private String loadingPoint;

    private String unloadingPoint;

    private String productType;
    private String truckType;

    private int noOfTrucks;

    private int weight;

    private String comment;

    @CreationTimestamp
    private LocalDate date;

    private String shipperId;


}
