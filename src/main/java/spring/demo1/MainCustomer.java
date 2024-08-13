package spring.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo1.config.CustomerConfig;
import spring.demo1.entity.CustomerEntity;
import spring.demo1.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MainCustomer {
    static ApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);
    static CustomerRepository customerRepository = (CustomerRepository) context.getBean("customerRepository");

    //    public static void addCustomer() {
//        CustomerEntity customerEntity = new CustomerEntity();
//        customerEntity.setName("Hoa");
//        customerEntity.setBirthdate(LocalDate.parse("2024-08-14"));
//        customerEntity.setSex("Nam");
//        customerEntity.setEmail("ngaoop@gmail.com");
//        customerEntity.setPhone("09741325437");
//        customerEntity.setAddress("Binh Dinh");
//
//        CustomerEntity result = customerRepository.save(customerEntity);
//        if(result != null) {
//            System.out.println("Add customer saved successfully, customer ID = " + customerEntity.getId());
//        }
//    }
//    public static void allCustomer() {
//        List<CustomerEntity> customerEntityList = (List<CustomerEntity>) customerRepository.findAll();
//        System.out.println("Found " + customerEntityList.size() + "customer(s) in the table customer ");
//        System.out.println("They are: ");
//        for (CustomerEntity customer : customerEntityList) {
//            System.out.println(customer.toString());
//        }
//    }
//     public static void findById(int customerID) {
//         Optional<CustomerEntity> customerEntity = customerRepository.findById(customerID);
//         if (customerEntity != null) {
//            System.out.println("Found a customer with customer ID = " + customerID);
//            System.out.println(customerEntity.toString());
//        } else {
//            System.out.println("Not found any customer with book ID = " + customerID);
//        }
//     }
//    public static void main(String[] args) {
////        addCustomer();
////        allCustomer();
////        findById(2);
//    }
//    public static void main(String[] args) {
//        List<CustomerEntity> customerEntityList = customerRepository.findByName("Hoa");
//        if (customerEntityList.size() != 0) {
//            System.out.println("Found " + customerEntityList.size() + "customer(s) of Hoa");
//            System.out.println("They are:");
//            for (CustomerEntity customer : customerEntityList) {
//                System.out.println(customer.toString());
//            }
//        }
//    }

    public static void main(String[] args) {

        List<CustomerEntity> customerEntityList = customerRepository.findByPhoneOrEmail("0868012713", "ngaoop@gmail.com");

        if (customerEntityList.size() != 0) {
            System.out.println("Found " + customerEntityList.size() + " customer(s) with phone 0868012713 of email ngaoop@gmail.com");
            System.out.println("They are:");
            for (CustomerEntity customer : customerEntityList) {
                System.out.println(customer.toString());
            }
        } else {
            System.out.println("No customer found with phone 0868012713 of email ngaoop@gmail.com.");
        }
    }

}