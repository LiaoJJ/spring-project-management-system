package com.example.demo.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/expenses")
public class HelloController {

    @RequestMapping(value = "/form")
    public String helloController() {
        return "<form action=\"/expenses/submitted\" metohd=\"POST\">\n" +
                "  First name:<br>\n" +
                "  <input type=\"text\" name=\"firstname\">\n" +
                "  <br>\n" +
                "  Last name:<br>\n" +
                "  <input type=\"text\" name=\"lastname\">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }

    @RequestMapping(value = "/submitted", method = RequestMethod.GET)
    public String submitted(@RequestParam String firstname, @RequestParam String lastname) {
        return "submitted:" + firstname + " " + lastname;
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String getOrder(@PathVariable String id) {
        return "Order ID: " + id + " haha";
    }
}
