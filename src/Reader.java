//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private int[][] map;
    private String file;

    public Reader(String file, int worldSize) {
        this.file = file;
        this.map = new int[worldSize][worldSize];
        this.ReadFile(file);
    }

    private void ReadFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            for(int lineCount = 0; (line = reader.readLine()) != null; ++lineCount) {
                String[] chars = line.split(" ");

                for(int i = 0; i < chars.length; ++i) {
                    this.map[lineCount][i] = Integer.parseInt(chars[i]);
                }
            }

            reader.close();
        } catch (IOException var7) {
            IOException e = var7;
            e.printStackTrace();
        }

    }

    public int[][] GetMap() {
        return this.map;
    }
}

