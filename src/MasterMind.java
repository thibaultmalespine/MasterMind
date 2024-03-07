import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

public class MasterMind extends Frame implements WindowListener,ActionListener{
	Modèle modèle;
	public MasterMind() {
		this.modèle = new Modèle(4, 10);
		VuePropositions propositions = new VuePropositions(modèle);
		VueClavier clavier = new VueClavier(this);
		this.setLayout(new BorderLayout());
		this.add(propositions,BorderLayout.PAGE_START);
		this.add(clavier, BorderLayout.PAGE_END);
		this.setVisible(true);
		this.pack();
		this.addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new MasterMind();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int indiceJeton = this.modèle.propositions[modèle.tentative].indiceJeton;
		int tentative = this.modèle.tentative;
		Rangée rangéeActuelle = this.modèle.propositions[modèle.tentative];
		JButton jb = (JButton) e.getSource();
		//rangéeActuelle[indiceJeton] = jb.getBackground();
		indiceJeton++;
	}
}
