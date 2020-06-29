package CNPM;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class Newfr {

	private JFrame News;
	Statement sta;
	ResultSet rs;
	PreparedStatement pre;
	String link;
	private JPanel panel;
	
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

		News = new JFrame();
		News.getContentPane().setBackground(SystemColor.activeCaption);
		News.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		panel.setBounds(0, 0, 671, 449);
		News.getContentPane().add(panel);
		News.setBounds(100, 100, 687, 488);
		News.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
	
	public void InitComponent() {
		
	}
	
	public Newfr(String title) {
	
		JScrollPane sp = new JScrollPane();
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		sp.setViewportView(editorPane);
		panel.add(sp);
		link = title;
		try {
		    editorPane.setPage(new URL(link));
		    } catch (Exception ex) {ex.printStackTrace();}
		}
	
	public void setVisible() {
		News.setVisible(true);		
	}
		
	}

	



