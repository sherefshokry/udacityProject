package com.example.dell.sh2tk_online;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DELL on 6/24/2015.
 */

public class userController
{

    public void login(String email, String password)
    {
        String all[] = new String[3];
        all[0] = "http://fci-codezilla256.appspot.com/rest/sh2tk-LoginService";
        all[1] = "email=" + email + "&password=" + password;
        all[2]="login";
        new Connection().execute(all);
    }

    public void getSellFlats()
    {
        String all[] = new String[3];
        all[0] = "http://fci-codezilla256.appspot.com/rest/getsellflat";
        all[1] = "";
        all[2]="sell";
        new Connection().execute(all);
    }

  public void  addAdvertisment(String address,String area ,String price , String description , String Email ,String name )
  {
      String all[] = new String[3];
      all[0] = "http://fci-codezilla256.appspot.com/rest/RegistrationFlatService";
      all[1] = "address=" + address + "&area=" + area + "&price=" + price + "&description=" + description + "&email=" + Email + "&name=" + name ;
      all[2]="register";
      new Connection().execute(all);

  }




    public void signUp(String uname, String email, String password,String phoneNumber,String address)
    {
        String all[] = new String[3];
        all[0] = "http://fci-codezilla256.appspot.com/rest/sh2tk-SignUpService";
        all[1] ="uname=" + uname + "&email=" + email  + "&password=" + password + "&phoneNumber=" + phoneNumber + "&address" + address ;
        all[2]="signup";
        new Connection().execute(all);

    }


    static private class Connection extends AsyncTask<String, String, String> {

String serviceType;


        @Override
        protected String doInBackground(String... params) {
            URL url;
            serviceType=params[2];
            String urlParameters = params[1];

            HttpURLConnection connection;
            try {
                url = new URL(params[0]);

                connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setInstanceFollowRedirects(false);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(60000); // 60 Seconds
                connection.setReadTimeout(60000); // 60 Seconds

                connection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded;charset=UTF-8");
                OutputStreamWriter writer = new OutputStreamWriter(
                        connection.getOutputStream());
                writer.write(urlParameters);
                writer.flush();

                String line, retJson = "";
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

                while ((line = reader.readLine()) != null) {
                    retJson += line;
                }

                return retJson;

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            Toast.makeText(ApplicationContextProvider.getContext(), result, Toast.LENGTH_LONG).show();
            try {




                 if (serviceType.equals("login") ||  serviceType.equals("signup")  ) {
                    JSONObject object = new JSONObject(result);
                    if (!object.has("Status") || object.getString("Status").equals("Failed")) {
                        Toast.makeText(ApplicationContextProvider.getContext(), "Please , Fill All Fields or try again ", Toast.LENGTH_LONG).show();
                        return;
                    }


                    Intent homeIntent = new Intent(ApplicationContextProvider.getContext(), homePage.class);

                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    homeIntent.putExtra("name", object.getString("uname"));
                    homeIntent.putExtra("email", object.getString("email"));
                    ApplicationContextProvider.getContext().startActivity(homeIntent);
                }
                else if ( serviceType.equals("register") ){
                     JSONObject object = new JSONObject(result);
                    Intent homeIntent = new Intent(ApplicationContextProvider.getContext(), homePage.class);

                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					/* here you should initialize user entity */
                    homeIntent.putExtra("name", object.getString("name"));
                    homeIntent.putExtra("email", object.getString("email"));
                    ApplicationContextProvider.getContext().startActivity(homeIntent);

                }
                else if(  serviceType.equals("sell") )
                {
                    JSONArray objectArr = new JSONArray(result);
                    String address = "";
                    for(int i=0;i<objectArr.length();i++)
                    {
                        address+=( objectArr.get(i))+"#";

                    }

                    Intent frReqIntent = new Intent(
                            ApplicationContextProvider.getContext(),
                            sellFlats.class);
                    frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    frReqIntent.putExtra("Address",address);

                    ApplicationContextProvider.getContext().startActivity(frReqIntent);

                }

             }
                catch(JSONException e){
                    // TODO Auto-generated catch block
                    Toast.makeText(ApplicationContextProvider.getContext(), "exception :(", Toast.LENGTH_LONG).show();

                }

            }
        }
    }