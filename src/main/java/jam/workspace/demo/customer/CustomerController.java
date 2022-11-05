package jam.workspace.demo.customer;

import jam.workspace.demo.SpringBootMasterClassApplication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers/")
@Deprecated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> customer(){
        return customerService.getCustomers();
    };

    @GetMapping(value = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomers().stream().filter(c -> c.getId().equals(id))
                .findFirst().orElseThrow(() -> new IllegalStateException("Customer with id " + id + " was not found"));
    }

    @PostMapping
    void createCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Created customer: ");
        System.out.println(customer);
    }
    @PutMapping
     void updateCustomer(@RequestBody Customer customer) {
         System.out.println("Updating customer: ");
         System.out.println(customer);
     }

     @DeleteMapping("{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("Deleting customer: ");
        System.out.println("Customer id is " + id);
    }
}
