//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public enum Material {
    CHARACTER_LOCATION(1),
    BARRIER(2),
    EMPTY(0),
    FLAG(3);

    private final int value;

    private Material(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
