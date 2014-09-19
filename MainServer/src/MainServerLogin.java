import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class MainServerLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField name;
	private JPasswordField password;
	private JButton login;
	private JLabel loginInfo;
	private JFrame windowContainer;
	private JPanel cardContainerPanel;
	private CardLayout cards;
	private int SERVER_PORT;
	
	public MainServerLogin(String port,JFrame frame,JPanel panel,CardLayout cardLayout) {

		this.windowContainer = frame;
		this.cardContainerPanel = panel;
		this.cards = cardLayout;
		this.SERVER_PORT = Integer.parseInt(port);
		
		if(!new CheckMainServer(SERVER_PORT).Ok()){
			JOptionPane.showMessageDialog(null, "Unable to start server with port " + port );
		}
		
		initComponent();

	}


	private void initComponent() {

		
		JPanel Headerpanel = new JPanel();
		Headerpanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		Headerpanel.setOpaque(false);
		
		JLabel conTestHeading = new JLabel("Programming Contest Control System");
		conTestHeading.setFont(new Font("Lucida Calligraphy",Font.PLAIN,25));
		Headerpanel.add(conTestHeading);
		
		add(Headerpanel,BorderLayout.NORTH);
		
		initLoginPanel();
		
		setPreferredSize(new Dimension(650,450));
		setBackground(Color.WHITE);
	}


	private void initLoginPanel() {
		
		JPanel loginPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		name = new JTextField();
		password = new JPasswordField();
		login = new JButton("Login");
		loginInfo = new JLabel("");
		
		name.addKeyListener(new ActionListenerClass());
		password.addKeyListener(new ActionListenerClass());
		
		name.setPreferredSize(new Dimension(300,30));
		password.setPreferredSize(new Dimension(300,30));
		login.setPreferredSize(new Dimension(80,35));
		
		name.setFont(new Font("",Font.PLAIN,16));
		password.setFont(new Font("",Font.PLAIN,16));
		
		login.addActionListener(new ActionListenerClass());
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		loginPanel.add(new JLabel("Name:"),constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(0, 0, 10, 0);
		loginPanel.add(name,constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(0, 0, 0, 0);
		loginPanel.add(new JLabel("Password:"),constraints);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(0, 0, 10, 0);
		loginPanel.add(password,constraints);
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		loginPanel.add(login,constraints);
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		loginPanel.add(loginInfo,constraints);
		
		add(loginPanel,BorderLayout.CENTER);
	}
	
	
	class ActionListenerClass implements ActionListener,KeyListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String Name = name.getText().toString();
			@SuppressWarnings("deprecation")
			String Pass = password.getText().toString();
			if(Name.equals("0")){
				if(Pass.equals("0")){
					setLoginInfo("Login in...");
					cardContainerPanel.add(new MainServerPanel(SERVER_PORT) , "mainserver");
					cards.show(cardContainerPanel,"mainserver");
					windowContainer.setTitle("Main Server");
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					windowContainer.setLocation(dim.width/2-windowContainer.getPreferredSize().width/2, dim.height/2-windowContainer.getPreferredSize().height/2);
				}
				else {
					setLoginInfo("Invalid Password");
				}
			}
			else {
				setLoginInfo("Invalid Name");
			}
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if( e.getSource() == name || e.getSource() == password ){
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					login.doClick();	
				}
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}


	public void setLoginInfo(String info) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				loginInfo.setText(info);
			}
			
		});
		
	}


	
}
