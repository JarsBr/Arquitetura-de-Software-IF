package br.ifg.urutai.idgenerator;

import br.ifg.urutai.usercase.port.IdGenerator;
import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

public class JugIdGenerator implements IdGenerator {
    @Override
    public String generate() {
        return generator().generate().toString().replaceAll("-", "");
    }

    private static NoArgGenerator generator() {
        return Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    }
}
