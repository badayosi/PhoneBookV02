package kr.or.dgit.PhoneBookv02;

import java.awt.EventQueue;

import kr.or.dgit.PhoneBookv02.UI.PhoneBookMainUI;

public class PhoneBook {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneBookMainUI frame = new PhoneBookMainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
//과제 1 팝업메뉴를 통해 수정/삭제 가능하도록
//추가 1 수정선택시 추가버튼이 수정버튼으로 기능변경
//과제 2 위 내용이 다되면 저장/불러오기/종료 메뉴바 추가
//과제 3 그 외 추가구현하고 싶은기능 있으면 해보도록..