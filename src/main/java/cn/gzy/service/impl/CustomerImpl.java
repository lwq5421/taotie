package cn.gzy.service.impl;
import cn.gzy.entity.Customer;
import cn.gzy.mapper.CustomerMapper;
import cn.gzy.service.CustomerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
@Data
//@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    //    public  CustomerImpl(){
//        this.customerDao=new CustomerDaoImpl();
//    }
//    public CustomerImpl(){}
//    public CustomerImpl(CustomerDao customerDao) {
//        this.customerDao=customerDao;
//    }
    public CustomerImpl(){}
    public CustomerImpl(CustomerMapper customerMapper) {
        this.customerMapper=customerMapper;
    }

    @Override
    public Customer login(String phone,String password){
        Customer customer=new Customer(phone,password);
        return  customerMapper.findUserByLogin(customer);
    }

}