package com.RotasVanApi.controllers;

import com.RotasVanApi.dto.GerenPresenDto;
import com.RotasVanApi.dto.UserDto;
import com.RotasVanApi.models.GerenPresenModel;
import com.RotasVanApi.models.UserModel;
import com.RotasVanApi.services.GerenPresenService;
import com.RotasVanApi.utils.Utils;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
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

        gerenPresenModel.setIdAluno(gerenPresenDto.getIdAluno());
        gerenPresenModel.setDataNPresenca(Utils.stringToDate(gerenPresenDto.getDataNPresenca()));

        return ResponseEntity.status(HttpStatus.CREATED).body(gerenPresenService.save(gerenPresenModel));
    }

    @GetMapping("/van/{idVan}/{data}")
    public ResponseEntity<Object> getAlunosPresentes(@PathVariable(value = "idVan") Long idVan, @PathVariable(value = "data") String data){

        try {
            List<UserDto> userDtoList = gerenPresenService.findAlunosPresentes(idVan, data);
            return ResponseEntity.status(HttpStatus.OK).body(userDtoList);
        } catch (DateTimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data informada inválida!");
        }

    }
}
