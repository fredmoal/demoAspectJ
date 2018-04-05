package visiteur;

public class Entier extends Expression {
	private int value;
	
	public Entier(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public int eval() {
		return value;
	}
}