package ch07.exam02;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		DmbCellPhone dcp = new DmbCellPhone("자바폰", "검정", 10);
		
		System.out.println("모델 ▶ " + dcp.model);
		System.out.println("색상 ▶ " + dcp.color);
		System.out.println("채널 ▶ " + dcp.channel);
		
		//부모 Method
		dcp.powerOn();		
		dcp.bell();			
		dcp.sendVoice("여보세요");
		dcp.receiveVoice("안녕하세요 ! 저는 ★★★ 인데요");
		dcp.hangUp();
		
		//자식 Method
		dcp.turnOnDmb(dcp.channel);
		dcp.changeCannelDmb(15);
		dcp.turnOffDmb();

	}

}
