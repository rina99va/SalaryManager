package com.salary.manager.service;

import com.salary.manager.domain.repository.UnitRepository;
import com.salary.manager.exceptions.UnitNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    @Autowired
    private UnitRepository unitRepository;

    public int getSalary(final String id) throws UnitNotFoundException {
        return unitRepository.findById(id).orElseThrow(() -> new UnitNotFoundException(id)).getSalary();
    }
}
