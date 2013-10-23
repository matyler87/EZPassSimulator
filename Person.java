class Person{
	private String first_name;
	private String last_name;
	
	Person(){
		first_name = "";
		last_name = "";
	}
	
	Person(String first_name,String last_name){
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public String toString(){
		return("First Name: " + first_name + " Last Name: "+ last_name);
	}
	
	public static void main(String[] args){
		
	}
}