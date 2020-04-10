package com.demo.vue.vuedata.pojo;
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

import java.util.List;

/**
 * @ClassName Result
 * @Description TODO
 * @Author My
 * @Date 2020/2/9 22:46
 * @ModifyDate 2020/2/9 22:46
 * @Version 1.0
 */
public class ResultList {


    /**
     * code : 0
     * data : [{"id":1,"productName":"tvset","product_price":1000,"total":2},{"id":2,"productName":"computer","product_price":2000.3,"total":10},{"id":3,"productName":"iphone","product_price":8000,"total":11},{"id":4,"productName":"手机","product_price":1000,"total":3}]
     */

    private int code;
    private List<Product> data;

    public int getCode() {
        return code;
    }

    public void setCode(int stauts) {
        this.code = stauts;
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }


}
    