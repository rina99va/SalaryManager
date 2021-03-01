package com.salary.manager.controllers.model.unit;

import com.salary.manager.domain.model.UnitModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnitResponse {
    private String name;
    private String title;
    private String id;
    private int salary;

    public static UnitResponse toResponse(final UnitModel unitModel) {
        return new UnitResponse(unitModel.getName(), unitModel.getTitle(), unitModel.getId(), unitModel.getSalary());
    }
}
