package es.project.tony.wallets.utils;

import es.project.tony.wallets.model.User;
import es.project.tony.wallets.model.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {


    public static List<UserDTO> mapToUserDTOList(List<User> userList) {
        List<UserDTO> resultList = new ArrayList<>();
        userList.forEach(user -> resultList.add(mapToUserDTO(user)));

        return resultList;
    }

    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setWallets(WalletMapper.mapToWalletDTOList(user.getWallets()));
        return userDTO;
    }

}
