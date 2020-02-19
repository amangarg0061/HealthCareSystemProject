package Group2;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import  org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Test;

public  class FirtsTestCase
{
   @Test
   public  void  checkingpPatientId()
{SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
Calendar currentDate = Calendar.getInstance();
String joindate = formatter.format(currentDate.getTime());
	   
    Patient p=new Patient(1,"Raja", "Miyapur,Hyderabad", 40, 'm', "Fever", 250f, joindate );
//HospitalProcess hm = new HospitalProcess();
    for(int i=0;i<HospitalProcess.arl.size();i++) {
  Assertions.assertEquals("Aman",HospitalProcess.arl.get(1).patientName);
}}
}

