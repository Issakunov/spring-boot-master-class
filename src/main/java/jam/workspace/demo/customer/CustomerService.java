package jam.workspace.demo.customer;

import jam.workspace.demo.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("customer with id " + id + " not found"));
    }

}
