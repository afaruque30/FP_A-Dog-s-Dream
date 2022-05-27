import java.util.*;

class Calculator {
    private double result;

    public void add(double a, double b) {
        result = a + b;
    }

    public void subtract(double a, double b) {
        result = a - b;
    }

    public void multiply(double a, int b) {
        result = a * b;
    }

    public void divide(double a, double b) {
        result = a / b;
    }
    
    

    public double getResult() {
        return result;
    }

    boolean isInTopBar(int x, int y) {
        return x >= 0 && x <= 100 && y >= 0 && y <= 20;
    }

    void setup() {
      rectMode(CORNER);
      background(293);
    }

    void draw() {
        // draw calculator frame with the operation buttons
        rect(200, 50, 400, 500);
        fill(255);
        textSize(30);
        text("Calculator", 100, 50);
        textSize(20);
    }
}
