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
import com.demo.vue.vuedata.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
public class ProductService {
    @Autowired
    ProductDao productDao;

    public List<Product> getProducts() {
        return productDao.getProducts();
    }


    public int insertProduct(Product product) {
        return productDao.insertProduct(product);
    }


    public int deleteProductByid(Integer id) {
        return productDao.deleteProductByid(id);
    }

    public List<Product> SelectProductByName(HashMap map) {
        return productDao.SelectProductByName(map);
    }

    public Integer SelectProductCount(String productName) {
        return productDao.SelectProductCount(productName);
    }

    public Product selectProductById(Integer id) {
        return productDao.selectProductById(id);
    }

    public Integer updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    public List<Product> SelectProductByName2(String searchName) {
        return productDao.SelectProductByName2(searchName);
    }

    public Integer deleteProductsByids(List<Integer> ids){
        return productDao.deleteProductsByids(ids);
    }


}
