package com.mapua.lab.tags;

import java.text.DateFormat;
import java.util.Date;
import java.io.*;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DateDisplayTag extends TagSupport{
	
	private Date today = new Date();
	private DateFormat date;
	private String style;
	
	
	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int doStartTag() {
		
		try {
			if (style.equalsIgnoreCase("short"))
				date = DateFormat.getDateInstance(DateFormat.SHORT);
			if (style.equalsIgnoreCase("medium"))
				date = DateFormat.getDateInstance(DateFormat.MEDIUM);
			if (style.equalsIgnoreCase("long"))
				date = DateFormat.getDateInstance(DateFormat.LONG);
			
			JspWriter out = pageContext.getOut();
			out.print(date.format(today));
		
		} catch (Exception e) {
			System.out.println("Error from the Date Display Tag: " + e.getMessage());
		}
		return SKIP_BODY;
	}
}
