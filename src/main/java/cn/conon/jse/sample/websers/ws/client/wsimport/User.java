package cn.conon.jse.sample.websers.ws.client.wsimport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * user complex type的 Java 类。
 * 
 * <p>
 * 以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="user">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="momo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="weibo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="weixin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
		"id",
		"momo",
		"username",
		"weibo",
		"weixin"
})
public class User {

	protected int id;
	protected String momo;
	protected String username;
	protected String weibo;
	protected String weixin;

	/**
	 * 获取id属性的值。
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id属性的值。
	 * 
	 */
	public void setId(int value) {
		this.id = value;
	}

	/**
	 * 获取momo属性的值。
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMomo() {
		return momo;
	}

	/**
	 * 设置momo属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMomo(String value) {
		this.momo = value;
	}

	/**
	 * 获取username属性的值。
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置username属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUsername(String value) {
		this.username = value;
	}

	/**
	 * 获取weibo属性的值。
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWeibo() {
		return weibo;
	}

	/**
	 * 设置weibo属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWeibo(String value) {
		this.weibo = value;
	}

	/**
	 * 获取weixin属性的值。
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWeixin() {
		return weixin;
	}

	/**
	 * 设置weixin属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWeixin(String value) {
		this.weixin = value;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", momo=" + momo + ", username=" + username + ", weibo=" + weibo + ", weixin=" + weixin + "]";
	}

}
