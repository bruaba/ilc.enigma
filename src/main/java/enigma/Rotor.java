package enigma;

public class Rotor extends Wheel {

	private int[] cipher = new int[nbrLetter]; // les nbrLetter lettres de l'alphabet
	private int[] bcipher = new int[nbrLetter];
	private int notch1 = -1;
	private int notch2 = -1;

	// creer une constante pour le nbrLetter

	public static Rotor rotorFactory(String str, String notches) {
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[nbrLetter];
		for (int i = 0; i < nbrLetter; i++) {
			cipher[i] = toIndex(s[i]);
		}
		s = notches.trim().replace(" and ", "").toCharArray();
		if (s.length == 2) {
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}

	}

	Rotor(int[] c, int notch1, int notch2) {
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}

	Rotor(int[] c, int notch1) {
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}

	// faut les proteger
	protected void advance() {
		position = (position + 1) % nbrLetter;
	}

	protected boolean atNotch() {
		return (position == notch1 || position == notch2);
	}

	// enlever les static
	protected static char toLetter(int p) {
		return (char) (p + 'A');
	}

	private void createBCipher() {
		for (int i = 0; i < nbrLetter; i++)
			bcipher[cipher[i]] = i;
	}

	@Override
	protected int convertForward(int p) {
		return ((cipher[((p + position) % nbrLetter + nbrLetter) % nbrLetter] - position) % nbrLetter + nbrLetter)
				% nbrLetter;
	}

	@Override
	protected int convertBackward(int e) {
		return ((bcipher[((e + position) % nbrLetter + nbrLetter) % nbrLetter] - position) % nbrLetter + nbrLetter)
				% nbrLetter;
	}

}
