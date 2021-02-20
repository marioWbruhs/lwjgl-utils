import static org.lwjgl.opengl.GL11.*;

public class Rectangle {
    public float x, y, width, height, color[];

    public Rectangle(float x, float y, float width, float height, int color[])
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = new float[] {color[0] / 255f, color[1] / 255f, color[2] / 255f, color[3] / 255f};
    }

    public void draw()
    {
        glBegin(GL_QUADS);
            glColor4f(this.color[0], this.color[1], this.color[2], this.color[3]);
            glVertex2f(this.x, this.y);
            glVertex2f(this.x + this.width, this.y);
            glVertex2f(this.x + this.width, this.y + this.height);
            glVertex2f(this.x, this.y + this.height);
        glEnd();
    }
}
