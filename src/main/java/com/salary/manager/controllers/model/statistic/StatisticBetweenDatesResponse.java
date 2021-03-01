package com.salary.manager.controllers.model.statistic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatisticBetweenDatesResponse {
    private int amountOfUnitsBetweenDates;
    private String firstData;
    private String secondData;
    private List<String> id;
}
