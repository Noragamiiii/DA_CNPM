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
import javax.swing.JTextField;

public class Newfr {

	private JFrame News;
	Statement sta;
	ResultSet rs;
	PreparedStatement pre;
	String link;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	private JPanel panel;
	private JTextField txtLink;
	
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
		
		InitComponent();
	}
	public void InitComponent() {

		News = new JFrame();
		News.getContentPane().setBackground(SystemColor.activeCaption);
		News.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		panel.setBounds(0, 0, 671, 449);
		News.getContentPane().add(panel);
		panel.setLayout(null);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(0, 0, 671, 449);
//		panel.add(scrollPane);
//		
//		JEditorPane editorPane = new JEditorPane();
//		panel.add(editorPane);
//		editorPane.setBounds(0, 0, 671, 410) ;
//		
		txtLink = new JTextField();
		txtLink.setBounds(0, 0, 669, 20);
		panel.add(txtLink);
		txtLink.setColumns(10);
		News.setBounds(0, 0, 687, 488);
		News.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane sp = new JScrollPane();
		String lk = txtLink.getText();
		JEditorPane editorPane = new JEditorPane();
		
		editorPane.setEditable(false);
		sp.setViewportView(editorPane);
		
		panel.add(sp);
		//link = linklee;
		try {
		    editorPane.setPage(new URL(lk));
		    } catch (Exception ex) {ex.printStackTrace();}
		
	
}
//	public void LoadPage(String linklee) {
//		JScrollPane sp = new JScrollPane();
//		JEditorPane editorPane = new JEditorPane();
//		editorPane.setEditable(false);
//		sp.setViewportView(editorPane);
//		panel.add(sp);
//		link = linklee;
//		try {
//		    editorPane.setPage(new URL(link));
//		    } catch (Exception ex) {ex.printStackTrace();}
//	}
//	
	public Newfr(String title) {
		txtLink.setText(title);
		InitComponent();
		}
	
	public void setVisible() {
		News.setVisible(true);		
	}
	}

	



