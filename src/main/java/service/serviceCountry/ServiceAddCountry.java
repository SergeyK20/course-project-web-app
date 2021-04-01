package service.serviceCountry;

import dao.CountryDAO;
import entity.Country;
import service.Service;
import service.ServiceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceAddCountry implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CountryDAO countryDAO = new CountryDAO();

        Country country = new Country();
        country.setNameCountry(request.getParameter("nameCountry"));

        countryDAO.save(country);

        Service service = ServiceUtils.commandDefinition("GET_COUNTRY","GET_COUNTRY");

        return service.execute(request, response);
    }
}
