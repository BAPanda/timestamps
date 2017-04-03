package dao;

import java.math.BigInteger;
import java.util.List;

import models.Entity;

public interface EntityDAO {
	public Entity getByID(BigInteger ID);
	public List<Entity> getAll();
	public Entity getByName(String name);
	
	public void add(Entity entity);
}
