package com.salary.manager.service;

import com.salary.manager.controllers.model.unit.UnitRequest;
import com.salary.manager.controllers.model.unit.UnitResponse;
import com.salary.manager.domain.model.UnitModel;
import com.salary.manager.domain.repository.UnitRepository;
import com.salary.manager.exceptions.UnitNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public List<UnitResponse> getAllUnits() {
        final List<UnitResponse> unitResponses = new ArrayList<UnitResponse>();
        final Iterable<UnitModel> all = unitRepository.findAll();
        for (final UnitModel unitModel : all) {
            unitResponses.add(UnitResponse.toResponse(unitModel));
        }
        return unitResponses;
    }


    public void createUnit(final String name, final String title, int salary) {
        final UnitModel unitModel = new UnitModel(UUID.randomUUID().toString(), name, title, LocalDateTime.now().toString(), salary);
        if (unitRepository.findByName(name).isEmpty()) {
            unitRepository.save(unitModel);
        }
    }

    public void removeUnit(final String id) {
        unitRepository.deleteById(id);
    }

    public UnitResponse readById(final String id) {
        return UnitResponse.toResponse(unitRepository.findById(id).orElseThrow(() -> new UnitNotFoundException(id)));
    }

    public void update(final String id, final UnitRequest unitRequest) {
        final Optional<UnitModel> byId = unitRepository.findById(id);
        if (byId.isEmpty()) {
            throw new UnitNotFoundException(id);
        } else {
            final UnitModel fromRepository = byId.get();
            fromRepository.setName(unitRequest.getName());
            fromRepository.setTitle(unitRequest.getTitle());
            fromRepository.setSalary(unitRequest.getSalary());
            unitRepository.save(fromRepository);
        }
    }
}
