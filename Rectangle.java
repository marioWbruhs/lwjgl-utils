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

    public boolean collide(Rectangle obj)
    {
        boolean c1, c2, c3, c4;
        boolean p1, p2, p3, p4;

        //collision points upper left

        c1 = this.x >= obj.x;
        c2 = this.y >= obj.y;

        c3 = this.x <= obj.x + this.width;
        c4 = this.y <= obj.y + this.height;

        p1 = c1 && c2 && c3 && c4;

        boolean c11, c12, c13, c14;

        //collision points upper right

        c11 = this.x + this.width >= obj.x;
        c12 = this.y >= obj.y;

        c13 = this.x + this.width <= obj.x + this.width;
        c14 = this.y <= obj.y + this.height;

        p2 = c11 && c12 && c13 && c14;

        boolean c21, c22, c23, c24;

        //collision points bottom left

        c21 = this.x >= obj.x;
        c22 = this.y + this.height >= obj.y;

        c23 = this.x <= obj.x + this.width;
        c24 = this.y + this.height <= obj.y + this.height;

        p3 = c21 && c22 && c23 && c24;

        boolean c31, c32, c33, c34;

        //collision points bottom right

        c31 = this.x + this.width >= obj.x;
        c32 = this.y + this.height >= obj.y;

        c33 = this.x + this.width <= obj.x + this.width;
        c34 = this.y + this.height <= obj.y + this.height;

        p4 = c31 && c32 && c33 && c34;

        if(p1 || p2 || p3 || p4)
        {
            return true;
        }

        return false;
    }
}
