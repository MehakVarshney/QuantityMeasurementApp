package com.QuantityMeasurementApp;

public class QuantityMeasurementApp {

    public static void demonstrateEquality(Quantity<?> q1, Quantity<?> q2) {
        System.out.println(q1 + " equals " + q2 + " → " + q1.equals(q2));
    }

    public static <U extends IMeasurable> void demonstrateConversion(
            Quantity<U> q, U target) {

        System.out.println(q + " → " + q.convertTo(target));
    }

    public static <U extends IMeasurable> void demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2, U target) {

        System.out.println(q1 + " + " + q2 + " → " + q1.add(q2, target));
    }

    public static <U extends IMeasurable> void demonstrateSubtraction(
            Quantity<U> q1, Quantity<U> q2, U target) {

        System.out.println(q1 + " - " + q2 + " → " + q1.subtract(q2, target));
    }
    
    public static <U extends IMeasurable> void demonstrateDivision(
            Quantity<U> q1, Quantity<U> q2) {

        System.out.println(q1 + " ÷ " + q2 + " → " + q1.divide(q2));
    }
    
    public static void main(String[] args) {

        // Length example
        Quantity<LengthUnit> length1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(12.0, LengthUnit.INCH);

        demonstrateEquality(length1, length2);

        demonstrateConversion(length1, LengthUnit.INCH);

        demonstrateAddition(length1, length2, LengthUnit.FEET);
        
        demonstrateSubtraction(length1, length2, LengthUnit.FEET);
        demonstrateDivision(length1, length2);


        // Weight example
        Quantity<WeightUnit> weight1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> weight2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        demonstrateEquality(weight1, weight2);

        demonstrateConversion(weight1, WeightUnit.GRAM);

        demonstrateAddition(weight1, weight2, WeightUnit.KILOGRAM);
        
        demonstrateSubtraction(weight1, weight2, WeightUnit.KILOGRAM);
        demonstrateDivision(weight1, weight2);
        
     // Volume example

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> volume3 =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        demonstrateEquality(volume1, volume2);

        demonstrateConversion(volume1, VolumeUnit.MILLILITRE);

        demonstrateAddition(volume1, volume2, VolumeUnit.LITRE);
        demonstrateSubtraction(volume1, volume2, VolumeUnit.LITRE);
        demonstrateDivision(volume1, volume2);
        
    }
}