package com.QuantityMeasurementApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.QuantityMeasurementApp.model.QuantityMeasurementEntity;
import com.QuantityMeasurementApp.util.ConnectionPool;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository{

    private static final String INSERT =

            "INSERT INTO measurement(operation,result) VALUES(?,?)";

    @Override
    public void save(QuantityMeasurementEntity entity){

        try{

            Connection con =
                    ConnectionPool.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(INSERT);

            ps.setString(1,
                    entity.getOperation());

            ps.setString(2,
                    entity.getResult());

            ps.executeUpdate();

        }
        catch(Exception e){

            throw new RuntimeException(
                    "Database save failed");

        }

    }

	@Override
	public List<QuantityMeasurementEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}