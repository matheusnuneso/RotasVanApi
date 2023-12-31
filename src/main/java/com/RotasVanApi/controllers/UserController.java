package com.RotasVanApi.controllers;

import com.RotasVanApi.dto.AuthUserDto;
import com.RotasVanApi.dto.UserDto;
import com.RotasVanApi.enums.RoleUser;
import com.RotasVanApi.models.UserModel;
import com.RotasVanApi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){

        if (userService.existsByEmail(userDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já está em uso");
        }

        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);

        userModel.setSenha("123456");

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") Long id){
        Optional<UserModel> userModelOptional = userService.findById(id);

        if (userModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<UserModel>> getUserAluno(){
        List<UserModel> userList = userService.findByRole(RoleUser.ALUNO.toString());

        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id){
        Optional<UserModel> userModelOptional = userService.findById(id);

        if (userModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        userService.delete(userModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> authUser(@RequestBody @Valid AuthUserDto authUserDto){
        Optional<UserModel> userModelOp = userService.findByEmail(authUserDto.getEmail());

        if (userModelOp.isPresent()){

            UserModel userModel = userModelOp.get();
            if (userModel.getSenha().equals(authUserDto.getSenha())){
                return ResponseEntity.status(HttpStatus.OK).body(userModel);

            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuário ou senha incorretos");
            }

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }


}
