//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Point;

public class State {
    private boolean isFlagFound = false;

    public State() {
    }

    public World TryGoLeft(World world) {
        while(true) {
            if (this.CanGoLeft(world)) {
                int row = world.GetCharacterLocation().x;
                int column = world.GetCharacterLocation().y;
                world.SetCharacterLocation(new Point(row, column - 1));
                if (!this.FlagCheck(world)) {
                    world.GetWorldShallow()[row][column - 1] = Material.CHARACTER_LOCATION.getValue();
                    world.GetWorldShallow()[row][column] = Material.BARRIER.getValue();
                    continue;
                }

                this.isFlagFound = true;
                world.GetWorldShallow()[row][column - 1] = Material.CHARACTER_LOCATION.getValue();
                world.GetWorldShallow()[row][column] = Material.BARRIER.getValue();
            }

            return world;
        }
    }

    private boolean CanGoLeft(World world) {
        int row = world.GetCharacterLocation().x;
        int column = world.GetCharacterLocation().y;
        boolean borderCheck = column - 1 >= 0;
        boolean barrierCheck = borderCheck && world.GetWorldDeep()[row][column - 1] != Material.BARRIER.getValue();
        return barrierCheck;
    }

    public World TryGoRight(World world) {
        while(true) {
            if (this.CanGoRight(world)) {
                int row = world.GetCharacterLocation().x;
                int column = world.GetCharacterLocation().y;
                world.SetCharacterLocation(new Point(row, column + 1));
                if (!this.FlagCheck(world)) {
                    world.GetWorldShallow()[row][column + 1] = Material.CHARACTER_LOCATION.getValue();
                    world.GetWorldShallow()[row][column] = Material.BARRIER.getValue();
                    continue;
                }

                this.isFlagFound = true;
                world.GetWorldShallow()[row][column + 1] = Material.CHARACTER_LOCATION.getValue();
                world.GetWorldShallow()[row][column] = Material.BARRIER.getValue();
            }

            return world;
        }
    }

    private boolean CanGoRight(World world) {
        int row = world.GetCharacterLocation().x;
        int column = world.GetCharacterLocation().y;
        boolean borderCheck = column + 1 < world.GetWorldDeep()[row].length;
        boolean barrierCheck = borderCheck && world.GetWorldDeep()[row][column + 1] != Material.BARRIER.getValue();
        return barrierCheck;
    }

    public World TryGoUp(World world) {
        while(true) {
            if (this.CanGoUp(world)) {
                int row = world.GetCharacterLocation().x;
                int column = world.GetCharacterLocation().y;
                world.SetCharacterLocation(new Point(row - 1, column));
                if (!this.FlagCheck(world)) {
                    world.GetWorldShallow()[row - 1][column] = Material.CHARACTER_LOCATION.getValue();
                    world.GetWorldShallow()[row][column] = Material.BARRIER.getValue();
                    continue;
                }

                this.isFlagFound = true;
                world.GetWorldShallow()[row - 1][column] = Material.CHARACTER_LOCATION.getValue();
                world.GetWorldShallow()[row][column] = Material.BARRIER.getValue();
            }

            return world;
        }
    }

    private boolean CanGoUp(World world) {
        int row = world.GetCharacterLocation().x;
        int column = world.GetCharacterLocation().y;
        boolean borderCheck = row - 1 >= 0;
        boolean barrierCheck = borderCheck && world.GetWorldDeep()[row - 1][column] != Material.BARRIER.getValue();
        return barrierCheck;
    }

    public World TryGoDown(World world) {
        while(true) {
            if (this.CanGoDown(world)) {
                int row = world.GetCharacterLocation().x;
                int column = world.GetCharacterLocation().y;
                world.SetCharacterLocation(new Point(row + 1, column));
                if (!this.FlagCheck(world)) {
                    world.GetWorldShallow()[row + 1][column] = Material.CHARACTER_LOCATION.getValue();
                    world.GetWorldShallow()[row][column] = Material.BARRIER.getValue();
                    continue;
                }

                this.isFlagFound = true;
                world.GetWorldShallow()[row + 1][column] = Material.CHARACTER_LOCATION.getValue();
                world.GetWorldShallow()[row][column] = Material.BARRIER.getValue();
            }

            return world;
        }
    }

    private boolean CanGoDown(World world) {
        int row = world.GetCharacterLocation().x;
        int column = world.GetCharacterLocation().y;
        boolean borderCheck = row + 1 < world.GetWorldDeep().length;
        boolean barrierCheck = borderCheck && world.GetWorldDeep()[row + 1][column] != Material.BARRIER.getValue();
        return barrierCheck;
    }

    private boolean FlagCheck(World world) {
        int row = world.GetCharacterLocation().x;
        int column = world.GetCharacterLocation().y;
        if (row == -1) {
            System.out.println("Character is not found");
        }

        return world.GetWorldShallow()[row][column] == Material.FLAG.getValue();
    }

    public boolean IsFlagFound() {
        return this.isFlagFound;
    }
}

