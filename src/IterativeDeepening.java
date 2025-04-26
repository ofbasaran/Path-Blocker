//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.HashSet;
import java.util.Set;

public class IterativeDeepening {
    private State state = new State();
    public static int levelCount = 1;

    public IterativeDeepening(World world, int maxDepth) {
        boolean result = this.iterativeSearch(world, maxDepth);
        world.setSolutionExist(result);
    }

    private boolean iterativeSearch(World world, int maxDepth) {
        int limit = 0;

        boolean found;
        for(found = false; !found && limit < maxDepth; ++limit) {
            if (this.performSearch(world, limit)) {
                found = true;
            }
        }

        return found;
    }

    private boolean performSearch(World world, int limit) {
        Set<World> visited = new HashSet<   >();
        return this.performSearchHelper(world, limit, 1, visited);
    }

    private boolean performSearchHelper(World world, int limit, int depth, Set<World> visited) {
        if (world != null && limit >= 0 && !visited.contains(world)) {
            visited.add(world);
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
                        } else if (!world.equals(worldUp) && this.performSearchHelper(worldUp, limit - 1, depth + 1, visited)) {
                            this.createPngFile(worldUp, depth);
                            return true;
                        } else if (!world.equals(worldDown) && this.performSearchHelper(worldDown, limit - 1, depth + 1, visited)) {
                            this.createPngFile(worldDown, depth);
                            return true;
                        } else if (!world.equals(worldLeft) && this.performSearchHelper(worldLeft, limit - 1, depth + 1, visited)) {
                            this.createPngFile(worldLeft, depth);
                            return true;
                        } else if (!world.equals(worldRight) && this.performSearchHelper(worldRight, limit - 1, depth + 1, visited)) {
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

    private void createPngFile(World child, int depth) {
        Printer printer = new Printer(child.GetWorldDeep(), 10);
        printer.CreatePngFile("Level" + levelCount, child.GetWorldDeep(), depth--);
    }
}

