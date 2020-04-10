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
import com.demo.vue.vuedata.service.ProductService;
import com.demo.vue.vuedata.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author My
 * @Date 2020/2/9 21:46
 * @ModifyDate 2020/2/9 21:46
 * @Version 1.0
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getProductList")
    public ResultList getProductList() {
        ResultList resultList = new ResultList();

        List<Product> products = productService.getProducts();
        if (products != null) {
            resultList.setCode(0);
            resultList.setData(products);
        } else {
            resultList.setCode(-1);
        }
        return resultList;
    }

    @PostMapping("/getListCount")
    public Map<String, Object> SelectProductCount(String productName) {
        Integer count = productService.SelectProductCount(productName);
        Map<String, Object> map = new HashMap<>();
        if (count != null) {
            map.put("code", 0);
            map.put("result", count);
        }
        return map;
    }

    @PostMapping("/getProductPageByName")
    public Map<String, Object> getProductByName(String productName, int currentPage, int pageSize) {
        //  String token = request.getHeader("token");
        // System.out.println(token);
        // boolean verity = JwtUtil.verity(token);
        HashMap map = new HashMap();
        Map<String, Object> remap = new HashMap<>();
        //  if (verity) {
        int pageStart = (currentPage - 1) * pageSize;
        map.put("pageStart", pageStart);
        map.put("pageSize", pageSize);
        map.put("productName", productName);
        List<Product> products = productService.SelectProductByName(map);
        if (products != null) {
            remap.put("code", 0);
            remap.put("data", products);
        } else {
            remap.put("code", -1);
            remap.put("message", "请先登录");
        }
        return remap;

    }


    @PostMapping("/getProductByName")
    public Map<String, Object> getProductByName(String productName) {

        Map<String, Object> remap = new HashMap<>();
        List<Product> products = productService.SelectProductByName2(productName);
        if (products != null) {
            remap.put("code", 0);
            remap.put("data", products);
        } else {
            remap.put("code", -1);
        }
        return remap;
    }


    @RequestMapping("/insertProduct")
    public int insertProduct(Product product) {
        return productService.insertProduct(product);
    }

    @GetMapping("/deleteProductByid/{id}")
    public int deleteProductByid(@PathVariable("id") Integer id) {
        return productService.deleteProductByid(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/deleteProductsByids")
    public Integer deleteProductsByids(String ids) {  //'59,60,61,"
        String[] split = ids.split(",");
        List<Integer> ids_l = new ArrayList<>();
        for (String id : split)
            ids_l.add(Integer.parseInt(id));
        return productService.deleteProductsByids(ids_l);
    }

    @RequestMapping("/deleteProductByid")
    public int deleteProductByid2(Integer id) {
        return productService.deleteProductByid(id);
    }

    @GetMapping("/selectProductById/{id}")
    public Map<String, Object> selectProductById(@PathVariable("id") Integer id) {
        Product product = productService.selectProductById(id);
        Map<String, Object> map = new HashMap<>();
        if (product != null) {
            map.put("code", 0);
            map.put("result", product);
        }
        return map;
    }

    @RequestMapping("/updateProduct")
    public Map<String, Object> updateProduct(HttpServletRequest request, Product product) {
        //  boolean verity = JwtUtil.verity(request.getHeader("token"));
        Map<String, Object> map = new HashMap<>();
        // if (verity) {
        Integer id = productService.updateProduct(product);
        String message = "";
        if (id == 1) {
            map.put("code", 0);
            message = "修改成功";

        } else {
            map.put("code", -1);
            message = "修改失败";
        }
        map.put("message", message);
        return map;

    }

    @PostMapping("/imagesUpload")
    public String imagesUpload(MultipartFile file) {
        String filePath = "d:/myImage/"; //上传的路径
        String fileName = file.getOriginalFilename(); // 文件名
        String suffix = fileName.substring(fileName.lastIndexOf(".")); //取得文件的后缀名
        fileName = UUID.randomUUID() + suffix; //新的文件名 防止同名上传时覆盖
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest); //上传文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;

    }

}
