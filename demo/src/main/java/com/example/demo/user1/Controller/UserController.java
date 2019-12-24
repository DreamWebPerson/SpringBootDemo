package com.example.demo.user1.Controller;

import com.example.demo.user1.Entity.User;
import com.example.demo.user1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    //@Autowired
    //UserService userService;

    /***********************************************************
    * @dec:
    *  基本返回对象
    * @param: []
    * @return: com.example.demo.user1.Entity.User
    * @author: chenGuang ma
    * @createDate: 2019/12/24 15:17
    ************************************************************/
    @RequestMapping("queryUser")
    public User queryUser(){
        User user = new User();
        user.setId("1");
        user.setGenner("F");
        user.setName("张三");
        user.setPassword("123456");
        return user;
    }

    /***********************************************************
    * @dec:
    *  GET请求接参的方式
     *  请求：http://localhost:8080/user/queryUserById/张三/asd12456?id=asd
     *  返回：{"id":"asd","name":"张三","genner":"F","password":"asd12456"}
     * @RequestParam("id") 接问号之后的参数
     * @PathVariable("name") 接收URL的参数
     * @RequestBody 接收POST的参数
     * @RequestHeader 接收请求头
     * @CookieValue 接收COOKIE值
     * HttpServletRequest 接收所有request信息
     * 实体类，接收实体类属性
    * @param: [id]
    * @return: com.example.demo.user1.Entity.User
    * @author: chenGuang ma
    * @createDate: 2019/12/24 15:20
    ************************************************************/
    @GetMapping("queryUserById/{name}/{password}")
    public User queryUserById(@RequestParam("id") String id,@PathVariable("name") String name,@PathVariable("password") String password ){
        User user = new User();
        user.setId(id);
        user.setGenner("F");
        user.setName(name);
        user.setPassword(password);
        return user;
    }
    @GetMapping("queryUserEntity")
    public User queryUserEntity(User user){
        return user;
    }


    @RequestMapping("queryUserByJDBC")
    public List<User> queryUserByJDBC(){
        //准备连接mysql基础信息
        String url = "jdbc:mysql://127.0.0.1:3306/mysql";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "123456";

        //jdbc连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName(driver);
            //建立连接
            conn = DriverManager.getConnection(url,userName,password);
            //准备sql
            String sql ="select * from demo.demo_user";
            //把sql加载到驱动
            ps = conn.prepareStatement(sql);
            //执行sql并接收返回结果
            rs = ps.executeQuery();
            //处理返回结果
            while (rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getInt(2));
                System.out.println(rs.getInt(3));
                System.out.println(rs.getInt(4));
            }
        }catch (Exception e){
            //异常打印异常信息
            e.printStackTrace();
        }finally {
            //关闭连接
            try {
                if(rs != null){
                    rs.close();
                    rs = null;
                }
                if(ps != null){
                    ps.close();
                    ps = null;
                }
                if(conn != null){
                    conn.close();
                    conn = null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }





//    @RequestMapping("queryUserBySql")
//    public List<User> queryUserBySql(){
//       //return userService.queryUser();
//    }

}
