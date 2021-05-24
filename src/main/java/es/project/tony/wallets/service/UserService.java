package es.project.tony.wallets.service;

import es.project.tony.wallets.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO findUserById(Integer userId);
}
