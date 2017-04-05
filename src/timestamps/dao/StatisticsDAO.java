package timestamps.dao;

import java.math.BigInteger;

import timestamps.models.Statistics;

public interface StatisticsDAO {
	
	public Statistics getForEntity(BigInteger ID);

}
