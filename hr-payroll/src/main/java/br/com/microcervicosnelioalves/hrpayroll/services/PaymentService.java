package br.com.microcervicosnelioalves.hrpayroll.services;

import br.com.microcervicosnelioalves.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("Bob", 200.0, days);
    }
}
