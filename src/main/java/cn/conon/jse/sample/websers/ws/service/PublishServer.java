package cn.conon.jse.sample.websers.ws.service;

import javax.xml.ws.Endpoint;

public class PublishServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// java jdk 提供一个自带的类可以将java 应用程序发布成webservice
		/**
		 * 1,提供服务对外的访问地址 2,提供服务的类的对象...
		 */

		Endpoint.publish("http://localhost:9999/helloService", new HelloService());
	}

}
