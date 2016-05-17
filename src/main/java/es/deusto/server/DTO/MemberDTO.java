package es.deusto.server.DTO;

import java.io.Serializable;

public class MemberDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String passWord;
	private int premium;
	public MemberDTO(){}
	public MemberDTO(String name, String password){
		System.out.println(name+"                      "+password);
		this.name = name;
		this.passWord = password;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPassword(){
		return this.passWord;
	}
	
	public int getPremium(){
		return this.premium;
	}
	
	public void setPremium(int premium){
		this.premium = premium;
	}
}
