public class Test{
	public int day;
	public int month;
	public int year;
	public int[] dayofmonth={31,28,31,30,31,30,31,31,30,31,30,31};
	public Test(int year,int month,int day){
		if(year<1840||year>2020){
			System.err.println("超出日历范围");
			return;
		}
		if(month<1||month>12){
			System.err.println("月份超出日历范围");
		    return;
		}
		if(day<1||day>monthofday(month,year)){
			System.err.println("天数超出日历范围");
			return;
		}
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public int monthofday(int month,int year){
		if(month!=2){
			return dayofmonth[month-1];
			
		}
		if(isLeapYear(year)){
			return 29;
		}
		return 28;
	}
	public boolean isLeapYear(int yaer){
		if((year%4==0&&year%100!=0)||(year%400==0))
		return true;
		return false;
	}
	public Test after(int days){
		day+=days;
		while(day>monthofday(month,year)){
			day-=monthofday(month,year);
			month++;
		}
		if(month>12){
			month=1;
			year++;
		}
		return this;
	}	
	public String toString(){
		return String.format("%04d-%02d-%2d",year,month,day);
	}
	public static void main(String[] args){
		Test d=new Test(2019,7,20);
		Test r=d.after(80);
		System.out.println(r.toString());
	}
}