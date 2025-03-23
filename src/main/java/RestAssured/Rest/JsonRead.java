package RestAssured.Rest;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     ObjectMapper om=new ObjectMapper();
     File file=new File("employeedetail.txt");
     JsonNode jsonnode= om.readTree(file);
     FileWriter filewrite=new FileWriter("createemployee.json");
     filewrite.write(jsonnode.toString());
     filewrite.close();
	}

}
