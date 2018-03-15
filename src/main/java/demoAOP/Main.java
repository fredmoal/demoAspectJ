package demoAOP;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Expression dix = new Number(10);
		Expression neuf = new Number(9);
		Expression cinq = new Number(5);
		Expression plus1 = new Plus(dix,neuf);
		Expression plus2 = new Plus(plus1,cinq);
		Expression deux = new Number(2);
		Expression top = new Multiplication(deux, plus2);
		// au début, defaut de cache obligatoire
		System.out.println("- premier appel");
		System.out.println(top.eval());
		// on a un cache valide, donc on le consulte au lieu de parcourir l'arbre
		System.out.println("- deuxieme appel");
		System.out.println(top.eval());
		// on va altérer la valeur du noeud cinq
		// qui va conduire à invalider son cache ainsi que celui de plus2 et top
		((Number)cinq).setValue(4);
		System.out.println("- troisieme appel");
		System.out.println(top.eval());
	}

}
