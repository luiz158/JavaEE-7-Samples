package org.javaee7.jsontest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws JSONException {

        String jsonStr = "{"
                + "  \"apple\":\"red\","
                + "  \"banana\":\"yellow\""
                + "}";
        JSONObject jsonobject = new JSONObject(jsonStr);
        System.out.println(jsonobject.getString("apple"));
    }
}
