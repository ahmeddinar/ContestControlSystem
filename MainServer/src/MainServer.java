import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainServer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cards;
	private JPanel cardPanel;
	private String port;
	
	public MainServer(String port) {
		
		super();
		this.port = port;
		
		loadCards();
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getPreferredSize().width/2, dim.height/2-this.getPreferredSize().height/2);
		
		setResizable(false);
		setVisible(true);
	}

	private void loadCards() {
		
		cards = new customCardLayout();
		cardPanel = new JPanel(cards);
		
		cardPanel.add(new MainServerLogin(port, this, cardPanel, cards) , "loginCard");
		
		add(cardPanel,BorderLayout.CENTER);
	}

}
