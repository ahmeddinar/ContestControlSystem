import java.awt.Dimension;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import TabbedPaneCustomised.CWTabbedPaneUI;
import TabbedPaneCustomised.CustomTabbedPaneUI;
import TabbedPaneCustomised.PPTTabbedPaneUI;


public class MainServerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Socket connection;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private JTabbedPane pane;
	private int SERVER_PORT;
	private JTabbedPane mainTabs;
	
	public MainServerPanel(int port) {
		
		this.SERVER_PORT = port;
		
		initComponent();
		
		setPreferredSize(new Dimension(650,450));
	}

	private void initComponent() {
		
		mainTabs = new JTabbedPane();
		mainTabs.setUI(new PPTTabbedPaneUI());
		
		initServerTab();
		
		initContestConfigTab();
		
		initContestSummeryTab();

		add(mainTabs);
	}
	
	private void initServerTab() {
		
		pane = new JTabbedPane();
		pane.setPreferredSize(new Dimension(600,400));
		
		initServersTab();
		initConnectionsTab();
		initLoginsTab(pane);
		initTimeTab();
		
		mainTabs.addTab("Server", pane);
		
	}
	
	private void initTimeTab() {
		JPanel Times = new TimeTabPanel();
		pane.addTab("Times",Times);
	}

	private void initLoginsTab(JTabbedPane PANE) {
		JPanel Logins = new JPanel();
		PANE.addTab("Logins",Logins);
	}

	private void initConnectionsTab() {
		JPanel Connections = new JPanel();
		pane.addTab("Connections",Connections);
	}

	private void initServersTab() {
		
		JPanel Servers = new JPanel();
		
		pane.addTab("Servers",Servers);
	}
	
	private void initContestConfigTab() {
		
		JTabbedPane conConfigTab = new JTabbedPane();
		
		addsetups(conConfigTab);
		addAccountTab(conConfigTab);
		addLanuages(conConfigTab);
		addProblems(conConfigTab);
		addTimes(conConfigTab);
		addJudges(conConfigTab);
		
		mainTabs.addTab("Contest Config", conConfigTab);
	}
	
	private void addJudges(JTabbedPane conConfigTab) {
		
		JPanel judgesPanel = new JPanel();
		conConfigTab.addTab("Judges", judgesPanel);
		
	}

	private void addTimes(JTabbedPane conConfigTab) {
		
		JPanel TimesPanel = new JPanel();
		conConfigTab.addTab("Contest Time", TimesPanel);
		
	}

	private void addsetups(JTabbedPane conConfigTab) {

		JPanel setupsPanel = new JPanel();
		conConfigTab.addTab("Contest Setup", setupsPanel);
		
	}

	private void addProblems(JTabbedPane conConfigTab) {
		
		JPanel problemsPanel = new JPanel();
		conConfigTab.addTab("Problems", problemsPanel);
		
	}

	private void addLanuages(JTabbedPane conConfigTab) {
		
		JPanel languagePanel = new JPanel();
		conConfigTab.addTab("Languages", languagePanel);
		
	}

	private void addAccountTab(JTabbedPane conConfigTab) {
		
		JPanel accountsPanel = new JPanel();
		conConfigTab.addTab("Accounts", accountsPanel);
		
		
		
	}

	private void initContestSummeryTab() {
		
		JTabbedPane summeryTab = new JTabbedPane();
		
		initLoginsTab(summeryTab);
		addRuns(summeryTab);
		addStandings(summeryTab);
		addTeamStat(summeryTab);
		addOptions(summeryTab);
		
		mainTabs.addTab("Contest Summery",summeryTab );
	}

	private void addOptions(JTabbedPane summeryTab) {

		JPanel optionPanel = new JPanel();
		summeryTab.addTab("Options", optionPanel);
		
	}

	private void addTeamStat(JTabbedPane summeryTab) {
		
		JPanel teamStatPanel = new JPanel();
		summeryTab.addTab("Team Status", teamStatPanel);
		
	}

	private void addStandings(JTabbedPane summeryTab) {
		
		JPanel standingsPanel = new JPanel();
		summeryTab.addTab("Standings", standingsPanel);
		
	}

	private void addRuns(JTabbedPane summeryTab) {
		
		JPanel runsPanel  = new JPanel();
		summeryTab.addTab("Problem Runs", runsPanel);
		
	}



	
	
	
	
	
}
