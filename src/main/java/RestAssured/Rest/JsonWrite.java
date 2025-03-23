package RestAssured.Rest;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class JsonWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("email", "george22.bluth@reqres.in");
		jsonobject.put("first_name", "GeorgeWilson");
		jsonobject.put("last_name", "Bluth");
		jsonobject.put("id", 1);
		jsonobject.put("avatar", "https://reqres.in/img/faces/1-image.jpg");
		FileWriter file=new FileWriter("createemployee.json");
		file.write(jsonobject.toJSONString());
		file.close();
	}

}
