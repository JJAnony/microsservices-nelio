package br.com.microcervicosnelioalves.hrpayroll.services;

import br.com.microcervicosnelioalves.hrpayroll.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerService service;

    public Payment getPayment(long workerId, int days) {
        return new Payment(service.getWorker(workerId), days);
    }
}
