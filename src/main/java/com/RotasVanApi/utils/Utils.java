package com.RotasVanApi.utils;

import com.RotasVanApi.dto.UserDto;
import com.RotasVanApi.models.UserModel;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate stringToDate(String dataString){
        return LocalDate.parse(dataString, formatter);
    }

    public static String dateToString(LocalDate data){
        return data.format(formatter);
    }

    public static List<UserDto> copyUserListModelToDto(List<UserModel> userModelList){
        List<UserDto> userDtoList = new ArrayList<>();

        for (UserModel userModel : userModelList) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userModel, userDto);
            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    public static UserDto copyUserModelToDto(UserModel userModel){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userModel, userDto);
        return userDto;
    }

}
