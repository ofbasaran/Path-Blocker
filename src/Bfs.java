//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Bfs {
    private State state = new State();
    private Map<World, List<World>> graph = new HashMap<>();
    private Map<World, World> backTracking = new HashMap<>();
    public static int levelCount = 1;

    public Bfs(World world) {
        boolean result = this.performSearch(world);
        world.setSolutionExist(result);
    }

    public boolean performSearch(World start) {
        Queue<WorldDepth> queue = new LinkedList<>();
        Set<World> visited = new HashSet<>();
        queue.add(new WorldDepth(start, 0));
        visited.add(start);

        while(!queue.isEmpty()) {
            WorldDepth worldDepth = (WorldDepth)queue.poll();
            World world = worldDepth.getWorld();
            int depth = worldDepth.getDepth();
            World worldUp = this.state.TryGoUp(new World(world));
            if (this.state.IsFlagFound()) {
                this.backTracking.put(worldUp, world);
                this.createPngFiles(worldUp, depth + 1);
                return true;
            }

            World worldDown = this.state.TryGoDown(new World(world));
            if (this.state.IsFlagFound()) {
                this.backTracking.put(worldDown, world);
                this.createPngFiles(worldDown, depth + 1);
                return true;
            }

            World worldLeft = this.state.TryGoLeft(new World(world));
            if (this.state.IsFlagFound()) {
                this.backTracking.put(worldLeft, world);
                this.createPngFiles(worldLeft, depth + 1);
                return true;
            }

            World worldRight = this.state.TryGoRight(new World(world));
            if (this.state.IsFlagFound()) {
                this.backTracking.put(worldRight, world);
                this.createPngFiles(worldRight, depth + 1);
                return true;
            }

            List<World> list = new ArrayList<>();
            if (!world.equals(worldUp)) {
                list.add(worldUp);
                this.backTracking.put(worldUp, world);
            }

            if (!world.equals(worldDown)) {
                list.add(worldDown);
                this.backTracking.put(worldDown, world);
            }

            if (!world.equals(worldLeft)) {
                list.add(worldLeft);
                this.backTracking.put(worldLeft, world);
            }

            if (!world.equals(worldRight)) {
                list.add(worldRight);
                this.backTracking.put(worldRight, world);
            }

            this.graph.put(world, list);
            Iterator var13 = ((List)this.graph.get(world)).iterator();

            while(var13.hasNext()) {
                World neighbor = (World)var13.next();
                if (!visited.contains(neighbor)) {
                    queue.add(new WorldDepth(neighbor, depth + 1));
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }

    private void createPngFiles(World deepestChild, int depth) {
        for(Printer printer = new Printer(deepestChild.GetWorldDeep(), 50); this.backTracking.containsKey(deepestChild); deepestChild = (World)this.backTracking.get(deepestChild)) {
            printer.CreatePngFile("Level" + levelCount, deepestChild.GetWorldDeep(), depth--);
        }

    }
}

