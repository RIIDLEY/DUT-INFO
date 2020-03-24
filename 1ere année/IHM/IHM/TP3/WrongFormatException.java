public class WrongFormatException extends Exception {
	public WrongFormatException(String mes) {
		super(mes);
	}

	public String toString() {
		return super.toString() + " : Mauvais format pour le fichier meteo";
	}
}
