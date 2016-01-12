package cn.conon.jse.sample.websers.ws.document.client;

import cn.conon.jse.sample.websers.ws.document.client.wsimport.HelloWorld;
import cn.conon.jse.sample.websers.ws.document.client.wsimport.HelloWorldImplService;

public class WsimportClient {
	public static void main(String[] args) {
		HelloWorld service = new HelloWorldImplService().getHelloWorldImplPort();

		System.out.println(service.getHelloWorldAsString("WsimportClient"));
	}
}
