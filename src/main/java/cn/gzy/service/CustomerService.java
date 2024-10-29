package cn.gzy.service;

import cn.gzy.entity.Customer;

public interface CustomerService {
    Customer login(String phone,String password);
}
