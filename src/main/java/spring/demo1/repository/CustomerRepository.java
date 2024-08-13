package spring.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.demo1.entity.CustomerEntity;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
    List<CustomerEntity> findByName(String name);

    List<CustomerEntity> findByPhoneOrEmail(String phone, String email);

}
