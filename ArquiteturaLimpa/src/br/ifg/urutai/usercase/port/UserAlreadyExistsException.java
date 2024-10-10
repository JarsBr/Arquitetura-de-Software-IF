package br.ifg.urutai.usercase.port;

public class UserAlreadyExistsException extends Throwable {
    public UserAlreadyExistsException(String email) {
    }
}
