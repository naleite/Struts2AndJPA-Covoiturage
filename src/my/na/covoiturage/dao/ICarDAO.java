package my.na.covoiturage.dao;

import my.na.covoiturage.model.Car;

public interface ICarDAO extends IDAOGeneric<Car> {

	Car getByCarOwner(String ownerUserName);
	Car getByCarCode(String code);
}
