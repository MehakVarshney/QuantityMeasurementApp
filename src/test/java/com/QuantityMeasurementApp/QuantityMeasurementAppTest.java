package com.QuantityMeasurementApp;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {
	@Test
    void testEquality_SameValue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f2), "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    void testEquality_DifferentValue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);

        assertFalse(f1.equals(f2), "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    void testEquality_NullComparison() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(f1.equals(null), "Feet object should not be equal to null");
    }

    @Test
    void testEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        String nonNumeric = "1.0";

        assertFalse(f1.equals(nonNumeric), "Feet should not be equal to non-numeric object");
    }

    @Test
    void testEquality_SameReference() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f1), "Object must be equal to itself");
    }
    
    
    
    
    //  INCH TEST CASES

    @Test
    void testInchEquality_SameValue() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);

        assertTrue(i1.equals(i2), "1.0 inch should be equal to 1.0 inch");
    }

    @Test
    void testInchEquality_DifferentValue() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(2.0);

        assertFalse(i1.equals(i2), "1.0 inch should not be equal to 2.0 inch");
    }

    @Test
    void testInchEquality_NullComparison() {
        Inches i1 = new Inches(1.0);

        assertFalse(i1.equals(null), "Inches object should not be equal to null");
    }

    @Test
    void testInchEquality_NonNumericInput() {
        Inches i1 = new Inches(1.0);
        String nonNumeric = "1.0";

        assertFalse(i1.equals(nonNumeric), "Inches should not be equal to non-numeric object");
    }

    @Test
    void testInchEquality_SameReference() {
        Inches i1 = new Inches(1.0);

        assertTrue(i1.equals(i1), "Object must be equal to itself");
    }
    
    // UC - 3 
    @Test
    void testEquality_SameUnitSameValue() {
        QuantityLength q1 = new QuantityLength(1.0, Unit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, Unit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_SameUnitDifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, Unit.INCH);
        QuantityLength q2 = new QuantityLength(2.0, Unit.INCH);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToInch() {
        QuantityLength feet = new QuantityLength(1.0, Unit.FEET);
        QuantityLength inch = new QuantityLength(12.0, Unit.INCH);

        assertTrue(feet.equals(inch));
    }

    @Test
    void testEquality_NullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, Unit.FEET);
        assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        QuantityLength q1 = new QuantityLength(1.0, Unit.FEET);
        assertTrue(q1.equals(q1));
    }
    
    
    
    //UC - 4 
    
    @Test
    void testEquality_YardToYard_SameValue() {
        QuantityMeasurementApp.QuantityLength y1 =
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.YARDS);

        QuantityMeasurementApp.QuantityLength y2 =
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.YARDS);

        assertTrue(y1.equals(y2),
                "1.0 yard should be equal to 1.0 yard");
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        QuantityMeasurementApp.QuantityLength y1 =
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.YARDS);

        QuantityMeasurementApp.QuantityLength y2 =
                new QuantityMeasurementApp.QuantityLength(2.0,
                        QuantityMeasurementApp.Unit.YARDS);

        assertFalse(y1.equals(y2),
                "1.0 yard should not be equal to 2.0 yard");
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.YARDS)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(3.0,
                                        QuantityMeasurementApp.Unit.FEET)
                        ),
                "1.0 yard should be equal to 3.0 feet"
        );
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        assertTrue(
                new QuantityMeasurementApp.QuantityLength(3.0,
                        QuantityMeasurementApp.Unit.FEET)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(1.0,
                                        QuantityMeasurementApp.Unit.YARDS)
                        ),
                "3.0 feet should be equal to 1.0 yard"
        );
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        assertTrue(
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.YARDS)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(36.0,
                                        QuantityMeasurementApp.Unit.INCH)
                        ),
                "1.0 yard should be equal to 36.0 inches"
        );
    }

    // ---------- UC4 : CENTIMETERS TESTS ----------

    @Test
    void testEquality_CentimeterToCentimeter_SameValue() {
        QuantityMeasurementApp.QuantityLength c1 =
                new QuantityMeasurementApp.QuantityLength(2.0,
                        QuantityMeasurementApp.Unit.CENTIMETERS);

        QuantityMeasurementApp.QuantityLength c2 =
                new QuantityMeasurementApp.QuantityLength(2.0,
                        QuantityMeasurementApp.Unit.CENTIMETERS);

        assertTrue(c1.equals(c2),
                "2.0 cm should be equal to 2.0 cm");
    }

    @Test
    void testEquality_CentimeterToInches_EquivalentValue() {
        assertTrue(
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.CENTIMETERS)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(0.393701,
                                        QuantityMeasurementApp.Unit.INCH)
                        ),
                "1.0 cm should be equal to 0.393701 inch"
        );
    }

    @Test
    void testEquality_CentimeterToFeet_NonEquivalentValue() {
        assertFalse(
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.CENTIMETERS)
                        .equals(
                                new QuantityMeasurementApp.QuantityLength(1.0,
                                        QuantityMeasurementApp.Unit.FEET)
                        ),
                "1.0 cm should not be equal to 1.0 feet"
        );
    }

    // ---------- UC4 : TRANSITIVE PROPERTY ----------

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.YARDS);

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(3.0,
                        QuantityMeasurementApp.Unit.FEET);

        QuantityMeasurementApp.QuantityLength inch =
                new QuantityMeasurementApp.QuantityLength(36.0,
                        QuantityMeasurementApp.Unit.INCH);

        assertTrue(yard.equals(feet),
                "1 yard should equal 3 feet");

        assertTrue(feet.equals(inch),
                "3 feet should equal 36 inches");

        assertTrue(yard.equals(inch),
                "Transitive property failed: yard → inch");
    }

    // ---------- NULL & REFLEXIVE TESTS ----------

    @Test
    void testEquality_YardSameReference() {
        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.YARDS);

        assertTrue(yard.equals(yard),
                "Object must be equal to itself");
    }

    @Test
    void testEquality_YardNullComparison() {
        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(1.0,
                        QuantityMeasurementApp.Unit.YARDS);

        assertFalse(yard.equals(null),
                "QuantityLength should not be equal to null");
    }


}
