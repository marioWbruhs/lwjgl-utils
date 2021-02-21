
import static org.lwjgl.glfw.GLFW.*;

import java.io.IOException;
import org.lwjgl.opengl.GL;


public class Main {
    //main function ofc
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().run();
    }



    public void run() throws IOException {


        if (!glfwInit()) {
            throw new IllegalStateException("failed to inti glfw");
        }

        Window window = new Window(1080, 720, "test", 0, 0, new int[] {255, 255, 255, 255}, "assests/icon.png");

        Rectangle rect1 = new Rectangle(0f, 0f,  0.1f, 0.1f, new int[] {255, 0, 0, 255});
        Rectangle rect2 = new Rectangle(-0.09f, -0.1f,  0.1f, 0.1f, new int[] {255, 0, 0, 255});

        GL.createCapabilities();

        while (!glfwWindowShouldClose(window.window())) {

            glfwPollEvents();
            window.update();

            rect1.draw();
            rect2.draw();

            if(rect1.collide(rect2))
            {
                System.out.println(true);
            }

            glfwSwapBuffers(window.window());


        }
    }
}


