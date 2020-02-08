package com.example.demo.web;

import com.example.demo.domain.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{userID}")
    public String display(@PathVariable int userID) {
        return "User Found: " + userID;
    }

    @RequestMapping("/{userID}/invoices")
    public String displayInvoices(@PathVariable int userID,
                                  @RequestParam(value = "date", required = false) Date dateOrNull) {
        return "invoice found : " + userID + " on the date " + dateOrNull;
    }

    @RequestMapping("/{userID}/products_as_json")
    public List<Product> displayList() {
        return Arrays.asList(new Product(1, "shoes", 42.99),
                new Product(2, "laptops", 1299.98));
    }

}
