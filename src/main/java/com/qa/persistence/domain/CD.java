package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "cd")
public class CD {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id; 
	private String title;
	@OneToMany(
			mappedBy = "cd",
			cascade = CascadeType.ALL
			)
	private List <Artists> artist = new ArrayList<Artists>();
	
	public CD () {}
	
	public CD(String title, List<Artists> artist) {
		this.title = title;
		this.artist = artist;
		
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

	public List<Artists> getArtist() {
		return artist;
	}

	public void setArtist(List<Artists> artist) {
		this.artist = artist;
	}

	



}
