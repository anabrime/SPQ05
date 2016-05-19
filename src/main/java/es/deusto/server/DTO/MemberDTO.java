package es.deusto.server.DTO;

import java.io.Serializable;

/**
 * A simple MemberDTO class
 * 
 * @author Team 05
 *
 */
public class MemberDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String passWord;
	private int premium;
	public MemberDTO(){}
	
	/**Constructor method
	 * @param name
	 * @param password
	 */
	public MemberDTO(String name, String password){
		System.out.println(name+"                      "+password);
		this.name = name;
		this.passWord = password;
	}
	
	/**
	 * @return name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * @return password
	 */
	public String getPassword(){
		return this.passWord;
	}
	
	/**
	 * @return premium
	 */
	public int getPremium(){
		return this.premium;
	}
	
	/**
	 * @param premium
	 */
	public void setPremium(int premium){
		this.premium = premium;
	}
}
