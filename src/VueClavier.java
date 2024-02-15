import java.awt.Button;
import java.awt.Panel;

public class VueClavier extends Panel{

	public VueClavier() {
		for(int i=0; i < Modèle.COULEURS.length; i++) {
			this.add(new Button());
		}
	}
}
