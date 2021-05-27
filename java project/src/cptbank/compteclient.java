package cptbank;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class compteclient extends JFrame {
	
	
	public static JPanel contentPane;
	private JTextField chercher;
	private JTable table;
	private JTextField Solde;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					compteclient frame = new compteclient();
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
	public compteclient() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gestion du Compte");
		setBounds(100, 100, 627, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JButton btnNewButton_1 = new JButton("return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				compteclient.this.dispose();
				
			}
		});
		btnNewButton_1.setBounds(512, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 591, 199);
		contentPane.add(panel);
		panel.setLayout(null);
		
		chercher = new JTextField();
		chercher.setBounds(80, 27, 136, 20);
		panel.add(chercher);
		chercher.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID Client :");
		lblNewLabel.setBounds(10, 27, 63, 20);
		panel.add(lblNewLabel);
		JButton btnNewButton_2 = new JButton("Valider");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Connection Conn = null;
				Statement stmts = null;
				ResultSet rs = null;
				
				
			
				
				
				
				
				
				
				
	try {
		 			
		 			Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		 			
		 			
		 		
		 			
		 			
		 			
					String query= "INSERT INTO compte VALUES (?,?,?,?,?)";
					// id prenom nom solde
					PreparedStatement pst = Conn.prepareStatement(query);
					//table.setValueAt("",i,0);
	                
					pst.setString(1,table.getValueAt(0,0).toString());
					pst.setString(2,null);
					pst.setString(3,table.getValueAt(0,1).toString());
					pst.setString(4,table.getValueAt(0,2).toString());
					pst.setInt(5,Integer.parseInt(Solde.getText()));
					
					
					pst.execute();
		      
		      JOptionPane.showMessageDialog(null,"Compte ajouté avec succés");

		  
		      
				
		 			
		 			
		 			
		 			
		 			
				}
				catch (Exception exc) {
					 JOptionPane.showMessageDialog(null,exc);
				}
				finally {
					try {
					if (rs != null) {
						
							rs.close();
						
					}
					
					if (stmts != null) {
						
							stmts.close();
						}
					
					
					if (Conn != null) {
					
							Conn.close();
							
					}
					}	
						 catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			
				}
				
				
				
				
				
			}
		);
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(492, 45, 89, 23);
		panel.add(btnNewButton_2);
		
		Solde = new JTextField();
		Solde.setEnabled(false);
		Solde.setHorizontalAlignment(SwingConstants.RIGHT);
		Solde.setBounds(121, 109, 86, 20);
		panel.add(Solde);
		Solde.setColumns(10);
		Solde.setText("0");
		
		JLabel lblNewLabel_1 = new JLabel("Solde initial :");
		lblNewLabel_1.setBounds(10, 109, 101, 20);
		panel.add(lblNewLabel_1);
		JButton btnNewButton = new JButton("Chercher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int i = 0;
				table.setValueAt("",i,0);
                table.setValueAt("",i,1);
                table.setValueAt("",i,2);
                table.setValueAt("",i,3);
		 		Connection myConn = null;
		 		Statement myStmt = null;
		 		ResultSet rs = null;
		 		btnNewButton_2.setEnabled(false);
                Solde.setEnabled(false);
		 		
		 		
		 		
		 		try {
		 			
		 			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		 			
		 			
		 			java.sql.Statement stmts = null;
	                String query = "select * from client where id ='"+chercher.getText().toString()+"'";
	                stmts = myConn.createStatement();

	                rs = stmts.executeQuery(query);
	              
	                
	                while(rs.next()){
	                	//if ( model.getRowCount() <= i) {model.addRow(row); }
	                	btnNewButton_2.setEnabled(true);
		                Solde.setEnabled(true);
	                    table.setValueAt(rs.getString("iD"),i,0);
	                    table.setValueAt(rs.getString("prenom"),i,1);
	                    table.setValueAt(rs.getString("nom"),i,2);
	                    table.setValueAt(rs.getString("date_N"),i,3);
	                  
	                    // "ID","Prenom","Nom","Tel","Date_N","Sexe","Mail","Pays","Ville","Adresse"
	                    i++;
	                } 
	                
		 		}
		 		catch (Exception exc) {
		 			exc.printStackTrace();
		 		}
		 		finally {
		 			try {
		 				
		 			if (rs != null) {
		 				
		 					rs.close();
		 				
		 			}
		 			
		 			if (myStmt != null) {
		 				
		 					myStmt.close();
		 				}
		 			
		 			
		 			if (myConn != null) {
		 			
		 					myConn.close();
		 					
		 			}
		 			}	
		 				 catch (SQLException e1) {
		 			
		 					e1.printStackTrace();
		 				}
		 			}
		 		}
		 
		 });
		 		
		btnNewButton.setBounds(492, 11, 89, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(217, 80, 364, 108);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {{null, null, null, null},},
				new String[] {"ID", "Prenom", "Nom", "Date Naissance"}) 
		{private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {String.class, String.class, String.class, String.class};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(93);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		
	}
	
	

}
