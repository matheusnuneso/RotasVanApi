package com.RotasVanApi.services;

import com.RotasVanApi.dto.UserDto;
import com.RotasVanApi.models.GerenPresenModel;
import com.RotasVanApi.models.UserModel;
import com.RotasVanApi.repositories.GerenPresenRepository;
import com.RotasVanApi.repositories.UserRepository;
import com.RotasVanApi.utils.Utils;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GerenPresenService {

    final GerenPresenRepository gerenPresenRepository;
    final UserRepository userRepository;

    public GerenPresenService(GerenPresenRepository gerenPresenRepository, UserRepository userRepository) {
        this.gerenPresenRepository = gerenPresenRepository;
        this.userRepository = userRepository;
    }

    public Object save(GerenPresenModel gerenPresenModel){
        return gerenPresenRepository.save(gerenPresenModel);
    }

    public List<UserDto> findAlunosPresentes(String data){
        List<GerenPresenModel> listaNPresenca = gerenPresenRepository.findByDataNPresenca(Utils.stringToDate(data));
        List<UserModel> listaAlunos = userRepository.findByRole("ALUNO");

        if (!listaNPresenca.isEmpty()){
            for(GerenPresenModel gm : listaNPresenca){

                Optional<UserModel> userModelOptional = userRepository.findById(gm.getIdAluno());
                userModelOptional.ifPresent(listaAlunos::remove);

            }
        }

        return Utils.copyUserListModelToDto(listaAlunos);
    }

}
