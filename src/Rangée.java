import java.awt.Color;

public class Rangée {
	Color[] jetons, résultats;
	int indiceJeton;
	
	public Rangée() {
		this.jetons = new Color[Modèle.DIFFICULTE];
		this.résultats = new Color[Modèle.DIFFICULTE];
		this.indiceJeton = 0;
	}

	public void addJeton(Color c){
		this.jetons[indiceJeton] = c;
		indiceJeton++;
	}

}
