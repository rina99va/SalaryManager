package com.salary.manager.controllers.model.unit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnitRequest {
    private String name;
    private String title;
    private int salary;
}
