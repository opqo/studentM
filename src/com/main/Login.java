package com.main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.controll.menu;

class LoginCheck{
    private String name;
    private String password;
    public LoginCheck(String name,String password){
        this.name=name;
        this.password=password;
    }
    public boolean equals(){
        if("admin".equals(name)&&"admin".equals(password)){
            return true;
        }else{
            return false;
        }
    }
};
class ActionHandle{
    private JFrame frame=new JFrame("ѧ����Ϣ����ϵͳ");
    private JTextField name=new JTextField();//�����ı���
    private JPasswordField pass=new JPasswordField();
    private JLabel but1=new JLabel("�û���:");
    private JLabel but2=new JLabel("��   ��:");
    private JButton but3=new JButton("��½");
    private JButton but4=new JButton("����");
    
    public ActionHandle(){
        but3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==but3){
                    String sname=name.getText();
                    String spass=new String(pass.getPassword());
                    LoginCheck log=new LoginCheck(sname,spass);
                    if(log.equals()){
                        try {
                        	com.controll.menu controll= new com.controll.menu();
                        	controll.Me();  //����controll���е�menu���е�Me()����
                        } catch (Exception e1) {
                            
                            e1.printStackTrace();
                        }
                        frame.setVisible(false);
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�������û��������룡");
                    }
                }
            }                   
        });     
        but4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==but4){
                    name.setText("");
                    pass.setText("");
                }
            }

        	});
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); //������ʾ
        but1.setBounds(80, 40 , 80,30);
        name.setBounds(140,40, 120, 30);    //
        but2.setBounds(80, 80 , 80,30);
        pass.setBounds(140,80, 120, 30);
        but3.setBounds(100, 150 , 60,30);
        but4.setBounds(180, 150 , 60,30);
        frame.setSize(400,330);     
        frame.setLocation(300, 200);
        frame.add(but1);
        frame.add(name);
        frame.add(pass);
        frame.add(but2);
        frame.add(but3);
        frame.add(but4);
        frame.setVisible(true);
    }
}

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActionHandle();
	}

}
