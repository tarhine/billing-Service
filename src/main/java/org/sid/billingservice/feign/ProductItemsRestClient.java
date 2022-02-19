package org.sid.billingservice.feign;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductItemsRestClient {
    //je veux recuperer la liste de tous les produits
    //PageModel : grace a la depandence Hateoas
    //je vais recuperer une page qui contient des Products
    @GetMapping(path = "/products")
    PagedModel<Product> pageProducts();
    //recuperer un produit sachant son id
    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable Long id);

}
