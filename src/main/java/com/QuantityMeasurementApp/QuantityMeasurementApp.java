package com.QuantityMeasurementApp;

import com.QuantityMeasurementApp.controller.*;
import com.QuantityMeasurementApp.repository.*;
import com.QuantityMeasurementApp.service.*;
import com.QuantityMeasurementApp.model.*;

public class QuantityMeasurementApp {

    public static void main(String[] args){

        IQuantityMeasurementRepository repo =
                QuantityMeasurementCacheRepository
                        .getInstance();

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
    }
}