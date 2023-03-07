package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.PaymentInformation;
import com.JoysToysApplication.JoysToysApplication.Repository.PaymentInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class PaymentInformationController {

    @Autowired
    PaymentInformationRepository paymentInformationRepository;

    @GetMapping("/payment_information/{id}")
    public ResponseEntity<PaymentInformation> getPaymentInformation(@PathVariable("id")long id){
        Optional<PaymentInformation> paymentInformation =
                paymentInformationRepository.findById(id);

        /*
        This is what is going on with the return line:
        if(paymentInformation.isPresent()){
            return ResponseEntity.ok(paymentInformation.get());
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
         */
        return paymentInformation.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
