package com.edu.tery.build.buildXML;
/**
 * @author Create by tery007
 * @date   2017Äê8ÔÂ20ÈÕ
 *
 */
public class TagBuilderTest {

	public static void main(String[] args) {
		TagBuilder builder=new TagBuilder("struts");
		String xml=builder.addChild("results").addChild("result").addAttribute("id", "89").addAttribute("name", "haha")
		.addSibling("result").addAttribute("id", "98").addAttribute("name", "hahaha").toXML();
		System.out.println(xml);
	}
}
