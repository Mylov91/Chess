public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        boolean isMoveSectorEmpty = false;
        if ((Math.abs(toLine - line) == Math.abs(toColumn - column)) && ((toLine - line) != 0) && ((toColumn - column) != 0)) {
            for (int i = line + 1; i <= toLine; i++) {
                for (int j = column + 1; j <= toColumn; j++) {
                    if (i == j && chessBoard.board[i][j] != null) {
                        isMoveSectorEmpty = false;
                    }
                }
            }
        } else if ((line == toLine) && ((toColumn - column) != 0)) {
            for (int i = column + 1; i <= toColumn; i++) {
                if (chessBoard.board[line][i] != null) {
                    isMoveSectorEmpty = false;
                }
            }
        } else if ((column == toColumn) && ((toLine - line) != 0)) {
            for (int i = line + 1; i <= toLine; i++) {
                if (chessBoard.board[i][column] != null) {
                    isMoveSectorEmpty = false;
                }
            }
        } else {
            isMoveSectorEmpty = true;
        }

        boolean isRightPosition;
        if (((Math.abs(toLine - line) == Math.abs(toColumn - column)) && ((toLine - line) != 0) && ((toColumn - column) != 0))
                || ((line == toLine) && ((toColumn - column) != 0)) || ((column == toColumn) && ((toLine - line) != 0))) {
            isRightPosition = true;
        } else {
            isRightPosition = false;
        }

        boolean isStayOnBoard;
        if ((toLine <= 7) && (toLine >= 0) && (toColumn <= 7) && (toColumn >= 0)) {
            isStayOnBoard = true;
        } else {
            isStayOnBoard = false;
        }

        if ((isMoveSectorEmpty && isRightPosition && isStayOnBoard) ||
                (isMoveSectorEmpty && isRightPosition && isStayOnBoard && chessBoard.board[line][column].getColor().equals(this.color) &&
                        !chessBoard.board[toLine][toColumn].getColor().equals(this.color))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}