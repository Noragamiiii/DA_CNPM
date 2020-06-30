
package CNPM;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JEditorPane;

@SuppressWarnings("serial")
public class Dashboard extends JFrame {

	static boolean maximized = true;

	int xMouse;
	int yMouse;
	Connection connect = null;
	private JButton btnExit, btnMaximize, btnMinimize, btnNews, btnTimeline;
	private JLabel fullname, jLabel12, jLabel13, jLabel17, jLabel6, jLabel7, jLabel8, jLabel9, lblNewLabel, lblNews,
			lblTimeline, lblfullname, label_1;
	private JPanel Hodan_management, DangkiTiem, LichDaDangKy, lichtiem, pnlBody, pnlHeader, pnlMenu, pnlNews, LichTiem, panel, Update_Vaccine, UpdateNews;
	private JScrollPane jspTimeline, jspNews;
	private GroupLayout pnlHeaderLayout, pnlMenuLayout, gl_Hodan_management, gl_DangkiTiem, gl_LichDaDangKy, gl_lichtiem,
			gl_LichTiem, layout, gl_panel, pnlNewsLayout;
	public String iRole;
	Statement sta;
	PreparedStatement pre;
	ResultSet rs;
	DefaultTableModel tablemodel;
	JTable tabel;
	JScrollPane scr;
	xxx getLink;
	
	public String getiRole() {
		return iRole;
	}

	public void setiRole(String iRole) {
		this.iRole = iRole;
	}

	private String name;
	private JTable table;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dashboard(String Fullname, String role) {
		initComponents();
		fullname.setText(Fullname);
		iRole = role;
		if(iRole.equals("Ho dan")) {
			UpdateNews.setEnabled(true);
			Update_Vaccine.setEnabled(true);
			Hodan_management.setEnabled(true);
		}
		
	}
	public Dashboard(xxx link) {
		getLink = link;
	}
	
