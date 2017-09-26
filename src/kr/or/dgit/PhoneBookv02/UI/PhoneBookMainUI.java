package kr.or.dgit.PhoneBookv02.UI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.PhoneBookv02.ctrl.PhoneControl;

@SuppressWarnings("serial")
public class PhoneBookMainUI extends JFrame {

	public static final String[] COL_NAMES = {"번호", "이름", "주소", "연락처"};
	private JPanel contentPane;
	private JTable table;
	private PhoneControl phoneControl;
	
	DefaultTableModel model;

	public PhoneBookMainUI() {
		phoneControl = new PhoneControl();
			
		setTitle("PhoneBook App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 570, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		PhonePanel panel = new PhonePanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel(getDatas(), PhoneBookMainUI.COL_NAMES);
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
	
	private Object[][] getDatas() {
		return phoneControl.showPhones();
	}

}
