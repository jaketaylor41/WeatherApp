package dao;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Weather;

@Path("/data")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class RestWeatherServices {
	
	//This part is different
	
	@SuppressWarnings("unchecked")
	WeatherRestDataAccessServiceInterface<Weather> wea = (WeatherRestDataAccessServiceInterface<Weather>) new WeatherDataAccessService();
	public RestWeatherServices() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/weather/{time}/{tempurature}/{humidity}/{windSpeed}/{city}/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public boolean createWeather(@PathParam("time") String time, @PathParam("tempurature") String tempurature, @PathParam("humidity") String humidity, @PathParam("windSpeed") String windSpeed, @PathParam("city") String city, @PathParam("state") String state) {
		System.out.println("Time: " + time +", Tempurature: " + tempurature +", Humidity: " + humidity + ", Wind Speed: " + windSpeed + " ,City: " + city + " , State: " + state);
		Weather w = new Weather();
		w.setTemp(Integer.parseInt(tempurature));
		w.setHumidity(Integer.parseInt(humidity));
		w.setWindSpeed(Integer.parseInt(windSpeed));
		w.setState(state);
		w.setCity(city);;
		
		wea.create(w);
		return true;
	}
		

}
