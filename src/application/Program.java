package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessExcepition;
import chess.ChessMath;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMath chessMath = new ChessMath();
		
		while (true) {
			
			try {
				UI.clearScreen();
				UI.printBoard(chessMath.getPieces());
				System.out.println();
				System.out.println("Posicao de origem: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				System.out.println();
				System.out.println("Posicao de destino: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPeace = chessMath.performChessMovie(source, target);
			}
			catch (ChessExcepition e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			}
		
		
	}

}
