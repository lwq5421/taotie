package cn.gzy;

import cn.gzy.entity.Customer;
import cn.gzy.mapper.CustomerMapper;
import cn.gzy.service.CustomerService;
import cn.gzy.service.impl.CustomerImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//                CustomerService   customerService=
//                (CustomerService) context.getBean("customerService2");
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService  customerService=
                (CustomerService) context.getBean("customerService1");
        Customer customer = customerService.login("13512346789", "123456");
        System.out.println(customer);
//        Main main=new Main();





//        main.findByLogin();
//        SqlSessionFactory factory = null;

//        System.out.println("Hello world!");

//        try {
//            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("config.xml"));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        SqlSession session = factory.openSession();
//        System.out.println(session);
//        Customer customer = new Customer("张三", "13312342345");
//        Customer c = session.getMapper(CustomerMapper.class)
//                .findUserByLogin(customer);
//        System.out.println(c);

    }
//void  findByLogin(){
//    CustomerService customerService=new CustomerImpl();
//    System.out.println(customerService.login("13512346789","1233456"));
//}

}