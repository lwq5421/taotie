package cn.gzy.controller;

import cn.gzy.entity.Customer;
import cn.gzy.entity.Food;
import cn.gzy.service.CustomerService;
import cn.gzy.service.FoodService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class PublicController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/")
    public ModelAndView index(String type,ModelAndView mv) {
        List<String> typelist=foodService.foodTyleList();
        List<Food> foodList=foodService.findFoodsByType(type==null? typelist.get(0):type);
        List<Food> top3=foodService.recommendBySales();
        mv.addObject("types",typelist);
        mv.addObject("foods",foodList);
        mv.addObject("top3",top3);
        mv.setViewName("index");
        return  mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
            System.out.println("tologin");
       return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "phone", required = true) String phone,
                        @RequestParam(value = "password", required = true) String password,
                        RedirectAttributes attributes, HttpSession session) {
        Customer customer = customerService.login(phone, password);
        if (Optional.ofNullable(customer).isEmpty()) {
            attributes.addFlashAttribute("msg", "登录失败");
            return "redirect:/login";
        }
        session.setAttribute("me", customer);
        return "redirect:/";
    }
}
