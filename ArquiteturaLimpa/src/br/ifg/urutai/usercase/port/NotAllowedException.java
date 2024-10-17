package br.ifg.urutai.usercase.port;

public class NotAllowedException extends Throwable {
    public NotAllowedException(String notAllowed) {
        super(notAllowed);
    }
}
