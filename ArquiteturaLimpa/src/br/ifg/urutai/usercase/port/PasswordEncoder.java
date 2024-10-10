package br.ifg.urutai.usercase.port;

public interface PasswordEncoder {
    public default String encoder(String str){
        return str;
    }
}
