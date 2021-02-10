package data;


import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;
import org.zkoss.json.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TransDataset {

    private JSONArray data;

    public TransDataset() {
        String resourceName = "./transmusicales_dataset.json";
        JSONParser parser = new JSONParser();

        try {
            //Get file data as JSON
            data = (JSONArray) parser.parse(new FileReader(resourceName, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printStuff(){
        //Get fisrt element
        JSONObject obj = (JSONObject) data.get(0);
        System.out.println(obj);

        //Get a particular field
        JSONObject fields = (JSONObject) obj.get("fields");
        //Retrieve attribute
        String pays = (String) fields.get("origine_pays1");

        System.out.println(pays);
    }

    public JSONArray getData() {
        return data;
    }

    public static void main(String[] args) {
        TransDataset data = new TransDataset();
        data.printStuff();

    }




}


