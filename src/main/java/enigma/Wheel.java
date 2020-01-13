package enigma;

/**
 * Class that represents a wheel in the enigma.
 * 
 * @author MARONE cheikh
 */

//creer une classe de généralisation et puis de le faire hériter sur reflector et rotor
abstract class Wheel {

	protected int position;

	protected static int nbrLetter = 26;

	protected static int toIndex(char c) {
		return c - 'A';
	}

	abstract protected int convertForward(int p);

	abstract protected int convertBackward(int e);

	public int getPosition() {
		return position;
	}

	public void setPosition(int posn) {
		position = posn;
	}

}
