class TOD{
	
	private boolean holiday;
	private boolean weekday;
	private boolean peak;
	
	TOD(){
		this.setHoliday(false);
		this.setWeekday(true);
		this.setPeak(false);
	}
	
	TOD(boolean holiday, boolean weekday, boolean peak){
		this.setHoliday(holiday);
		this.setWeekday(weekday);
		this.setPeak(peak);
	}

	public boolean isPeak() {
		return peak;
	}

	public void setPeak(boolean peak) {
		this.peak = peak;
	}

	public boolean isWeekday() {
		return weekday;
	}

	public void setWeekday(boolean weekday) {
		this.weekday = weekday;
	}

	public boolean isHoliday() {
		return holiday;
	}

	public void setHoliday(boolean holiday) {
		this.holiday = holiday;
	}
	
	public String toString(){
		return("Holiday? " + holiday + " Weekend? " + weekday + " Peak-Time? " + peak );
	}
	
	public static void main(String[] args){
		
	}
}