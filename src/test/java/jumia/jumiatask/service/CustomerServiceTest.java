package jumia.jumiatask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testFindAllCustomers(){
        final var customers = customerService.findAllCustomers(null, null);
        Assertions.assertEquals(41, customers.size());
    }

    @Test
    public void testFindAllCustomers_NotValid(){
        final var customers = customerService.findAllCustomers(null, false);
        Assertions.assertEquals(21, customers.size());
    }

    @Test
    public void testFindAllCustomers_Code_Morocco_212_And_Valid(){
        final var customers = customerService.findAllCustomers("Morocco", true);
        Assertions.assertEquals(0, customers.size());
    }

    @Test
    public void testFindAllCustomers_Code_Morocco_212_And_NotValid(){
        final var customers = customerService.findAllCustomers("Morocco", false);
        Assertions.assertEquals(7, customers.size());
    }

    @Test
    public void testFindAllCustomers_Code_Cameroon_237_And_Valid(){
        final var customers = customerService.findAllCustomers("Cameroon", true);
        Assertions.assertEquals(7, customers.size());
    }

    @Test
    public void testFindAllCustomers_Code_Cameroon_237_And_NotValid(){
        final var customers = customerService.findAllCustomers("Cameroon", false);
        Assertions.assertEquals(3, customers.size());
    }
}
