package CNPM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class HomePage extends JFrame {

	private JFrame frmHome;
	private JScrollPane scrTimeline ;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setVisible(true);
		frmHome.setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/gambar/home.png")));
		frmHome.setTitle("Homepage");
		//setTitle("Homepage");
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(null);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblngK = new JLabel("Đăng kí");
		lblngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblngK.setForeground(Color.BLUE);
		lblngK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(lblngK, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblngK, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frmHome.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 826, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		frmHome.getContentPane().setLayout(groupLayout);
	}
}
