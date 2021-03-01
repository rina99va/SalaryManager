package com.salary.manager.controllers.model.statistic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatisticUniqueResponse {
    private int amountOfUniqueNames;
    private int amountOfUniqueTitles;
}
