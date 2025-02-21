package org.Library;

public class Member {
	private int id ;
	private String name ;
	private String password ;
	private String address ;
	private String phoneNumber ;

	static int currentIdNumber;

	Member(int id , String name , String password , String address , String phoneNumber){

	currentIdNumber++;
	this.id = id ;
	this.name = name ;
	this.address = address ;
	this.phoneNumber = phoneNumber ;

	}

	public void printInfo(){

		System.out.println(
				"ID: " + id + "\n" +
				"Name: " + name + "\n" +
				"Address: " + address + "\n" +
				"Phone Number: " + phoneNumber + "\n"

		);
	}

	public void setID( int id ){
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setAddress(String address){
		this.address = address ;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber ;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
