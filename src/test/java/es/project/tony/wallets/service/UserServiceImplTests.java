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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceImplTests {

    @InjectMocks
    private UserServiceImpl userServiceMock;

    @Mock private UserDao userDao;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userServiceMock = new UserServiceImpl();
    }

    @Test
    public void getUsersOk(){
        List<User> userList = getUserList();
        List<UserDTO> resultList = userServiceMock.getUsers();
        when(userDao.findAll()).thenReturn(userList);
        assertNotNull(resultList);
        assertEquals("toni_aguilera", resultList.get(0).getUsername());
    }

    private List<User> getUserList() {
        User user = new User();
        user.setEmail("toniaguilera@gmail.com");
        user.setUsername("toni_aguilera");
        user.setName("Toni");
        user.setSurname("Aguilera");

        User user2 = new User();
        user2.setEmail("toniaguilera@gmail.com");
        user2.setUsername("toni_aguilera");
        user2.setName("Toni");
        user2.setSurname("Aguilera");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        return userList;
    }
}
