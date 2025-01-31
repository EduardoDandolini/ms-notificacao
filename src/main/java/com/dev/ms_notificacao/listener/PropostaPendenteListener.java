package com.dev.ms_notificacao.listener;

import com.dev.ms_notificacao.constant.Mensagem;
import com.dev.ms_notificacao.domain.Proposta;
import com.dev.ms_notificacao.service.NotificacaoSnsService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PropostaPendenteListener {

    private final NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendente(Proposta proposta) {
        String menesagem = String.format(Mensagem.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacaoSnsService.notificar(menesagem, proposta.getUsuario().getTelefone());
    }
}
