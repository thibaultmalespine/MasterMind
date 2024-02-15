import java.awt.Color;

public class Rangée {
	Color[] jetons, résultats;
	int indiceJeton;
	
	public Rangée() {
		this.jetons = new Color[Modèle.DIFFICULTE];
		this.résultats = new Color[Modèle.DIFFICULTE];
		this.indiceJeton = 0;
	}
}
