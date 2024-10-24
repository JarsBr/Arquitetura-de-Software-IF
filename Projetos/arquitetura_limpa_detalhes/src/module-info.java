module arquitetura.limpa.detalhes {
    exports br.ifg.urutai.encoder;
    exports br.ifg.urutai.idgenerator;
    exports br.ifg.urutai.repository;
    requires com.fasterxml.uuid;
    requires arquitetura.limpa.dominio;
    requires org.apache.commons.codec;
}