package br.ifg.urutai.usercase;


import br.ifg.urutai.entity.User;
import br.ifg.urutai.usercase.port.IdGenerator;
import br.ifg.urutai.usercase.port.PasswordEncoder;
import br.ifg.urutai.usercase.port.UserAlreadyExistsException;
import br.ifg.urutai.usercase.port.UserRepository;
import br.ifg.urutai.usercase.validator.UserValidator;
import br.ifg.urutai.usercase.validator.UserValidatorException;

public final class CreateUser {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;

    public CreateUser(final UserRepository repository, final PasswordEncoder passwordEncoder, final IdGenerator idGenerator) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.idGenerator = idGenerator;
    }

    public User create(final User user) throws UserValidatorException, UserAlreadyExistsException {
        UserValidator.validateCreateUser(user);
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(user.getEmail());
        }

        User userToSave = User.builder()
                .id(idGenerator.generate())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();

        return repository.create(userToSave);
    }
}