package com.myspringbootproject.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="stories")
public class Story {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String title;
	private String content;
	private Date latestUpdated;
	
	@ManyToOne
	private Blogger blogger;
	
	private Story() {
		
	}
	

	public Story(String title, String content, Date latestUpdated, Blogger blogger) {
		super();
		this.title = title;
		this.content = content;
		this.latestUpdated = latestUpdated;
		this.blogger = blogger;
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

	@Override
	public String toString() {
		return "Story [title=" + title + ", latestUpdated=" + latestUpdated + ", author=" + blogger.getName() + "]";
	}
	
	
}
