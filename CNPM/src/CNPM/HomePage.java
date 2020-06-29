package CNPM;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class HomePage extends JFrame implements ActionListener {

//	private JFrame frmHome;
	private JPanel panel, pnlHeader;
	private JButton btnExit, btnMinimize, btnMaximize;
	private boolean maximized = true;
	int xMouse, yMouse;
	private JMenuBar menuBar_1;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private String separate;

	
	
	
	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HomePage().setVisible(true);
			}
		});
	}

	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/gambar/home.png")));
		getContentPane().setBackground(SystemColor.activeCaption);
		initialize();
		
	}
	
	private void initialize() {


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Homepage");
		setUndecorated(true);
		setSize(new Dimension(1000, 600));
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		JLabel lblHompage = new JLabel();
		lblHompage.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHompage.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		lblHompage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHompage.setIcon(
				new ImageIcon(HomePage.class.getResource("/gambar/imageonline-co-whitebackgroundremoved.png")));

		JLabel lblRegister = new JLabel("Đăng kí");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register register = new Register();
				register.Show();
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JTextPane txtpntitle = new JTextPane();
		txtpntitle.setEditable(false);
		txtpntitle.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		txtpntitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
		txtpntitle.setText("HỆ THỐNG QUẢN LÍ TIÊM CHỦNG GIA SÚC GIA CẦM");

		 pnlHeader = new JPanel();
		pnlHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHeaderMousePressed(e);
			}

			public void mouseDragged(MouseEvent e) {
				pnlHeaderMouseDragged(e);
			}
		});

		pnlHeader.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));

		btnMinimize = new JButton();
		btnMinimize.setIcon(new ImageIcon(HomePage.class.getResource("/gambar/Minimize (2).png")));
		btnMinimize.setOpaque(true);
		btnMinimize.setFocusable(false);
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnMinimize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnMinimizeMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnMinimizeMouseExited(evt);
			}
		});
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMinimizeActionPerformed(evt);
			}
		});

		btnMaximize = new JButton();
		btnMaximize.setIcon(new ImageIcon(HomePage.class.getResource("/gambar/Maximize (2).png")));
		btnMaximize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMaximize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMaximizeActionPerformed(evt);
			}
		});
		btnMaximize.setOpaque(true);
		btnMaximize.setFocusable(false);
		btnMaximize.setContentAreaFilled(false);
		btnMaximize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnMaximize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnMaximizeMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnMaximizeMouseExited(evt);
			}

		});
		
		btnExit = new JButton();
		btnExit.setIcon(new ImageIcon(HomePage.class.getResource("/gambar/Exit.png")));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExitActionPerformed(e);
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExitMouseEntered(e);
			}

			public void mouseExited(MouseEvent evt) {
				btnExitMouseExited(evt);
			}

		});
		btnExit.setOpaque(true);
		btnExit.setFocusable(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		GroupLayout gl_pnlHeader = new GroupLayout(pnlHeader);
		gl_pnlHeader.setHorizontalGroup(gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlHeader.createSequentialGroup().addContainerGap(671, Short.MAX_VALUE)
						.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_pnlHeader.setVerticalGroup(gl_pnlHeader.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlHeader
				.createSequentialGroup()
				.addGroup(gl_pnlHeader.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMaximize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMinimize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExit, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
				.addContainerGap()));
		pnlHeader.setLayout(gl_pnlHeader);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(pnlHeader, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
					.addGap(0))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		
		menuBar_1 = new JMenuBar();
		menuBar_1.setBorderPainted(false);
		menuBar_1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		menuBar_1.setBorder(null);
		
		mnNewMenu_1 = new JMenu("Đăng nhập");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu_1.setForeground(Color.BLUE);
		mnNewMenu_1.setBorder(null);
		mnNewMenu_1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		menuBar_1.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("Admin");
		mntmNewMenuItem.addActionListener(this);
		
		mntmNewMenuItem.setBorder(null);
		mntmNewMenuItem.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		mntmNewMenuItem.setForeground(Color.BLUE);
		
		mnNewMenu_1.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Hộ dân");
		mntmNewMenuItem_1.setBorder(null);
		mntmNewMenuItem_1.setForeground(Color.BLUE);
		mntmNewMenuItem_1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		mntmNewMenuItem_1.addActionListener(this);
		
		mnNewMenu_1.add(mntmNewMenuItem_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(18)
					.addComponent(menuBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(menuBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(772)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblRegister, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(202)
					.addComponent(lblHompage, GroupLayout.PREFERRED_SIZE, 696, Short.MAX_VALUE)
					.addGap(102))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(246, Short.MAX_VALUE)
					.addComponent(txtpntitle, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
					.addGap(221))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblRegister, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(13)
					.addComponent(txtpntitle, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblHompage, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		
		getContentPane().setLayout(groupLayout);
	}

	private void btnExitMouseEntered(MouseEvent evt) {
		btnExit.setBackground(new Color(232, 17, 35));
	}

	private void btnExitMouseExited(MouseEvent evt) {
		btnExit.setBackground(new Color(255, 255, 255));
	}

	private void btnExitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void btnMaximizeMouseEntered(MouseEvent evt) {
		btnMaximize.setBackground(new Color(229, 229, 229));
	}

	private void btnMaximizeMouseExited(MouseEvent evt) {
		btnMaximize.setBackground(new Color(255, 255, 255));
	}

	private void btnMaximizeActionPerformed(ActionEvent evt) {
		if (maximized) {

			HomePage.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			HomePage.this.setMaximizedBounds(env.getMaximumWindowBounds());
			maximized = false;
		} else {
			setExtendedState(JFrame.NORMAL);
			maximized = true;
		}
	}

	private void btnMinimizeMouseEntered(MouseEvent evt) {
		btnMinimize.setBackground(new Color(229, 229, 229));
	}

	private void btnMinimizeMouseExited(MouseEvent evt) {
		btnMinimize.setBackground(new Color(255, 255, 255));
	}

	private void btnMinimizeActionPerformed(ActionEvent evt) {
		this.setState(Frame.ICONIFIED);
	}

	private void pnlHeaderMousePressed(MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void pnlHeaderMouseDragged(MouseEvent evt) {
		if (maximized) {
			int x = evt.getXOnScreen();
			int y = evt.getYOnScreen();
			this.setLocation(x - xMouse, y - yMouse);
		}
	}
	
	public HomePage(String sepa) {
		this.separate = sepa;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmNewMenuItem ) {
			login Login = new login();
			(new HomePage()).setSeparate("Admin");
			Login.Show();
		}
		
		if(e.getSource() == mntmNewMenuItem_1) {
			login Login = new login();
			(new HomePage()).setSeparate("Hodan");
			Login.Show();
		}
		
	}
	public  void setSeparate(String Separate) {
		this.separate = Separate;
	}
	public String getSeparate() {
		return this.separate;
	}
}
