// create basic window with turquoise background

int height = 1280;
int width = 800;
PImage bg;

void setup() {
    fullScreen();
    background(1, 130, 129);
    bg = loadImage("./windows95.png");
    noStroke();
}

void draw() {
    // draw a circle
    image(bg, 0, 0, 200, 200);
    // create new taskbar
    Taskbar taskbar = new Taskbar(width, height);
    //  imageMode(CENTER);
    // fill(255, 255, 255);
    // ellipse(mouseX, mouseY, 50, 50);
}

class Taskbar {
    // color col;
    // Taskbar(int c) {
    //     this.col = color(c);
// }
    
    Taskbar(int width, int height) {
        rect(width, height, width, 50);
        fill(255, 255, 255);
    }
    
    void draw() {
        fill(255);
        rect(0, height - 50, width, 50);
    }
}