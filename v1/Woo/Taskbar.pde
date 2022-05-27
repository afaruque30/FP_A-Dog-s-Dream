class Taskbar {
    // color col;
    // Taskbar(int c) {
    //     this.col = color(c);
// }
    
    Taskbar(int width, int height) {
        rect( - 50, height, 4 * width, 50);
        fill(255, 255, 255);
    }
    
    void draw() {
        fill(255);
        rect(0, height - 50, width, 50);
    }
}

