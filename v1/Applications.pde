class Applications {
    String iconPath, name;
    Application(String name, String iconPath) {
        this.name = name;
        this.iconPath = iconPath;
    }

    void draw() {
        fill(255);
        rect(0, height - 50, width, 50);
    }
}