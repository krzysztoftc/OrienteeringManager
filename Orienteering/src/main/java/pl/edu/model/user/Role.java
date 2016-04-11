package pl.edu.model.user;

import lombok.Getter;

public enum Role {
	
	/**
	 * zwykły użytkownik
	 */
	ROLE_USER("ROLE_USER"), 
	
	ROLE_ADMIN("ROLE_ADMIN");
	
	Role(String code){
		this.code=code;
	}

	@Getter
	private String code;
	
}
