class TollBooth extends EZPass{
	
	private double toll = 7.34;
	private vehicle theCar;
	private TOD theDay;
	
	public double getToll(){
		return toll;
	}
	
	public double calcTotalToll(TOD x, vehicle y){
		if(y.isCar()){
			if(x.isHoliday()){
				toll -= 1.00;
			}if(x.isPeak()){
				toll += 2.34;
			}if(x.isWeekday()){
				toll += 1.00;
			}	
		}else{
			return (toll);
		}
		return (toll);
	}
	
	public void chargeEZPass(EZPass x, double c){
		double temp = 0;
		temp = x.getBalance() - c ;
		x.setBalance(temp);
		System.out.println("New Balance:" + temp +"\n");
		System.out.println("Amount Charged: " + c +"\n");
	}
	
	TollBooth(vehicle x, TOD y){
		theCar = x;
		theDay = y;
	}
	
	public String toString(){
		return("Tunnel Cost: $" + toll );
	}
	
	public static void main(String[] args){
		
		EZPass myTag = new EZPass();
		
		TOD theDay = new TOD(true,true,true);
		System.out.println(theDay.toString());
		//vehicle myCar = new vehicle("Hyundai","Sonata",true, 2,"BKV-2178");

	}
}