package edu.icet.service.impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository repository;
    final ModelMapper mapper;
    @Override
    public void addCustomer(Customer customer) {

        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public List<Customer> getAll() {

        ArrayList<Customer> customerList = new ArrayList<>();
        List<CustomerEntity> all = repository.findAll();

        all.forEach(customerEntity -> {
           customerList.add(mapper.map(customerEntity,Customer.class));
        });
        return customerList;
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.save(mapper.map(customer,CustomerEntity.class));
    }

    @Override
    public Customer searchCustomer(Integer id) {
        return mapper.map(repository.findById(id),Customer.class);
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<CustomerEntity> byName = repository.findByName(name);
        List<Customer> customerList = new ArrayList<>();

        byName.forEach(customerEntity -> {

            customerList.add(mapper.map(customerEntity,Customer.class));

        });
        return customerList;
    }

    @Override
    public List<Customer> searchByAddress(String address) {
        List<CustomerEntity> byAddress = repository.findByAddress(address);
        List<Customer> customerList = new ArrayList<>();

        byAddress.forEach(customerEntity -> {

            customerList.add(mapper.map(customerEntity,Customer.class));

        });
        return customerList;
    }

    @Override
    public List<Customer> searchBySalary(Double salary) {
        List<CustomerEntity> bySalary = repository.findBySalary(salary);
        List<Customer> customerList = new ArrayList<>();

        bySalary.forEach(customerEntity -> {

            customerList.add(mapper.map(customerEntity,Customer.class));

        });
        return customerList;
    }
}
