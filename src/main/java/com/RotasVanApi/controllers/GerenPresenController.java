package com.RotasVanApi.controllers;

import com.RotasVanApi.dto.GerenPresenDto;
import com.RotasVanApi.models.GerenPresenModel;
import com.RotasVanApi.models.UserModel;
import com.RotasVanApi.services.GerenPresenService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/gerencia-presenca")
public class GerenPresenController {

    final GerenPresenService gerenPresenService;

    public GerenPresenController(GerenPresenService gerenPresenService) {
        this.gerenPresenService = gerenPresenService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid GerenPresenDto gerenPresenDto){
        GerenPresenModel gerenPresenModel = new GerenPresenModel();
        BeanUtils.copyProperties(gerenPresenDto, gerenPresenModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(gerenPresenService.save(gerenPresenModel));
    }

    @GetMapping("/{data}")
    public ResponseEntity<List<UserModel>> getAlunosPresentes(@PathVariable(value = "data") String data){
        String dataFormatada = data.replace("-", "/");
        return ResponseEntity.status(HttpStatus.OK).body(gerenPresenService.findAlunosPresentes(dataFormatada));
    }
}
