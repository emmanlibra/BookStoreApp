package com.mapua.lab.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.*;

public class GreeterTag extends TagSupport{
	private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int doStartTag() {
		try {
			JspWriter out = pageContext.getOut();
			if (color.equals("blue")) {
				out.println("<h1><font color='blue'>Welcome to Online Bookstore!</font></h1>");
			} else {
				out.println("<h1><font color='black'>Welcome to Online Bookstore!</font></h1>");
			}
		} catch (Exception e) {
			System.out.println("Error from the Greeter Tag: " + e.getMessage());
		}
		return SKIP_BODY;
	}
	
	
}
