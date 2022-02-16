package jumia.jumiatask.mapper;

import jumia.jumiatask.dto.Customer;
import jumia.jumiatask.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public Customer fromEntity(CustomerEntity customerEntity){
        return new Customer(customerEntity.getId(), customerEntity.getName(), customerEntity.getPhone());
    }

    public List<Customer> fromEntities(List<CustomerEntity> entities){
        return entities.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
