package com.controll;

import javax.swing.JFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
** @author   zfz 
*/ 
public class menu {
/*******/	
	menu_Enter enterPanel = new menu_Enter();
	menu_Edit editPanel = new menu_Edit();
	menu_View viewPanel = new menu_View();
	private JFrame jf=new JFrame("学生信息管理系统");
	JPanel Panel=new JPanel();
	JMenuBar menubar=new JMenuBar();

	

	/**
	 * @wbp.parser.entryPoint
	 */
//	Hashtable<String, Person> has = new Hashtable<String, Person>();// 哈希表，加密，文件乱码   
//	public File file = new File("学生信息.txt");// 新建一个文件
	
	public void Me(){

		enterPanel.setVisible(true);   
		editPanel.setVisible(false); 
		viewPanel.setVisible(false); 

		
	jf.setVisible(true);  //
	jf.setSize(687,453);
	jf.setLocationRelativeTo(null); //使界面居中显示
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JMenuBar menuBar_1 = new JMenuBar();
	jf.setJMenuBar(menuBar_1);
	
	JMenu Menu_En = new JMenu("录入成绩");   
	Menu_En.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			enterPanel.setVisible(true);   
			editPanel.setVisible(false); 
			viewPanel.setVisible(false); 
		}
	});
	menuBar_1.add(Menu_En);
	
	JMenu Menu_Ed = new JMenu("学生成绩查询");
	Menu_Ed.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			enterPanel.setVisible(false);   
			editPanel.setVisible(true); 
			viewPanel.setVisible(false); 
		}
	});
	menuBar_1.add(Menu_Ed);
	
	JMenu menu_Vi = new JMenu("课程成绩排名");
	menu_Vi.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			enterPanel.setVisible(false);   
			editPanel.setVisible(false); 
			viewPanel.setVisible(true); 
		}
	});
	menuBar_1.add(menu_Vi);
	
	jf.setContentPane(Panel);
	Panel.setLayout(null);
	enterPanel.setBounds(0, 0, 666, 487);
	Panel.add(enterPanel); //加入录入成绩界面
	editPanel.setBounds(0, 0, 666, 487);
	Panel.add(editPanel); 		
	viewPanel.setBounds(0, 0, 666, 487);
	Panel.add(viewPanel); 
	
	
	
	
	}
}
