
class EZPass{
	
	private String account;
	private String tag;
	private double balance;
	private Person accountHolder;
	private CreditCards creditCard;
		
	EZPass(){
		account = "";
		tag = "";
		balance = 0.0;
		accountHolder = new Person();
		creditCard = new CreditCards();
	}
	
	EZPass(String account, String tag, double balance, Person accountHolder, CreditCards creditCard){
		this.account = account;
		this.tag = tag;
		this.balance = balance;
		this.accountHolder = accountHolder;
		this.creditCard = creditCard;
	}
	
	public static void run(){
		int count = 20;
		long milli = 100;
		System.out.print("Replenishing");
				try{
					for(int i = 0; i < count; i++){
						Thread.sleep(milli);
						System.out.print(".");
					}
					System.out.print("Replenished!\n");
					Thread.sleep(milli);
				}catch(InterruptedException ie){}			
	}
	
	public String getAccount(){
		return account;
	}
	
	public String getTag(){
		return tag;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public Person getAccountHolder(){
		return accountHolder;
	}
	
	public CreditCards getCreditCard(){
		return creditCard;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	public boolean tooLow(double balance){
		if(balance < 10.00){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		return("EZPass Account: "+ account +"\nTag: "+ tag+ "\nBalance: $" + balance +"\n" + accountHolder.toString() + "\n" + creditCard.toString());
	}
	
	public void replenishEZPass(CreditCards creditCard, EZPass x, double balance){
		double replenish = 30.00;
		double escrow = 0;
		
		if(!tooLow(balance)){
			if(creditCard.getBalance() > 30.00){
				creditCard.setBalance(creditCard.getBalance()- replenish);
				escrow += replenish;
				x.setBalance(x.getBalance() + escrow);
			}
		}else{
			System.out.println("The EZPass Balance and CreditCard Balance is too low.");
		}
	}
	
	public static void main(String[] args){
		
			Person me = new Person("Mark", "Tyler");
			CreditCards myAMEXCard = new CreditCards("4029445056878685", 1000.00, me);
			myAMEXCard.toString();
			EZPass myEZPass = new EZPass( "1A2B357", "1A10", 20.00, me, myAMEXCard);
			
			
			System.out.println(myEZPass.toString());
			
			for(int i = 0; i < 3; i++){
				//Space
				System.out.println("");
			
				run();
				//Replenish the card...
				myEZPass.replenishEZPass(myAMEXCard, myEZPass, myEZPass.getBalance());
				System.out.println(myEZPass.toString());
				//System.out.println(myAMEXCard.toString());
			}
	}
}