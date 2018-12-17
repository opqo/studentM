package com.controll;
import java.io.Serializable;

public class Person implements Serializable {//使用Serializable类，可以使对象被序列化，用于持久化（保存）对象。

	private String num;
	private String name;
	private String classnum;
        private String term; //班级
        private String Score1;
        private String Score2;
        private String sex;
        private String date;
        private String pol;
        private String phone;
	//public Person(){}
	public Person(String num,String name,String classnum,String term,String Score1,String Score2/*,String sex,String date,String pol,String phone*/ ){
		this.num=num;
		this.name=name;
        this.classnum=classnum;
		this.term=term;
		this.Score1=Score1;
		this.Score2=Score2;
                this.sex=sex;
                this.date=date;
                this.pol=pol;
                this.phone=phone;
        }
        public void setNum(String num){
		this.num=num;
	}
	public String getNum(){
		return num;
	} 
	public void setScore1(String Score1){
		this.Score1=Score1;
	}
	public String getScore1(){
		return Score1;
	}
	public void setScore2(String Score2){
		this.Score2=Score2;
	}
	public String getScore2(){
		return Score2;
	}
	public void setclassnum(String classnum){
		this.classnum=classnum;
	}
	public String getclassnum(){
		return classnum;
	}
	public void setterm(String term){
		this.term=term;
	}
	public String getterm(){
		return term;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	///////////
	public String getAddress(){
		return term;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return sex;
	}
	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return date;
	}
	public void setPol(String pol){
		this.pol=pol;
	}
	public String getPol(){
		return pol;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}  

	

}
