package pl.karolgolec.examples.scheduled.mains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class BaseUrlService {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public String getBaseUrl(){
            String scheme = httpServletRequest.getScheme() + "://";
            String serverName = httpServletRequest.getServerName();
            String serverPort = (httpServletRequest.getServerPort() == 80 || httpServletRequest.getServerPort() == 443) ? "" : ":" + httpServletRequest.getServerPort();
            String contextPath = httpServletRequest.getContextPath();
            return scheme + serverName + serverPort + contextPath;
    }
}
