package com.controll;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu_Enter extends JPanel/* implements ActionListener,
DocumentListener*/{
	private JTextField name;
	private JTextField num;
	private JTextField classnum;
	protected JComponent panel_underJava;
	protected JComponent panel_underDianlu;
	ButtonGroup sortGroup = new ButtonGroup();
	
	private static JTextField score_1; private static double s1;
	private static JTextField score_2; private static double s2;
	private static JTextField score_3; private static double s3;
	private static JTextField score_4; private static double s4;
	private static JTextField score_5; private static double s5;
	private static JTextField score_test; private static double st;
	private static JTextField score2; private static double s_2;
	private static JTextField score2_test; private static double s_2t;
	private static double escore1;private static double escore2;
	public String term1="大三上";
	JButton button;
	
	Hashtable<String, Person> has = new Hashtable<String, Person>();// 哈希表，加密，文件乱码   
	File file = new File("学生信息.txt");// 新建一个文件
	String wenjian="学生信息0.txt"; //
	
	public menu_Enter() {
		
		
		if (!file.exists()) {
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));// 把一个实例的对象以文件的形式保存到磁盘上。		out.writeObject(has);
				out.close();
			} catch (IOException e) {
			}

		}
		
		setBounds(0, 100, 684, 387);
		setLayout(null);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(47, 60, 54, 15);
		add(label);
		
		name = new JTextField(); //姓名
		name.setBounds(92, 57, 85, 21);
		add(name);
		name.setColumns(10);
		
		num = new JTextField();//学号
		num.setBounds(248, 57, 85, 21);
		num.setColumns(10);
		add(num);
		
		JLabel label_1 = new JLabel("学号");
		label_1.setBounds(203, 60, 54, 15);
		add(label_1);
		
		classnum = new JTextField();//班级
		classnum.setBounds(413, 57, 85, 21);
		classnum.setColumns(10);
		add(classnum);
		
		JLabel label_2 = new JLabel("班级");
		label_2.setBounds(368, 60, 54, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("学期");
		label_3.setBounds(526, 60, 54, 15);
		add(label_3);
		
		JButton button = new JButton("保存");
		button.addMouseListener(new MouseAdapter() {
			private DefaultButtonModel model;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == button) {
			          //  but3.setEnabled(false);//使but3这个按钮变灰不可点击了
			            String number1 = num.getText();
			            if (number1.length() == 8) {
			                try {
			                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));//读回对象
			                    has = (Hashtable) in.readObject();    in.close();
			                } catch (Exception e1) {
			                }
			                            } 
			            else {
			                JOptionPane.showMessageDialog(null, "请输入8位数字的学号");//提示框显示
			            }
			            //
			            if (number1.length() == 8) {
			            	if(score_1.getText().length()>0 && score_2.getText().length()>0 &&score_3.getText().length()>0
			            			&&score_4.getText().length()>0&&score_5.getText().length()>0&&score_test.getText().length()>0
			            			&&score2.getText().length()>0&&score2_test.getText().length()>0
			            			&&name.getText().length()>0&&classnum.getText().length()>0) {
			            if (has.containsKey(number1)) {JOptionPane.showMessageDialog(null, "该生信息已存在，请点击修改按钮修改！");
			            } else {
			            //	String wenjian="学生信息0.txt"; //
		                   OutputStream os = null;      //
							try {
								os = new FileOutputStream(wenjian,true);// 此处表示在文件末尾追加内容
								os.write("姓名：".getBytes());
				            	os.write(name.getText().getBytes());
				            	os.write("\r\n".getBytes());
				            	
				            	os.write("学号：".getBytes());
				            	os.write(num.getText().getBytes());
				            	os.write("\r\n".getBytes());
				            	
				            	os.write("班级：".getBytes());
				            	os.write(classnum.getText().getBytes());
				            	os.write("\r\n".getBytes());
				            	
				            	os.write("年级：".getBytes());
				            	os.write(term1.getBytes());
				            	os.write("\r\n".getBytes());
				            //	calculate1();
				            //	double a=calculate1();
				            	String str1 = calculate1() ;
				            	byte a[] = str1.getBytes() ;
				            	os.write("JAVA成绩:".getBytes());
				            	os.write(a);
				            	os.write("\r\n".getBytes());
				            	
				            	String str2 = calculate2() ;
				            	byte b[] = str2.getBytes() ;
				            	os.write("电路设计成绩:".getBytes());
				            	os.write(b);
				            	os.write("\r\n".getBytes());
				            //	((ObjectOutputStream) os).writeDouble(calculate1());
				            //	os.write(classnum.getText().getBytes());
				            	
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								}

			       
			            	
			           /* 	os.write("年级:".getBytes());
			            	os.write(term);
			            	os.write("\r\n".getBytes());*/

			            	
			            ////////////////////////////////////////	
			                String name1 = name.getText();
			                String classnum1 = classnum.getText();
			                String term = term1;
			                String Score1 = calculate1();
							String Score2 = calculate2();
			           
			                Person per = null;
			                per = new Person(number1, name1, classnum1, term,Score1,Score2);
			                has.put(number1, per);// ???
			                try {
			                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			                    out.writeObject(has);
			                    out.close();
			               JOptionPane.showMessageDialog(null, "添加成功！");
			                } catch (Exception e1) {}
			            }
			            	}else {
			            		JOptionPane.showMessageDialog(null, "还有信息未输入，请全部输入之后再点击添加。");
			            	}
			            }
					}
			}
		});
		button.setBounds(568, 128, 93, 23);
		add(button);
		
		 // 需要选择的条目
        String[] listData1 = new String[]{"JAVA程序设计", "电路设计"};
		
		String[] listData2 = new String[]{"大三上", "大三下"};
		JComboBox comboBox_1 = new JComboBox(listData2);
		comboBox_1.setBounds(559, 56, 85, 23);
		add(comboBox_1);
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {//判断改变是被选中的值
					if(e.getItem().equals(listData2[0])) {
						term1 ="大三上";
						System.out.print(term1);
					}  //e.getItem().equals(listData1[2])
					else if(e.getItem().equals(listData2[1])) {
						term1 ="大三下";
					}
				}
				else term1 ="大三上";
			}
		});
		
		
		JPanel panel_underDianlu = new JPanel();
		
		panel_underDianlu.setBounds(10, 148, 548, 212);
		add(panel_underDianlu);
		panel_underDianlu.setLayout(null);
	//	if (model.getGroup().isSelected(model))
		
		JLabel label_5 = new JLabel("\u5E73\u65F6\u6210\u7EE9:");
		label_5.setBounds(18, 65, 74, 15);
		panel_underDianlu.add(label_5);
		
		score_1 = new JTextField();
		score_1.setBounds(82, 62, 47, 21);
		panel_underDianlu.add(score_1);
		score_1.setColumns(10);
		
		score_2 = new JTextField();
		score_2.setColumns(10);
		score_2.setBounds(153, 62, 47, 21);
		panel_underDianlu.add(score_2);
		
		score_3 = new JTextField();
		score_3.setColumns(10);
		score_3.setBounds(222, 62, 47, 21);
		panel_underDianlu.add(score_3);
		
		score_4 = new JTextField();
		score_4.setColumns(10);
		score_4.setBounds(291, 62, 47, 21);
		panel_underDianlu.add(score_4);
		
		score_5 = new JTextField();
		score_5.setColumns(10);
		score_5.setBounds(360, 62, 47, 21);
		panel_underDianlu.add(score_5);
		
		JLabel label_6 = new JLabel("考试成绩：");
		label_6.setBounds(417, 65, 75, 15);
		panel_underDianlu.add(label_6);
		
		score_test = new JTextField();
		score_test.setColumns(10);
		score_test.setBounds(488, 62, 47, 21);
		panel_underDianlu.add(score_test);
		
		JLabel label_7 = new JLabel("1");
		label_7.setBounds(69, 65, 23, 15);
		panel_underDianlu.add(label_7);
		
		JLabel label_8 = new JLabel("2");
		label_8.setBounds(139, 65, 23, 15);
		panel_underDianlu.add(label_8);
		
		JLabel label_9 = new JLabel("3");
		label_9.setBounds(210, 65, 23, 15);
		panel_underDianlu.add(label_9);
		
		JLabel label_10 = new JLabel("4");
		label_10.setBounds(279, 65, 23, 15);
		panel_underDianlu.add(label_10);
		
		JLabel label_11 = new JLabel("5");
		label_11.setBounds(349, 65, 23, 15);
		panel_underDianlu.add(label_11);
		
		JLabel lblNewLabel = new JLabel("平时成绩：");
		lblNewLabel.setBounds(18, 144, 65, 15);
		panel_underDianlu.add(lblNewLabel);
		
		score2 = new JTextField();
		score2.setColumns(10);
		score2.setBounds(82, 141, 47, 21);
		panel_underDianlu.add(score2);
		
		score2_test = new JTextField();
		score2_test.setColumns(10);
		score2_test.setBounds(272, 141, 47, 21);
		panel_underDianlu.add(score2_test);
		
		JLabel label_12 = new JLabel("考试成绩：");
		label_12.setBounds(185, 144, 84, 15);
		panel_underDianlu.add(label_12);
		
		JLabel lblJava = new JLabel("JAVA\u7A0B\u5E8F\u8BBE\u8BA1\uFF1A");
		lblJava.setBounds(18, 32, 98, 15);
		panel_underDianlu.add(lblJava);
		
		JLabel label_13 = new JLabel("\u7535\u8DEF\u8BBE\u8BA1\uFF1A");
		label_13.setBounds(18, 107, 98, 15);
		panel_underDianlu.add(label_13);
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button_1) {
					///判断是否有成绩未输入
					
					if(score_1.getText().length()>0 && score_2.getText().length()>0 &&score_3.getText().length()>0&&score_4.getText().length()>0&&score_5.getText().length()>0&&score_test.getText().length()>0&&score2.getText().length()>0&&score2_test.getText().length()>0) {
					String number1 = num.getText();
					try {
						ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
						has = (Hashtable) in.readObject();  //数据存入has中
						in.close();
					} catch (Exception e1) {
					}
					
				if (number1.length() == 8) {
					if (has.containsKey(number1)&&name.getText().length()>0) {
					try {
						String name1 = name.getText();
						String classnum1 = classnum.getText();
						String term = term1;
						String Score1 = calculate1();
						String Score2 = calculate2();
						Person per = new Person(number1, name1, classnum1, term, Score1, Score2);
						has.put(number1, per);  //更新数据
						ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
						out.writeObject(has);
						out.close();
					} catch (Exception e1) {
					}
					JOptionPane.showMessageDialog(null, "修改成功");
					}
					else {JOptionPane.showMessageDialog(null, "该生信息不存在，请重新输入姓名与学号！");}
				}
					else {
						JOptionPane.showMessageDialog(null, "请输入8位数字学号");
					}
				}
					else {
						JOptionPane.showMessageDialog(null, "还有成绩未输入，请全部输入之后再点击修改。");
					}//成绩栏为空时判断
			}
			}
		});
		button_1.setBounds(568, 192, 93, 23);
		add(button_1);
		
		JButton clear = new JButton("清屏");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == clear) {//获得事件所作用的对象

					num.setText(null);
					classnum.setText(null);
					name.setText(null);
					score_1.setText(null);
					score_2.setText(null);
					score_3.setText(null);
					score_4.setText(null);
					score_5.setText(null);
					score_test.setText(null);
					score2.setText(null);
					score2_test.setText(null);
				}
			}
		});
		clear.setBounds(568, 256, 93, 23);
		add(clear);
		
		
	}
/**
 * @return *****/
/*
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
*/
/*	@Override
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/
	public static String calculate1() {  //计算java成绩
		s1=Double.parseDouble(score_1.getText());
		s2=Double.parseDouble(score_2.getText());
		s3=Double.parseDouble(score_3.getText());
		s4=Double.parseDouble(score_4.getText());
		s5=Double.parseDouble(score_5.getText());
		st=Double.parseDouble(score_test.getText());
		escore1 =(s1+s2+s3+s4+s5)/5*0.8+st*0.2;
		String a = escore1 + "";
		System.out.print(escore1);
		System.out.print(" "+a+" \n");
		return String.format("%.2f", escore1).toString();} //保留两位小数
	public String calculate2(){  //计算电路设计成绩
		s_2=Double.parseDouble(score2.getText());
		s_2t=Double.parseDouble(score2_test.getText());
		escore2 =s_2*0.5+s_2t*0.5;
		String b = escore2 + "";
		System.out.print(escore2+" ");
		System.out.print(b);
		return String.format("%.2f", escore2).toString();
	} 
	
}
