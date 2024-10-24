package br.ifg.urutai.config;

import br.ifg.urutai.encoder.Sha256PasswordEncoder;
import br.ifg.urutai.idgenerator.JugIdGenerator;
import br.ifg.urutai.repository.InMemoryUserRepository;
import br.ifg.urutai.usercase.LoginUser;
import br.ifg.urutai.usercase.port.*;

public class ManualConfig {
    private final UserRepository userRepository = new InMemoryUserRepository();
    private final IdGenerator idGenerator = new JugIdGenerator();
    private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();


    public CreateUser createUser() {
        return new CreateUser(userRepository, passwordEncoder, idGenerator);
    }

    public FindUser findUser() {
        return new FindUser(userRepository);
    }

    public LoginUser loginUser() {
        return new LoginUser(userRepository, passwordEncoder);
    }
}
