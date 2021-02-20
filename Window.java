import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Window {
    public long window;
    public float[] backgroundColor;

    public int fps;
    public int lastFps;
    public long startTimeFps;

    public Window(int width, int height, String title, int monitor, int share, int[] backgroundColor)
    {
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        this.window = glfwCreateWindow(width, height, title, monitor, share);

        if (window == 0) {
            throw new IllegalStateException("failed to create window");
        }

        glfwShowWindow(window);

        glfwMakeContextCurrent(window);
        this.backgroundColor = new float[] {backgroundColor[0] / 255f, backgroundColor[1] / 255f, backgroundColor[2] / 255f, backgroundColor[3] / 255f};

        this.fps = 0;
        this.lastFps = 0;
        this.startTimeFps = System.currentTimeMillis();

    }

    public long window()
    {
        return window;
    }

    private void drawBackground()
    {
        glBegin(GL_QUADS);
            glColor4f(this.backgroundColor[0], this.backgroundColor[1], this.backgroundColor[2], this.backgroundColor[3]);
            glVertex2f(-2f, -2f);
            glVertex2f(2f, -2f);
            glVertex2f(2f, 2f);
            glVertex2f(-2f, 2f);
        glEnd();
    }

    public void update()
    {
        ++this.fps;
        if(System.currentTimeMillis() - this.startTimeFps >= 1000L)
        {
            this.lastFps = this.fps;
            this.fps = 0;
            this.startTimeFps = System.currentTimeMillis();
        }
        drawBackground();
    }

    public int getFPS()
    {
        return this.lastFps;
    }
}
