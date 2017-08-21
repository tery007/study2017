package com.edu.tery.build.buildXML;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by tery007
 * @date   2017年8月20日
 *节点类，完成一个xml的构建
 */
public class TagNode {

	private String name;
	private String value;
	private List<TagNode> children=new ArrayList<>();
	private List<Attribute> attributes=new ArrayList<>();
	
	public TagNode(String name){
		this.name=name;
	}
	
	public void add(TagNode child){
		this.children.add(child);
	}
	
	public void setAttribute(String name,String value){
		Attribute attr=findAttribute(name);
		if(attr !=null){
			attr.value=value;
			return ;
		}
		attributes.add(new Attribute(name, value));
	}
	
	private Attribute findAttribute(String name) {
		for(Attribute attr:attributes){
			if(name.equals(attr.name)){
				return attr;
			}
		}
		return null;
	}
	
	public void setValue(String value){
		this.value=value;
	}
	
	public String getTagName(){
		return this.name;
	}
	
	public List<TagNode> getChildren(){
		return this.children;
	}

	public String toXML(){
		return toXML(this);
	}
	
	private String toXML(TagNode tagNode) {
		StringBuilder sb=new StringBuilder();
		sb.append("<"+tagNode.name);
		List<Attribute> attributes=tagNode.attributes;
		if(attributes.size()>0){
			for(Attribute attr : attributes){
				sb.append(" "+attr.name+"=\""+attr.value+"\" ");
			}
			
		}
		if(tagNode.children.size()==0){
			sb.append("/>\n");
			return sb.toString();
		}
		sb.append(">\n");
		for(TagNode node : tagNode.children){
			sb.append(toXML(node));
		}
		sb.append("</"+tagNode.name+">\n");
		return sb.toString();
	}
	
	
	public static class Attribute{
		private String name;
		private String value;
		
		public Attribute(String name,String value){
			this.name=name;
			this.value=value;
		}
	}
}
