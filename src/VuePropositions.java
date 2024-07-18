import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class VuePropositions extends Canvas implements Observer{
	int tailleCercle;
	Modèle modèle;
	public VuePropositions(Modèle m){
		tailleCercle = 30;
		this.setBackground(Color.GRAY);
		this.setSize(new Dimension(285,tailleCercle*Modèle.N_TENTATIVES+tailleCercle/2*(Modèle.N_TENTATIVES+1)));
		this.modèle = m;
	}
	public void paint(Graphics g) {
		
		for (int j = 1; j < modèle.tentative+1; j++) {
			Rangée rangéeCourante = modèle.propositions[j-1];
			int nbJeton = rangéeCourante.indiceJeton;
			for (int i = 1; i < Modèle.DIFFICULTE+1 ; i++) {
				Color couleurJeton = rangéeCourante.jetons[i-1];
				if ( i <= nbJeton) {
					g.setColor(couleurJeton);
					g.fillOval(i * (tailleCercle)/2 + (i-1)*tailleCercle,j* (tailleCercle)/2 + (j-1)*tailleCercle,tailleCercle,tailleCercle);
				}
				else{
					g.setColor(Color.BLACK);
					g.drawOval(i * (tailleCercle)/2 + (i-1)*tailleCercle,j* (tailleCercle)/2 + (j-1)*tailleCercle,tailleCercle,tailleCercle);
				}
			}
		}
		for (int i = 1; i < modèle.tentative; i++) {
			Rangée rangéeFini = modèle.propositions[i-1];

			for (int j = 0; j < Modèle.DIFFICULTE; j++) {
				if(rangéeFini.résultats[j] instanceof Color){
					Color c = rangéeFini.résultats[j];
					g.setColor(c);
					g.fillOval(6*tailleCercle + (tailleCercle/2)*j,i* (tailleCercle)/2 + (i-1)*tailleCercle ,tailleCercle/2,tailleCercle/2);
				}
				else{
					g.setColor(Color.BLACK);
					g.drawOval(6*tailleCercle + (tailleCercle/2)*j,i* (tailleCercle)/2 + (i-1)*tailleCercle ,tailleCercle/2,tailleCercle/2);
				}
			}
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		repaint();
		// TODO Auto-generated method stub
	}

}
