package br.ifg.urutai.usercase.port;

public interface IdGenerator {
    public default String generate(){
        return "string";
    }
}
