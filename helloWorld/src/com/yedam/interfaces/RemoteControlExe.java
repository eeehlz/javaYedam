package com.yedam.interfaces;

import com.yedam.inheritance.ComFriend;
import com.yedam.inheritance.Friend;

public class RemoteControlExe {
	public static void main(String[] args) {

		Friend friend = new ComFriend("", "", "", "");
		RemoteControl rc = new Television();
		System.out.println((RemoteControl.MAX_VOLUME));
		rc.turnOn();
		
		rc = new Radio();
		rc.turnOn();
	}

}
