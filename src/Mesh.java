import java.util.ArrayList;
import static org.lwjgl.opengl.GL11.*;

public class Mesh {
    public ArrayList<ArrayList<Float>> points;
    public float[] color;

    public Mesh(ArrayList<ArrayList<Float>> points, int color[])
    {
        this.points = points;
        this.color = new float[] {color[0] / 255f, color[1] / 255f, color[2] / 255f, color[3] / 255f};
    }

    public void draw()
    {
        glBegin(GL_POINTS);
            glColor4f(this.color[0], this.color[1], this.color[2], this.color[3]);
            for(int i = 0; i < this.points.size(); i++)
            {
                glVertex2f(this.points.get(i).get(0), this.points.get(i).get(1));
            }
        glEnd();
    }
}
