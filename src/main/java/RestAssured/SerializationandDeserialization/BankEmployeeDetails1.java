package RestAssured.SerializationandDeserialization;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;



import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class BankEmployeeDetails1 {

	
		// TODO Auto-generated method stub
       public void Serialization() throws IOException
       {
		BankEmployeeDetails baempdet=new BankEmployeeDetails();
		baempdet.setBankID("BA134567");
		baempdet.setEmployeeName("VenuGopal");
		baempdet.setDesignation("Senior Manager");
		System.out.println("Bank Employee Detail -Serialization");
		ObjectMapper om=new ObjectMapper();
		String BankEmpDetail=om.writerWithDefaultPrettyPrinter().writeValueAsString(baempdet);
		FileWriter file=new FileWriter("BankEmployeeDetail.json");
		file.write(BankEmpDetail);
		file.close();
		}
       
       public void Deserialization() throws StreamReadException, DatabindException, IOException
       {
    	   System.out.println("Bank Employee Detail -Deserialization");
    	   File file=new File("BankEmployeeDetail.json");
    	   ObjectMapper om=new ObjectMapper();
    	  BankEmployeeDetails bed =om.readValue(file, BankEmployeeDetails.class);
    	  System.out.println("BANK ID: " +bed.getBankID());
    	  System.out.println("BANK EMPLOYEE DESIGNATION: " +bed.getDesignation());
    	  System.out.println("BANK EMPLOYEE NAME: " +bed.getEmployeeName());
    	   
       }
       public static void main(String[] args) throws IOException  {
    	  BankEmployeeDetails1 BankEmpDet1=new BankEmployeeDetails1();
    	  BankEmpDet1.Serialization();
    	  BankEmpDet1.Deserialization();
    	  
	}

}
