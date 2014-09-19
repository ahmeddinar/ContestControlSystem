
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TimeTabPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int second = 0;
	static int minute = 0;
	static int hour = 5;
	
	private JLabel CountDownClock;
	private JLabel clockState;
	private JLabel remainTime;
	private JLabel elapsedTime;
	private JLabel timeLenth;
	private JButton startB;
	private JButton refreshB;
	private JButton editB;
	private JButton stopB;
	private Timer timer;
	private String currentState = "stop";
	private JButton uButton;
	private EditTime editTime ;
	
	public TimeTabPanel() {
		
		initComponent();
		
	}
	
	private void initComponent() {
		
		JPanel infoPanel = new JPanel(new GridLayout(4,1));
		JPanel buttonPanel = new JPanel();
		JPanel clockPanel = new JPanel();
		
		setBackground(Color.WHITE);
		
		clockPanel.setPreferredSize(new Dimension(500,50));
		clockPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		infoPanel.setPreferredSize(new Dimension(500,200));
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		buttonPanel.setPreferredSize(new Dimension(500,50));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		clockState = new JLabel("State : " + currentState);
		remainTime = new JLabel("Reamaining : ");
		elapsedTime = new JLabel("Elapsed : ");
		timeLenth = new JLabel("Lenth : ");
		
		startB = new JButton("Start");
		editB = new JButton("Edit");
		refreshB = new JButton("Refresh");
		stopB = new JButton("Stop");
		
		startB.addActionListener(new ActionListenerClass());
		editB.addActionListener(new ActionListenerClass());
		refreshB.addActionListener(new ActionListenerClass());
		stopB.addActionListener(new ActionListenerClass());
		
		CountDownClock = new JLabel("05:00:00");
		CountDownClock.setFont(new Font("",Font.PLAIN,25));
		
		infoPanel.add(clockState);
		infoPanel.add(remainTime);
		infoPanel.add(elapsedTime);
		infoPanel.add(timeLenth);
		
		buttonPanel.add(startB);
		buttonPanel.add(stopB);
		buttonPanel.add(editB);
		buttonPanel.add(refreshB);
		
		clockPanel.add(CountDownClock);
	
		add(clockPanel);
		add(infoPanel);
		add(buttonPanel);
		
	}
	
	public void StopClock() {
		timer.cancel();
	}
	
	public void ResumeClock() {
		
		int delay = 1000;
		int period = 1000;
		
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimeTaskClass(), delay, period);
		
	}


	
	private void setTime(String time) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				CountDownClock.setText(time);
				
			}
		});
		
	}
	
	public class TimeTaskClass extends TimerTask {
		
		@Override
		public void run() {
			
			if(second == 0){
				if(minute == 0){
					if (hour == 0) {
						timer.cancel();
					}
					else {
						second = 59;
						minute = 59;
						--hour;
					}
				}
				else {
					second = 59;
					--minute;
				}
			}
			else {
				--second;
			}
			
			String time = Integer.toString(hour).concat(":").concat(Integer.toString(minute)).concat(":").concat(Integer.toString(second));
			setTime(time);
			
		}

	}
	
	public void setState() {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				clockState.setText("State : " + currentState);
			}
		});
	}
	
	class ActionListenerClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource() == stopB){
				
				if(currentState.equals("running")){
					StopClock();
					currentState = "stop";
					setState();
				}
				
			}
			else if(e.getSource() == startB){
				
				if(currentState.equals("stop")){
					ResumeClock();
					currentState = "running";
					setState();
				}
				
			}
			else if(e.getSource() == editB){
				
				editTime = new EditTime(hour,minute,second);
				uButton = editTime.getUpdateButton();
				uButton.addActionListener(new ActionListenerClass());

			}
			else if(e.getSource() == refreshB){
				
			}
			else if(e.getSource() == uButton){
				
				System.out.println(editTime.getHour().getText());
				editTime.getThis().dispose();
				
			}
			
		}
		
	}
	
	
}
