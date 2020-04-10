package com.demo.vue.vuedata.service;
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

import com.demo.vue.vuedata.dao.ProductDao;
import com.demo.vue.vuedata.dao.UserDao;
import com.demo.vue.vuedata.pojo.Product;
import com.demo.vue.vuedata.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName productService
 * @Description TODO
 * @Author My
 * @Date 2020/2/9 21:43
 * @ModifyDate 2020/2/9 21:43
 * @Version 1.0
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User login(User user) {
        return userDao.Login(user);
    }

    public List<User> getUserList() {
        return userDao.getUserList();
    }


}
