package br.com.andealmeida.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class KafkaConsumer {

    private static final Logger LOG = Logger.getLogger(KafkaConsumer.class);

    @Incoming("consumer")
    public void receberMensagem(String mensagem) {
         LOG.infof("Mensagem recebida: %s no consumer", mensagem);
        // Adicione o código para processar a mensagem conforme necessário.
    }

}
