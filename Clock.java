public class Clock{
	public int hour;
	public int minute;
	public int second;
	public int year;
	public int month;
	public int day;
	public int[] dayofmonth={31,28,31,30,31,30,31,31,30,31,30,31};
	public Clock (int year,int month,int day,int hour,int minute,int second){
		if(year<1840||year>2020){
			System.err.println("年份不对");
			return;
		}
		if(month<=0||month>12){
			System.err.println("月份不对");
			return;
		}
		if(day<=0||day>CalMonthOfDay(year,month)){
			System.err.println("天数不对");
			return;
		}
		if(hour>24||hour<0){
			System.err.println("钟点数不对");
			return;
		}
		if(minute<0||minute>=60){
			System.err.println("时分数不对");
			return;
		}
		if(second<0||second>=60){
			System.err.println("秒数不对");
			return;
		}
		this.year=year;
		this.month=month;
		this.day=day;
		this.hour=hour;
		this.minute=minute;
		this.second=second; 
	}   
	public int CalMonthOfDay(int year,int month){
		if(month!=2){
			return dayofmonth[month-1];
		}
		if(isLeapYear(year)){
			return 29;
		}
		return 28;
	}
	public boolean isLeapYear(int year){
		if((year%4==0&&year%100!=0)||(year%400==0))
		 return true;
		else
		 return false;
	}
	public Clock after(int seconds){
		Clock other=new Clock(year,month,day,hour,minute,second);
		other.second+=seconds;
		while(other.second>=60){
			other.second-=60;
			other.minute++;
		}
		while(other.minute>=60){
			other.minute-=60;
			other.hour++;
		}
		while(other.hour>24){
			other.hour-=24;
			other.day++;
		}
		while(other.day>CalMonthOfDay(year,month)){
			other.day-=CalMonthOfDay(year,month);
			other.month++;
		}
		while(other.month > 12) {
			other.month-=12;
			other.year ++;
			}
		return other;
	}
	public Clock before(int seconds){
		Clock other=new Clock(year,month,day,hour,minute,second);
		other.second-=seconds;
		while(other.second<0){
			other.second+=60;
			other.minute--;
		}
		while(other.minute<0){
			other.minute+=60;
			other.hour--;
		}
		while(other.hour<0){
			other.hour-=12;
			other.day--;
		}
		while(other.day<CalMonthOfDay(year,month)){
			other.day-=CalMonthOfDay(year,month);
			other.month--;
		}
		while(other.month<=0){
			other.month-=12;
			other.year++;
		}
		return other;
	}
	public String toString(){
		return String.format("%4d-%02d-%02d %02d:%02d:%02d",year,month,day,hour,minute,second);
	}
	public static void main(String[] args){
		Clock n=new Clock(2019,7,21,19,45,30);
		Clock r=n.after(2678400);
		System.out.println(r.toString());
	}
}
