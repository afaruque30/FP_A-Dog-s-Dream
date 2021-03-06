// create basic window with turquoise background

int height = 1280;
int width = 800;
PImage bg;

void setup() {
    fullScreen();
    background(1, 130, 129);
    surface.setTitle("Windows 95");
    bg = loadImage("./assets/windows95.png");
    surface.setIcon(bg);
    noStroke();
    imageMode(CENTER);
}

void draw() {
    image(bg, width, height / 3, 300, 300);
    // create new taskbar
    Taskbar taskbar = new Taskbar();
    Calculator calculator = new Calculator();
    add(taskbar);
    // fill(255, 255, 255);
    // ellipse(mouseX, mouseY, 50, 50);
}
