package CNPM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;

import CNPM.Register;
import CNPM.Connect_DB;

public class login {

	private JFrame frmngNhp;
	private JTextField txtusername;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	Connection connect = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmngNhp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Connect_DB connect;

	public login() {
		// initialize();
		// connect = Connect_DB.getSQLServer();
		try {
			connect = Connect_DB.getSQLServer();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frmngNhp = new JFrame();
		frmngNhp.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmngNhp.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\tiu\\icon\\user.png"));
		frmngNhp.setTitle("\u0110\u0103ng nh\u1EADp");
		frmngNhp.setBounds(100, 100, 799, 447);
		frmngNhp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmngNhp.getContentPane().setBackground(SystemColor.activeCaption);
		frmngNhp.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(83, 69, 643, 301);
		frmngNhp.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel.setBounds(351, 11, 282, 279);
		lblNewLabel.setIcon(new ImageIcon("E:\\tiu\\icon\\agriculture (2).png"));
		panel.add(lblNewLabel);

		JLabel lblsignin = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblsignin.setBackground(Color.LIGHT_GRAY);
		lblsignin.setFont(new Font("Arial", Font.BOLD, 14));
		lblsignin.setHorizontalAlignment(SwingConstants.CENTER);
		lblsignin.setBounds(104, 11, 150, 43);
		panel.add(lblsignin);

		JLabel lblusername = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblusername.setHorizontalAlignment(SwingConstants.CENTER);
		lblusername.setBounds(10, 96, 96, 22);
		panel.add(lblusername);

		JLabel lblmatkhau = new JLabel("M\u1EADt kh\u1EA9u");
		lblmatkhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblmatkhau.setBounds(22, 151, 72, 20);
		panel.add(lblmatkhau);

		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(128, 89, 161, 29);
		panel.add(textField);
		textField.setColumns(10);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		passwordField_1.setBounds(128, 147, 161, 29);
		panel.add(passwordField_1);

		JButton btnlogin = new JButton("\u0110\u0103ng nh\u1EADp");
		btnlogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {

					String url = "select * from HoDan where Username = ? and iPassword = ?";
					PreparedStatement pre = connect.prepareStatement(url);
					pre.setString(1, txtusername.getText());
					pre.setString(2, passwordField.getText());
					ResultSet rs = pre.executeQuery();
					int count = 0;
					while (rs.next()) {
						count = count + 1;
					}
					if (count == 1) {
						JOptionPane.showMessageDialog(null, "Username and Password are correct!");
						// goto Home page
					}
					if (count > 1) {
							// chua biet lam gi, nen de do cai da
					} else {
						JOptionPane.showMessageDialog(null, "Username or Password is incorrect. Try again");
					}

					rs.close();
					pre.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "System error! " + ex);
				}
			}
		});

		btnlogin.setBackground(SystemColor.activeCaptionBorder);
		btnlogin.setBorder(new LineBorder(SystemColor.text));
		btnlogin.setFont(new Font("Arial", Font.BOLD, 11));
		btnlogin.setBounds(116, 215, 79, 23);
		panel.add(btnlogin);

		JButton btncancel = new JButton("H\u1EE7y");
		btncancel.setBackground(SystemColor.activeCaptionBorder);
		btncancel.setBorder(new LineBorder(SystemColor.text));
		btncancel.setFont(new Font("Arial", Font.BOLD, 11));
		btncancel.setBounds(231, 215, 79, 23);
		panel.add(btncancel);

		JLabel lblnewacc = new JLabel("\u0110\u0103ng k\u00ED t\u00E0i kho\u1EA3n");
		lblnewacc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmngNhp.dispose();
				Register regist = new Register();
				regist.Show();
				
				// regist.setVisible(true;)

			}
		});
		lblnewacc.setHorizontalAlignment(SwingConstants.CENTER);
		lblnewacc.setBounds(124, 268, 150, 22);
		panel.add(lblnewacc);

		JCheckBox chckbxShowPassword = new JCheckBox("Show password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected()) {
					passwordField_1.setEchoChar((char) 0);
				} else {
					passwordField_1.setEchoChar('*');
				}
			}
		});
		chckbxShowPassword.setBounds(128, 183, 126, 23);
		panel.add(chckbxShowPassword);

		/*
		 * JPanel panel = new JPanel(); panel.setForeground(Color.GRAY);
		 * panel.setBackground(Color.GRAY); panel.setBorder(new LineBorder(Color.WHITE,
		 * 2, true)); panel.setLayout(null);
		 * 
		 * JLabel lbluserlogin = new JLabel("User Login"); lbluserlogin.setBounds(111,
		 * 22, 104, 24); lbluserlogin.setHorizontalAlignment(SwingConstants.CENTER);
		 * lbluserlogin.setForeground(Color.WHITE);
		 * 
		 * lbluserlogin.setFont(new Font("Arial", Font.BOLD, 14));
		 * lbluserlogin.setIcon(null); panel.add(lbluserlogin);
		 * 
		 * JLabel lblusername = new JLabel("Username"); lblusername.setBounds(10, 76,
		 * 73, 27); lblusername.setBackground(Color.WHITE);
		 * lblusername.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblusername.setFont(new Font("Arial", Font.BOLD, 11));
		 * lblusername.setIcon(null); panel.add(lblusername);
		 * 
		 * txtusername = new JTextField(); txtusername.setBounds(82, 76, 185, 27);
		 * panel.add(txtusername); txtusername.setColumns(10);
		 * 
		 * JLabel lblpassword = new JLabel("Password"); lblpassword.setBounds(10, 131,
		 * 73, 24); lblpassword.setBackground(Color.WHITE);
		 * lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblpassword.setFont(new Font("Arial", Font.BOLD, 11));
		 * lblpassword.setIcon(null); panel.add(lblpassword);
		 * 
		 * passwordField = new JPasswordField(); passwordField.setBounds(82, 128, 185,
		 * 27); panel.add(passwordField);
		 * 
		 * JButton btnlogin = new JButton("Login"); btnlogin.setBounds(49, 188, 73, 23);
		 * btnlogin.setBackground(Color.GRAY); btnlogin.setBorder(new
		 * BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, null, null));
		 * btnlogin.setForeground(Color.BLACK); btnlogin.setFont(new Font("Arial",
		 * Font.BOLD, 11)); panel.add(btnlogin);
		 * 
		 * JButton btncancel = new JButton("Cancel"); btncancel.setBounds(161, 188, 73,
		 * 23); btncancel.setForeground(Color.BLACK); btncancel.setBorder(new
		 * BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, null, null));
		 * btncancel.setBackground(Color.GRAY); btncancel.setFont(new Font("Arial",
		 * Font.BOLD, 11)); panel.add(btncancel);
		 * 
		 * JLabel lblCreatenew = new JLabel("Create a new account");
		 * lblCreatenew.setBounds(49, 244, 185, 14);
		 * lblCreatenew.setHorizontalAlignment(SwingConstants.CENTER);
		 * panel.add(lblCreatenew); JLabel label = new JLabel(""); label.setBounds(298,
		 * 7, 264, 257); label.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new
		 * Color(0, 0, 0))); panel.add(label);
		 * label.setHorizontalTextPosition(SwingConstants.CENTER);
		 * label.setHorizontalAlignment(SwingConstants.CENTER); label.setIcon(new
		 * ImageIcon("E:\\tiu\\icon\\agriculture (2).png"));
		 */
	}
}
