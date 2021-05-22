package es.project.tony.wallets.service;

import es.project.tony.wallets.model.dto.UserDTO;
import es.project.tony.wallets.repository.UserDao;
import es.project.tony.wallets.repository.UserRepository;
import es.project.tony.wallets.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
     private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserDTO> getUsers() {
        return UserMapper.mapToUserDTOList(userDao.findAll());
    }
}
