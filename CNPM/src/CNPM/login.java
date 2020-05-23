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
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

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
import java.awt.event.MouseMotionAdapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;

import CNPM.Register;
import CNPM.Connect_DB;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.LayoutStyle.ComponentPlacement;

public class login {

	private JFrame frmLogin;
//	private JTextField txtusername;
//	private JPasswordField passwordField;
//	private JTextField textField;
//	private JPasswordField passwordField_1;
	private JButton btnExitt, btnminimize;
	static boolean maximized = true;
	int xMouse, yMouse;
	Connection connect = null;
//	private JTextField textField_1;
//	private JTextField textField_2;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		try {
			connect = Connect_DB.getSQLServer();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setBounds(new Rectangle(0, 0, 700, 311));//getContentPane().
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\tiu\\icon\\user.png"));
		frmLogin.setTitle("Đăng nhập");
		//frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setBackground(SystemColor.activeCaption);
		frmLogin.setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(361, 11, 323, 279);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/gambar/people.png")));

		JLabel lblsignin = new JLabel();
		lblsignin.setBounds(104, 11, 150, 43);
		lblsignin.setText("Đăng nhập");
		lblsignin.setBackground(Color.LIGHT_GRAY);
		lblsignin.setFont(new Font("Arial", Font.BOLD, 14));
		lblsignin.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblusername = new JLabel();
		lblusername.setBounds(22, 76, 96, 22);
		lblusername.setText("Tên đăng nhập");
		lblusername.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblusername.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblmatkhau = new JLabel();
		lblmatkhau.setBounds(22, 137, 72, 20);
		lblmatkhau.setText("Mật khẩu");
		lblmatkhau.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblmatkhau.setHorizontalAlignment(SwingConstants.CENTER);

//		textField = new JTextField();
//		textField.setFont(new Font("Arial", Font.PLAIN, 12));
//		textField.setBounds(128, 71, 161, 29);
//		textField.setBorder(null);
//		textField.setColumns(10);

//		passwordField_1 = new JPasswordField();
//		passwordField_1.setBounds(128, 127, 161, 29);
//		passwordField_1.setBorder(null);

