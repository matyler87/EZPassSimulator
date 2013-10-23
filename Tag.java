class Tag extends EZPass{
	private String theTag;
	private vehicle v;
	
	Tag(){
		theTag = null;
	}
	
	Tag(String x){
		setTheTag(x);
	}
	
	public vehicle getV() {
		return v;
	}

	public void setV(vehicle v) {
		this.v = v;
	}

	public String getTheTag() {
		return theTag;
	}

	public void setTheTag(String theTag) {
		this.theTag = theTag;
	}
	
	public String toString(){
		return("EZ-Pass Tag: " + theTag );
	}
	
	public static void main(String args[]){
		Tag myTag = new Tag();
		System.out.println(myTag.toString());
	}


	
}