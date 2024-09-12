package com.example.demo.domain;

import java.io.Serializable;

public class PhonebookVO implements Serializable{
	
	private static final long serialVersionUID = -1371437555064029578L;
	
	private int id;
	private String name;
	private String hp;
	private String memo;
	
	public PhonebookVO() {}
		
	public PhonebookVO(int id, String name, String hp, String memo) {
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.memo = memo;
	}

	/**
	 * 입력 시 필요하는 생성자
	 */
	public PhonebookVO(String name, String hp, String memo) {
		this.name = name;
		this.hp = hp;
		this.memo = memo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "PhonebookVO [id=" + id + ", name=" + name + ", hp=" + hp + ", memo=" + memo + "]";
	}
	
}
