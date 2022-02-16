package jumia.jumiatask.service;

import jumia.jumiatask.dto.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers(String countryCode, Boolean isValid);
}
