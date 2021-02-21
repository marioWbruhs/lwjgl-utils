import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.stb.STBImage.stbi_load;

public class ImageLoader {
    private static ByteBuffer image;
    private static int width, heigh;

    public static ByteBuffer get_image() {
        return image;
    }

    public static int get_width() {
        return width;
    }

    public static int get_heigh() {
        return heigh;
    }

    ImageLoader(int width, int heigh, ByteBuffer image) {
        this.image = image;
        this.heigh = heigh;
        this.width = width;
    }
    public static ImageLoader load_image(String path) {
        ByteBuffer image;
        int width, heigh;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer comp = stack.mallocInt(1);
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);

            image = stbi_load(path, w, h, comp, 4);
            if (image == null) {
                // throw new resource_error("Could not load image resources.");
            }
            width = w.get();
            heigh = h.get();
        }
        return new ImageLoader(width, heigh, image);
    }
}
