package com.deviget.models.mars;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Rover {
    private int id;
    private String name;
    private String landing_date;
    private String launch_date;
    private String status;
}
