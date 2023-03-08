package com.deviget.models.mars;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Camera {
    private int id;
    private String name;
    private int rover_id;
    private String full_name;
}
