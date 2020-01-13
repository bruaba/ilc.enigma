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

	abstract int convertForward(int p);

	abstract int convertBackward(int e);

}
