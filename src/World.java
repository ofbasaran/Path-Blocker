//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Point;
import java.util.Arrays;

public class World {
    private int[][] world;
    private Point characterLocation;
    private boolean isCharacterExist;
    private boolean isFlagExist;
    private boolean isSolutionExist;

    public void setSolutionExist(boolean isSolutionExist) {
        this.isSolutionExist = isSolutionExist;
    }

    public World(int[][] world) {
        this.world = world;
        this.isCharacterExist = false;
        this.isFlagExist = false;
        this.isSolutionExist = false;
        this.findLocations();
        if (this.characterLocation.x == -1) {
            this.isCharacterExist = false;
        }

    }

    public boolean isCharacterExist() {
        return this.isCharacterExist;
    }

    public boolean isFlagExist() {
        return this.isFlagExist;
    }

    public boolean isSolutionExist() {
        return this.isSolutionExist;
    }

    public World(World world) {
        this.world = world.GetWorldDeep();
        this.characterLocation = new Point(world.GetCharacterLocation().x, world.GetCharacterLocation().y);
    }

    public void PrintWorld() {
        for(int i = 0; i < this.world.length; ++i) {
            for(int j = 0; j < this.world[i].length; ++j) {
                System.out.print(this.world[i][j] + " ");
            }

            System.out.println();
        }

    }

    private void findLocations() {
        int[][] map = this.GetWorldShallow();

        for(int i = 0; i < map.length; ++i) {
            for(int j = 0; j < map[i].length; ++j) {
                if (map[i][j] == 1) {
                    this.characterLocation = new Point(i, j);
                    this.isCharacterExist = true;
                } else if (map[i][j] == 3) {
                    this.isFlagExist = true;
                }
            }
        }

    }

    public int[][] GetWorldShallow() {
        return this.world;
    }

    public int[][] GetWorldDeep() {
        int[][] deepCopy = new int[this.world.length][];

        for(int i = 0; i < this.world.length; ++i) {
            deepCopy[i] = (int[])this.world[i].clone();
        }

        return deepCopy;
    }

    public Point GetCharacterLocation() {
        return this.characterLocation;
    }

    public void SetCharacterLocation(Point p) {
        this.characterLocation = p;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && obj instanceof World) {
            World otherWorld = (World)obj;
            int[][] otherMap = otherWorld.GetWorldDeep();
            return Arrays.deepEquals(this.world, otherMap);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(this.world);
    }
}

