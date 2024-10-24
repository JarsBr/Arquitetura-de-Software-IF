package br.ifg.urutai.application;


import br.ifg.urutai.config.ManualConfig;
import br.ifg.urutai.entity.User;
import br.ifg.urutai.usercase.LoginUser;
import br.ifg.urutai.usercase.port.*;
import br.ifg.urutai.usercase.validator.UserValidatorException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws UserAlreadyExistsException, UserValidatorException, NotAllowedException {
        // Setup
        ManualConfig config = new ManualConfig();
        CreateUser createUser = config.createUser();
        FindUser findUser = config.findUser();
        LoginUser loginUser = config.loginUser();
        User user = User.builder()
                .email("jonh.doe@gmail.com")
                .password("mypassword")
                .lastName("doe")
                .firstName("jonh")
                .build();

        // Create a user
        User actualCreateUser = createUser.create(user);
        System.out.println("User created with id " + actualCreateUser.getId());

        // Find a user by id
        Optional<User> actualFindUser = findUser.findById(actualCreateUser.getId());
        System.out.println("Found user with id " + actualFindUser.get().getId());

        // List all users
        List<User> users = findUser.findAllUsers();
        System.out.println("List all users: " + users);

        // Login
        loginUser.login("jonh.doe@gmail.com", "mypassword");
        System.out.println("Allowed to login with email 'john.doe@gmail.com' and password 'mypassword'");

    }




}
