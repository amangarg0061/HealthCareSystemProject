package Group2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

class User{
 String username;
 String password;
 String phone_no;
 
public User(String username, String password, String phone_no) {
	super();
	this.username = username;
	this.password = password;
	this.phone_no = phone_no;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone_no() {
	return phone_no;
}
public void setPhoneno(String phone_no) {
	this.phone_no = phone_no;
}
@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + ", phoneno=" + phone_no + "]";
} 	
}


	
public class Login extends HospitalProcess {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String userName;
		String passWord;
		String phoneno;
		char l='i';
		
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
		joindate = formatter.format(currentDate.getTime());
		 
		Patient p1 = new Patient(1,"Raja", "Miyapur,Hyderabad", 40, 'm', "Fever", 250f,joindate);
		arl.add(p1);
		
		
		
		ArrayList<User> al=new ArrayList<User>();
		/*
		 * System.out.println("enter number of users: "); int n=sc.nextInt();
		 */
		while(1>0) {
			System.out.println("Choose what you want to do: ");
			int choice;
			System.out.println("Enter 0 for sign up: ");		
			System.out.println("Enter 1 for login : ");
			System.out.println("Enter 2 for exit: ");
			choice =sc.nextInt();
		switch(choice) {
		case 0:
		System.out.println("Enter Username: ");
		userName =sc.next();
		System.out.println("Enter Password: ");
		passWord=sc.next();
		System.out.println("Enter Phone No.: ");
		phoneno=sc.next();
		User c1=new User(userName,passWord,phoneno);	
		al.add(c1);
		Iterator<User> i=al.iterator();
		while(i.hasNext()) {
			User c=i.next();
			System.out.println(c);	
		}
		break;
		case 1:
			System.out.println("Enter Username: ");
			userName =sc.next();
			System.out.println("Enter Password: ");
			passWord=sc.next();
		    int flag=0;
			Iterator<User> i2=al.iterator();
			while(i2.hasNext()) {
				User c=i2.next();
				if(userName.equals(c.username) && passWord.equals(c.password)) {
					System.out.println("Welcome "+userName+"\n How are you?");
					flag=1;
					
					do
					{
					Patient p = new Patient();
					System.out.println("Please Enter: \n 1. To Register a Patient \n 2. To Update Patient Details \n 3. To Deactivate Patient Details \n 4. To Display Patient Details");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					int choice1 = Integer.parseInt(br.readLine());
					 
					switch(choice1)
					{
					case 1:
					p.registerPatient();
					System.out.println("Patient Registered Successfully !!!");
					p.showPatientDetails();
					break;
					case 2:
					p.showPatientDetails();
					p.updatePatientDetails();
					 
					break;
					case 3:
					p.removeInactivePatient();
					break;
					case 4:
					Collections.sort(arl);
					p.showPatientDetails();
					break;
					default:
					System.out.println("Patient does not exist with the Entered ID");
					System.out.println("Try again");
					break;
					}
					 
					System.out.println("Do you want to continue Selecting Options (y/n):");
					l=(char)br.read();
					}
					while(l=='y');
					
				}	
				else flag=0;
			}
			if(flag==0) {
				System.out.println("Invalid User ");
			}
			break;
			
		case 2: System.exit(0);
		}
		}
	}
}