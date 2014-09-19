import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class EditTime extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String second;
	private String minute;
	private String hour ;
	
	private JButton updateB;
	private JButton cancelB;
	private JTextField remainHour;
	private JTextField remainMinute;
	private JTextField remainSecond;
	private JTextField elapsedHour;
	private JTextField elapsedMinute;
	private JTextField elapsedSecond;
	private JTextField lenthHour;
	private JTextField lenthMinute;
	private JTextField lenthSecond;
	
	public EditTime(int hour,int minute,int second) {
		

		super("Edit Time");
		this.hour = Integer.toString(hour);
		this.minute = Integer.toString(minute);
		this.second = Integer.toString(second);
		
		initComponent();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		pack();
		
	}
	
	public void Close() {
		this.dispose();
	}

	private void initComponent() {
		

		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		panel.setPreferredSize(new Dimension(450,250));
		panel.setBackground(Color.WHITE);
		
		remainHour = new JFormattedTextField(hour);
		remainMinute = new JTextField(minute);
		remainSecond = new JTextField(second);
		elapsedHour = new JTextField();
		elapsedMinute = new JTextField();
		elapsedSecond = new JTextField();
		lenthHour = new JTextField();
		lenthMinute = new JTextField();
		lenthSecond = new JTextField();
		
		Dimension filedDim = new Dimension(50,30);
		remainHour.setPreferredSize(filedDim);
		remainMinute.setPreferredSize(filedDim);
		remainSecond.setPreferredSize(filedDim);
		elapsedHour.setPreferredSize(filedDim);
		elapsedMinute.setPreferredSize(filedDim);
		elapsedSecond.setPreferredSize(filedDim);
		lenthHour.setPreferredSize(filedDim);
		lenthMinute.setPreferredSize(filedDim);
		lenthSecond.setPreferredSize(filedDim);
		
		updateB = new JButton("Update");
		cancelB = new JButton("Cancel");
		
		updateB.addActionListener(new ActionListenerClass());
		cancelB.addActionListener(new ActionListenerClass());
		
		updateB.setFocusPainted(false);
		cancelB.setFocusPainted(false);
		
		updateB.setBackground(new Color(38,160,218));
		updateB.setForeground(Color.WHITE);
		
		cancelB.setBackground(Color.RED);
		cancelB.setForeground(Color.WHITE);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(mylabel("Contest Lenth: ") , constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(lenthHour , constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(lenthMinute , constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(lenthSecond , constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(mylabel("Reamining Time: ") , constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(remainHour , constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(remainMinute , constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(remainSecond , constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(mylabel("Eclapsed Time: ") , constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(elapsedHour , constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(elapsedMinute , constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 2;
		constraints.insets = new Insets(0, 0, 10, 0);
		panel.add(elapsedSecond , constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		panel.add(updateB , constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 3;
		panel.add(cancelB , constraints);
		
		add(panel);
	}
	
	public JLabel mylabel(String s) {
		
		JLabel label = new JLabel(s);
		
		label.setFont(new Font("",Font.PLAIN,16));
		
		return label;
	}
	
	public JButton getUpdateButton() {
		return updateB;
	}
	
	public JTextField getHour() {
		return remainHour;
	}
	
	public JFrame getThis() {
		return this;
	}
	
	class ActionListenerClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == cancelB){
				Close();
			}
			
		}
		
	}
	
}
