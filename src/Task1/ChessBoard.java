package Task1;


public class ChessBoard {

    public String makeBoard(int height, int width) {
        StringBuilder board = new StringBuilder();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((j + i) % 2 == 0) {
                    board.append("X");
                } else {
                    board.append(" ");
                }
            }
            board.append("\n");
        }
        return board.toString();
    }
}