	public Dashboard() {
		try {
			connect = Connect_DB.getSQLServer();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/gambar/dashboard (2).png")));
		getContentPane().setBackground(SystemColor.activeCaption);
		initComponents();
		
	}
	
	private void initComponents() {
		
		pnlHeader = new JPanel();
		btnExit = new JButton();
		btnMaximize = new JButton();
		btnMinimize = new JButton();
		pnlMenu = new JPanel();
		btnTimeline = new JButton();
		btnTimeline.setText("BẢNG ĐIỀU KHIỂN");
		lblTimeline = new JLabel();
		btnNews = new JButton();
		lblNews = new JLabel();
		jLabel17 = new JLabel();
		jLabel17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage home = new HomePage();
				home.setVisible(true);
				setVisible(false);
			}
		});
		fullname = new JLabel();
		fullname.setFont(new Font("Arial", Font.BOLD, 14));
		pnlBody = new JPanel();
		jspTimeline = new JScrollPane();
		LichTiem = new JPanel();
		Hodan_management = new JPanel();
		Hodan_management.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 102)));
		jLabel6 = new JLabel();
		jLabel6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditInfo infor = new EditInfo();
				infor.setVisible(true);
			}
		});
		DangkiTiem = new JPanel();
		DangkiTiem.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 153)));
		jLabel7 = new JLabel();
		LichDaDangKy = new JPanel();
		LichDaDangKy.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 204)));
		jLabel8 = new JLabel();
		jLabel13 = new JLabel();
		lichtiem = new JPanel();
		lichtiem.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 255)));
		jLabel9 = new JLabel();
		pnlNews = new JPanel();
		pnlNews.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Dashboard");
		setUndecorated(true);
		setSize(new Dimension(1000, 600));

		pnlHeader.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
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

		btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnExit.setIcon(new ImageIcon(getClass().getResource("/gambar/Exit.png")));
		btnExit.setContentAreaFilled(false);
		btnExit.setFocusable(false);
		btnExit.setOpaque(true);
		btnExit.setRolloverIcon(new ImageIcon(getClass().getResource("/gambar/Exit (2).png")));

		btnExit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnExitMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnExitMouseExited(evt);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});

		btnMaximize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnMaximize.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/Maximize (2).png")));
		btnMaximize.setContentAreaFilled(false);
		btnMaximize.setFocusable(false);
		btnMaximize.setOpaque(true);
		btnMaximize.setRolloverIcon(new ImageIcon(getClass().getResource("/Gambar/Maximize (2).png")));
		btnMaximize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnMaximizeMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnMaximizeMouseExited(evt);
			}
		});
		btnMaximize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMaximizeActionPerformed(evt);
			}
		});

		btnMinimize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnMinimize.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/Minimize (2).png")));
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setFocusable(false);
		btnMinimize.setOpaque(true);
		btnMinimize.setRolloverIcon(new ImageIcon(getClass().getResource("/gambar/Minimize (2).png")));
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

		pnlHeaderLayout = new GroupLayout(pnlHeader);
		pnlHeaderLayout.setHorizontalGroup(
			pnlHeaderLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(pnlHeaderLayout.createSequentialGroup()
					.addContainerGap(839, Short.MAX_VALUE)
					.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit))
		);
		pnlHeaderLayout.setVerticalGroup(
			pnlHeaderLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
					.addGroup(pnlHeaderLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(btnMaximize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(btnMinimize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		pnlHeader.setLayout(pnlHeaderLayout);

		pnlMenu.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		btnTimeline.setFont(new Font("Arial", Font.BOLD, 16));
		btnTimeline.setForeground(new Color(44, 62, 80));
		btnTimeline.setContentAreaFilled(false);
		btnTimeline.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTimeline.setFocusable(false);
		btnTimeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnTimelineActionPerformed(evt);
			}
		});

		lblTimeline.setBackground(new Color(0, 102, 153));
		lblTimeline.setOpaque(true);

		btnNews.setFont(new Font("Arial", Font.BOLD, 16));
		btnNews.setForeground(new Color(44, 62, 80));
		btnNews.setText("TIN TỨC");
		btnNews.setContentAreaFilled(false);
		btnNews.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNews.setFocusable(false);
		btnNews.setPreferredSize(new Dimension(100, 27));
		btnNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNewsActionPerformed(evt);
			}
		});

		lblNews.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		lblNews.setOpaque(true);

		jLabel17.setFont(new Font("Segoe UI", 0, 14));
		jLabel17.setForeground(new Color(52, 152, 219));
		jLabel17.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel17.setText("Đăng xuất");
		jLabel17.setCursor(new Cursor(Cursor.HAND_CURSOR));

		lblfullname = new JLabel("");
		lblfullname.setHorizontalAlignment(SwingConstants.CENTER);
		lblfullname.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/icons8-customer-30.png")));
		lblfullname.setFont(new Font("Arial", Font.BOLD, 14));

		pnlMenuLayout = new GroupLayout(pnlMenu);
		pnlMenuLayout.setHorizontalGroup(
			pnlMenuLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(pnlMenuLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(pnlMenuLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(pnlMenuLayout.createSequentialGroup()
							.addGap(51)
							.addGroup(pnlMenuLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblTimeline, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTimeline))
							.addGap(125)
							.addGroup(pnlMenuLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNews, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNews, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(pnlMenuLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblfullname, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(fullname, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 561, Short.MAX_VALUE)
							.addComponent(jLabel17)
							.addGap(18))))
		);
		pnlMenuLayout.setVerticalGroup(
			pnlMenuLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(pnlMenuLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(pnlMenuLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(pnlMenuLayout.createSequentialGroup()
							.addGap(8)
							.addGroup(pnlMenuLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(jLabel17)
								.addGroup(pnlMenuLayout.createSequentialGroup()
									.addGroup(pnlMenuLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblfullname, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
										.addComponent(fullname, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(48)
							.addComponent(btnTimeline)
							.addComponent(lblTimeline, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))
						.addGroup(pnlMenuLayout.createSequentialGroup()
							.addComponent(btnNews, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNews, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))))
		);
		pnlMenu.setLayout(pnlMenuLayout);

		pnlBody.setLayout(new CardLayout());

		jspTimeline.setBorder(null);
		jspTimeline.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		LichTiem.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		Hodan_management.setBackground(new Color(157, 182, 212));
		Hodan_management.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jLabel6.setBackground(new Color(92, 118, 169));
		jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jLabel6.setForeground(new Color(0, 0, 0));
		jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel6.setText("Quản lý hộ dân");
		jLabel6.setOpaque(true);
		jLabel12 = new JLabel();

		jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel12.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/hr.png")));

		gl_Hodan_management = new GroupLayout(Hodan_management);
		gl_Hodan_management.setHorizontalGroup(gl_Hodan_management.createParallelGroup(Alignment.TRAILING)
				.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(gl_Hodan_management.createSequentialGroup().addGap(10).addComponent(jLabel12,
						GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)));
		gl_Hodan_management.setVerticalGroup(gl_Hodan_management.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Hodan_management.createSequentialGroup()
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		Hodan_management.setLayout(gl_Hodan_management);

		DangkiTiem.setBackground(new Color(169, 196, 217));
		DangkiTiem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jLabel7.setBackground(new Color(116, 143, 196));
		jLabel7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jLabel7.setForeground(new Color(0, 0, 0));
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setText("Đăng kí lịch tiêm");
		jLabel7.setOpaque(true);

		label_1 = new JLabel();
		label_1.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/vaccine (1).png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);

		gl_DangkiTiem = new GroupLayout(DangkiTiem);
		gl_DangkiTiem.setHorizontalGroup(gl_DangkiTiem.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						gl_DangkiTiem.createSequentialGroup().addContainerGap(34, Short.MAX_VALUE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_DangkiTiem.setVerticalGroup(gl_DangkiTiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DangkiTiem.createSequentialGroup()
						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));
		DangkiTiem.setLayout(gl_DangkiTiem);

		LichDaDangKy.setBackground(new Color(193, 215, 226));
		LichDaDangKy.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jLabel8.setBackground(new Color(139, 166, 221));
		jLabel8.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jLabel8.setForeground(new Color(0, 0, 0));
		jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel8.setText("Lịch đã đăng kí");
		jLabel8.setOpaque(true);

		jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel13.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/calendar (1).png")));

		gl_LichDaDangKy = new GroupLayout(LichDaDangKy);
		gl_LichDaDangKy.setHorizontalGroup(gl_LichDaDangKy.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(gl_LichDaDangKy.createSequentialGroup().addContainerGap()
						.addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE).addContainerGap()));
		gl_LichDaDangKy.setVerticalGroup(gl_LichDaDangKy.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LichDaDangKy.createSequentialGroup()
						.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		LichDaDangKy.setLayout(gl_LichDaDangKy);

		lichtiem.setBackground(new Color(212, 233, 238));
		lichtiem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jLabel9.setBackground(new Color(186, 207, 250));
		jLabel9.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jLabel9.setForeground(new Color(0, 0, 0));
		jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel9.setText("Lịch tiêm");
		jLabel9.setOpaque(true);

		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/schedule.png")));

		gl_lichtiem = new GroupLayout(lichtiem);
		gl_lichtiem.setHorizontalGroup(gl_lichtiem.createParallelGroup(Alignment.TRAILING)
				.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_lichtiem.createSequentialGroup().addGap(19)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addGap(24)));
		gl_lichtiem.setVerticalGroup(gl_lichtiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lichtiem.createSequentialGroup()
						.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		lichtiem.setLayout(gl_lichtiem);
		
		 Update_Vaccine = new JPanel();
		Update_Vaccine.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 255)));
		Update_Vaccine.setBackground(new Color(212, 233, 238));
		
		JLabel lblCpNhtVaccine = new JLabel();
		lblCpNhtVaccine.setText("Cập nhật Vaccine");
		lblCpNhtVaccine.setOpaque(true);
		lblCpNhtVaccine.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpNhtVaccine.setForeground(Color.BLACK);
		lblCpNhtVaccine.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCpNhtVaccine.setBackground(new Color(186, 207, 250));
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/vaccine (2).png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_Update_Vaccine = new GroupLayout(Update_Vaccine);
		gl_Update_Vaccine.setHorizontalGroup(
			gl_Update_Vaccine.createParallelGroup(Alignment.LEADING)
				.addGap(0, 252, Short.MAX_VALUE)
				.addComponent(lblCpNhtVaccine, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(gl_Update_Vaccine.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_Update_Vaccine.setVerticalGroup(
			gl_Update_Vaccine.createParallelGroup(Alignment.LEADING)
				.addGap(0, 238, Short.MAX_VALUE)
				.addGroup(gl_Update_Vaccine.createSequentialGroup()
					.addComponent(lblCpNhtVaccine, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		Update_Vaccine.setLayout(gl_Update_Vaccine);
		
		 UpdateNews = new JPanel();
		 UpdateNews.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		AddNews news = new AddNews();
		 		news.setVisible(true);
		 	}
		 });
		UpdateNews.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 255)));
		UpdateNews.setBackground(new Color(212, 233, 238));
		
		JLabel lblCpNhtVaccine_1 = new JLabel();
		lblCpNhtVaccine_1.setText("Cập nhật bảng tin");
		lblCpNhtVaccine_1.setOpaque(true);
		lblCpNhtVaccine_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpNhtVaccine_1.setForeground(Color.BLACK);
		lblCpNhtVaccine_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCpNhtVaccine_1.setBackground(new Color(186, 207, 250));
		
		JLabel lblNewLabel_1_1 = new JLabel();
		lblNewLabel_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/news.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_UpdateNews = new GroupLayout(UpdateNews);
		gl_UpdateNews.setHorizontalGroup(
			gl_UpdateNews.createParallelGroup(Alignment.LEADING)
				.addGap(0, 252, Short.MAX_VALUE)
				.addGap(0, 252, Short.MAX_VALUE)
				.addComponent(lblCpNhtVaccine_1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(gl_UpdateNews.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_UpdateNews.setVerticalGroup(
			gl_UpdateNews.createParallelGroup(Alignment.LEADING)
				.addGap(0, 238, Short.MAX_VALUE)
				.addGap(0, 238, Short.MAX_VALUE)
				.addGroup(gl_UpdateNews.createSequentialGroup()
					.addComponent(lblCpNhtVaccine_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		UpdateNews.setLayout(gl_UpdateNews);

		gl_LichTiem = new GroupLayout(LichTiem);
		gl_LichTiem.setHorizontalGroup(
			gl_LichTiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LichTiem.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_LichTiem.createParallelGroup(Alignment.TRAILING)
						.addComponent(lichtiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Hodan_management, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_LichTiem.createParallelGroup(Alignment.LEADING)
						.addComponent(DangkiTiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Update_Vaccine, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_LichTiem.createParallelGroup(Alignment.LEADING)
						.addComponent(UpdateNews, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addComponent(LichDaDangKy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(61))
		);
		gl_LichTiem.setVerticalGroup(
			gl_LichTiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LichTiem.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_LichTiem.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(LichDaDangKy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Hodan_management, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(DangkiTiem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(27)
					.addGroup(gl_LichTiem.createParallelGroup(Alignment.LEADING)
						.addComponent(lichtiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Update_Vaccine, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addComponent(UpdateNews, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		LichTiem.setLayout(gl_LichTiem);

		jspTimeline.setViewportView(LichTiem);

		pnlBody.add(jspTimeline, "card2");

		pnlNews.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		jspNews = new JScrollPane();
		jspNews.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jspNews.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jspNews.setBorder(null);

		pnlNewsLayout = new GroupLayout(pnlNews);
		pnlNewsLayout.setHorizontalGroup(pnlNewsLayout.createParallelGroup(Alignment.TRAILING).addComponent(jspNews,
				Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE));
		pnlNewsLayout.setVerticalGroup(pnlNewsLayout.createParallelGroup(Alignment.LEADING).addComponent(jspNews,
				GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE));

		panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		jspNews.setViewportView(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		scrollPane.setBorder(null);
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(69)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 739, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(190, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(63)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(636, Short.MAX_VALUE))
		);
		
		panel.setLayout(gl_panel);
		pnlNews.setLayout(pnlNewsLayout);
		
		tablemodel = new DefaultTableModel(); 
		table = new JTable(tablemodel);
		table.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		table.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		tablemodel.addColumn("Tin tức");
		tablemodel.addColumn("Ngày đăng");
		
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getLink();
				
			}
		});
		
		panel.setLayout(gl_panel);
		pnlNews.setLayout(pnlNewsLayout);

		pnlBody.add(pnlNews, "card4");

		layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlBody, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnlHeader, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addComponent(pnlMenu, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlMenu, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlBody, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
				
		);
		getContentPane().setLayout(layout);

		setSize(new Dimension(1000, 600));
		setLocationRelativeTo(null);
		

		
	}

	private void btnExitMouseEntered(MouseEvent evt) {
		btnExit.setBackground(new Color(232, 17, 35));
	}

	private void btnExitMouseExited(MouseEvent evt) {
		btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}
	

	private void btnExitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void btnMaximizeMouseEntered(MouseEvent evt) {
		btnMaximize.setBackground(new Color(229, 229, 229));
	}

	private void btnMaximizeMouseExited(MouseEvent evt) {
		btnMaximize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}

	private void btnMaximizeActionPerformed(ActionEvent evt) {
		if (maximized) {

			Dashboard.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Dashboard.this.setMaximizedBounds(env.getMaximumWindowBounds());
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
		btnMinimize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
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

	private void btnNewsActionPerformed(ActionEvent evt) {
		lblNews.setBackground(new Color(0, 102, 153));

		lblTimeline.setBackground(new Color(215, 228, 242));

		pnlBody.removeAll();
		pnlBody.repaint();
		pnlBody.revalidate();
		pnlBody.add(pnlNews);
		pnlBody.repaint();
		pnlBody.revalidate();
		tablemodel.setRowCount(0);
		Show_userlist();
	}

	private void btnTimelineActionPerformed(ActionEvent evt) {
		lblTimeline.setBackground(new Color(0, 102, 153));

		lblNews.setBackground(new Color(215, 228, 242));

		pnlBody.removeAll();
		pnlBody.repaint();
		pnlBody.revalidate();
		pnlBody.add(jspTimeline);
		pnlBody.repaint();
		pnlBody.revalidate();
	}
	
	public ArrayList<News> UserList() {
		ArrayList<News> news = new ArrayList<News>();
		try {
			String sql = "select Title, Datepost from News";
			sta = connect.createStatement();
			rs = sta.executeQuery(sql);
			News userlist;
			while (rs.next()) {
				userlist = new News(rs.getString("Title"), rs.getString("Datepost"));
				news.add(userlist);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		return news;
	}
	
	public void Show_userlist() {
		ArrayList<News> list = UserList();
		tablemodel = (DefaultTableModel)table.getModel();

		Object[] row = new Object[2];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getTitle();
			row[1] = list.get(i).getDatepost();
			tablemodel.addRow(row); 
		}
	
	}
	public void getLink() {
		
		int i = table.getSelectedRow();
		TableModel model = table.getModel();
		String title = model.getValueAt(i, 0 ).toString();
		
		try {
			String sql = "Select * from News where Title like N'" + title +"'"; 
			sta = connect.createStatement();
			rs = sta.executeQuery(sql);
			
			ArrayList<String> link = new ArrayList<String>();
			
			while(rs.next()) {
				String Link = rs.getString(3);
				link.add(Link);
			
			}
			String l = link.get(0);
			
			getLink = new xxx();
			getLink.getdata[0] = l; 
			getLink.getdat();
			
			getLink.setVisible(true);
			
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
	}

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Dashboard().setVisible(true);
			}
		});
	}
}
