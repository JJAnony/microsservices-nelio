package br.com.microcervicosnelioalves.hrpayroll.services;

import br.com.microcervicosnelioalves.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WorkerService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Worker getWorker(long workerId) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", Long.toString(workerId));
        return restTemplate.getForObject(workerHost+ "/worker/{id}", Worker.class, uriVariables);
    }

}
