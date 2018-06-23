package sample;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.prefs.Preferences;

import org.json.JSONObject;

public class User {
    static String def="default";
    static String user="user";
    static  JSONObject userdata=null;
    static String baseurl = "http://ec2-13-127-49-132.ap-south-1.compute.amazonaws.com/mv/Servlet?";
    public static String createUser(String htno,String name,String pswd,String jyear,String dept,String course,String section){
        try{
            String action = "createuser";
            String url = baseurl + "action=" + action + "&htno=" + htno + "&name=" + name + "&" +
                    "pswd=" + pswd + "&jyear=" + jyear + "&dept=" + dept + "&section=" + section + "&course=" + course;
            return connect(url);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "error";
    }
    public static String login(String htno,String pswd){
        try {
            String action="login";
            String url=baseurl+"action="+action+"&htno="+htno+"&pswd="+pswd;
            return connect(url);
        }catch (Exception e){
            System.out.println(e);
        }

        return "error";
    }
    private static String connect(String url) throws Exception{
        System.out.println("URL:" + url);
        URL ur = new URL(url);
        HttpURLConnection con = (HttpURLConnection) ur.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();
        return content.toString();
    }

    public static boolean isLoggedIn(){
        Preferences pre=Preferences.systemRoot();
        String res= new String(pre.getByteArray(user,def.getBytes()));
        if(res.equals(def)){
            return false;
        }
        return true;

    }

}
