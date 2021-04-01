package service.serviceCountry;

import dao.CountryDAO;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceGetCountry implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CountryDAO countryDAO = new CountryDAO();
        request.setAttribute("countries", countryDAO.getAll());
        return "jsp/country/countries.jsp";
    }
}
