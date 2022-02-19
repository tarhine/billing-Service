package org.sid.billingservice;
import org.sid.billingservice.feign.CustomerRestClient;
import org.sid.billingservice.feign.ProductItemsRestClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients  //c pour activer Feign client : c oblige
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(
            BillRepository billRepository,                      // ajouter des facture ;
            ProductItemRepository productItemRepository,       //ajouter des Products Items;
            CustomerRestClient customerRestClient,             // j'ai besoin de communiquer avec micro-service ....
            ProductItemsRestClient productItemsRestClient      // ... qui retourne les infos sur le client
            ){
        return args -> {
            Customer customer=customerRestClient.getCustomerById(1L);
            System.out.println("----------------------");
            System.out.println(customer.getId());
            System.out.println(customer.getName());
            System.out.println(customer.getEmail());

        };
    }
}
