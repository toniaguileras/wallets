package es.project.tony.wallets.controller;

import es.project.tony.wallets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/user")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping()
    public ResponseEntity<?> getUsers(){
        return  ResponseEntity.ok(userService.getUsers());
    }

}
