package com.ehc.elasticsearchdemo;

import com.ehc.elasticsearchdemo.model.Customer;
import com.ehc.elasticsearchdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
    saveCustomers();
    fetchAllCustomers();
    fetchIndividualCustomers();
  }

  private void saveCustomers() {
    this.repository.save(new Customer(1, "Alice", "Smith"));
    this.repository.save(new Customer(2, "Bob", "Smith"));
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
