package com.salary.manager.service;

import com.salary.manager.domain.model.UnitModel;
import com.salary.manager.domain.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StatisticService {
    @Autowired
    private UnitRepository unitRepository;

    public Set<String> getUniqueNames() {
        final Set<String> uniqueNames = new HashSet<>();
        for (final UnitModel unitModel : unitRepository.findAll()) {
            uniqueNames.add(unitModel.getName());
        }
        return uniqueNames;
    }

    public Set<String> getUniqueTitles() {
        final Set<String> uniqueTitles = new HashSet<>();
        for (final UnitModel unitModel : unitRepository.findAll()) {
            uniqueTitles.add(unitModel.getTitle());
        }
        return uniqueTitles;
    }

    public List<UnitModel> getUnitModelsBetweenDates(final String firstDate, final String secondDate) {
        final List<UnitModel> unitModelsBetweenDates = new ArrayList<>();
        final LocalDate parseFirstData = LocalDate.parse(firstDate);
        final LocalDate parseSecondData = LocalDate.parse(secondDate);

        for (final UnitModel unitModel : unitRepository.findAll()) {
            final LocalDate modelDate = LocalDateTime.parse(unitModel.getTimestamp()).toLocalDate();
            if ((modelDate.isBefore(parseSecondData) && modelDate.isAfter(parseFirstData) || (modelDate.isEqual(parseFirstData)) || (modelDate.isEqual(parseSecondData)))) {
                unitModelsBetweenDates.add(unitModel);
            }
        }
        return unitModelsBetweenDates;
    }
}
