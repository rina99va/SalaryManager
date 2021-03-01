package com.salary.manager.controllers;

import com.salary.manager.controllers.model.salary.SalaryResponse;
import com.salary.manager.domain.repository.UnitRepository;
import com.salary.manager.exceptions.UnitNotFoundException;
import com.salary.manager.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping(value = "/month/getSalaryByUnitId")
    public SalaryResponse getMonthSalary(@RequestParam(name = "id") final String id) {
        return new SalaryResponse(salaryService.getSalary(id) * 30, id, "MONTH");
    }

    @GetMapping(value = "/year/getSalaryByUnitId")
    public SalaryResponse getYearSalary(@RequestParam(name = "id") final String id) {
        return new SalaryResponse(salaryService.getSalary(id) * 365, id, "YEAR");
    }
}
