import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


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
	
	public static void main(String[] args) {
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File ini = new File("server.ini");
		
		if(ini.exists()){
			
			Properties pro = new Properties();
			
			try {
				
				pro.load(new FileInputStream(ini));
				String port = pro.getProperty("port", "serverPort");
				
				MainServer main = new MainServer(port);
				main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				main.pack();
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else {
			JOptionPane.showMessageDialog(null,"server.ini file not found","ini not found",JOptionPane.ERROR_MESSAGE );
		}
		
	}
	
}
