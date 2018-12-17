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
	Hashtable<String, Person> has = new Hashtable<String, Person>();// 哈希表，加密，文件乱码   
	public menu_Edit() {
		
		setLayout(null);
		JTextArea show = new JTextArea("");
		show.setBounds(84, 130, 381, 167);
		add(show);
		JLabel label = new JLabel("学号");
		label.setBounds(106, 78, 54, 15);
		add(label);
		
		num = new JTextField();
		num.setBounds(150, 75, 83, 21);
		
		add(num);
		num.setColumns(10);
		
		JButton button = new JButton("查看成绩");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					String number1 = num.getText();
					if (number1.length() == 8) {
						try {
							ObjectInputStream in = new ObjectInputStream(new FileInputStream("学生信息.txt"));//直接打开已保存的文件
							has = (Hashtable) in.readObject();
							in.close();
						} catch (Exception e1) {
						}
						if (has.containsKey(number1)) {
							show.setText("");
							Person per = (Person) has.get(number1);
							String str = "  <学号>：" + per.getNum() + "\n" + "  <姓名>：" + per.getName() + "\n" +"  <班级>：" + per.getclassnum() + "\n" + "  <学期>："
									+ per.getterm() + "\n" + "  <JAVA程序设计最终成绩>：" + per.getScore1() + "\n" + "  <电路设计最终成绩>："
									+ per.getScore2();
							show.append(str);
							System.out.print("姓名"+per.getName());
							
						} else {
							JOptionPane.showMessageDialog(null, "学号不存在");
							show.setText(null);
						}
					} else {
						JOptionPane.showMessageDialog(null, "请输入8位数字学号");
					}
				}
			}
		});
		button.setBounds(305, 74, 93, 23);
		add(button);
		
		JButton deleteButton = new JButton("删除该生信息");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteButton) {
					int n = JOptionPane.showConfirmDialog(null, "确认删除吗?", "确认对话框", JOptionPane.YES_NO_OPTION);	
					if (n == JOptionPane.YES_OPTION) { 
						String number1 = num.getText();
						if (number1.length() == 8) {
							try {
								ObjectInputStream in = new ObjectInputStream(new FileInputStream("学生信息.txt"));
								has = (Hashtable) in.readObject();
								in.close();
							} catch (Exception e1) {
							}
						} else {
							JOptionPane.showMessageDialog(null, "请输入8位数字的学号");
						}
						if (has.containsKey(number1)) {
							has.remove(number1);
							ObjectOutputStream out = null;
							JOptionPane.showMessageDialog(null, "删除成功");
							try {
								out = new ObjectOutputStream(new FileOutputStream("学生信息.txt"));
								out.writeObject(has);
								out.close();
							} catch (IOException ex) {
								Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);//记录当前类可能发生的异常
							}
						} else {
							JOptionPane.showMessageDialog(null, "学号不存在");
						}
					//	JOptionPane.showMessageDialog(new JFrame(),"已删除");
					} else if (n == JOptionPane.NO_OPTION) { 
						JOptionPane.showMessageDialog(new JFrame(),"已取消");
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
