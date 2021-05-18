package es.project.tony.wallets.service;

import es.project.tony.wallets.model.dto.UserDTO;
import es.project.tony.wallets.repository.UserRepository;
import es.project.tony.wallets.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserRepository userRepository;

    @Override
    public List<UserDTO> getUsers() {
        return UserMapper.mapToUserDTOList(userRepository.findAll());
    }
}
