package AoC.Day11;

public enum HexagonalCoordinates {
    n(0, -1),
    nw(-1, 0),
    ne(1, -1),
    sw(-1, 1),
    se(1, 0),
    s(0, 1);



    int dx;
    int dy;

    HexagonalCoordinates(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
