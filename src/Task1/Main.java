package Task1;


public class Main {
    public static void main(String[] args) {
        try {
            ChessBoard chessBoard = new ChessBoard(args[0], args[1]);
            PrintHelper.printConsoleBoard(chessBoard.makeBoard());
        } catch (NumberFormatException nfe) {
            PrintHelper.print("Invalid parameter");
        } catch (Exception e) {
            PrintHelper.printConsoleInstruction();
        }

    }
}
/*1) вынести инициализацию из конструктора
 * 2) нул поинтер ексепшен решить вопрос
 * 3) */