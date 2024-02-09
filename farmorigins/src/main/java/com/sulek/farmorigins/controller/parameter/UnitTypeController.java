package com.sulek.farmorigins.controller.parameter;

import com.sulek.farmorigins.dto.UnitTypeDto;
import com.sulek.farmorigins.entity.parameter.UnitType;
import com.sulek.farmorigins.service.parameter.UnitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/parameter")
@RestController
@CrossOrigin
public class UnitTypeController {

    @Autowired
    private UnitTypeService unitTypeService;

    @RequestMapping(value = "/unit-type-list", method = RequestMethod.GET)
    public ResponseEntity<List<UnitTypeDto>> getAllUnitTypes() throws AuthenticationException {
        return ResponseEntity.ok(unitTypeService.getAllUnitTypes());
    }
}
