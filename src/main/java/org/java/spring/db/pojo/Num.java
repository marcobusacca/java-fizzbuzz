package org.java.spring.db.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Num {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean fizz;
	
	private boolean buzz;
	
	private boolean fizzbuzz;
	
	public Num() { }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isFizz() {
		return fizz;
	}
	public void setFizz(boolean fizz) {
		this.fizz = fizz;
	}
	public boolean isBuzz() {
		return buzz;
	}
	public void setBuzz(boolean buzz) {
		this.buzz = buzz;
	}
	public boolean isFizzbuzz() {
		return fizzbuzz;
	}
	public void setFizzbuzz(boolean fizzbuzz) {
		this.fizzbuzz = fizzbuzz;
	}
	
	@Override
	public String toString() {

		return getId() + "";
	}
}
