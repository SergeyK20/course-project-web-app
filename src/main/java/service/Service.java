package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {

    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
