package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
//  http://localhost:8080/customer

    final CustomerService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public  void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @GetMapping("/get_all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Customer> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable Integer id){
        service.deleteCustomer(id);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer){
        service.updateCustomer(customer);

    }

    @GetMapping("/search-byid/{id}")
    public Customer searchCustomer(@PathVariable Integer id){
       return service.searchCustomer(id);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Customer>searchByName(@PathVariable String name){
        return service.searchByName(name);
    }

    @GetMapping("/search-by-address/{address}")
    public List<Customer>searchByAddress(@PathVariable String address){
        return service.searchByAddress(address);
    }

    @GetMapping("/search-by-salary/{salary}")
    public List<Customer>searchBySalary(@PathVariable Double salary){
        return service.searchBySalary(salary);
    }


}
