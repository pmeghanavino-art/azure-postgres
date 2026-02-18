package in.azure.azure.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    public UserService userService;

    @GetMapping("/get")
    public ResponseEntity<List<UserDTO>> getUsers()
    {
         return  ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> createUser(@RequestBody  UserDTO userDTO)
    {
        return  ResponseEntity.ok(userService.createUser(userDTO ));
    }
}
