package com.controll;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;


import javax.swing.*;

public class menu_View extends JPanel implements ActionListener{
	public static String []number = new String[20];
	public static String []thenumber = new String[20];
	public static String []name = new String[20];
	public static String []term = new String[20];
	public static double []score1 = new double[20];//java�ɼ�
	public static double []score2 = new double[20];//��·��Ƴɼ�
	public static double []thescore = new double[20];//�м�ֵ
	public int i;
	public String head;
	public int flag=1;//�ж�ѡ�еĿγ�1��java ��0:��·���
	Hashtable<String, Person> has = new Hashtable<String, Person>();// ��ϣ�����ܣ��ļ����� 
	private JTextArea textArea_1;
	
	public menu_View() {
		
	//	JTextArea textArea = new JTextArea("");
	//	textArea.setBounds(64, 163, 381, 224);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 139, 353, 234);
		add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(SystemColor.inactiveCaptionBorder);
		scrollPane.setViewportView(textArea_1);
		 head=" ���  |     ѧ��     |     ����     |     �γ�     |     �ɼ�  "+"\n";
		textArea_1.append(head);
		setLayout(null);
		
		JLabel label = new JLabel("�γ�");
		label.setBounds(64, 77, 54, 15);
		add(label);
		
		JButton findButton = new JButton("��ѯ");
		findButton.setBounds(240, 73, 93, 23);
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == findButton) {
				//	String number1 =textField.getText();
				//	paixu();//���γ�Ĭ�Ͻ�������
					try {
						ObjectInputStream in = new ObjectInputStream(new FileInputStream("ѧ����Ϣ.txt"));//ֱ�Ӵ��ѱ�����ļ�
						has = (Hashtable) in.readObject();
						in.close();
					} catch (Exception e1) {
					}
					textArea_1.setText(head);//���²�ѯ��ť�������Ļ���������Ŀ��
					int I=studentarray();//
					System.out.print(flag+"\n"+I+"\n");
					if(flag==1) {//ѡ��java			
						for(int j=0;j<I;j++) {
							thescore[j]=score1[j];
							thenumber[j]=number[j];
							System.out.print(thescore[j]+"\n"+thenumber[j]+"\n");
						}
						for(int m=0;m<I-1;m++) {//ð������
							for(int j=0;j<I-1-m;j++) {
								if(thescore[j]>thescore[j+1]) {
									double temp=thescore[j];
									String nu=thenumber[j];
									thescore[j]=thescore[j+1];
									thenumber[j]=thenumber[j+1];
									thescore[j+1]=temp;
									thenumber[j+1]=nu;
								}
							}
						}
						
						for(int j=0;j<I;j++) {
							System.out.print(thescore[j]+"\n ѧ��"+thenumber[j]);
							Person per = (Person) has.get(thenumber[j]);
							int n=j+1;
							String str ="    "+n+"    "+ per.getNum() + "    " +per.getName() + "   " +"JAVA�������" +"    "+ per.getScore1() + "\n" ;
							textArea_1.append(str);
						}
					///	������ı�����
						
					}
					else if(flag==0) {//ѡ�����
						for(int j=0;j<I;j++) {
							thescore[j]=score2[j];
							thenumber[j]=number[j];
							System.out.print(thescore[j]+"\n"+thenumber[j]+"\n");
						}
						for(int m=0;m<I-1;m++) {//ð������
							for(int j=0;j<I-1-m;j++) {
								if(thescore[j]>thescore[j+1]) {
									double temp=thescore[j];
									String nu=thenumber[j];
									thescore[j]=thescore[j+1];
									thenumber[j]=thenumber[j+1];
									thescore[j+1]=temp;
									thenumber[j+1]=nu;
								}
							}
						}
						
						for(int j=0;j<I;j++) {
							System.out.print(thescore[j]+"\n ѧ��"+thenumber[j]);
							Person per = (Person) has.get(thenumber[j]);
							int n=j+1;
							String str ="    "+n+"    "+ per.getNum() + "   " +per.getName() + "    " +"��·���" +"    "+ per.getScore2() + "\n" ;
							textArea_1.append(str);
						}
					}		
					
				}
			}
		});
		add(findButton);
		String[] listData1 = new String[]{"JAVA�������", "��·���"};
		JComboBox comboBox = new JComboBox(listData1);
		comboBox.setBounds(96, 73, 109, 23);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {//�жϸı��Ǳ�ѡ�е�ֵ
					if(e.getItem().equals(listData1[0])) {
						flag =1;
						System.out.print(flag);  //����
					}  //e.getItem().equals(listData1[2])
					else if(e.getItem().equals(listData1[1])) {
						flag =0;
					}
				}
				else flag =1;;
			}
		});
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("��ȡ�����ļ������γ�����");
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setBounds(64, 29, 227, 15);
		add(lblNewLabel);
		
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int studentarray() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("ѧ����Ϣ.txt"));//ֱ�Ӵ��ѱ�����ļ�
			has = (Hashtable) in.readObject();
			in.close();
		} catch (Exception e1) {
		}
		int i=0;
		for (Enumeration enu = has.elements(); enu.hasMoreElements();) {
			Person per = (Person) enu.nextElement();
			number[i]=per.getNum();
			name[i]=per.getName();
			term[i]=per.getterm();
			score1[i]=Double.parseDouble(per.getScore1());
			score2[i]=Double.parseDouble(per.getScore2());
			i++;
		}
		for(int j=0;j<i;j++)
		{
			System.out.print("����"+number[j]+" "+name[j]+" "+term[j]+" "+score1[j]+" "+score2[j]);
			System.out.print("\n");
		}//���������	
		return i;
	}
}
