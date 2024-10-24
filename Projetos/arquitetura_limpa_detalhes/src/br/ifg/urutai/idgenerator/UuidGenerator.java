package br.ifg.urutai.idgenerator;

import br.ifg.urutai.usercase.port.IdGenerator;

import java.util.UUID;

public class UuidGenerator implements IdGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