		JButton btnlogin = new JButton();
		btnlogin.setBounds(87, 235, 91, 29);
		btnlogin.setText("Đăng nhập");
		btnlogin.setFocusable(false);
		btnlogin.setFont(new Font("Arial", Font.BOLD, 16)); // NOI18N
		btnlogin.setForeground(new Color(44, 62, 80));
		btnlogin.setContentAreaFilled(false);
		btnlogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnlogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {

					String url = "select * from HoDan where Username = ? and iPassword = ?";
					PreparedStatement pre = connect.prepareStatement(url);

					char getpass[];
					String password = "";
					getpass = passwordField.getPassword();
					password = String.valueOf(getpass);

					pre.setString(1, txtUsername.getText());
					pre.setString(2, password);

					ResultSet rs = pre.executeQuery();
					int count = 0;
					while (rs.next()) {
						count = count + 1;
					}
					if (count == 1) {
						JOptionPane.showMessageDialog(null, "Username and Password are correct!");
						Dashboard db = new Dashboard();
						db.show();  // goto Dashboard
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Username or Password is incorrect. Try again");
					}

					rs.close();
					pre.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "System error! " + ex);
				}
			}
		});

		btnlogin.setBackground(new Color(255, 255, 255));
		btnlogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 153)));
		btnlogin.setFont(new Font("Segoe UI", Font.BOLD, 12));

		JButton btncancel = new JButton();
		btncancel.setBounds(211, 234, 91, 29);
		btncancel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 153)));
		btncancel.setText("Hủy");
		btncancel.setFocusable(false);
		btncancel.setFont(new Font("Arial", Font.BOLD, 12)); // NOI18N
		btncancel.setForeground(new Color(44, 62, 80));
		btncancel.setContentAreaFilled(false);
		btncancel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JLabel lblnewacc = new JLabel();
		lblnewacc.setBounds(124, 274, 150, 22);
		lblnewacc.setText("Đăng kí tài khoản mới");
		lblnewacc.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblnewacc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmLogin.dispose();
				Register regist = new Register();
				regist.Show();

			}
		});
		lblnewacc.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox chckbxShowPassword = new JCheckBox("Show password");
		chckbxShowPassword.setBounds(128, 189, 126, 23);
		chckbxShowPassword.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlHeader.setForeground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.addMouseMotionListener(new MouseMotionAdapter() {
	            public void mouseDragged(MouseEvent evt) {
	                pnlHeaderMouseDragged(evt);
	            }
	        });
	     pnlHeader.addMouseListener(new MouseAdapter() {
	            public void mousePressed(MouseEvent evt) {
	                pnlHeaderMousePressed(evt);
	            }
	        });
		btnExitt = new JButton();
		btnExitt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExitt.setBorder(null);
		
		btnminimize = new JButton();
		btnminimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnminimize.setBorder(null);
		btnminimize.setOpaque(true);
		btnminimize.setFocusable(false);
		btnminimize.setContentAreaFilled(false);
		btnminimize.setBackground(Color.WHITE);
		GroupLayout gl_pnlHeader = new GroupLayout(pnlHeader);
		gl_pnlHeader.setHorizontalGroup(
			gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlHeader.createSequentialGroup()
					.addContainerGap(578, Short.MAX_VALUE)
					.addComponent(btnminimize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExitt, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlHeader.setVerticalGroup(
			gl_pnlHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlHeader.createSequentialGroup()
					.addGroup(gl_pnlHeader.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnExitt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnminimize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addContainerGap())
		);
		pnlHeader.setLayout(gl_pnlHeader);
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE)
				.addComponent(pnlHeader, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
				.addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
		);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBounds(128, 74, 184, 28);
		txtUsername.setColumns(10);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(lblsignin);
		panel.add(lblusername);
		panel.add(lblmatkhau);
		panel.add(btnlogin);
		panel.add(btncancel);
		panel.add(lblnewacc);
		panel.add(chckbxShowPassword);
		panel.add(txtUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBounds(128, 137, 184, 29);
		panel.add(passwordField);
		
//		textField_1 = new JTextField();
//		textField_1.setBorder(null);
//		textField_1.setBounds(126, 76, 176, 29);
//		panel.add(textField_1);
//		textField_1.setColumns(10);
		
//		textField_2 = new JTextField();
//		textField_2.setBorder(null);
//		textField_2.setColumns(10);
//		textField_2.setBounds(126, 132, 176, 29);
//		panel.add(textField_2);
		frmLogin.getContentPane().setLayout(groupLayout);
		 
		btnExitt.setBackground(new Color(255, 255, 255));
		btnExitt.setIcon(new ImageIcon(getClass().getResource("/gambar/Exit.png"))); // NOI18N
		btnExitt.setContentAreaFilled(false);
	    btnExitt.setFocusable(false);
	    btnExitt.setOpaque(true);
	    btnExitt.setRolloverIcon(new ImageIcon(getClass().getResource("/gambar/Exit (2).png"))); // NOI18N
	    btnExitt.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent evt) {
	                btnExitMouseEntered(evt);
	            }
	            
				public void mouseExited(MouseEvent evt) {
	                btnExitMouseExited(evt);
	            }
	        });
	    btnExitt.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                btnExitActionPerformed(evt);
	            }
	        });

	        
	        
	        btnminimize.setBackground(new Color(255, 255, 255));
	        btnminimize.setIcon(new ImageIcon(getClass().getResource("/gambar/Minimize.png"))); // NOI18N
	        btnminimize.setContentAreaFilled(false);
	        btnminimize.setFocusable(false);
	        btnminimize.setOpaque(true);
	        btnminimize.setRolloverIcon(new ImageIcon(getClass().getResource("/gambar/Minimize (2).png")));
	        btnminimize.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent evt) {
	                btnMinimizeMouseEntered(evt);
	            }
	            public void mouseExited(MouseEvent evt) {
	                btnMinimizeMouseExited(evt);
	            }
	        });
	        btnminimize.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                btnMinimizeActionPerformed(evt);
	            }
	        });
	    
	
	}
	 private void btnExitMouseEntered(MouseEvent evt) {                                     
	        btnExitt.setBackground(new Color(232,17,35));
	    }                                    

	    private void btnExitMouseExited(MouseEvent evt) {                                    
	        btnExitt.setBackground(new Color(255,255,255));
	    }                                   

	    private void btnExitActionPerformed(ActionEvent evt) {                                        
	        System.exit(0);
	    }                                       

	    private void btnMinimizeMouseEntered(MouseEvent evt) {                                         
	        btnminimize.setBackground(new Color(229,229,229));
	    }                                        

	    private void btnMinimizeMouseExited(MouseEvent evt) {                                        
	        btnminimize.setBackground(new Color(255,255,255));
	    }                                       

	    private void btnMinimizeActionPerformed(ActionEvent evt) {                                            
	        frmLogin.setState(Frame.ICONIFIED);
	    }                                           

	    private void pnlHeaderMousePressed(MouseEvent evt) {                                       
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }                                      

	    private void pnlHeaderMouseDragged(MouseEvent evt) {                                       
	        if(maximized){
	            int x = evt.getXOnScreen();
	            int y = evt.getYOnScreen();
	           frmLogin.setLocation(x - xMouse, y - yMouse);
	        }
	    }  

	public void Show() {
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setVisible(true);

	}
}
