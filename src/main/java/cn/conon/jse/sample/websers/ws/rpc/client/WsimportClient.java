package cn.conon.jse.sample.websers.ws.rpc.client;

import cn.conon.jse.sample.websers.ws.rpc.client.wsimport.HelloWorld;
import cn.conon.jse.sample.websers.ws.rpc.client.wsimport.HelloWorldImplService;

public class WsimportClient {

	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorldImplService().getHelloWorldImplPort();
		System.out.println(helloWorld.getHelloWorldAsString("WsimportClient"));
	}

}
