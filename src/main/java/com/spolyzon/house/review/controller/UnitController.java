package com.spolyzon.house.review.controller;

import com.spolyzon.house.review.domain.model.Unit;
import com.spolyzon.house.review.domain.repository.UnitRepository;
import com.spolyzon.house.review.dto.UnitDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/units")
@RestController
public class UnitController {
    public static final Logger LOGGER = LoggerFactory.getLogger(UnitController.class);

    private final UnitRepository unitRepository;

    @Autowired
    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @GetMapping
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable long id) {
        LOGGER.info("Retrieving unit by id {}", id);
        return unitRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Unit> createNewUnit(@RequestBody UnitDTO unitDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(unitRepository.save(unitDTO.getUnit()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable long id) {
        unitRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
