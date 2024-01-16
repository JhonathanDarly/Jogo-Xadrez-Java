package application;

import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMath;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMath chessMath = new ChessMath();
		
		while (true) {
			UI.printBoard(chessMath.getPieces());
			System.out.println();
			System.out.println("Posicao de origem: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.println("Posicao de destino: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPeace = chessMath.performChessMovie(source, target);
		}
		
		
	}

}
