import java.awt.Color;
import java.util.Observable;
import java.util.Random;

public class Modèle extends Observable{
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
		this.NouvelleProposition();
	}
	
	private Rangée RangéeInitiale() {
		Rangée init = new Rangée();
		while(init.indiceJeton != Modèle.DIFFICULTE) {
			init.jetons[init.indiceJeton] = Modèle.COULEURS[this.r.nextInt(0,Modèle.COULEURS.length)];
			init.indiceJeton++;
		}
		return init;
	}
	
	public void ajouterJeton(Color c){
		this.propositions[tentative-1].addJeton(c);
		
		if (this.propositions[tentative-1].indiceJeton == Modèle.DIFFICULTE){
			this.TesterRangée();
			this.tentative++;
			if(tentative > Modèle.N_TENTATIVES){
				System.out.println("Perdu !");
				System.exit(0);
			}
			this.NouvelleProposition();
		}
		setChanged(); 
		notifyObservers();
	}

	public void NouvelleProposition() {
		this.propositions[tentative-1] = new Rangée();
	}
	
	public void TesterRangée() {
		Rangée currentTry = this.propositions[tentative-1];
		for(int i=0; i<Modèle.DIFFICULTE; i++) {
			for(int y = 0; y<Modèle.DIFFICULTE ;y++) {
				if(currentTry.jetons[i] == this.combinaison.jetons[y]) {
					currentTry.résultats[i] =Color.WHITE;
				}
			}
			if(currentTry.jetons[i] == this.combinaison.jetons[i]) {
				currentTry.résultats[i] =Color.BLACK;
			}
		}
		boolean isWin = true;
		for (Color c : currentTry.résultats) {
			if (c != Color.BLACK){
				isWin = false;
			}
		}
		if (isWin){
			System.out.println("Gagné !");
			System.exit(0);
		}
	}
	
	
}
