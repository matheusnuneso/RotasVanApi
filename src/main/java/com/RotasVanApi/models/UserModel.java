package com.RotasVanApi.models;

import com.RotasVanApi.enums.RoleUser;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Table(name = "TB_USER")
@Entity
@Data
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String ruaEndereco;

    @Column(nullable = false)
    private Integer numEndereco;

    @Column(nullable = false)
    private String bairroEndereco;

    @Column(nullable = false)
    private RoleUser role;

}
