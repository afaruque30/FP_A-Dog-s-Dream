

class Calculator {
    private int result;

    public void add(int a, int b) {
        result = a + b;
    }

    public void subtract(int a, int b) {
        result = a - b;
    }

    public void multiply(int a, int b) {
        result = a * b;
    }

    public void divide(int a, int b) {
        result = a / b;
    }

    public int getResult() {
        return result;
    }

    boolean isInTopBar(int x, int y) {
        return x >= 0 && x <= 100 && y >= 0 && y <= 20;
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