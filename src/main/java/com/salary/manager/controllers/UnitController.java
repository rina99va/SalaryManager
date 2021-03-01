package com.salary.manager.controllers;

import com.salary.manager.controllers.model.unit.UnitRequest;
import com.salary.manager.controllers.model.unit.UnitResponse;
import com.salary.manager.exceptions.UnitNotFoundException;
import com.salary.manager.exceptions.UnitsNotFoundException;
import com.salary.manager.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping(value = "/readAll")
    public List<UnitResponse> getAllUnits() {
        final List<UnitResponse> allUnits = unitService.getAllUnits();
        if (allUnits.size() != 0) {
            return allUnits;
        } else {
            throw new UnitsNotFoundException();
        }
    }

    @GetMapping(value = "/read")
    public UnitResponse getUnit(@RequestParam(name = "id") final String id) {
        final UnitResponse unitResponse = unitService.readById(id);
        if (unitResponse != null) {
            return unitResponse;
        } else {
            throw new UnitNotFoundException(id);
        }
    }

    @PostMapping(value = "/create")
    public void createUnit(@RequestBody final UnitRequest unitRequest) {
        unitService.createUnit(unitRequest.getName(), unitRequest.getTitle(), unitRequest.getSalary());
    }

    @PutMapping(value = "/update")
    public void updateUnit(@RequestParam(name = "id") final String id, @RequestBody final UnitRequest unitRequest) {
        unitService.update(id, unitRequest);
    }

    @DeleteMapping(value = "/delete")
    public void deleteUnit(@RequestParam(name = "id") final String id) {
        unitService.removeUnit(id);
    }

}
