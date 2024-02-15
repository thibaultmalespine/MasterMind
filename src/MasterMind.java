import java.awt.Frame;

public class MasterMind extends Frame{
	public MasterMind() {
		VueClavier clavier = new VueClavier();
		this.add(clavier);
		this.setSize(400, 400);
		this.setVisible(true);
		this.pack();
	}
	
	public static void main(String[] args) {
		new MasterMind();
	}
}
