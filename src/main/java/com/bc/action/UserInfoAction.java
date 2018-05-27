package com.bc.action;

import com.bc.service.UserInfoService;
import com.bc.view.Result;
import com.bc.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user_info")  //uel映射
public class UserInfoAction {

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 跳转页面
     */
    @RequestMapping("index.action")
    public String index() {
        return "/admain/index";
    }
    /**
     * 跳转登录页面
     */
    @RequestMapping("login.action")
    public String login() {
        return "/admain/login";
    }

    /**
     * 后台登录验证页面 由ajax转jsp
     * 返回json数据
     */
    @RequestMapping("login.json")
    @ResponseBody              //返回结果直接写入HTTP response body中，不会被解析为跳转路径。比如异步请求 一般是指定要response 的typ
    //@requestBody注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容
    //等同于response.getWriter.write 就是响应给前台数据 而不是跳到页面（自己猜想）


    // 就是返回的是数据（返回类型由消息转换器设置，默认有4种，json也属于其中，  RequestMappingHandlerAdapter请求映射处理适配器构造函数里添加了默认4个数据转换器，其中llEncompassingFormHttpMessageConverter这个转换器构造函数里有个方法  //如果Classpath下有com.fasterxml.jackson.databind.ObjectMapper
    //    //和com.fasterxml.jackson.core.JsonGenerator的话，则添加
    //    //MappingJackson2HttpMessageConverter转换器
    //    if (jackson2Present) {
    //        addPartConverter(new MappingJackson2HttpMessageConverter());
    //    }  ）
    //上面就是返回json默认使用的是jackjson的jar包，需要设置<mvc:annotation-driven/>配置，
    public Result login2(HttpServletRequest request) {
        //getParameter()是获取POST/GET传递的参数值
        String loginName=request.getParameter("login_name");
        String passWord=request.getParameter("pass_word");

        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(passWord)) {
            System.out.println("空的");
            return Result.erro("用户名，密码不能为空"); //数据返回给ajax 因为 @ResponseBody
        }

        // 校验用户名、密码是否正确
        User userInfo = userInfoService.checkUser(loginName, passWord);
        if (userInfo==null) {
            System.out.println("密码错误");
            return Result.erro("用户名或密码不正确");
        }
        request.getSession().setAttribute("userInfo",userInfo);

        // 登录成功，进入主页
        return  Result.success();

    }






    /**
     * 测试用户登录
     * @param loginName 登录名
     * @param passWord 登录密码
     */
    @RequestMapping("logins.action")
   // ModelMap的实例是由bboss mvc框架自动创建并作为控制器方法参数传入，用户无需自己创建。使用例子model.addAttribute("key",someparam);
    public String login(ModelMap map,
                        //类似request.getParameter
                        @RequestParam(required = false, value = "login_name") String loginName,//required：是否必须，默认是true，表示请求中一定要有相应的参数，否则将报404错误码；
                        @RequestParam(required = false, value = "pass_word") String passWord) {

        // 如果登录名或密码未填写，直接返回登录页面
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(passWord)) {
            System.out.println("空的");
            return "login";
        }

        // 校验用户名、密码是否正确
        User userInfo = userInfoService.checkUser(loginName, passWord);
        if (userInfo==null) {
            System.out.println("密码错误");
            return "login";
        }

        // 登录成功，进入主页
        return "home";
    }



}
