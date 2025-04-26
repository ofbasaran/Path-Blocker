//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int totalLevels = 10;
        int gridSize = 14;
        World[] worlds = new World[totalLevels];

        int i;
        for(i = 0; i < totalLevels; ++i) {
            String levelFile = String.format("src/level%02d.txt", i + 1);
            Reader reader = new Reader(levelFile, gridSize);
            worlds[i] = new World(reader.GetMap());
        }

        for(i = 0; i < totalLevels; ++i) {
            if (worlds[i].isCharacterExist() && worlds[i].isFlagExist()) {
                new IterativeDeepening(worlds[i], 26);
                ++Bfs.levelCount;
                ++Dfs.levelCount;
                ++IterativeDeepening.levelCount;
            } else {
                System.out.println("Character or flag is not exist at " + (i + 1) + " th txt file");
            }

            if (!worlds[i].isSolutionExist()) {
                System.out.println("There is no such solution for " + (i + 1) + " th txt file\n");
            }
        }

        long endTime = System.nanoTime();
        double durationInSeconds = (double)(endTime - startTime) / 1.0E9;
        System.out.println("Time taken: " + durationInSeconds + " seconds");
    }
}

