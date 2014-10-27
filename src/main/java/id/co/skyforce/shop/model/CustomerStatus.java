package id.co.skyforce.shop.model;

public enum CustomerStatus {
	
	ACTIVE("ACTIVE"), BLOCKED("ACTIVE");
	 
	private String name;

	  private CustomerStatus(String name) {
	    this.name = name;
	  }

	  public String getName() {
	    return name;
	  }
	
	 public static CustomerStatus getByName(String name){
		    for(CustomerStatus prop : values()){
		      if(prop.getName().equals(name)){
		        return prop;
		      }
		    }

		    throw new IllegalArgumentException(name + " is not a valid PropName");
		  }
}

