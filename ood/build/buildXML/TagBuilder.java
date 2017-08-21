package com.edu.tery.build.buildXML;
/**
 * @author Create by tery007
 * @date   2017Äê8ÔÂ20ÈÕ
 *
 */
public class TagBuilder {

	private TagNode rootNode;
	private TagNode parentNode;
	private TagNode currentNode;
	
	public TagBuilder(String tagName){
		rootNode=new TagNode(tagName);
		this.currentNode=rootNode;
		this.parentNode=null;
	}
	
	public TagBuilder addChild(String name){
		this.parentNode=this.currentNode;
		this.currentNode=new TagNode(name);
		this.parentNode.add(currentNode);
		return this;
	}
	
	public TagBuilder addSibling(String name){
		this.currentNode=new TagNode(name);
		this.parentNode.add(currentNode);
		return this;
	}
	
	public TagBuilder addAttribute(String name,String value){
		this.currentNode.setAttribute(name, value);
		return this;
	}
	
	public TagBuilder setValue(String value){
		this.currentNode.setValue(value);
		return this;
	}
	
	public String toXML(){
		return this.rootNode.toXML();
	}
}
