package Group2;


	import java.text.SimpleDateFormat;
		import java.util.*;
		import java.io.*;
		 
		public class HospitalProcess {
		 
		static ArrayList<Patient> arl  = new ArrayList<Patient>();
		static String joindate;
		 
		public static void main(String[] args) throws IOException {
		 
		char l='i';
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
		joindate = formatter.format(currentDate.getTime());
		 
		Patient p1 = new Patient(1,"Raja", "Miyapur,Hyderabad", 40, 'm', "Fever", 250f,joindate);
		arl.add(p1);
		
		
		
		 
		do
		{
		Patient p = new Patient();
		System.out.println("Please Enter: \n 1. To Register a Patient \n 2. To Update Patient Details \n 3. To Deactivate Patient Details \n 4. To Display Patient Details");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = Integer.parseInt(br.readLine());
		 
		switch(choice)
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
		}while(l=='y');
		}/*End of main() method */
		 
		}
		 
		/************** End of HospitalProcess class ******************/
		 
		 
		/************ Patient class to implement operations  *******************/
		 
		class Patient implements Comparable<Patient> {
		 
		int patientID;
		String patientName;
		String patientAddress;
		int age;
		char patientSex;
		String patientIllness;
		float amountForAppointment;
		String joindate;
		 
		HospitalProcess hm = new HospitalProcess();
		 
		Patient() {}
		 
		 
		public int compareTo(Patient p)
		{
		return this.patientID = p.patientID;
		}
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		Patient(int patientID,String patientName,String patientAddress,int age,char patientSex,String patientIllness,float amountForAppointment, String joindate)
		{
		this.patientID=patientID;
		this.patientName=patientName;
		this.patientAddress=patientAddress;
		this.age=age;
		this.patientSex=patientSex;
		this.patientIllness=patientIllness;
		this.amountForAppointment=amountForAppointment;
		this.joindate = joindate;
		}
		 
		void registerPatient()throws IOException //function to insert new patient records
		{
		Patient pr = new Patient();
		@SuppressWarnings("static-access")
		int patientID= hm.arl.size();
		pr.patientID = patientID+1;
		System.out.println("Enter Patient name:");
		pr.patientName = br.readLine();
		System.out.println("Enter Patient Address:");
		pr.patientAddress = br.readLine();
		System.out.println("Enter Patient Age:");
		pr.age = Integer.parseInt(br.readLine());
		System.out.println("Enter Patient Sex:");
		String temp = br.readLine();
		pr.patientSex =temp.charAt(0);
		System.out.println("Enter Patient Illness:");
		pr.patientIllness = br.readLine();
		System.out.println("Enter the amount patient needs to pay for appointment:");
		pr.amountForAppointment = Float.parseFloat(br.readLine());
		pr.joindate = hm.joindate;
		hm.arl.add(pr);
		}
		 
		@SuppressWarnings("static-access")
		void removeInactivePatient() throws IOException //function to remove patient records
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Patient ID:");
		int id1 = Integer.parseInt(br.readLine());
		for(int i=0; i<hm.arl.size(); i++)
		{
		if(id1 != hm.arl.get(i).patientID)
		{
		
		System.out.println("Patient with the entered ID does not exist");
		}
		else if(id1 == hm.arl.get(i).patientID)
		{
		hm.arl.remove(i);
		System.out.println("Patient deleted as his validity expired");
		}
		}
		}

		/*Function to update patient records*/
		void updatePatientDetails() throws IOException
		{
		char l='n';
		Patient p2 = new Patient(patientID, patientName, patientAddress, age, patientSex, patientIllness, amountForAppointment, joindate);
		do{
		System.out.println("Enter patient ID you want to update:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idnum = Integer.parseInt(br.readLine());
		for(int i=0; i<hm.arl.size(); i++)
		{
		if(idnum == hm.arl.get(i).patientID)
		{
		System.out.println("Enter: \n 1 To Change Patient's Name \n 2 To Change Patient's Address \n 3 To Change Patient's Age \n 4 To Change Patient's Illness \n 5 To Change Registration Fees along with the Medical Expenses");
		int ch = Integer.parseInt(br.readLine());
		 
		switch(ch)
		{
		case 1:
		System.out.println("Enter new patient's name:");
		p2.patientName = br.readLine();
		p2.patientID= hm.arl.get(i).patientID;
		p2.patientAddress= hm.arl.get(i).patientAddress;
		p2.age=hm.arl.get(i).age;
		p2.patientSex=hm.arl.get(i).patientSex;
		p2.patientIllness = hm.arl.get(i).patientIllness;
		p2.amountForAppointment = hm.arl.get(i).amountForAppointment;
		p2.joindate = hm.arl.get(i).joindate;
		hm.arl.set(i,p2);
		System.out.println("Patient updated !!!");
		break;
		 
		case 2:
		System.out.println("Enter new patient Address:");
		p2.patientAddress = br.readLine();
		p2.patientID = hm.arl.get(i).patientID;
		p2.patientName = hm.arl.get(i).patientName;
		p2.age = hm.arl.get(i).age;
		p2.patientSex = hm.arl.get(i).patientSex;
		p2.patientIllness = hm.arl.get(i).patientIllness;
		p2.amountForAppointment = hm.arl.get(i).amountForAppointment;
		p2.joindate = hm.arl.get(i).joindate;
		hm.arl.set(i,p2);
		System.out.println("Patient updated !!!");
		break;
		 
		case 3:
		System.out.println("Enter new Patient age:");
		p2.age = Integer.parseInt(br.readLine());
		p2.patientID = hm.arl.get(i).patientID;
		p2.patientName = hm.arl.get(i).patientName;
		p2.patientAddress = hm.arl.get(i).patientAddress;
		p2.patientSex = hm.arl.get(i).patientSex;
		p2.patientIllness = hm.arl.get(i).patientIllness;
		p2.amountForAppointment = hm.arl.get(i).amountForAppointment;
		p2.joindate= hm.arl.get(i).joindate;
		hm.arl.set(i,p2);
		System.out.println("Patient updated !!!");
		break;
		 
		case 4:
		System.out.println("Enter new Patient illness:");
		p2.age = hm.arl.get(i).age;
		p2.patientID= hm.arl.get(i).patientID;
		p2.patientName = hm.arl.get(i).patientName;
		p2.patientAddress = hm.arl.get(i).patientAddress;
		p2.patientSex = hm.arl.get(i).patientSex;
		p2.patientIllness = br.readLine();
		p2.amountForAppointment = hm.arl.get(i).amountForAppointment;
		p2.joindate = hm.arl.get(i).joindate;
		hm.arl.set(i,p2);
		System.out.println("Patient updated !!!");
		break;
		 
		case 5:
		System.out.println("Enter the new amount that patient needs to pay:");
		p2.age = hm.arl.get(i).age;
		p2.patientID = hm.arl.get(i).patientID;
		p2.patientName = hm.arl.get(i).patientName;
		p2.patientAddress = hm.arl.get(i).patientAddress;
		p2.patientSex = hm.arl.get(i).patientSex;
		p2.patientIllness = hm.arl.get(i).patientIllness;
		p2.amountForAppointment = Float.parseFloat(br.readLine());
		p2.joindate = hm.arl.get(i).joindate;
		hm.arl.set(i,p2);
		System.out.println("Patient details Updated !!!");
		break;
		 
		default:
		System.out.println("Invalid choice.");
		break;
		} /*End of switch block */
		}/*End of if block */
		} /*End of for block */
		System.out.println("Do you want to continue Updating (y/n):");
		l=(char)br.read();
		}while(l=='y'); /*End of do-while block */
		}
		 
		/* Function to display patients details*/
		void showPatientDetails()
		{
		System.out.println("Patient-ID \t Patient-Name \t Address \t\t Age \t Sex \t Illness \t Fees \t Join-date");
		 
		for(int i=0; i<hm.arl.size(); i++)
		{
		 
		System.out.println(hm.arl.get(i).patientID + " \t\t "+hm.arl.get(i).patientName+" \t\t "+hm.arl.get(i).patientAddress+" \t "+hm.arl.get(i).age+" \t "+hm.arl.get(i).patientSex+" \t "+hm.arl.get(i).patientIllness+" \t\t "+hm.arl.get(i).amountForAppointment+" \t "+hm.arl.get(i).joindate);
		}
		 
		} /********* End of Patient class **************/
	}


