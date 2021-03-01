package com.salary.manager.controllers;

import com.salary.manager.controllers.model.statistic.StatisticBetweenDatesResponse;
import com.salary.manager.controllers.model.statistic.StatisticUniqueResponse;
import com.salary.manager.domain.model.UnitModel;
import com.salary.manager.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "statistic")
public class StatisticsController {
    @Value(value = "${statistic.info}")
    private String statisticInfo;

    @Autowired
    private StatisticService statisticService;

    @GetMapping(value = "/read")
    public StatisticUniqueResponse getStatistics() {
        Set<String> uniqueNames = statisticService.getUniqueNames();
        Set<String> uniqueTitles = statisticService.getUniqueTitles();
        return new StatisticUniqueResponse(uniqueNames.size(), uniqueTitles.size());
    }


    @GetMapping(value = "/readBetweenDates")
    public StatisticBetweenDatesResponse getUnitsBetweenDates(@RequestParam(name = "firstData") final String firstData, @RequestParam(name = "secondData") final String secondData) {
        final List<UnitModel> unitModelsBetweenDates = statisticService.getUnitModelsBetweenDates(firstData, secondData);
        return new StatisticBetweenDatesResponse(unitModelsBetweenDates.size(), firstData, secondData, unitModelsBetweenDates.stream().map(UnitModel::getId).collect(Collectors.toList()));
    }

}
