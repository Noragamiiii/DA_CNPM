package CNPM;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Newfr {

	private JFrame News;
	private Connection connect;
	Statement sta;
	ResultSet rs;
	PreparedStatement pre;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newfr register = new Newfr();
					register.News.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Newfr() {
	try {
		connect =  Connect_DB.getSQLServer();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
		News = new JFrame();
		News.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\tiu\\icon\\register.png"));
		News.getContentPane().setBackground(SystemColor.activeCaption);
		News.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		panel.setBounds(0, 0, 671, 449);
		News.getContentPane().add(panel);
		News.setBounds(100, 100, 687, 488);
		News.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	public ArrayList<News> UserList() {
		ArrayList<News> news = new ArrayList<News>();
		try {
			String sql = "select Title, LinktoWeb, Datepost from News";
			sta = connect.createStatement();
			rs = sta.executeQuery(sql);
			News userlist;
			while (rs.next()) {
				userlist = new News(rs.getString(2), rs.getString(3), rs.getString(4));
				news.add(userlist);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		return news;
	}
	


}
