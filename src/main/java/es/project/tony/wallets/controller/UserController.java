package es.project.tony.wallets.controller;

import es.project.tony.wallets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> getUsers() {
    return ResponseEntity.ok(userService.getUsers());
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public ResponseEntity<?> findUserById(@RequestParam Integer userId) {
    return ResponseEntity.ok(userService.findUserById(userId));
  }
}
