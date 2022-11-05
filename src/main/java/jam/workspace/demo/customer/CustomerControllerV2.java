package jam.workspace.demo.customer;

import jam.workspace.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customers/")
public class CustomerControllerV2 {

    private final CustomerService customerService;

    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> customer(){
        return customerService.getCustomers();
    };

    @GetMapping(value = "{customerId}")
    Customer getCustomerById(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }
    @GetMapping(value = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException("ApiRequestException was thrown for customer with ida " + id);
    }

    @PostMapping
    void createCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Created customer: ");
        System.out.println(customer);
    }
    @PutMapping
     void updateCustomer(@Valid @RequestBody Customer customer) {
         System.out.println("Updating customer: ");
         System.out.println(customer);
     }

     @DeleteMapping("{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("Deleting customer: ");
        System.out.println("Customer id is " + id);
    }
}
