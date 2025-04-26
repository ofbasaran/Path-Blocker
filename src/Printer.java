//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Printer {
    private BufferedImage image;
    private Graphics g;
    private int cellSize;

    public Printer(int[][] world, int cellSize) {
        this.cellSize = cellSize;
        int width = world[0].length * cellSize;
        int height = world.length * cellSize;
        this.image = new BufferedImage(width, height, 1);
        this.g = this.image.getGraphics();
    }

    public boolean CreatePngFile(String folderName, int[][] world, int fileCount) {
        for(int row = 0; row < world.length; ++row) {
            for(int col = 0; col < world[0].length; ++col) {
                switch (world[row][col]) {
                    case 1 -> this.g.setColor(new Color(240, 204, 71));
                    case 2 -> this.g.setColor(new Color(53, 13, 98));
                    case 3 -> this.g.setColor(Color.LIGHT_GRAY);
                    default -> this.g.setColor(new Color(134, 141, 232));
                }

                this.g.fillRect(col * this.cellSize, row * this.cellSize, this.cellSize, this.cellSize);
            }
        }

        try {
            String count = String.format("/%04d", fileCount);
            File outputDir = new File(folderName);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            ImageIO.write(this.image, "png", new File(folderName + "/" + count + ".png"));
            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }
}

