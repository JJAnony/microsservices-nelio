package br.com.microcervicosnelioalves.hrpayroll.resources;

import br.com.microcervicosnelioalves.hrpayroll.entities.Payment;
import br.com.microcervicosnelioalves.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentResource {

    @Autowired
    private PaymentService service;


    @GetMapping(value = "/{workerId}/days/{days}")
    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = service.getPayment(workerId, days);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
        Payment payment = new Payment("braann",400.0, days);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }


}
