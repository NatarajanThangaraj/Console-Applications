package com.natarajanthangaraj.calltaxibookingapplication.login;
import com.natarajanthangaraj.calltaxibookingapplication.dto.Person;
import com.natarajanthangaraj.calltaxibookingapplication.utillity.Input;

public class LoginView {
  public LoginViewModel loginViewModel;
  LoginView(){
	  this.loginViewModel=new LoginViewModel(this);
  }
  public int start() {
	return loginViewModel.verifyPersonAndGetID();
	  
  }
 void getTypeOfPerson() {
	System.out.println("+-----------+\n" +
            "| 1.Admin   |\n" +
            "| --------- |\n" +
            "| 2.User    |\n" +
            "+-----------+\n");
	
}
 void  signUpOrSignIn() {
	 System.out.println("+-------------+\n" +
	                    "| 1.SIGN UP   |\n" +
	                    "| ----------- |\n" +
	                    "| 2.SIGN IN   |\n" +
	                    "+-------------+\n");
	
}
 Person getDetails() {
	 Person person =new Person(Input.getString("name"),
			                   Input.getString(" Email Address"),
			                   Input.getString(" Mobile Number "),
			                   Input.getString("  user name "), 
			                   Input.getString("password"));
	return person;
	 
 }
 String getUserName() {
	 return Input.getString("USER NAME ");
 }
 String getPassWord() {
	 return Input.getString("PassWord ");
 }
}
