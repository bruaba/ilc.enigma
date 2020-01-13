package enigma;

/**
 * Class that represents a reflector in the enigma.
 * 
 * @author
 */

//creer une classe de généralisation et puis de le faire hériter sur reflector et rotor
public class Reflector extends Wheel {

	int[] reflection;

	public static Reflector reflectorFactory(String str) {
		char[] s = str.trim().replace(" ", "").toCharArray(); // on supprime les espaces
		int[] cipher = new int[nbrLetter];
		for (int i = 0; i < nbrLetter; i++) {
			cipher[i] = toIndex(s[i]); // recupère la soustraction entre s[i] et 'A'
		}
		return new Reflector(cipher);
	}

	Reflector(int[] r) {
		reflection = r;
	}

	@Override
	int convertForward(int p) {
		return ((reflection[((p) % nbrLetter + nbrLetter) % nbrLetter]) % nbrLetter + nbrLetter) % nbrLetter;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int posn) {
		position = posn;
	}

	@Override
	int convertBackward(int e) {
		throw new UnsupportedOperationException();
	}

}
