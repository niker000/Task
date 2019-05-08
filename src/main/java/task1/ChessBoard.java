package task1;


public class ChessBoard {
    private int height;
    private int width;

    public ChessBoard(int height, int width) {
        if (height < 0) {
            this.height = height * (-1);
        } else {
            this.height = height;
        }
        if (width < 0) {
            this.width = width * (-1);
        } else {
            this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String makeBoard() {
        StringBuilder board = new StringBuilder();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((j + i) % 2 == 0) {
                    board.append("X");
                } else {
                    board.append(" ");
                }
            }
            board.append('\n');
        }
        return board.toString();
    }
}
