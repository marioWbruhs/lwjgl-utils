import static org.lwjgl.opengl.GL11.*;
public class Triangle {
    public float[] p1, p2, p3, color;

    public Triangle(float[] p1, float[] p2, float[] p3, int[] color)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        this.color = new float[] {color[0] / 255f, color[1] / 255f, color[2] / 255f, color[3] / 255f};
    }

    public void draw()
    {
        glBegin(GL_TRIANGLES);
            glColor4f(this.color[0], this.color[1], this.color[2], this.color[3]);
            glVertex2f(this.p1[0], this.p1[1]);
            glVertex2f(this.p2[0], this.p2[1]);
            glVertex2f(this.p3[0], this.p3[1]);
        glEnd();

    }
}
