package com.cnic.datachain.common.util;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duyuanyuan on 2015/11/16.
 * good day commander!
 * 通过SSH协议远程执行脚本
 */
public class RemoteShellUtil {

    private RemoteShellUtil(){}

    private static Connection conn;
    //private static String charset = Charset.defaultCharset().toString();
    private static String charset = "UTF-8";

    private static final int TIME_OUT = 1000 * 5 * 60;

    /**
     * 远程登录SSH
     * @param ip
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    private static boolean login(String ip, String username, String password) throws IOException {
        conn = new Connection(ip);
        conn.connect();
        return conn.authenticateWithPassword(username, password);
    }

    public static int execWithParams(String scriptsLocation, String ip, String username, String password, String... param) throws Exception {
        if(param!=null) {
            for(String p : param) {
                scriptsLocation += " "+p;
            }
        }
        return exec(scriptsLocation, ip, username, password);
    }

    /**
     * 执行远程SSH服务器上的脚本
     * @param ip
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public static int exec(String scriptsLocation, String ip, String username, String password) throws Exception {
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr;
        String outErr;
        int ret = -1;
        try {
            if (login(ip, username, password)) {
                Session session = conn.openSession();
                session.execCommand("sh " + scriptsLocation);
                session.execCommand(scriptsLocation);

                stdOut = new StreamGobbler(session.getStdout());
                outStr = processStream(stdOut, charset);

                stdErr = new StreamGobbler(session.getStderr());
                outErr = processStream(stdErr, charset);

                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);

                System.out.println("outStr=" + outStr);
                System.out.println("outErr=" + outErr);

                ret = session.getExitStatus();
            } else {
                throw new Exception("登录远程机器失败" + ip);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            IOUtils.closeQuietly(stdOut);
            IOUtils.closeQuietly(stdErr);
        }
        return ret;
    }

    /**
     * 输出
     * @param in
     * @param charset
     * @return
     * @throws Exception
     */
    private static String processStream(InputStream in, String charset) throws Exception {
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (in.read(buf) != -1) {
            sb.append(new String(buf, charset));
        }
        return sb.toString();
    }

    private static String processStream1(InputStream in, String charset) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            sb.append(line + "\n");
        }
        return sb.toString();
    }

    public static Map<String, String> execCommand(String command, String ip, String username, String password){
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr;
        String outErr;
        Map<String, String> result = new HashMap<String, String>();
        try {
            try {
                if (login(ip, username, password)) {
                    Session session = conn.openSession();
                    session.execCommand(command);

                    stdOut = new StreamGobbler(session.getStdout());
                    outStr = processStream1(stdOut, charset);

                    stdErr = new StreamGobbler(session.getStderr());
                    outErr = processStream1(stdErr, charset);

                    session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);

                    result.put("outStr", outStr);
                    result.put("outErr", outErr);

                } else {
                    throw new Exception("登录远程机器失败" + ip);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            IOUtils.closeQuietly(stdOut);
            IOUtils.closeQuietly(stdErr);
        }
        return result;
    }

    public static void main(String args[]) throws Exception {
        //System.out.println("executeResult=" + RemoteShellUtil.execWithParams("/usr/local/software/scripts/create_new_user.sh", "159.226.50.195", "root", "cnic.cn", "ftp5"));
        //exe.exec("uname -a && date && uptime && who");
        //System.out.println("executeResult=" + RemoteShellUtil.execWithParams("cat /opt/hadoop/logs/yarn-root-resourcemanager-spark-master.log", "10.0.96.60", "root", "cnic.cn"));
        //Map<String, String> result = RemoteShellUtil.execCommand("ls -AF /opt/hadoop/logs", "10.0.96.60", "root", "cnic.cn");
        Map<String, String> result = RemoteShellUtil.execCommand("cat /opt/hadoop/logs/yarn-root-resourcemanager-spark-master.log", "10.0.96.60", "root", "cnic.cn");
        System.out.println(result.get("outStr"));
    }

}
