package jumia.jumiatask.controller;

import jumia.jumiatask.dto.Customer;
import jumia.jumiatask.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(value = "country", required = false) String country, @RequestParam(value="valid", required = false) Boolean valid){
        return ResponseEntity.ok(customerService.findAllCustomers(country,valid));
    }
}
