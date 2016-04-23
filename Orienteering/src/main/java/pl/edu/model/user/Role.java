package pl.edu.model.user;

import lombok.Getter;

public enum Role {
	
	/**
	 * zwykły użytkownik
	 */
	CLUB("CLUB"),
	
	ADMIN("ADMIN"),

    INDIVIDUAL("INDIVIDUAL");

	Role(String code){
		this.code=code;
	}

	@Getter
	private String code;

    public String getCodeWithPrefix(){
        return "ROLE_" + code;
    }

    @Override
    public String toString() {
        return code;
    }
}
