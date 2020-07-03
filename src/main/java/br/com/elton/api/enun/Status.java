package br.com.elton.api.enun;

public enum Status {
	
	ACTIVE(0), 
	CANCELED(1);
	
   private Integer id;	
   
   private String description;
   
   Status(Integer id) {
        this.id = id;
    }
   
   Status(Integer id, String description) {
       this.id = id;
       this.description = description;
   }

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	   
}
