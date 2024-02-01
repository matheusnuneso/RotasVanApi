package com.RotasVanApi.repositories;

import com.RotasVanApi.models.GerenPresenModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GerenPresenRepository extends JpaRepository<GerenPresenModel, Long> {

    List<GerenPresenModel> findByDataNPresenca(LocalDate dataNPresenca);
}
