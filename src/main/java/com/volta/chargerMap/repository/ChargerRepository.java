package com.volta.chargerMap.repository;

import com.volta.chargerMap.model.Charger;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ChargerRepository extends CrudRepository<Charger, String> {
    @Query("SELECT * FROM CHARGER WHERE CHARGER.LONGITUDE= :longitude")
    public Iterable<Charger> retrieveChargersByLongitude(float longitude);
    @Query("SELECT * FROM CHARGER WHERE CHARGER.LONGITUDE= :longitude")
    public Iterable<Charger> retrieveChargersByLatitude(float latitude);
    @Query("SELECT * FROM CHARGER WHERE CHARGER.ID= :id")
    public Iterable<Charger> retrieveCharger(String id);
}
