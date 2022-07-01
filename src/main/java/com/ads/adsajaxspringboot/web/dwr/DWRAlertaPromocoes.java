package com.ads.adsajaxspringboot.web.dwr;

import com.ads.adsajaxspringboot.repository.PromocaoRepository;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

@Component
@RemoteProxy
public class DWRAlertaPromocoes {

    @Autowired
    private PromocaoRepository repository;

    private Timer timer;


    private LocalDateTime getDtCadastroByUltimaPromocao() {
        PageRequest pageRequest = PageRequest.of(0, 1, Sort.Direction.DESC, "dtCadastro");
        return repository.findUltimaDataDePromocao(pageRequest)
                .getContent().get(0);
    }

    @RemoteMethod
    public synchronized void init() {
        System.out.println("DWR está ativado!");

        LocalDateTime lastDate = getDtCadastroByUltimaPromocao();

        WebContext context = WebContextFactory.get();

        timer = new Timer();
        timer.schedule(new AlertTask(context, lastDate), 10000, 60000);
    }

    class AlertTask extends TimerTask {

        private LocalDateTime lastDate;
        private WebContext context;
        private long count;

        public AlertTask( WebContext context ,LocalDateTime lastDate) {
            super();
            this.lastDate = lastDate;
            this.context = context;
        }

        @Override
        public void run() {

        }
    }


}
