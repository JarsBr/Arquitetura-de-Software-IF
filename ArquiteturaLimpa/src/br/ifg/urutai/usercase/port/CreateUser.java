package br.ifg.urutai.usercase.port;

import br.ifg.urutai.entity.User;
import br.ifg.urutai.usercase.validator.UserValidator;
import br.ifg.urutai.usercase.validator.UserValidatorException;

public final class CreateUser {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;

    public CreateUser(final UserRepository repository, final PasswordEncoder passwordEncoder, final IdGenerator idGenerator, UserRepository repository1, PasswordEncoder passwordEncoder1, IdGenerator idGenerator1){
        this.repository = repository1;
        this.passwordEncoder = passwordEncoder1;
        this.idGenerator = idGenerator1;
    }

    public User create(final User user) throws UserAlreadyExistsException, UserValidatorException {
        UserValidator.validateCreateUser(user);
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(user.getEmail());
        }
        User userToSave = User.builder()
                .id(idGenerator.generate())
                .email(user.getEmail())
                .password(passwordEncoder.encoder(user.getEmail() + user.getPassword()))
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
        return repository.create(userToSave);
    }
}
