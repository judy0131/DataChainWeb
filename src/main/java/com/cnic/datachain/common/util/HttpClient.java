package com.cnic.datachain.common.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by xjzhu@cnic.cn on 2015/11/12.
 */
public class HttpClient {

    //Get Request
    //path: url
    public static String get(String path) throws Exception{
        HttpURLConnection httpConnection = null;
        BufferedReader in = null;
        try{
            URL url = new URL(path);
            httpConnection=(HttpURLConnection)url.openConnection();

            String tempStr="";
            //read response
            if(httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                StringBuffer content = new StringBuffer();
                in = new BufferedReader( new InputStreamReader(httpConnection.getInputStream()));
                while((tempStr=in.readLine())!=null){
                    content.append(tempStr);
                }
                return content.toString();
            }else{
                throw new Exception("Get Request ERROR!");
            }
        }catch (IOException ex){
            //ex.printStackTrace();
            System.out.println("HttpClient Exception");
        }finally {
            in.close();
            httpConnection.disconnect();
        }
        return null;
    }

    //POST Request
    // path: url
    // params:key1=value1&key2=value2...
    public static String post(String path,String params) throws Exception{
        HttpURLConnection httpConn=null;
        BufferedReader in=null;
        PrintWriter out=null;
        try {
            URL url=new URL(path);
            httpConn=(HttpURLConnection)url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);

            //set post params
            out=new PrintWriter(httpConn.getOutputStream());
            out.println(params);
            out.flush();

            //read response
            if(httpConn.getResponseCode()==HttpURLConnection.HTTP_OK){
                StringBuffer content=new StringBuffer();
                String tempStr="";
                in=new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                while((tempStr=in.readLine())!=null){
                    content.append(tempStr);
                }
                return content.toString();
            }else{
                throw new Exception("Post Request ERROR!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            in.close();
            out.close();
            httpConn.disconnect();
        }
        return null;
    }

    public static boolean ping(String ip){
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        String line = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        boolean res = false;
        try {
            process = runtime.exec("ping " + ip); // PING
            is = process.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                if (line.contains("TTL")) {
                    res = true;
                    break;
                }
            }
            is.close();
            isr.close();
            br.close();
            if (res) {
                System.out.println("ping " + ip + " Successful!");
            } else {
                System.out.println("ping " + ip + " unsuccessful!");
            }
        } catch (IOException e) {
            System.out.println(e);
            runtime.exit(1);
        }
        return res;
    }

}
