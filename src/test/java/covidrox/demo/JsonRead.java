package covidrox.demo;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class JsonRead {

    public static void main(String[] args) {
        String jsonStr = "{\n" +
                "   \"total_rows\":184,\n" +
                "   \"offset\":0,\n" +
                "   \"rows\":[\n" +
                "      {\n" +
                "         \"id\":\"SIT/DRA/2020/001\",\n" +
                "         \"key\":\"SIT/DRA/2020/001\",\n" +
                "         \"value\":{\n" +
                "            \"rev\":\"645-2f3611a220ac5cc86186764304f2e4b5\"\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":\"SIT/DRA/2020/002\",\n" +
                "         \"key\":\"SIT/DRA/2020/002\",\n" +
                "         \"value\":{\n" +
                "            \"rev\":\"630-19697a00a20857b46406c9ed55fa75da\"\n" +
                "         },\n" +
                "         \"counter1\":[\n" +
                "            {\n" +
                "               \"id\":\"1234\",\n" +
                "               \"counter2\":[\n" +
                "                  {\n" +
                "                     \"id\":\"1234\"\n" +
                "                  }\n" +
                "               ]\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   ],\n" +
                "   \"date\":\"12/12/2001\"\n" +
                "}";


        RetrieveAllKeyValueFromJson(jsonStr);

   }


   public static void RetrieveAllKeyValueFromJson(String jsonString){
       JSONObject jsonObject = new JSONObject(jsonString);
       Iterator<String> keys = jsonObject.keys();
       while(keys.hasNext()) {
           String key = keys.next();
           System.out.println(key);
           if(jsonObject.get(key) instanceof JSONArray) {
               JSONArray array = (JSONArray) jsonObject.get(key);
               JSONObject object = (JSONObject) array.get(0);
               Iterator<String> innerKeys = object.keys();
               while(innerKeys.hasNext()) {
                   String innerKey = innerKeys.next();
                   System.out.println(innerKey);
               }
           }
       }
   }
}





