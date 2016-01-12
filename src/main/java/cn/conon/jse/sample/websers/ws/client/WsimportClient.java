package cn.conon.jse.sample.websers.ws.client;

import cn.conon.jse.sample.websers.ws.client.wsimport.HelloService;
import cn.conon.jse.sample.websers.ws.client.wsimport.HelloService_Service;
import cn.conon.jse.sample.websers.ws.client.wsimport.User;

public class WsimportClient {
	public static void main(String[] args) {
		HelloService service = new HelloService_Service().getHelloServicePort();

		User user = service.getUserById(1);
		System.out.println(user.toString());
	}
}
