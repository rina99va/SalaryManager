package com.salary.manager.controllers.model.salary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SalaryResponse {
    private int salary;
    private String id;
    private String period;
}
