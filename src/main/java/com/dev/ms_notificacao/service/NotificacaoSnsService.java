package com.dev.ms_notificacao.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.dev.ms_notificacao.config.AwsSnsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoSnsService {

    private final AmazonSNS amazonSNS;

    public void notificar(String mensagem, String telefone) {
        PublishRequest publishRequest = new PublishRequest().withMessage(mensagem).withPhoneNumber(telefone);
        amazonSNS.publish(publishRequest);
    }
}
