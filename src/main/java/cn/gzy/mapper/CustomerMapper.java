package cn.gzy.mapper;

import cn.gzy.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
    Customer findUserByLogin(Customer customer);

}
