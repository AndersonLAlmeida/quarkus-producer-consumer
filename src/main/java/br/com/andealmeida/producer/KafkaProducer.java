package br.com.andealmeida.producer;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

@Path("/kafka-producer")
public class KafkaProducer {

    private static final Logger LOG = Logger.getLogger(KafkaProducer.class);


    @Inject
    @Channel("producer")
    Emitter<String> emitter;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String sendMessage(@QueryParam("mensagem") String mensagem) {
        LOG.infof("Mensagem recebida: %s", mensagem);
        emitter.send(mensagem);
        LOG.info("Mensagem enviada com sucesso para o Kafka");
        return "Mensagem enviada com sucesso para o Kafka: " + mensagem;
    }

}
