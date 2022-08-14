package katas.kyu6;

public class Assign7 {

    public static int bouncingBall(double h, double bounce, double window) {
        if (h > 0 && bounce > 0 && bounce < 1 && window < h) {
            double bounces = Math.log(window/h)/Math.log(bounce);
            if (bounces > 0 && Math.floor(bounces) == bounces) bounces -= 1;
            return 1 + 2 * (int) Math.floor(bounces);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(bouncingBall(3, 0.66, 1.5));
        System.out.println(bouncingBall(30, 0.66, 1.5));
    }

}
