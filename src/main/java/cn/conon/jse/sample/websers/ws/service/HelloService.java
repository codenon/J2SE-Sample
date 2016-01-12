package cn.conon.jse.sample.websers.ws.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import cn.conon.jse.sample.websers.ws.bean.User;

@WebService(
		targetNamespace = "www.conon.cn",
		serviceName = "HelloService",
		portName = "HelloServicePort")
public class HelloService {

	@WebMethod(exclude = true)
	public void doubleKill() {

		System.out.println("itcast");
	}

	public @WebResult(name = "date") String getDate(
			@WebParam(name = "date") String date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}

	@WebMethod(operationName = "getUserById")
	public User getUserById(int id) {
		User user = new User();
		user.setId(id);
		user.setMomo("18078900982");
		user.setUsername("老冯");
		user.setWeibo("laofeng@sina.com.cn");
		user.setWeixin("l89999");
		return user;
	}
}
