package com.cnic.datachain.common.util;

/**
 * Created by xjzhu@cnic.cn on 2015/11/26.
 */
public class AgentUrlUtil {

    private static final String AGENT_PORT = PropertyUtil.getInstance().getPropertyValue("openstack.agent_port");
    private static final String HADOOP_PORT = PropertyUtil.getInstance().getPropertyValue("hadoop.port");
    private static final String SPARK_PORT = PropertyUtil.getInstance().getPropertyValue("spark.port");

    public static String getHadoopStatusURL(String masterFixIp){
        String path = "http://" + masterFixIp +":" + AGENT_PORT +"/getHadoopStatus";
        return path;
    }

    public static String getJobStatusURL(String masterFixIp, String applicationId){
        /*String path = "http://" + masterFixIp +":" + AGENT_PORT + "/getJobStatus?jobName=" + jobName + "&jobUUID=" + jobUUId;
        return path;*/
        String path = "http://" + masterFixIp +":8088/ws/v1/cluster/apps/" + applicationId;
        return path;
    }

    public static String getJobApplicationIdURL(String masterFixIp,String jobName, String jobUUId){
        String path = "http://" + masterFixIp +":" + AGENT_PORT + "/getJobApplicationId?jobName=" + jobName + "&jobUUID=" + jobUUId;
        return path;
    }

    public static String getDeployHadoopURL(String masterFixIp){
        String path = "http://" + masterFixIp +":" + AGENT_PORT +"/deploy_hadoop";
        return path;
    }

    public static String getConfigCloudfuseURL(String masterFixIp){
        String path = "http://" + masterFixIp +":" + AGENT_PORT + "/config_cloudfuse";
        return path;
    }

    public static String getRunHadoopJobURL(String masterFixIp){
        String path = "http://" + masterFixIp +":" + AGENT_PORT + "/run_hadoop_job";
        return path;
    }

    public static String getClusterStatusURL(String masterFixIp){
        String path = "http://" + masterFixIp +":8088/ws/v1/cluster";
        return path;
    }

    public static String getClusterNodesStatusURL(String masterFixIp){
        String path = "http://" + masterFixIp +":8088/ws/v1/cluster/nodes";
        return path;
    }

    public static String getDeploySparkURL(String masterFixIp){
        String path = "http://" + masterFixIp +":" + AGENT_PORT +"/deploy_spark";
        return path;
    }

    public static String getRunSparkJobURL(String masterFixIp){
        String path = "http://" + masterFixIp +":" + AGENT_PORT +"/run_spark_job";
        return path;
    }

    public static String getHadoopClusterURL(String masterFixIp){
        String path = "http://" + masterFixIp +":" + HADOOP_PORT + "/ws/v1/cluster";
        return path;
    }

    public static String getSparkClusterURL(String masterFixIp){
        String path = "http://" + masterFixIp +":" + SPARK_PORT + "/json";
        return path;
    }
}
