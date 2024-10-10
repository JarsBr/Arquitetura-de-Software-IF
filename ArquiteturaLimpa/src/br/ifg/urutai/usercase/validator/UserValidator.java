package br.ifg.urutai.usercase.validator;

import br.ifg.urutai.entity.User;

public class UserValidator {
    public static void validateCreateUser(User user) throws UserValidatorException {
         if (user == null ) throw new UserValidatorException("User should not be null");
         if (user.getEmail() == null) throw new UserValidatorException("Email should not be null");
        if (user.getFirstName() == null) throw new UserValidatorException("FirstName should not be null");
        if (user.getLastName() == null) throw new UserValidatorException("LastName should not be null");
    }
}
