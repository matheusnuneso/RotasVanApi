package com.RotasVanApi.repositories;

import com.RotasVanApi.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByEmail(String email);

    Optional<UserModel> findByEmail(String email);

    List<UserModel> findByRoleAndIdVan(String role, Long idVan);
}
