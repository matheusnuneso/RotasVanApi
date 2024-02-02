package com.RotasVanApi.services;

import com.RotasVanApi.models.VanModel;
import com.RotasVanApi.repositories.VanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VanService {

    final VanRepository vanRepository;

    public VanService(VanRepository vanRepository) {
        this.vanRepository = vanRepository;
    }

    public Object save(VanModel vanModel){
        return this.vanRepository.save(vanModel);
    }

    public void delete(VanModel vanModel){
        this.vanRepository.delete(vanModel);
    }

    public List<VanModel> findAll(){
        return this.vanRepository.findAll();
    }

    public Optional<VanModel> findById(Long id){
        return this.vanRepository.findById(id);
    }

    public boolean existById(Long id){
        return vanRepository.existsById(id);
    }
}
