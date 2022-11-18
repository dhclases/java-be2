package com.pluralsight.functionaltechniquesjava.m4creatingreusablefunctions;

import java.util.function.Function;

public class ArgumentOrderExample {

    public static void main(String args[]) {
        /* Arguments: pointValue, numberOfPoints, total */

        /* A bad example */
        /*Function<Double,
                Function<Double,
                        Function<Integer, Double>>> applyReward =
                            total -> pointValue -> numberOfPoints -> total - (pointValue * numberOfPoints);

        Function<Double, Function<Integer, Double>> applyReward$5Total = applyReward.apply(10.0);
        Function<Double, Function<Integer, Double>> applyReward$6Total = applyReward.apply(6.0);
        Function<Double, Function<Integer, Double>> applyReward$7Total = applyReward.apply(7.0);*/

        /* Another bad example */
        /*Function<Integer,
                Function<Double,
                        Function<Double, Double>>> applyReward =
                            numberOfPoints -> pointValue -> total -> total - (pointValue * numberOfPoints);

        Function<Double, Function<Double, Double>> applyReward50Points = applyReward.apply(50);*/

        /* Good example */
        Function<Double,
                Function<Integer,
                        Function<Double, Double>>> applyReward =
                pointValue ->  numberOfPoints -> total -> total - (pointValue * numberOfPoints);

        Function<Integer, Function<Double, Double>> applyNormalReward = applyReward.apply(1.00);
        Function<Integer, Function<Double, Double>> applyVIPReward = applyReward.apply(2.00);

        System.out.println( applyNormalReward.apply(5).apply(10.0) ); // $5 Discount
        System.out.println( applyVIPReward.apply(5).apply(10.0) ); // $10 Discount!
    }

    /* Function that receives the three arguments at the same time */
    public Double applyReward(Double pointValue, Integer numberOfPoints, Double total) {
        return total - (pointValue * numberOfPoints);
    }
}
