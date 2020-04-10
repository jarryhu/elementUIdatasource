package com.demo.vue.vuedata.dao;
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
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName ProductDao
 * @Description TODO
 * @Author My
 * @Date 2020/2/9 21:34
 * @ModifyDate 2020/2/9 21:34
 * @Version 1.0
 */
@Repository
public interface ProductDao {
    @Select("select * from product")
    public List<Product> getProducts();

    @Insert("Insert into product values(null,#{productName},#{product_price},#{total},#{imagePath})")
    public int insertProduct(Product product);

    @Delete("delete from product where id=#{id}")
    public int deleteProductByid(Integer id);


    public List<Product> SelectProductByName(HashMap map);

    public Integer SelectProductCount(String productName);

    public Product selectProductById(Integer id);

    public Integer updateProduct(Product product);

    public List<Product> SelectProductByName2(String searchName);

    public Integer deleteProductsByids(List<Integer> ids);

}
