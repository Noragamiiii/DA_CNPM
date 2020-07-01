package CNPM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JEditorPane;
import java.awt.SystemColor;

public class Newss extends JFrame {

	private JPanel contentPane, panel, panel_1;
	Connection connect;
	PreparedStatement pre;
	Statement sta;
	ResultSet rs;
	private JTable table;
	DefaultTableModel tablemodel;
	JEditorPane editorPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newss frame = new Newss();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Newss() {
		try {
			connect = Connect_DB.getSQLServer();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 612);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		
		
		JPanel pnlBody = new JPanel();
		pnlBody.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(pnlBody, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlBody, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
		);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		
		JButton btnTinTc = new JButton();
		btnTinTc.setBorder(null);
		btnTinTc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Show_Newslist();
				
			}
		});
		btnTinTc.setText("TIN TỨC");
		btnTinTc.setForeground(new Color(44, 62, 80));
		btnTinTc.setFont(new Font("Arial", Font.BOLD, 16));
		btnTinTc.setFocusable(false);
		btnTinTc.setContentAreaFilled(false);
		GroupLayout gl_pnlMenu = new GroupLayout(pnlMenu);
		gl_pnlMenu.setHorizontalGroup(
			gl_pnlMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
					.addGap(23)
					.addComponent(btnTinTc, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(759, Short.MAX_VALUE))
		);
		gl_pnlMenu.setVerticalGroup(
			gl_pnlMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnTinTc, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlMenu.setLayout(gl_pnlMenu);
		
		 panel = new JPanel();
		 panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		GroupLayout gl_pnlBody = new GroupLayout(pnlBody);
		gl_pnlBody.setHorizontalGroup(
			gl_pnlBody.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlBody.createSequentialGroup()
					.addGroup(gl_pnlBody.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
						.addComponent(pnlMenu, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlBody.setVerticalGroup(
			gl_pnlBody.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBody.createSequentialGroup()
					.addComponent(pnlMenu, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
					.addGap(3))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
		);
		
		 editorPane = new JEditorPane();
		scrollPane_1.setViewportView(editorPane);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		
		
		pnlBody.setLayout(gl_pnlBody);
		contentPane.setLayout(gl_contentPane);
		
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
	
	public void Show_Newslist() {
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
			editorPane.setVisible(true);
			try {
	         editorPane.setBorder(null);
		         editorPane.setPage(new URL(l));
			 }catch(Exception ex) {
				 JOptionPane.showMessageDialog(null, ex);
				 
				 }
		}catch(Exception exx) {
			JOptionPane.showMessageDialog(null, exx);
		}
		
	
}
}
