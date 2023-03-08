package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MovieList")
public class model {
	@Id
	private int serialno;
	private String name;
	private float rating;
	private String dirname;
	private int year;
	
	public int getSerialno() {
		return serialno;
	}

	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getDirname() {
		return dirname;
	}

	public void setDirname(String dirname) {
		this.dirname = dirname;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public model(int serialno, String name, float rating, String dirname, int year) {
		super();
		this.serialno = serialno;
		this.name = name;
		this.rating = rating;
		this.dirname = dirname;
		this.year = year;
	}

	public model() {
		
	}
	
	public String toString() {
		return "serialno="+serialno+"name="+name+"rating="+rating+"dirname="+dirname+"year="+year;
	}
}
