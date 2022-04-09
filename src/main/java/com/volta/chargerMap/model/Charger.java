package com.volta.chargerMap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("CHARGER")
public class Charger {
    @Id
    private String id;
    
    private String chargerName;
    private float latitude;    
    private float longitude;
    private int power;
}
