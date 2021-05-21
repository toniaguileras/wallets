package es.project.tony.wallets.repository;

import es.project.tony.wallets.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    @Autowired private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
