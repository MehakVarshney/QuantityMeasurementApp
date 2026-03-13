package com.QuantityMeasurementApp;

import java.sql.Connection;

import com.QuantityMeasurementApp.controller.*;
import com.QuantityMeasurementApp.repository.*;
import com.QuantityMeasurementApp.service.*;
import com.QuantityMeasurementApp.util.ConnectionPool;
import com.QuantityMeasurementApp.model.*;

public class QuantityMeasurementApp {

    public static void main(String[] args){
    	try{

            Connection con =
                    ConnectionPool.getConnection();

            con.createStatement().execute(

            "CREATE TABLE IF NOT EXISTS measurement(" +
            "id INT AUTO_INCREMENT PRIMARY KEY," +
            "operation VARCHAR(50)," +
            "result VARCHAR(50))");

        }
        catch(Exception e){

            e.printStackTrace();

        }

    	IQuantityMeasurementRepository repo =
    	        new QuantityMeasurementDatabaseRepository();
        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repo);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        QuantityDTO q1 =
                new QuantityDTO(
                        1.0,"FEET","LENGTH");

        QuantityDTO q2 =
                new QuantityDTO(
                        12.0,"INCH","LENGTH");

        controller.performCompare(q1,q2);

        controller.performConvert(q1,"INCH");

        controller.performAdd(q1,q2);

        controller.performSubtract(q1,q2);

        controller.performDivide(q1,q2);
        
        System.out.println("App Started");
    }
}