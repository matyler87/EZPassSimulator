class vehicle extends EZPass{
	
	private String make;
	private String model;
	private boolean car;
	private int axles;
	private String plate;
	private Tag t;
	
	vehicle(){
		make = "";
		model = "";
		car = false;
		axles = 0;
		plate = "";
	}
	
	vehicle(String m, String n, boolean c, int a, String p, Tag t){
		make = m;
		model = n;
		car = c;
		axles = a;
		plate = p;
		setT(t);
		
	}
	
	public String toString(){
		return("EZPass Tag:"+ t.toString() +" Make:"  + make + " Model: " + model + " Car: " + car +" Axles Ct: "+ axles + " License Plate:" + plate);
	}
	
	public int getAxles() {
		return axles;
	}

	public void setAxles(int axles) {
		this.axles = axles;
	}

	public boolean isCar() {
		return car;
	}

	public void setCar(boolean car) {
		this.car = car;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getPlate(){
		return plate;
	}
	
	public void setPlate(String plate){
		this.plate = plate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	public Tag getT() {
		return t;
	}

	public void setT(Tag t) {
		this.t = t;
	}

	public static void main(String[] args){
		
		System.out.println("hello");
	}
}