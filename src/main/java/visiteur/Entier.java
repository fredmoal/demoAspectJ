package visiteur;

public class Entier implements Expression {
	private int value;
	
	public Entier(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}