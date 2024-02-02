package com.RotasVanApi.controllers;

import com.RotasVanApi.dto.VanDto;
import com.RotasVanApi.models.VanModel;
import com.RotasVanApi.services.VanService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/van")
public class VanController {

    final VanService vanService;

    public VanController(VanService vanService) {
        this.vanService = vanService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid VanDto vanDto){
        VanModel vanModel = new VanModel();
        BeanUtils.copyProperties(vanDto, vanModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.vanService.save(vanModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id){
        Optional<VanModel> vanModelOptional = vanService.findById(id);

        if (vanModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Van não encontrada");
        }

        vanService.delete(vanModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Van deletada com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<VanModel>> getAllVans(){
        List<VanModel> vanModelList = vanService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(vanModelList);
    }
}
