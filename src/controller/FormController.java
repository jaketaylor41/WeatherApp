package controller;




import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import models.Weather;
import dao.WeatherAccessInterface;
import dao.WeatherDataAccessService;


/*
 * Vien Nguyen
 * CST361, Controller class
 * This class will receive requests and redirect the processing.
 */

@ManagedBean
@ViewScoped
public class FormController {
	@Inject
	WeatherAccessInterface<Weather> dataAccessWeather;
	public String readWeather(Weather weather) {
		dataAccessWeather = new WeatherDataAccessService();
		List<Weather> weatherData = dataAccessWeather.read(weather);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("weatherList", weatherData);
		
		return "viewWeather.xhtml";
	}

	

}
