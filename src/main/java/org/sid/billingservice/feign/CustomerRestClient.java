package org.sid.billingservice.feign;


import org.sid.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//1. contient les noms du micros-service (tjr en majuscule, car il sont publie dans l'annuaire en majuscule)
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
//2.une methode qui consulte un Client = on lui donne Id et il retourne le Customer
   @GetMapping(path = "/customers/{id}")
     Customer getCustomerById(@PathVariable(name = "id") Long id);
}
