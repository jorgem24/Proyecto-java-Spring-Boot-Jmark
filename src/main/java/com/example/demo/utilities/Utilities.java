package com.example.demo.utilities;

import com.example.demo.model.ActivityLog;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

import java.sql.Timestamp;
import java.util.UUID;

public class Utilities {

    public static ActivityLog createLog(HttpServletRequest request, String operationMethod, String domain,
                                        String status, String endpoint, String restMethod ){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ip = request.getRemoteAddr();
        ActivityLog activityLog = null;
        activityLog = new ActivityLog();
        //System.out.println(activityLog);

        String uniqueID = UUID.randomUUID().toString();

        activityLog.setOperationMethod(operationMethod);
        activityLog.setDomain(domain);
        activityLog.setId(uniqueID);
        activityLog.setIp(ip);
        activityLog.setTime(timestamp);
        activityLog.setUser("anonymous");
        activityLog.setStatus(status);
        activityLog.setEndpoint(endpoint);
        //activityLog.setVersion("1.0");
        activityLog.setRestMethod(restMethod);

        return activityLog;
    }


    public static HttpHeaders createHeader(ActivityLog activityLog){

        HttpHeaders headers = null;
        headers = new HttpHeaders();

        headers.add("Operation", activityLog.getOperationMethod());
        headers.add("Version", activityLog.getVersion());
        headers.add("Domain", activityLog.getDomain());
        headers.add("Status", activityLog.getStatus());
        headers.add("TimestampServer", activityLog.getTime().toString());
        headers.add("id", activityLog.getId());
        headers.add("User", activityLog.getUser());
        headers.add("endpoint", activityLog.getEndpoint());
        headers.add("IPAddress", activityLog.getIp());
        headers.add("RestMethod", activityLog.getRestMethod());

        return headers;


    }
}
