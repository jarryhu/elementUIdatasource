package com.demo.vue.vuedata.controller;
////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//         佛祖保佑       永无BUG     永不修改                  //
////////////////////////////////////////////////////////////////////

import com.demo.vue.vuedata.pojo.Product;
import com.demo.vue.vuedata.pojo.ResultList;
import com.demo.vue.vuedata.pojo.User;
import com.demo.vue.vuedata.service.ProductService;
import com.demo.vue.vuedata.service.UserService;
import com.demo.vue.vuedata.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author My
 * @Date 2020/2/9 21:46
 * @ModifyDate 2020/2/9 21:46
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Map<String, Object> Login(User user) {
        Map<String, Object> map = new HashMap<>();
        User loginUser = userService.login(user);
        if (loginUser == null) {
            map.put("code", -1);
            map.put("data", loginUser);
            map.put("message", "用户名密码不正确");
            return map;
        } else if (loginUser != null) {
            map.put("code", 0);
            map.put("data", loginUser);
            String token = JwtUtil.sign(loginUser);
            System.out.println(">>>>>>>" + token);
            map.put("message", "登录成功");
            map.put("token", token);
            return map;
        }
        return map;
    }

    @GetMapping("getUserlist")
    public Map<String, Object> getUserlist() {
        Map<String, Object> map = new HashMap<>();
        List<User> users = userService.getUserList();
        if (users == null) {
            map.put("code", -1);
            map.put("message", "用户名密码不正确");
            return map;
        } else if (users != null) {
            map.put("code", 0);
            map.put("data", users);

            return map;
        }
        return map;
    }


}
