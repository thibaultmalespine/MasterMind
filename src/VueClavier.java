import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VueClavier extends JPanel{

	public VueClavier(ActionListener A) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for(int i=0; i < Modèle.COULEURS.length; i++) {
			JButton btn = new JButton();
			btn.setBackground(Modèle.COULEURS[i]);
		
			btn.setPreferredSize(new Dimension(30,30));
			btn.addActionListener(A);
			this.add(btn);
		}
	}
}
