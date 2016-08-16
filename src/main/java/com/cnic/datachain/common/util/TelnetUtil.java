package com.cnic.datachain.common.util;

import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.regex.Pattern;

/**
 * Created by xjzhu@cnic.cn on 2015/11/24.
 */

public class TelnetUtil {
    private TelnetClient telnetClient;
    private InputStream inputStream;
    private OutputStream outputStream;
    private long timeout=30000;//默认超时为30秒
    /**
     * 建立telnet连接
     * @param hostIp 服务器Ip
     * @param port   端口号  telnet 默认端口号为23
     * @param userName  登陆账号
     * @param password 登陆密码
     * @throws IOException
     * @throws SocketException
     */
    public void connect(String hostIp,int port,String userName,String password) throws SocketException, IOException{
        telnetClient=new TelnetClient();
        telnetClient.connect(hostIp, port);
        inputStream=telnetClient.getInputStream(); //接收服务器消息的输入流
        outputStream=telnetClient.getOutputStream();	 //发送消息到服务器的输出流
        //连接完毕，服务器就等待客户发送 用户名，然后是密码
        if(sendLoginInfo(userName,".*PASSWORD:")){//假如发送完用户名后得到的提示符是密码提示符
            sendLoginInfo(password, "//]//$"); //假如发送密码信息后得到的提示符是命令提示符
        }
    }
    private boolean sendLoginInfo(String info,String regext){
        Pattern pattern=Pattern.compile(regext);
        try {
            outputStream.write((info+"/n").getBytes());
            outputStream.flush();
            int i=-1;
            StringBuilder sb=new StringBuilder();
            long startTime=System.currentTimeMillis();
            while(System.currentTimeMillis()-startTime<timeout){
                while( (i=(char) inputStream.read())>-1){
                    if(i==-1){
                        throw  new IllegalArgumentException("接收不到消息");
                    }
                    char ch=(char)i;
                    if(ch=='\n'||ch=='\r'){ //命令提示符是最后在一行的
                        sb.delete(0, sb.length());
                        continue;
                    }
                    sb.append((char)ch);

                    if(pattern.matcher(sb.toString()).find()){
                        return true;
                    }
                }
            }
            throw  new IllegalArgumentException("超时收不到提示符");
        } catch (IOException e) {
            close();
            return false;
        }
    }

    public String send(String cmd){
        if(null==telnetClient||null==inputStream||null==outputStream){
            throw  new IllegalArgumentException("请先 建立连接 或建立连接失败");
        }
        Pattern pattern=Pattern.compile("//]//$");//假如命令提示符为 /$
        StringBuilder text=new StringBuilder();
        try {
            outputStream.write((cmd+"/n").getBytes());
            outputStream.flush();
            StringBuilder sb=new StringBuilder();
            long startTime=System.currentTimeMillis();
            int i=-1;
            while(System.currentTimeMillis()-startTime<timeout){
                while( (i=inputStream.read())>-1){
                    if(i==-1){
                        throw  new IllegalArgumentException("接收不到消息");
                    }
                    char ch=(char)i;
                    text.append(ch);
                    if(ch=='\n'||ch=='\r'){
                        sb.delete(0, sb.length());
                        continue;
                    }
                    sb.append(ch);
                    if(pattern.matcher(sb.toString()).find()){//返回字符流中找到了命令提示符
                        return text.toString();
                    }
                }
            }
            throw  new IllegalArgumentException("超时收不到提示符");
        } catch (IOException e) {
            close();
            return null;
        }
    }
    public void close(){
        if(null!=null){
            try {
                telnetClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws SocketException, IOException {
        TelnetUtil telnet=new TelnetUtil();
        telnet.connect("ip"	, 23, "username", "passowrd");
        System.out.println(telnet.send("ls"));
        telnet.close();
    }
}

