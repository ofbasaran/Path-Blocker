//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class WorldDepth {
    private World world;
    private int depth;

    public WorldDepth(World world, int depth) {
        this.world = world;
        this.depth = depth;
    }

    public boolean equals(Object obj) {
        WorldDepth object = (WorldDepth)obj;
        return this.world.equals(object.world);
    }

    public int hashCode() {
        return this.world.hashCode();
    }

    public World getWorld() {
        return this.world;
    }

    public int getDepth() {
        return this.depth;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
