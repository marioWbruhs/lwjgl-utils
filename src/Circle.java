import static org.lwjgl.opengl.GL11.*;

public class Circle {
    public float x, y, r, color[];

    public Circle(float x, float y, float r, int color[])
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = new float[] {color[0] / 255f, color[1] / 255f, color[2] / 255f, color[3] / 255f};
    }

    public void draw()
    {

        glBegin(GL_POINTS);
            glColor4f(this.color[0], this.color[1], this.color[2], this.color[3]);
            for(double i = 0; i <= 360; i += 0.1){
                glVertex2f((float)(x+r*Math.cos(Math.toRadians(i))),(float)(y-r*Math.sin(Math.toRadians(i))));
            }
        glEnd();
    }
}
