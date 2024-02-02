package com.RotasVanApi.repositories;

import com.RotasVanApi.models.VanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VanRepository extends JpaRepository<VanModel, Long> {
}
