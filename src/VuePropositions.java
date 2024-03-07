import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class VuePropositions extends Canvas {
	int tailleCercle;
	Modèle modèle;
	public VuePropositions(Modèle m){
		tailleCercle = 30;
		this.setBackground(Color.GRAY);
		this.setSize(new Dimension(285,tailleCercle*Modèle.N_TENTATIVES));
		this.modèle = m;
	}
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(modèle.tentative * (tailleCercle)/2,(tailleCercle)/2,modèle.tentative * tailleCercle,tailleCercle);
		
	}

}
