package CNPM;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  
public class AddNews extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtLink;
	private Connection connect;
	PreparedStatement pre;
	Statement sta;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNews frame = new AddNews();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddNews() {
		try {
			connect = Connect_DB.getSQLServer();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 540, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 524, 194);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ti\u00EAu \u0111\u1EC1");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(42, 31, 81, 38);
		panel.add(lblNewLabel);

		JLabel lblLink = new JLabel("Link");
		lblLink.setHorizontalAlignment(SwingConstants.CENTER);
		lblLink.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLink.setBounds(42, 95, 81, 38);
		panel.add(lblLink);

		txtTitle = new JTextField();
		txtTitle.setBorder(null);
		txtTitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtTitle.setBounds(132, 31, 366, 31);
		panel.add(txtTitle);
		txtTitle.setColumns(10);

		txtLink = new JTextField();
		txtLink.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtLink.setColumns(10);
		txtLink.setBorder(null);
		txtLink.setBounds(133, 95, 366, 31);
		panel.add(txtLink);

		JButton btnCpNht = new JButton("C\u1EADp nh\u1EADt");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateNews();
			}
		});
		btnCpNht.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCpNht.setBackground(SystemColor.activeCaption);
		btnCpNht.setBorder(null);
		btnCpNht.setBounds(169, 152, 89, 31);
		panel.add(btnCpNht);

		JButton btnHy = new JButton("H\u1EE7y");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitle.setText("");
				txtLink.setText("");
				setVisible(false);
			}
		});
		btnHy.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnHy.setBorder(null);
		btnHy.setBackground(SystemColor.activeCaption);
		btnHy.setBounds(316, 152, 89, 31);
		panel.add(btnHy);
	}

	public void UpdateNews() {
		String title = txtTitle.getText();
		String link = txtLink.getText();

		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  // yyyy/MM/dd
	    String strDate = formatter.format(date); 
	 
		
	    News news;
		ArrayList<News> n = new ArrayList<News>();
		
		
		try {
			String sql = "insert into News (Title, LinktoWeb, Datepost) values (?, ?, ?)";
			pre = connect.prepareStatement(sql);
			news = new News(title, link, strDate);
			n.add(news);
			pre.setString(1, n.get(0).getTitle());
			pre.setString(2, n.get(0).getLinktoWeb());
			pre.setString(3, n.get(0).getDatepost());
			
			pre.execute();
			JOptionPane.showMessageDialog(null, "Update successfully");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

	}

}
