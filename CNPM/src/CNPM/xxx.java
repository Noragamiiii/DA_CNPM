package CNPM;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class xxx extends JFrame {

	private JPanel contentPane, panel ;
	 JEditorPane editorPane;
	 JScrollPane jspTimeline;
	String link;
	public  String[] getdata = new String[1];
	JButton btnMinimize, btnMaximize, btnExit;
	static boolean maximized = true;
	int xMouse, yMouse;
	
	public void setLink(String link) {
		this.link = link;
	}
	public String getLink() {
		return this.link;
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xxx frame = new xxx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public xxx(String lk) {
		
		this.link = lk;
		//initComponent();
		 
	}
	public String getl(String l) {
		
		l = link;
		return l;
	}
	

	public xxx() {
		setUndecorated(true);
		getdat();
		initComponent();
	}
	
	public  String getdat() {
		this.link = getdata[0];
		return link;
	}
	
		public void initComponent() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 692, 453);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.inactiveCaption);
			contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			setContentPane(contentPane);
			
		 panel = new JPanel();
		 panel.setBackground(Color.WHITE);
		    
		     jspTimeline = new JScrollPane();
		    jspTimeline.setBorder(null);
		    
		   
		    
		    try {
		    	 String l = getdat();
		         editorPane = new JEditorPane();
		         jspTimeline.setViewportView(editorPane);
		         editorPane.setBorder(null);
		         editorPane.setPage(new URL(l));
		        
		        JPanel pnlHeader = new JPanel();
		        pnlHeader.setBackground(SystemColor.inactiveCaptionBorder);
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
		         btnMinimize = new JButton();
		         btnMinimize.setBorder(null);
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

		        btnMinimize.setIcon(new ImageIcon(xxx.class.getResource("/gambar/Minimize (2).png")));
		        btnMinimize.setOpaque(true);
		        btnMinimize.setFocusable(false);
		        btnMinimize.setContentAreaFilled(false);
		        btnMinimize.setBackground(SystemColor.inactiveCaptionBorder);
		        
		         btnMaximize = new JButton();
		         btnMaximize.setBorder(null);
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
		        btnMaximize.setIcon(new ImageIcon(xxx.class.getResource("/gambar/Maximize (2).png")));
		        btnMaximize.setOpaque(true);
		        btnMaximize.setFocusable(false);
		        btnMaximize.setContentAreaFilled(false);
		        btnMaximize.setBackground(SystemColor.inactiveCaptionBorder);
		        
		         btnExit = new JButton();
		         btnExit.setBorder(null);

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
		        btnExit.setIcon(new ImageIcon(xxx.class.getResource("/gambar/Exit (2).png")));
		        btnExit.setOpaque(true);
		        btnExit.setFocusable(false);
		        btnExit.setContentAreaFilled(false);
		        btnExit.setBackground(SystemColor.inactiveCaptionBorder);
		       
		        GroupLayout gl_pnlHeader = new GroupLayout(pnlHeader);
		        gl_pnlHeader.setHorizontalGroup(
		        	gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
		        		.addGroup(gl_pnlHeader.createSequentialGroup()
		        			.addContainerGap(547, Short.MAX_VALUE)
		        			.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
		        			.addPreferredGap(ComponentPlacement.RELATED)
		        			.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
		        			.addPreferredGap(ComponentPlacement.RELATED)
		        			.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
		        );
		        gl_pnlHeader.setVerticalGroup(
		        	gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
		        		.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
		        		.addComponent(btnMaximize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
		        		.addComponent(btnMinimize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
		        );
		        pnlHeader.setLayout(gl_pnlHeader);
		        GroupLayout gl_contentPane = new GroupLayout(contentPane);
		        gl_contentPane.setHorizontalGroup(
		        	gl_contentPane.createParallelGroup(Alignment.LEADING)
		        		.addComponent(pnlHeader, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
		        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
		        );
		        gl_contentPane.setVerticalGroup(
		        	gl_contentPane.createParallelGroup(Alignment.LEADING)
		        		.addGroup(gl_contentPane.createSequentialGroup()
		        			.addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		        			.addPreferredGap(ComponentPlacement.RELATED)
		        			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
		        );
		        GroupLayout gl_panel = new GroupLayout(panel);
		        gl_panel.setHorizontalGroup(
		        	gl_panel.createParallelGroup(Alignment.LEADING)
		        		.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
		        			.addContainerGap()
		        			.addComponent(jspTimeline, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
		        );
		        gl_panel.setVerticalGroup(
		        	gl_panel.createParallelGroup(Alignment.LEADING)
		        		.addComponent(jspTimeline, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
		        );
		        panel.setLayout(gl_panel);
		        contentPane.setLayout(gl_contentPane);
		        
		        } catch (Exception ex) {
		        	ex.printStackTrace();}
		    }
		
		private void btnExitMouseEntered(MouseEvent evt) {
			btnExit.setBackground(new Color(232, 17, 35));
		}

		private void btnExitMouseExited(MouseEvent evt) {
			btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		}
		
		private void btnExitActionPerformed(ActionEvent evt) {
			setVisible(false);
		}

		private void btnMaximizeMouseEntered(MouseEvent evt) {
			btnMaximize.setBackground(new Color(229, 229, 229));
		}

		private void btnMaximizeMouseExited(MouseEvent evt) {
			btnMaximize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		}

		private void btnMaximizeActionPerformed(ActionEvent evt) {
			if (maximized) {

				xxx.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
				xxx.this.setMaximizedBounds(env.getMaximumWindowBounds());
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
}
