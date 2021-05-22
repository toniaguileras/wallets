package es.project.tony.wallets.service;

import es.project.tony.wallets.WalletsApplication;
import es.project.tony.wallets.model.User;
import es.project.tony.wallets.model.dto.UserDTO;
import es.project.tony.wallets.repository.UserDao;
import es.project.tony.wallets.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceImplTests {

    private UserService userServiceMock;
    private UserDao userDao;


    @Test
    public void getUsersOk() {
        userDao = mock(UserDao.class);
        userServiceMock = new UserServiceImpl(userDao);
        when(userDao.findAll()).thenReturn(getUserList());
        List<UserDTO> resultList = userServiceMock.getUsers();
        assertNotNull(resultList);
        assertEquals("toni_aguilera", resultList.get(0).getUsername());
    }

    private List<User> getUserList() {
        User user = new User();
        user.setEmail("toniaguilera@gmail.com");
        user.setUsername("toni_aguilera");
        user.setName("Toni");
        user.setSurname("Aguilera");
        user.setWallets(new ArrayList<>());

        User user2 = new User();
        user2.setEmail("toniaguilera@gmail.com");
        user2.setUsername("toni_aguilera");
        user2.setName("Toni");
        user2.setSurname("Aguilera");
        user2.setWallets(new ArrayList<>());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        return userList;
    }
}
