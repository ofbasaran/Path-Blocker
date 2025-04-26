//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.HashSet;
import java.util.Set;

public class Dfs {
    private State state = new State();
    private Set<World> visited = new HashSet<>();
    public static int levelCount = 1;

    public Dfs(World world) {
        boolean result = this.performSearch(world, 1);
        world.setSolutionExist(result);
    }

    private boolean performSearch(World world, int depth) {
        if (world != null && !this.visited.contains(world)) {
            this.visited.add(world);
            World worldUp = this.state.TryGoUp(new World(world));
            if (this.state.IsFlagFound()) {
                this.createPngFile(worldUp, depth);
                return true;
            } else {
                World worldDown = this.state.TryGoDown(new World(world));
                if (this.state.IsFlagFound()) {
                    this.createPngFile(worldDown, depth);
                    return true;
                } else {
                    World worldLeft = this.state.TryGoLeft(new World(world));
                    if (this.state.IsFlagFound()) {
                        this.createPngFile(worldLeft, depth);
                        return true;
                    } else {
                        World worldRight = this.state.TryGoRight(new World(world));
                        if (this.state.IsFlagFound()) {
                            this.createPngFile(worldRight, depth);
                            return true;
                        } else if (!world.equals(worldUp) && this.performSearch(worldUp, depth + 1)) {
                            this.createPngFile(worldUp, depth);
                            return true;
                        } else if (!world.equals(worldDown) && this.performSearch(worldDown, depth + 1)) {
                            this.createPngFile(worldDown, depth);
                            return true;
                        } else if (!world.equals(worldLeft) && this.performSearch(worldLeft, depth + 1)) {
                            this.createPngFile(worldLeft, depth);
                            return true;
                        } else if (!world.equals(worldRight) && this.performSearch(worldRight, depth + 1)) {
                            this.createPngFile(worldRight, depth);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        } else {
            return false;
        }
    }

    private void createPngFile(World world, int depth) {
        Printer printer = new Printer(world.GetWorldDeep(), 50);
        printer.CreatePngFile("Level" + levelCount, world.GetWorldDeep(), depth--);
    }
}

