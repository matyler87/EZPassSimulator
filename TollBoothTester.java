class TollBoothTester extends TollBooth{
	
	TollBoothTester(vehicle x, TOD y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		//Declarations
		TOD theWeekend = new TOD();
		Person me = new Person("Mark","James");
		CreditCards myCard = new CreditCards("374356548756884",1000.00,me);
		Tag vehicleTag = new Tag("1234");
		EZPass e = new EZPass("EZTAG345B", vehicleTag.getTheTag(),10.00,me,myCard);
		//Vehicle a
		vehicle a = new vehicle("Hyundai","Sonata",false,4,"BKV-1764", vehicleTag);

		//Simulation
		TollBoothTester hollandTunnel = new TollBoothTester(a,theWeekend);
		
		if(e.tooLow(e.getBalance())){
			e.replenishEZPass(myCard, e, e.getBalance());
			hollandTunnel.chargeEZPass(e, hollandTunnel.calcTotalToll(theWeekend, a));

		}else{
			hollandTunnel.chargeEZPass(e, hollandTunnel.calcTotalToll(theWeekend, a));
			System.out.println("Balance is fine!");
		}
		System.out.println(hollandTunnel.toString());
		System.out.println(e.toString());
	}
}