package br.ifg.urutai.usercase;

import br.ifg.urutai.entity.User;
import br.ifg.urutai.usercase.port.NotAllowedException;
import br.ifg.urutai.usercase.port.PasswordEncoder;
import br.ifg.urutai.usercase.port.UserRepository;

public final class LoginUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginUser(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void login(final String email, final String password) throws NotAllowedException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotAllowedException("Not allowed"));
        String hashedPassword = passwordEncoder.encode(email + password);
        if (!user.getPassword().equals(hashedPassword)) throw new NotAllowedException("Not allowed");
    }
}