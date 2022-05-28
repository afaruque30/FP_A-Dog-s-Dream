class Taskbar {
    
    // taskbar is a rectangle that is on the bottom of the screen
    // it is used to display the taskbar buttons
    // it is also used to display the taskbar buttons
    
    public static final int TASKBAR_HEIGHT = 40;
    
    private static final int TASKBAR_BUTTON_WIDTH = 40;
    private static final int TASKBAR_BUTTON_HEIGHT = 40;
    
    private static final int TASKBAR_BUTTON_SPACING = 5;
    
    private static final int TASKBAR_BUTTON_X_OFFSET = 10;
    private static final int TASKBAR_BUTTON_Y_OFFSET = 10;
    
    public Taskbar() {
        rect(0, 0, 0, 50);
        fill(1, 130, 129);
    }
}