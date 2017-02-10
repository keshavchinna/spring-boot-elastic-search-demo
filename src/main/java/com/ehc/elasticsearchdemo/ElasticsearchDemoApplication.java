package com.ehc.elasticsearchdemo;

import com.ehc.elasticsearchdemo.model.Customer;
import com.ehc.elasticsearchdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
@ComponentScan
public class ElasticsearchDemoApplication implements CommandLineRunner {
  @Autowired
  private CustomerRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(ElasticsearchDemoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    saveCustomers();
//    fetchAllCustomers();
//    fetchIndividualCustomers();
    findCustomersNearBy();
  }


  private void findCustomersNearBy() {
    System.out.println("near by");
    System.out.println(this.repository.findByLocationNear("17.4394519,78.3937436", new PageRequest(0, 10)).getContent());
  }

  private void saveCustomers() {
    this.repository.save(new Customer(1, "Alice", "Smith", "17.441458,78.3963023"));
    this.repository.save(new Customer(2, "Bob", "Smith", "17.4389298,78.39568"));
    this.repository.save(new Customer(3, "Boss", "Smith", "17.4286303,78.4154022"));
  }

  private void fetchAllCustomers() {
    System.out.println("Customers found with findAll():");
    System.out.println("-------------------------------");
    for (Customer customer : this.repository.findAll()) {
      System.out.println(customer);
    }
    System.out.println();
  }

  private void fetchIndividualCustomers() {
    System.out.println("Customer found with findByFirstName('Alice'):");
    System.out.println("--------------------------------");
    System.out.println(this.repository.findByFirstName("Alice"));

    System.out.println("Customers found with findByLastName('Smith'):");
    System.out.println("--------------------------------");
    for (Customer customer : this.repository.findByLastName("Smith")) {
      System.out.println(customer);
    }
  }
}
