package in.azure.azure.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    public UsersRepo usersRepo;

    public List<UserDTO> getAllUsers() {

        List<Users> usersList = usersRepo.findAll();

        List<UserDTO> responseList = new ArrayList<>();

        for (Users user : usersList) {
            UserDTO dto = new UserDTO();


            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            dto.setAge(user.getAge());
            dto.setGender(user.getGender());

            responseList.add(dto);
        }

        return responseList;
    }


    public UserDTO createUser(UserDTO request) {

        Users user = new Users();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAge(request.getAge());
        user.setGender(request.getGender());

        Users savedUser = usersRepo.save(user);

        UserDTO dto = new UserDTO();
        dto.setFirstName(savedUser.getFirstName());
        dto.setLastName(savedUser.getLastName());
        dto.setAge(savedUser.getAge());
        dto.setGender(savedUser.getGender());

        return dto;
    }


}
