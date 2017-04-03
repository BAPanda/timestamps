package dao;

import java.math.BigInteger;

import models.Statistics;

public interface StatisticsDAO {
	
	public Statistics getForEntity(BigInteger ID);

}
