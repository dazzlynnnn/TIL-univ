class TV{
	boolean power; //전원상태(on/off)
	int channel; //채널
	void power() { power = !power;}
	void channelUp() {++channel;}
	void channelDonw() {--channel;}
}

class VCR{
	boolean power; //전원상태(on/off)
	int counter = 0;
	void power() {power = !power;}
	void play() {System.out.println("Play VCR");}
	void stop() {System.out.println("STOP VCR");}
	void rew(){System.out.println("Rewind VCR");}
	void ff(){System.out.println("Fast Forward VCR");}
}

class TVCR extends TV {
	VCR vcr = new VCR(); //has-a 관계
	int counter = vcr.counter;
	void play() {vcr.play();}
	void stop() {vcr.stop();}
	void rew() {vcr.rew();}
	void ff() {vcr.ff();}
	void power() { //오버라이딩
		super.power();
		System.out.println("TVCR power "+(power?"ON":"OFF"));
	}
	void channelUp() {//오버라이딩
		++channel;
		System.out.println("Channel No: "+channel);
	}
	void channelDown() {//오버라이딩
		--channel;
		System.out.println("Channel No: "+channel);
	}

}
public class Lab3 {
	public static void main(String[] args) {
		TVCR myTVCR = new TVCR();
		myTVCR.power();
		myTVCR.channelUp();
		myTVCR.play();
		myTVCR.stop();
	}

}
