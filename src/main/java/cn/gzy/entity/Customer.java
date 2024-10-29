package cn.gzy.entity;

public record Customer(

        Integer customerId,String customerNickname,
        String customerPhone,String customerPassword,
                String customerAvatar
) {
    public  Customer{};
public Customer(String customerPhone){
 this(null,null,customerPhone,null,null);
}
public  Customer(Integer id){
   this(id,null,null,null,null);
}
public  Customer(String phone,String password){
    this(null,null,phone,password,null);
}

}
