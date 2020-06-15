package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import models.Weather;


@Stateless
@Local(WeatherAccessInterface.class)
@LocalBean
@Alternative
public class WeatherDataAccessService implements WeatherAccessInterface<Weather> {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	List<Weather> weatherData = new ArrayList<>();
	
	Connection conn = null;
	String url = "jdbc:mysql://sq65ur5a5bj7flas.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/aawpey19h7mt74gk?autoReconnect=true&useSSL=false";
	String username = "o3av0hy3ufjsspzh";
	String password = "jc9sn5zc0pgd15mj";
	
	
	public WeatherDataAccessService() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	@Override
	public boolean create(Weather weather) {
		boolean isDataCreated = false;
		String sql = "insert into data(date_time, tempurature, humidity, windspeed, city, state)" + "values ( ?, ?, ?, ?, ?, ?)";
			try {
				conn = DriverManager.getConnection(url, username, password);
	            PreparedStatement st = conn.prepareStatement(sql);
	            st.setString(1, dateFormat.format(date));
	            st.setInt(2, weather.getTemp());      
	            st.setInt(3, weather.getHumidity());      
	            st.setInt(4, weather.getWindSpeed());
	            st.setString(5, weather.getCity());
	            st.setString(6, weather.getState());
	            
	            st.executeUpdate();             
	            conn.close();
	            isDataCreated = true;
	        }
			catch (SQLException e) {
	            e.printStackTrace();
	        }
		return isDataCreated;
	}

	@Override
	public List<Weather> read(Weather weather) {
		
		weatherData.clear();
		
		try {
			String sql = "select * from data";
			conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
           
            while(rs.next())
			{
				Weather w = new Weather();
				w.setDate(rs.getString(2));
				w.setTemp(rs.getInt(3));
				w.setHumidity(rs.getInt(4));
				w.setWindSpeed(rs.getInt(5));
				w.setCity(rs.getString(6));
				w.setState(rs.getString(7));
				weatherData.add(w);
			}
            
            rs.close();
            st.close();
            conn.close();
        }
		catch (SQLException e) {
            e.printStackTrace();
        }
		return weatherData;
	}

	@Override
	public boolean update(Weather t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Weather t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	


}
