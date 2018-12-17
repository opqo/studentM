package com.controll;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;

public class menu_Edit extends JPanel implements ActionListener{
	private JTextField num;
	Hashtable<String, Person> has = new Hashtable<String, Person>();// ��ϣ�����ܣ��ļ�����   
	public menu_Edit() {
		
		setLayout(null);
		JTextArea show = new JTextArea("");
		show.setBounds(84, 130, 381, 167);
		add(show);
		JLabel label = new JLabel("ѧ��");
		label.setBounds(106, 78, 54, 15);
		add(label);
		
		num = new JTextField();
		num.setBounds(150, 75, 83, 21);
		
		add(num);
		num.setColumns(10);
		
		JButton button = new JButton("�鿴�ɼ�");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					String number1 = num.getText();
					if (number1.length() == 8) {
						try {
							ObjectInputStream in = new ObjectInputStream(new FileInputStream("ѧ����Ϣ.txt"));//ֱ�Ӵ��ѱ�����ļ�
							has = (Hashtable) in.readObject();
							in.close();
						} catch (Exception e1) {
						}
						if (has.containsKey(number1)) {
							show.setText("");
							Person per = (Person) has.get(number1);
							String str = "  <ѧ��>��" + per.getNum() + "\n" + "  <����>��" + per.getName() + "\n" +"  <�༶>��" + per.getclassnum() + "\n" + "  <ѧ��>��"
									+ per.getterm() + "\n" + "  <JAVA����������ճɼ�>��" + per.getScore1() + "\n" + "  <��·������ճɼ�>��"
									+ per.getScore2();
							show.append(str);
							System.out.print("����"+per.getName());
							
						} else {
							JOptionPane.showMessageDialog(null, "ѧ�Ų�����");
							show.setText(null);
						}
					} else {
						JOptionPane.showMessageDialog(null, "������8λ����ѧ��");
					}
				}
			}
		});
		button.setBounds(305, 74, 93, 23);
		add(button);
		
		JButton deleteButton = new JButton("ɾ��������Ϣ");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteButton) {
					int n = JOptionPane.showConfirmDialog(null, "ȷ��ɾ����?", "ȷ�϶Ի���", JOptionPane.YES_NO_OPTION);	
					if (n == JOptionPane.YES_OPTION) { 
						String number1 = num.getText();
						if (number1.length() == 8) {
							try {
								ObjectInputStream in = new ObjectInputStream(new FileInputStream("ѧ����Ϣ.txt"));
								has = (Hashtable) in.readObject();
								in.close();
							} catch (Exception e1) {
							}
						} else {
							JOptionPane.showMessageDialog(null, "������8λ���ֵ�ѧ��");
						}
						if (has.containsKey(number1)) {
							has.remove(number1);
							ObjectOutputStream out = null;
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
							try {
								out = new ObjectOutputStream(new FileOutputStream("ѧ����Ϣ.txt"));
								out.writeObject(has);
								out.close();
							} catch (IOException ex) {
								Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);//��¼��ǰ����ܷ������쳣
							}
						} else {
							JOptionPane.showMessageDialog(null, "ѧ�Ų�����");
						}
					//	JOptionPane.showMessageDialog(new JFrame(),"��ɾ��");
					} else if (n == JOptionPane.NO_OPTION) { 
						JOptionPane.showMessageDialog(new JFrame(),"��ȡ��");
					}

				}
			}
		});
		deleteButton.setBounds(430, 74, 127, 23);
		add(deleteButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
