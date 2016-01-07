package my.na.covoiturage.dao.car;

import java.util.List;

import my.na.covoiturage.dao.IDAOGeneric;
import my.na.covoiturage.model.Car;

public interface ICarDAO extends IDAOGeneric<Car> {

	List<Car> getByCarOwner(String ownerUserName);
	Car getByCarCode(String code);
}
