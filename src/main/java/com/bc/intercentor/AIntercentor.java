package com.bc.intercentor;
/*
拦截器
验证后台登录
web.xml 的加载顺序是：context- param -> listener -> filter -> servlet
 */

import com.bc.view.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AIntercentor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws ServletException, IOException {
		/*该方法将在请求处理之前进行调用，只有该方法返回true，才会继续执行后续的Interceptor和Controller，当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法；*/
		//1.0获取请求地址
		String url=request.getRequestURI();

		//2.0对特殊地址直接放行
		if(url.contains("login")){
			return true;
		}

		//3.0判断session，session在的话，登录后台
		//HttpSession session=request.getSession();
		User user=(User)request.getSession().getAttribute("userInfo");
		if(user!=null){
			return  true;
		}

		//4.0执行这里表示用户身份需要验证，跳转到登录页面
		request.getRequestDispatcher("WEB-INF/page/admain/login.jsp").forward(request,response);
		return true;

	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,Object obj,Exception e)throws Exception {
		/*该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。*/
	}
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2,ModelAndView arg3) throws Exception {
		/*该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。用于进行资源清理。*/
	}

}
