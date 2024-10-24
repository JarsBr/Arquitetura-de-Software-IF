package br.ifg.urutai.usercase.port;


import br.ifg.urutai.entity.User;

public class LoginUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginUser(final UserRepository userRepository, final PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(String email, String password, String name) throws NotAllowedException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotAllowedException("Not allowed"));
        String hashedPassword = passwordEncoder.encode(email + password);
        if (!user.getPassword().equals(hashedPassword)) throw  new NotAllowedException("Not allowed");
        return user;
    }
}
