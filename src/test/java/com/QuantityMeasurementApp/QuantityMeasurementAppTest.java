package com.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    // LENGTH TESTS 

    @Test
    void testEquality_FeetToFeet() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToInch() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(12.0, LengthUnit.INCH);

        assertTrue(feet.equals(inch));
    }

    @Test
    void testEquality_YardToFeet() {

        Quantity<LengthUnit> yard =
                new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> feet =
                new Quantity<>(3.0, LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    // CONVERSION 

    @Test
    void testConversion_FeetToInch() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCH);

        assertEquals(12.0, result.getValue());
    }

    @Test
    void testConversion_InchToFeet() {

        Quantity<LengthUnit> inch =
                new Quantity<>(24.0, LengthUnit.INCH);

        Quantity<LengthUnit> result =
                inch.convertTo(LengthUnit.FEET);

        assertEquals(2.0, result.getValue());
    }

    // ADDITION 

    @Test
    void testAddition_FeetPlusInch() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> result =
                feet.add(inch);

        assertEquals(2.0, result.getValue());
    }

    @Test
    void testAddition_TargetUnit() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> result =
                feet.add(inch, LengthUnit.INCH);

        assertEquals(24.0, result.getValue());
    }

    //  WEIGHT TESTS 

    @Test
    void testWeightEquality_KgToGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> g =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(g));
    }

    @Test
    void testWeightConversion_KgToGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> g =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, g.getValue());
    }

    @Test
    void testWeightAddition() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> g =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                kg.add(g);

        assertEquals(2.0, result.getValue());
    }

  

    @Test
    void testLengthVsWeight_NotEqual() {

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    

    @Test
    void testNullComparison() {

        Quantity<LengthUnit> q =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertFalse(q.equals(null));
    }


    @Test
    void testSameReference() {

        Quantity<LengthUnit> q =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertTrue(q.equals(q));
    }

    //  VOLUME TESTS 

    @Test
    void testEquality_LitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    @Test
    void testEquality_GallonToLitre() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> litre =
                new Quantity<>(3.78541, VolumeUnit.LITRE);

        assertTrue(gallon.equals(litre));
    }

    @Test
    void testConversion_LitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                litre.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, ml.getValue(), 1e-6);
    }

    @Test
    void testConversion_GallonToLitre() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> litre =
                gallon.convertTo(VolumeUnit.LITRE);

        assertEquals(3.78541, litre.getValue(), 1e-5);
    }

    @Test
    void testAddition_LitrePlusMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(ml);

        assertEquals(2.0, result.getValue(), 1e-6);
    }

    @Test
    void testAddition_TargetUnit_Millilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(ml, VolumeUnit.MILLILITRE);

        assertEquals(2000.0, result.getValue(), 1e-6);
    }

    @Test
    void testVolumeVsLength_NotEqual() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertFalse(volume.equals(length));
    }

    //  UC12 OPERATIONS

    @Test
    void testSubtraction_FeetMinusInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(6.0, LengthUnit.INCH);

        Quantity<LengthUnit> result = feet.subtract(inch);

        assertEquals(9.5, result.getValue(), 1e-6);
    }

    @Test
    void testDivision_FeetByFeet() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(2.0, LengthUnit.FEET);

        double result = a.divide(b);

        assertEquals(5.0, result);
    }

    @Test
    void testDivision_ByZero() {

        Quantity<LengthUnit> a =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> b =
                new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class,
                () -> a.divide(b));
    }
}