import java.awt.Color;
import java.util.Random;

public class Modèle {
	static Color[] COULEURS = {Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, 
						Color.RED, Color.ORANGE, Color.WHITE,Color.BLACK};
	static int N_TENTATIVES;
	static int DIFFICULTE;
	
	enum Etat {EN_COURS, GAGNE, PERDU};
	
	Etat état;
	Rangée combinaison;
	Rangée[] propositions; 
	int tentative;
	
	Random r = new Random();
	
	public Modèle(int difficulté, int nbTentatives) {
		Modèle.DIFFICULTE = difficulté;
		Modèle.N_TENTATIVES = nbTentatives;
		this.état = Etat.EN_COURS;
		this.combinaison = this.RangéeInitiale();
		this.propositions = new Rangée[Modèle.N_TENTATIVES];
		this.tentative = 1;

		// test pour l'affichage
		Rangée r = new Rangée(); 
		r.addJeton(Color.cyan);
		this.propositions[0] = r; 

		//
	}
	
	private Rangée RangéeInitiale() {
		Rangée init = new Rangée();
		while(init.indiceJeton != Modèle.DIFFICULTE) {
			init.jetons[init.indiceJeton] = Modèle.COULEURS[this.r.nextInt(0,Modèle.COULEURS.length)];
			init.indiceJeton++;
		}
		return init;
	}
	
	public void NouvelleProposition() {
		this.propositions[tentative] = new Rangée();
		this.tentative++;
	}
	
	public void TesterRangée() {
		for(int i=0; i<Modèle.DIFFICULTE; i++) {
			Rangée currentTry = this.propositions[tentative];
			for(int y = 0; y<Modèle.DIFFICULTE ;y++) {
				if(currentTry.jetons[y] == this.combinaison.jetons[y]) {
					currentTry.résultats[i] =Color.WHITE;
				}
			}
			if(currentTry.jetons[i] == this.combinaison.jetons[i]) {
				currentTry.résultats[i] =Color.BLACK;
			}
		}
	}
	
	
}
