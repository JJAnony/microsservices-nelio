package br.com.microcervicosnelioalves.hrpayroll.services;

import br.com.microcervicosnelioalves.hrpayroll.clients.WorkerClient;
import br.com.microcervicosnelioalves.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private WorkerClient client;

    public Worker getWorker(long workerId) {
        return client.findById(workerId).getBody();
    }

}
