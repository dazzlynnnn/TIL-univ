public class Time {
	//==============
	//전공: 사이버보안
	//학번: 1971083
	//성명: 이해린
	//==============
	private int hour; //0~23
	private int minute; //0~59
	
	private boolean isValid(int hour, int minute) { 
		if ((hour>=0 && hour<24) && (minute>=0 && minute<60)) //입력된 시와 분이 범위 내에 있는지 확인
			return true;
		else
			return false;
	}
	
	public void setTime(int hour, int minute) {
		if(this.isValid(hour, minute)==true) { //isValid 결과가 true이면 hour, minute 값을 각각 저장
			this.hour = hour;
			this.minute = minute;
		}
		else { //isValid 결과가 false면 잘못된 입력임을 출력하고 hour, minute 값에 모두 0을 저장
			System.out.println("Wrong Input");
			this.hour = 0;
			this.minute = 0;
		}
	}
	
	public int getTime(char ch) { //문자를 인자로 받아 문자에 따라 hour 또는 minute 다르게 리턴
		if (ch=='h'||ch=='H')
			return hour;
		else if(ch=='m'||ch=='M')
			return minute;
		else
			return 0;
	}
	
}
