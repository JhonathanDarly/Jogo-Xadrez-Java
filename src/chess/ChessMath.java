package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMath {

	private Board board;

	public ChessMath() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}

	public ChessPiece performChessMovie(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();

		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	public Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPeace = board.removePiece(target);
		board.placePiece( p , target);
		return capturedPeace;
	}

	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
		throw new ChessExcepition("Nao existe peca na posicao de origem");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessExcepition("Nao existe movimento possivel para a peca escolhida!");
		}
		
	}
	
	private void validateTargetPosition (Position source, Position target) {
		if (!board.piece(source).possibleMovie(target)) {
			throw new ChessExcepition("A peca escolhida nao pode ser movida para posicao de destino!");
		}
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {
		placeNewPiece('B', 6, new Rook(board, Color.WHITE));
		placeNewPiece('E', 8, new King(board, Color.BLACK));
		placeNewPiece('E', 1, new King(board, Color.WHITE));
		placeNewPiece('C', 1, new Rook(board, Color.WHITE));
		placeNewPiece('C', 2, new Rook(board, Color.WHITE));
		placeNewPiece('D', 2, new Rook(board, Color.WHITE));
		placeNewPiece('E', 2, new Rook(board, Color.WHITE));
		placeNewPiece('D', 1, new King(board, Color.WHITE));

		placeNewPiece('C', 7, new Rook(board, Color.BLACK));
		placeNewPiece('C', 8, new Rook(board, Color.BLACK));
		placeNewPiece('D', 7, new Rook(board, Color.BLACK));
		placeNewPiece('E', 7, new Rook(board, Color.BLACK));
		placeNewPiece('D', 8, new King(board, Color.BLACK));
	}
}
