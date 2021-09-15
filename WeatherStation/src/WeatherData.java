import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);

		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for(Observer ob : observers) {
			ob.update(temperature, humidity, pressure);
		}

	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		
		measurementsChanged();
	}
	
	public float getTemperature() {
		return this.temperature;
	}
	
	public float getHumidity() {
		return this.humidity;
	}
	
	public float getPressure() {
		return this.pressure;
	}
	// other WeatherData methods here

}
