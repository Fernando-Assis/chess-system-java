package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPositon;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPositon source = UI.readChessPosition(sc);

				System.out.println();
				System.out.print("Target: ");
				ChessPositon target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			} catch (ChessException e) {
				System.out.println(e.getLocalizedMessage());
				sc.hasNextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getLocalizedMessage());
				sc.hasNextLine();
			}
		}
	}
}