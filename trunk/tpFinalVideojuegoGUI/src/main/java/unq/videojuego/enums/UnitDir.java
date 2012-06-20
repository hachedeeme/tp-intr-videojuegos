package unq.videojuego.enums;


public enum UnitDir {
	Up, Right, Down, Left;
	
	public UnitDir getOpposed(){
		switch (this) {
		case Up: return Down;
		case Down: return Up;
		case Right: return Left;
		default:
			return Right;
		}
	}
}
