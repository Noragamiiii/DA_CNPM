package CNPM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JScrollBar;

public class dashboardd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboardd frame = new dashboardd();
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
	public dashboardd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 526);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel flag_db = new JLabel("");
//		flag_db.setBackground(SystemColor.desktop);
		flag_db.setBackground(new java.awt.Color(0, 204, 106));
		flag_db.setOpaque(true);
		
		
		JButton btnControl = new JButton();
		btnControl.setFont(new Font("Arial", Font.BOLD, 16));
		btnControl.setForeground(new java.awt.Color(44, 62, 80));
		btnControl.setText("BẢNG ĐIỀU KHIỂN");
		btnControl.setContentAreaFilled(false);
        btnControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnControl.setFocusable(false);
        /*btnControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimelineActionPerformed(evt);
            }
        });*/

        btnControl.setBackground(SystemColor.control);
        btnControl.setOpaque(true);
		
		JButton btnNews = new JButton();
		btnNews.setBackground(SystemColor.control);
		btnNews.setFont(new Font("Arial", Font.BOLD, 16));
		btnNews.setForeground(new java.awt.Color(44, 62, 80));
		btnNews.setText("TIN TỨC");
		btnNews.setContentAreaFilled(false);
		btnNews.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNews.setFocusable(false);
		
		JLabel flag_news = new JLabel("");
		//flag_news.setBounds(new Rectangle(0, 0, 10, 3));
		flag_news.setBackground(new java.awt.Color(0, 204, 106));
		flag_news.setOpaque(true);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(89)
							.addComponent(btnControl, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(106)
							.addComponent(flag_db, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(80)
							.addComponent(flag_news, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(117)
							.addComponent(btnNews)))
					.addContainerGap(327, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNews)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(flag_news, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnControl, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(flag_db, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
