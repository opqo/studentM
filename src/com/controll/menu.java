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
	private JFrame jf=new JFrame("ѧ����Ϣ����ϵͳ");
	JPanel Panel=new JPanel();
	JMenuBar menubar=new JMenuBar();

	

	/**
	 * @wbp.parser.entryPoint
	 */
//	Hashtable<String, Person> has = new Hashtable<String, Person>();// ��ϣ�����ܣ��ļ�����   
//	public File file = new File("ѧ����Ϣ.txt");// �½�һ���ļ�
	
	public void Me(){

		enterPanel.setVisible(true);   
		editPanel.setVisible(false); 
		viewPanel.setVisible(false); 

		
	jf.setVisible(true);  //
	jf.setSize(687,453);
	jf.setLocationRelativeTo(null); //ʹ���������ʾ
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JMenuBar menuBar_1 = new JMenuBar();
	jf.setJMenuBar(menuBar_1);
	
	JMenu Menu_En = new JMenu("¼��ɼ�");   
	Menu_En.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			enterPanel.setVisible(true);   
			editPanel.setVisible(false); 
			viewPanel.setVisible(false); 
		}
	});
	menuBar_1.add(Menu_En);
	
	JMenu Menu_Ed = new JMenu("ѧ���ɼ���ѯ");
	Menu_Ed.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			enterPanel.setVisible(false);   
			editPanel.setVisible(true); 
			viewPanel.setVisible(false); 
		}
	});
	menuBar_1.add(Menu_Ed);
	
	JMenu menu_Vi = new JMenu("�γ̳ɼ�����");
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
	Panel.add(enterPanel); //����¼��ɼ�����
	editPanel.setBounds(0, 0, 666, 487);
	Panel.add(editPanel); 		
	viewPanel.setBounds(0, 0, 666, 487);
	Panel.add(viewPanel); 
	
	
	
	
	}
}
