package kr.or.dgit.PhoneBookv02.ctrl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import kr.or.dgit.PhoneBookv02.DTO.Phone;

public class PhoneControl {
	private Map<String, Phone> phoneBook;

	public PhoneControl() {
		phoneBook = new HashMap<>();
		phoneBook.put("홍길동", new Phone("홍길동", "대구", "010-1111-1111"));
		phoneBook.put("가나다", new Phone("가나다", "서울", "010-2222-2222"));
		phoneBook.put("나다라", new Phone("나다라", "부산", "010-3333-3333"));
	}

	@Override
	public String toString() {
		return String.format("%s", phoneBook);
	}

	//���� insertPhone()
	public boolean insertPhone(Phone newPhone) {
		if(isExist(newPhone)){
			JOptionPane.showMessageDialog(null, "이름 중복");
			return false;
		}
		phoneBook.put(newPhone.getName(), newPhone);
		return true;
	}
	
	public boolean isExist(Phone newPhone) {
		return phoneBook.containsKey(newPhone.getName());
	}

	//���� deletePhone()
	public void deletePhone(Phone delPhone) {
		if(!isExist(delPhone)){
			JOptionPane.showMessageDialog(null, delPhone.getName()+"존재하지 않음");
			return;
		}
		phoneBook.remove(delPhone.getName());
	}
	
	//ã�� searchPhone()
	public Phone searchPhone(Phone searchPhone) {
		if(!isExist(searchPhone))
			return null;
		return phoneBook.get(searchPhone.getName());
	}

	//��ü showPhones()
	//public void showPhones(PhoneBookMainUI pbMain) {
		/*ShowAllUI ShowAll = new ShowAllUI(phoneBook);
		ShowAll.setPbMain(pbMain);
		ShowAll.setPc(this);
		ShowAll.setVisible(true);*/
		
		//JOptionPane 출력방법
		/*StringBuffer sb = new StringBuffer();
		for(Entry<String, Phone> e : phoneBook.entrySet()){
			sb.append(e.getValue());
			sb.append("\n");
		}
		return sb.toString();*/
	//}
	
	public Object[][] showPhones(){
		Object[][] datas = new Object[phoneBook.size()][];
		
		int i=0;
		for(Entry<String, Phone> e : phoneBook.entrySet()){
			Object[] arr = new Object[4];
			arr[0] = i+1;
			
			//e변수는 Key와 Value를 가지고 있는 Entry. 
			//e.getValue().toArray() : e 변수의 getValue()값을 받아서 toArray()배열 형태로 리턴
			System.arraycopy(e.getValue().toArray(), 0, arr, 1, e.getValue().toArray().length);
			datas[i] = arr;			
			i++;
		}
		return datas;
	}

	public void removePhoneBook(String temp) {
		phoneBook.remove(temp);
	}
}
