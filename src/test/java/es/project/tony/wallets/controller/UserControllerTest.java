package es.project.tony.wallets.controller;

import es.project.tony.wallets.model.User;
import es.project.tony.wallets.model.dto.UserDTO;
import es.project.tony.wallets.repository.UserDao;
import es.project.tony.wallets.service.UserService;
import es.project.tony.wallets.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class UserControllerTest {

  @Mock  private UserService userService;

  @Before
  public void initMocks() throws Exception {
    MockitoAnnotations.openMocks(this);
  }
  @Test
  public void getUsersOk() {
    UserController userController = new UserController(userService);
    ResponseEntity responseEntity = userController.getUsers();
    assertEquals("200 OK", responseEntity.getStatusCode().toString());
  }

  @Test
  public void findUserByIdOk() {
    UserController userController = new UserController(userService);
    ResponseEntity responseEntity = userController.findUserById(1);
    assertEquals("200 OK", responseEntity.getStatusCode().toString());

  }
  @Test
  public void findUserByIdNotExistingUser() {
    UserController userController = new UserController(userService);
    ResponseEntity responseEntity = userController.findUserById(null);
    assertEquals("200 OK", responseEntity.getStatusCode().toString());
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

  private List<UserDTO> getUserListDTO() {
    UserDTO user = new UserDTO();
    user.setEmail("toniaguilera@gmail.com");
    user.setUsername("toni_aguilera");
    user.setName("Toni");
    user.setSurname("Aguilera");


    UserDTO user2 = new UserDTO();
    user2.setEmail("toniaguilera@gmail.com");
    user2.setUsername("toni_aguilera");
    user2.setName("Toni");
    user2.setSurname("Aguilera");

    List<UserDTO> userList = new ArrayList<>();
    userList.add(user);
    userList.add(user2);
    return userList;
  }
}
