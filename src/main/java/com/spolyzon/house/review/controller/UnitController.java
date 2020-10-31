package com.spolyzon.house.review.controller;

import com.spolyzon.house.review.domain.model.Unit;
import com.spolyzon.house.review.domain.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/units")
@RestController
public class UnitController {

    private final UnitRepository unitRepository;

    @Autowired
    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @GetMapping
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }
}
