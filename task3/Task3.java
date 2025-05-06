package task3;

import java.io.*;
import java.util.*;
import com.google.gson.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Task3 {

    static Map<Integer, String> MapValues = new HashMap<>();
    static JSONObject tests, values;

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 3) {
            System.out.println("Должно быть 3 аргумента");
            return ;
        }

        try {
            Object obj1 = new JSONParser().parse(new FileReader(args[0]));
            tests = (JSONObject) obj1;
            Object obj2 = new JSONParser().parse(new FileReader(args[1]));
            values = (JSONObject) obj2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ;
        }

        JSONArray vals = (JSONArray) values.get("values");
        for (Object value : vals.toArray()) {
            JSONObject val = (JSONObject) value;
            MapValues.put(Integer.parseInt(val.get("id").toString()),
                    (String)val.get("value").toString());
        }
        addResults((JSONArray) tests.get("tests"));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(tests.toJSONString());
        String prettyJsonString = gson.toJson(je);
        try {
            FileWriter fileWriter = new FileWriter(args[2]);
            fileWriter.write(prettyJsonString);
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addResults(JSONArray arr) {
        for (Object value : arr.toArray()) {
            JSONObject val = (JSONObject) value;
            int id = Integer.parseInt(val.get("id").toString());
            if (val.containsKey("value")) val.put("value", MapValues.get(id));
            if (val.containsKey("values")) addResults((JSONArray) val.get("values"));
        }
    }
}