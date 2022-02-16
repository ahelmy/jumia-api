package jumia.jumiatask.service.impl;

import jumia.jumiatask.dto.Customer;
import jumia.jumiatask.mapper.CustomerMapper;
import jumia.jumiatask.repo.CustomerRepository;
import jumia.jumiatask.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<Customer> findAllCustomers(final String countryName, final Boolean isValid) {
        final var customers = customerMapper.fromEntities(customerRepository.findAll());
        return customers.stream().filter(c -> (!StringUtils.hasLength(countryName) || c.getCountryName().equals(countryName))
                && (isValid == null || c.isValid() == isValid)).collect(Collectors.toList());
    }
}
