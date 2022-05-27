// create basic window with turquoise background

int height = 1280;
int width = 800;
PImage bg;

void setup() {
    fullScreen();
    background(1, 130, 129);
    bg = loadImage("./assets/windows95.png");
    noStroke();
    imageMode(CENTER);
}

void draw() {
    image(bg, width, height/2, 200, 200);
    // create new taskbar
    Taskbar taskbar = new Taskbar(width, height);
    // fill(255, 255, 255);
    // ellipse(mouseX, mouseY, 50, 50);
}

