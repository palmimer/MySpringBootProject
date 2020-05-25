package com.myspringbootproject.domain;

import java.util.Date;

public class Story {
	private String title;
	private String content;
	private Date latestUpdated;
	private String author;
	
	public Story() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getLatestUpdated() {
		return latestUpdated;
	}

	public void setLatestUpdated(Date latestUpdated) {
		this.latestUpdated = latestUpdated;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Story [title=" + title + ", latestUpdated=" + latestUpdated + ", author=" + author + "]";
	}
	
	
}
