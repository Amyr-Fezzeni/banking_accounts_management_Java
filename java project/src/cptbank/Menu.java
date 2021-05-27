package cptbank;
import java.util.Calendar;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;

import javax.swing.JButton;

import javax.swing.JTextField;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;



import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class Menu {

	public JFrame frmMenu;
	private JFrame subcl;
	private static JTextField transaction;
	private JTable table;

	private JTextField chercher;
	private static JTextField transfertnumcp1;
	private static JTextField transfertnumcp2;
	private JTable table_compte;
	private JTextField textField;
	private JTextField chercherop;
	private JTable table_1;
	private JTextField chercheremp;
	private JTable table_2;
	protected int EXIT_ON_CLOSE;
	private static JLabel logininfo = new JLabel("");
	/**
	 * Launch the application.
	 */		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					
					window.frmMenu.setVisible(true);
					window.frmMenu.setResizable(false);
					window.frmMenu.setLocationRelativeTo(null);
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public static String getnumcp() {
		
		
		
		return transaction.getText().toString();
	}
	
public static String getnumcp1() {
		
		
		
		return transfertnumcp1.getText().toString();
	}
public static String getnumcp2() {
	
	
	
	return transfertnumcp2.getText().toString();
}
	
	
	
	
	
	
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 1130, 583);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		Object[] column4 = {"ID","Prenom","Nom","tel","Date naissance","Sexe","Mail","Pays","Ville","Adresse","Agence"};
        DefaultTableModel model4 = new DefaultTableModel();
        model4.setColumnIdentifiers(column4);
        Object[] row4 = new Object[4];
		Object[] column3 = {"Num Operation","Num Compte E.","Prenom","Nom","Type","Num Compte R.","Mantant","Date"};
        DefaultTableModel model3 = new DefaultTableModel();
        model3.setColumnIdentifiers(column3);
        Object[] row3 = new Object[4];
        Object[] columns = {"ID","Prenom","Nom","Tel","Date_N","Sexe","Mail","Pays","Ville","Adresse"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        Object[] row = new Object[4];
        Object[] column2 = {"ID","Num compte","Prenom","Nom","Solde"};
        DefaultTableModel models = new DefaultTableModel();
        models.setColumnIdentifiers(column2);
        Object[] row2 = new Object[6];
		JPanel panel_oparation = new JPanel();
		panel_oparation.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_oparation.setBounds(361, 128, 743, 375);
		frmMenu.getContentPane().add(panel_oparation);
		panel_oparation.setLayout(null);
		panel_oparation.setVisible(false); 
		JComboBox comboBox = new JComboBox();
	    JComboBox comboBox_date = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String choix= (String) comboBox.getSelectedItem();
				if (choix.isEmpty()==false){
					chercherop.setEnabled(true);
					//JOptionPane.showMessageDialog(null, choix);
				}else {
					chercherop.setEnabled(false);
				}
		    	
		    	
				
			}
		});
		
		
		JButton btnNewButton_2_1 = new JButton("Chercher une operation");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//-----------------------------------------------------------------------------------		
		Calendar now = Calendar.getInstance();
		int choixdate= comboBox_date.getSelectedIndex();
		if (choixdate==1) {
			now.add(Calendar.DAY_OF_YEAR,0);
		}else if (choixdate==2) {
			now.add(Calendar.DAY_OF_YEAR, -7);
		}else if (choixdate==3) {
			now.add(Calendar.DAY_OF_YEAR, -31);
		}else {
			now.add(Calendar.MONTH, -999999);
		}
		
		String dateser= now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH)+1)
				    + "-" +now.get(Calendar.DATE)+ "-00-00-00";
				    

		 		Connection myConn = null;
		 		Statement myStmt = null;
		 		ResultSet rs = null;
		 		
		 		
		 		String choix= (String) comboBox.getSelectedItem();
        		if (choix.isEmpty()==false){
		 			
		 		try {
		 			
		 			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		 			
		 		
		 			
		 			String query = "select * from operation where "+comboBox.getSelectedItem()+" ='"+chercherop.getText()+"' and date >='"+dateser+"'";
	                myStmt = myConn.createStatement();

	                rs = myStmt.executeQuery(query);
	                int i = 0;
	                
	                
	                
	                int rowCount = model3.getRowCount();
		             
		              for (int j = rowCount - 1; j >= 0; j--) { model3.removeRow(i);}
		              
	                while(rs.next()){
	                	if ( model3.getRowCount() <= i) {model3.addRow(row3); }
	                	
	                	table_1.setValueAt(rs.getString("numop"),i,0);
	                	table_1.setValueAt(rs.getString("numcp"),i,1);
	                	table_1.setValueAt(rs.getString("prenom"),i,2);
	                	table_1.setValueAt(rs.getString("nom"),i,3);
	                	table_1.setValueAt(rs.getString("type"),i,4);
	                	table_1.setValueAt(rs.getString("numcp2"),i,5);
	                	table_1.setValueAt(rs.getString("mentant"),i,6);
	                	table_1.setValueAt(rs.getString("date"),i,7);
	                	
	                  
	                    // "Num Operation","Num Compte","Prenom","Nom","Type","Num Compte","mantant
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
		 		
			
			}
		 });
		
		
		
		
		
		
		
	
		btnNewButton_2_1.setBounds(10, 25, 170, 23);
		panel_oparation.add(btnNewButton_2_1);
		
		chercherop = new JTextField();
		chercherop.setBounds(273, 26, 140, 20);
		chercherop.setColumns(10);
		chercherop.setEnabled(false);
		panel_oparation.add(chercherop);
		
			JButton btnNewButton_10 = new JButton("Actualiser");
			btnNewButton_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//-----------------------------------------------------------------------------------	
					Calendar now = Calendar.getInstance();
					int choixdate= comboBox_date.getSelectedIndex();
					if (choixdate==1) {
						now.add(Calendar.DAY_OF_YEAR,0);
					}else if (choixdate==2) {
						now.add(Calendar.DAY_OF_YEAR, -7);
					}else if (choixdate==3) {
						now.add(Calendar.DAY_OF_YEAR, -31);
					}else {
						now.add(Calendar.MONTH, -999999);
					}
					
					String dateser= now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH)+1)
							    + "-" +now.get(Calendar.DATE)+ "-00-00-00";
							    

					

			 		Connection myConn = null;
			 		Statement myStmt = null;
			 		ResultSet rs = null;
			 		
			 		
			 		
			 		
			 		try {
			 			
			 			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
			 			
			 			
			 			
	                String query = "select * from operation where date >= '"+dateser+"'";
	                myStmt = myConn.createStatement();

	                rs = myStmt.executeQuery(query);
	                int i = 0;
	                
	                
	                
	                int rowCount = model3.getRowCount();
			             
			              for (int j = rowCount - 1; j >= 0; j--) { model3.removeRow(i);}
			              
	                while(rs.next()){
	                	if ( model3.getRowCount() <= i) {model3.addRow(row3); }
	                	
	                	table_1.setValueAt(rs.getString("numop"),i,0);
	                	table_1.setValueAt(rs.getString("numcp"),i,1);
	                	table_1.setValueAt(rs.getString("prenom"),i,2);
	                	table_1.setValueAt(rs.getString("nom"),i,3);
	                	table_1.setValueAt(rs.getString("type"),i,4);
	                	table_1.setValueAt(rs.getString("numcp2"),i,5);
	                	table_1.setValueAt(rs.getString("mentant"),i,6);
	                	table_1.setValueAt(rs.getString("date"),i,7);
	                	
	                  
	                    // "Num Operation","Num Compte","Prenom","Nom","Type","Num Compte","mantant
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
			btnNewButton_10.setBounds(593, 25, 140, 23);
			panel_oparation.add(btnNewButton_10);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(10, 59, 723, 305);
			panel_oparation.add(scrollPane_2);
			table_1 = new JTable();
			scrollPane_2.setViewportView(table_1);
			
			
			
			
        table_1.setModel(model3) ;
        
      
      
        comboBox.addVetoableChangeListener(new VetoableChangeListener() {
        	public void vetoableChange(PropertyChangeEvent evt) {
        		                                                                                // here !
        		
        	String choix= (String) comboBox.getSelectedItem();
        	JOptionPane.showMessageDialog(null, comboBox);
        	if (choix.equals("type")) {JOptionPane.showMessageDialog(null, comboBox);}
        			
        		
        	}
        });
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "numcp", "prenom", "nom", "type"}));
        comboBox.setBounds(190, 25, 73, 22);
        panel_oparation.add(comboBox);
        
    
        comboBox_date.setModel(new DefaultComboBoxModel(new String[] {"", "Aujourd'huit", "Dernier semaine", "Dernier mois"}));
        comboBox_date.setBounds(423, 25, 114, 23);
        panel_oparation.add(comboBox_date);
		JPanel panel_employe = new JPanel();
		panel_employe.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_employe.setBounds(361, 128, 743, 375);
		frmMenu.getContentPane().add(panel_employe);
		panel_employe.setLayout(null);
		panel_employe.setVisible(false);
		
		JButton btnNewButton_11 = new JButton("Chercher un employe");
		
		
		
		
		
		
		
	
		btnNewButton_11.setBounds(10, 25, 159, 23);
		panel_employe.add(btnNewButton_11);
		
		chercheremp = new JTextField();
		chercheremp.setColumns(10);
		chercheremp.setBounds(179, 26, 140, 20);
		chercheremp.setEnabled(false);
		panel_employe.add(chercheremp);
		
		JButton btnNewButton_10_1 = new JButton("Actualiser");
		
		btnNewButton_10_1.setBounds(593, 25, 140, 23);
		panel_employe.add(btnNewButton_10_1);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(10, 59, 723, 305);
		panel_employe.add(scrollPane_2_1);
		
		table_2 = new JTable();
		
        table_2.setModel(model4);
        scrollPane_2_1.setViewportView(table_2);
        
        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		
        		
        		String choix= (String) comboBox_3.getSelectedItem();
        		if (choix.isEmpty()==false){
        			chercheremp.setEnabled(true);
        			//JOptionPane.showMessageDialog(null, choix);
        		}else {
        			chercheremp.setEnabled(false);
        		}
            	
        	}
        });
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "id", "prenom", "nom", "tel", "pays", "ville", "agence"}));
        comboBox_3.setBounds(329, 25, 72, 22);
        panel_employe.add(comboBox_3);
		
		JPanel panel_compte = new JPanel();
		panel_compte.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_compte.setBounds(361, 128, 743, 375);
		frmMenu.getContentPane().add(panel_compte);
		panel_compte.setLayout(null);
		panel_compte.setVisible(false);
		
		
		
		JButton compte_actualier = new JButton("Actualiser");
		
		
				
				
				
				
				
			
		
		compte_actualier.setBounds(593, 25, 140, 23);
		panel_compte.add(compte_actualier);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 76, 723, 288);
		panel_compte.add(scrollPane_1);
		
		table_compte = new JTable();
		table_compte.setModel(models) ;
		scrollPane_1.setViewportView(table_compte);
		
		textField = new JTextField();
		textField.setBounds(179, 26, 140, 20);
		panel_compte.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
        
        
			JButton btnNewButton_9 = new JButton("Chercher un compte");
			
			
			
		
		btnNewButton_9.setBounds(10, 25, 159, 23);
		panel_compte.add(btnNewButton_9);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String choix= (String) comboBox_2.getSelectedItem();
        		if (choix.isEmpty()==false){
        			textField.setEnabled(true);
        			//JOptionPane.showMessageDialog(null, choix);
        		}else {
        			textField.setEnabled(false);
        		}
            	
				
				
				
				
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "numcp", "id", "prenom", "nom"}));
		comboBox_2.setBounds(329, 25, 79, 21);
		panel_compte.add(comboBox_2);
		
		JPanel panel_client = new JPanel();
		panel_client.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_client.setBounds(361, 128, 743, 375);
		frmMenu.getContentPane().add(panel_client);
		panel_client.setVisible(false);
		
		
		JButton btnNewButton_2 = new JButton("Chercher un client");
		btnNewButton_2.setBounds(10, 25, 159, 23);
		
		panel_client.setLayout(null);
		panel_client.add(btnNewButton_2);
		
		chercher = new JTextField();
		chercher.setBounds(179, 26, 140, 20);
		panel_client.add(chercher);
		chercher.setColumns(10);
		chercher.setEnabled(false);
		
		
		
		
		JButton btnNewButton = new JButton("Actualiser");
		btnNewButton.setBounds(593, 25, 140, 23);
		panel_client.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 723, 305);
		panel_client.add(scrollPane);
		
		table = new JTable();
		
		 	
			
		 scrollPane.setViewportView(table);
		 
        table.setModel(model) ;
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//---------------------------------------------------------------------------------------- client
        		String choix= (String) comboBox_1.getSelectedItem();
        		if (choix.isEmpty()==false){
        			chercher.setEnabled(true);
        			//JOptionPane.showMessageDialog(null, choix);
        		}else {
        			chercher.setEnabled(false);
        		}
            	
        		
        		
        		
        		
        	}
        });
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "id", "prenom", "nom", "tel", "pays", "ville"}));
        comboBox_1.setBounds(329, 25, 83, 22);
        panel_client.add(comboBox_1);
        
		 
		 
		 
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 		Connection myConn = null;
		 		Statement myStmt = null;
		 		ResultSet rs = null;
		 		
		 		
		 		
		 		
		 		try {
		 			
		 			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		 			
		 			
		 			java.sql.Statement stmts = null;
	                String query = "select * from client";
	                stmts = myConn.createStatement();

	                rs = stmts.executeQuery(query);
	                int i = 0;
	                int rowCount = model.getRowCount();
		             
		              for (int j = rowCount - 1; j >= 0; j--) { model.removeRow(i);}
	                while(rs.next()){
	                	if ( model.getRowCount() <= i) {model.addRow(row); }
	                	
	                    table.setValueAt(rs.getString("iD"),i,0);
	                    table.setValueAt(rs.getString("prenom"),i,1);
	                    table.setValueAt(rs.getString("nom"),i,2);
	                    table.setValueAt(rs.getString("tel"),i,3);
	                    table.setValueAt(rs.getString("date_N"),i,4);
	                    table.setValueAt(rs.getString("sexe"),i,5);
	                    table.setValueAt(rs.getString("mail"),i,6);
	                    table.setValueAt(rs.getString("pays"),i,7);
	                    table.setValueAt(rs.getString("ville"),i,8);
	                    table.setValueAt(rs.getString("adresse"),i,9);
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
		 					// TODO Auto-generated catch block
		 					e1.printStackTrace();
		 				}
		 			}
		 		}
		 	
		 });
		 JLabel cptname1 = new JLabel(":");
		 cptname1.setBackground(SystemColor.activeCaption);
		 cptname1.setBounds(226, 108, 105, 20);
		 JLabel cptname2 = new JLabel(":");
		 cptname2.setBackground(SystemColor.inactiveCaption);
		 cptname2.setBounds(226, 136, 105, 20);
		 JButton transfertbtn = new JButton("Transfert d'argent");
		 transfertbtn.setEnabled(false);
		 transfertbtn.setBounds(53, 74, 163, 23);
		 logininfo.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		//JFrame f= new JFrame();
		 	   int a=JOptionPane.showConfirmDialog(frmMenu,"Vous voullez deconecter ?");  
		 	  
		 	   if(a==JOptionPane.YES_OPTION){  
		 	   // frmMenu.dispose();
		 		  System.exit(0);
		 		   //frmMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 	      // login login= new login();
		 	   
		 	    // login.setVisible(true);
		 	
		 	  }  
		 		
		 		
		 	}
		 });
		 //System.out.println("+++ :"+login.getname());
		 logininfo.setText(login.getname());
		
		JLayeredPane panel_transaction = new JLayeredPane();
		panel_transaction.setBounds(10, 386, 341, 117);
		panel_transaction.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmMenu.getContentPane().add(panel_transaction);
		
		transaction = new JTextField();
		transaction.setBounds(18, 58, 132, 20);
		panel_transaction.add(transaction);
		transaction.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Connection Conn = null;
				Statement myStmt = null;
				ResultSet rs = null;
				

		try {
		 			
		 			Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		            String query = "select * from compte where numcp ='"+transaction.getText()+"'";
		            myStmt = Conn.createStatement();
                    rs = myStmt.executeQuery(query);
		
		            if(rs.next()==true){
		            	
		            	transactions frame = new transactions();
					    frame.setVisible(true);
					
		             
		                
		            } 
		    		  
				}
				catch (Exception exc) {
					 JOptionPane.showMessageDialog(null,exc);
				}
				finally {
					     if (Conn!=null) 
					     {
							try {
								
							
					    	rs.close();
							myStmt.close();
							Conn.close();
							}
							catch(Exception ex){
								
								JOptionPane.showMessageDialog(null,ex);
							}
					     }
			
				
				
				      
				      }
				
				
			}
		});
		
		
		
		
		btnNewButton_1.setBounds(160, 57, 149, 23);
		panel_transaction.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Transactions");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblNewLabel.setBounds(10, 0, 190, 29);
		panel_transaction.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero du compte :");
		lblNewLabel_1.setBounds(18, 40, 109, 14);
		panel_transaction.add(lblNewLabel_1);
		
		
	
		
		
		 
		 JPanel panel_transfert = new JPanel();
		 panel_transfert.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		 panel_transfert.setBounds(10, 11, 341, 167);
		 frmMenu.getContentPane().add(panel_transfert);
		 panel_transfert.setLayout(null);
		 
		 JButton cherchertransfert = new JButton("Chercher");
		 cherchertransfert.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		//-----------------------------------
                boolean cp1 =false;
                boolean cp2 =false;
                cptname1.setText(": ");
                cptname2.setText(": ");
                
				try {
				 			
					Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
					
					
					
				    String query = "select prenom from compte where numcp ='"+transfertnumcp1.getText()+"'";
				    Statement myStmt = Conn.createStatement();
				    ResultSet rs = myStmt.executeQuery(query);
				
				            if(rs.next()==true){
				            	
				            	cptname1.setText(": "+rs.getString("prenom"));
				            	cp1=true;
				            } 	
				           
				    query = "select prenom from compte where numcp ='"+transfertnumcp2.getText()+"'";
					myStmt = Conn.createStatement();
					rs = myStmt.executeQuery(query);
						    
					        if(rs.next()==true){
		            	
		            	        cptname2.setText(": "+rs.getString("prenom"));
		            	        cp2=true;
		                    }    
						    
                             if(transfertnumcp1.getText().equals(transfertnumcp2.getText())==false) {
						    	
						    	
						    
						               if (cp1 && cp2) {
						    	
						              	transfertbtn.setEnabled(true);
						    	
						                 }else {
						                	 transfertbtn.setEnabled(false);
						                 }
                             }	else	
						    	
						     {
                            	 transfertbtn.setEnabled(false);
                            	 JOptionPane.showMessageDialog(null, "Operation Impossible");
 						    	
						    }
						    
				            	
							
				             
				                
				           
				    		  
						}
						catch (Exception exc) {
							 JOptionPane.showMessageDialog(null,exc);
						}
		 		
		 		
		 	}
		 });
		 cherchertransfert.setBounds(226, 74, 105, 23);
		 panel_transfert.add(cherchertransfert);
		 
		 transfertnumcp1 = new JTextField();
		 transfertnumcp1.setColumns(10);
		 transfertnumcp1.setBounds(84, 108, 132, 20);
		 panel_transfert.add(transfertnumcp1);
		 
		 
		 transfertbtn.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 		transfert frame = new transfert();
			    frame.setVisible(true);
			    frame.setLocationRelativeTo(null);
		 		
		 	}
		 });
		
		 panel_transfert.add(transfertbtn);
		 
		 transfertnumcp2 = new JTextField();
		 transfertnumcp2.setBounds(84, 136, 132, 20);
		 panel_transfert.add(transfertnumcp2);
		 transfertnumcp2.setColumns(10);
		 
		 JLabel lblNewLabel_2 = new JLabel("N\u00B0 compte 1 :");
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 lblNewLabel_2.setBounds(10, 110, 93, 17);
		 panel_transfert.add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_3 = new JLabel("N\u00B0 compte 2  :");
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 lblNewLabel_3.setBounds(10, 138, 93, 17);
		 panel_transfert.add(lblNewLabel_3);
		 
		
		 panel_transfert.add(cptname1);
		 
		 
		 panel_transfert.add(cptname2);
		 
		 JLabel lblTransfert = new JLabel("Transfert d'argent");
		 lblTransfert.setFont(new Font("Tahoma", Font.ITALIC, 24));
		 lblTransfert.setBounds(10, 11, 265, 29);
		 panel_transfert.add(lblTransfert);
		 
		 JPanel panel_modification = new JPanel();
		 panel_modification.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		 panel_modification.setBounds(10, 189, 341, 186);
		 frmMenu.getContentPane().add(panel_modification);
		 panel_modification.setLayout(null);
		 
		 JButton btnNewButton_3 = new JButton("Ajouter un client");
		 btnNewButton_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		subscribe subclient = new subscribe();
				subclient.setVisible(true);
				subscribe.frame.setLocationRelativeTo(null);
		 	
		 	
		 	}
		 });
		 btnNewButton_3.setBounds(10, 11, 155, 23);
		 panel_modification.add(btnNewButton_3);
		 
		 JButton btnNewButton_4 = new JButton("Ajouter un compte");
		 btnNewButton_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		compteclient frame = new compteclient();
				frame.setVisible(true);
				
		 		
		 		
		 	}
		 });
		 btnNewButton_4.setBounds(10, 79, 155, 23);
		 panel_modification.add(btnNewButton_4);
		 
		 JButton btnNewButton_6 = new JButton("Ajouter un employ\u00E9");
		 btnNewButton_6.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		ajoutemploye employ = new ajoutemploye();
				employ.frmGestionDemployes.setVisible(true);
		 		
		 		
		 	}
		 });
		 btnNewButton_6.setBounds(10, 113, 155, 23);
		 panel_modification.add(btnNewButton_6);
		 
		 JButton btnNewButton_7 = new JButton("Modifier un client");
		 btnNewButton_7.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		modifier modif = new modifier();
		 		modif.frame.setVisible(true);
		 		modifier.frame.setLocationRelativeTo(null);
		 		
		 	}
		 });
		 btnNewButton_7.setBounds(175, 11, 156, 23);
		 panel_modification.add(btnNewButton_7);
		 
		 JButton btnNewButton_8 = new JButton("Modifier un employ\u00E9");
		 btnNewButton_8.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 		modifieremploye framemodifemp = new modifieremploye();
		 		framemodifemp.frame.setVisible(true);
		 		
		 		
		 		
		 		
		 	}
		 });
		 btnNewButton_8.setBounds(175, 113, 156, 23);
		 panel_modification.add(btnNewButton_8);
		 
		 JButton btnNewButton_7_1 = new JButton("Suprimer un client");
		 btnNewButton_7_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 		JFrame f=new JFrame();   
		 	    String id=JOptionPane.showInputDialog(f,"saisir l'id du client");
		 		
		 		
		 	    
		 	    
		 	    
		 	    
		 	    
		 		try {
		 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank","root","");
		 		Statement st=con.createStatement();
		 		String q="select * from client where id ='"+id+"'";
		 		ResultSet r=st.executeQuery(q);
		 		
		 		
		 		if (r.next()) {
		 		
		 		
		 			
		 		
                String query = "delete from client where id =?";
                String query2= "delete from compte where id =?";
                String query3= "delete from connexion where id =?";

                PreparedStatement pst = con.prepareStatement(query3);
				
				pst.setString(1,id);
				pst.execute();
                PreparedStatement pst2 = con.prepareStatement(query2);
				
				pst2.setString(1,id);
				pst2.execute();
                
				 PreparedStatement pst3 = con.prepareStatement(query);
					
					pst3.setString(1,id);
					pst3.execute();
                
               JOptionPane.showMessageDialog(null,"client suprimé ");
		 		}else {
		 			  
		 				
			 			if (id!=null) {
			 			   if (id.isEmpty()==false) {
			 				   
			 			   
			 				  JOptionPane.showMessageDialog(null,"client non trouvé");
			 			   }
			 			   }else{
			 			}
		 		}
		 		}
		 		catch(Exception ex) {
		 			 JOptionPane.showMessageDialog(null,ex);
		 		}
		 		
		 		
		 	}
		 });
		 btnNewButton_7_1.setBounds(175, 45, 156, 23);
		 panel_modification.add(btnNewButton_7_1);
		 
		 JButton btnNewButton_7_1_1 = new JButton("Suprimer un employ\u00E9");
		 btnNewButton_7_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		JFrame f=new JFrame();   
		 	    String id=JOptionPane.showInputDialog(f,"saisir l'id d'un employe");
		 		
		 		
		 	   
		 	    
		 	    
		 	    
		 	    
		 		try {
		 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank","root","");
		 		Statement st=con.createStatement();
		 		String q="select * from employes where id ='"+id+"'";
		 		ResultSet r=st.executeQuery(q);
		 		
		 		
		 		if (r.next()) {
		 		
		 			
		 			
		 		
                String query = "delete from employes where id =?";
               
                String query3= "delete from connexion where id =?";

                PreparedStatement pst = con.prepareStatement(query3);
				
				pst.setString(1,id);
				pst.execute();
              
                
				 PreparedStatement pst3 = con.prepareStatement(query);
					
					pst3.setString(1,id);
					pst3.execute();
                
               JOptionPane.showMessageDialog(null,"employe suprimé ");
               
		 		}else {
		 			
		 			if (id!=null) {
		 			   if (id.isEmpty()==false) {
		 				   
		 			   
		 			  JOptionPane.showMessageDialog(null,"employe non trouvé");
		 			   }
		 			   }else{
		 			}
		 			}
		 		}
		 		catch(Exception ex) {
		 			 JOptionPane.showMessageDialog(null,ex);
		 		}
		 		
		 		
		 		
		 		
		 		
		 		
		 	}
		 });
		 btnNewButton_7_1_1.setBounds(175, 147, 156, 23);
		 panel_modification.add(btnNewButton_7_1_1);
		 
		 JButton btnNewButton_7_1_1_1 = new JButton("Suprimer un compte");
		 btnNewButton_7_1_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
		 		JFrame f=new JFrame();   
		 	    String numcp=JOptionPane.showInputDialog(f,"saisir le numero du compte");
		 		
		 		
		 	    
		 	    
		 	    
		 	    
		 	    
		 		try {
		 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank","root","");
		 		Statement st=con.createStatement();
		 		String q="select * from compte where numcp ='"+numcp+"'";
		 		ResultSet r=st.executeQuery(q);
		 		
		 		
		 		if (r.next()) {
		 		
		 		
		 			
		 		
               
                String query2= "delete from compte where numcp =?";
               

                
                PreparedStatement pst2 = con.prepareStatement(query2);
				
				pst2.setString(1,numcp);
				pst2.execute();
                
				
                
               JOptionPane.showMessageDialog(null,"compte suprimé ");
		 		}else {
		 			
		 			  

			 			if (numcp!=null) {
			 			   if (numcp.isEmpty()==false) {
			 				   
			 			   
			 				  JOptionPane.showMessageDialog(null,"compte non trouvé");
			 			   }
			 			   }else{
			 			}
		 		
		 		}
		 		}
		 		catch(Exception ex) {
		 			 JOptionPane.showMessageDialog(null,ex);
		 		}
		 		
		 		
		 		
		 		
		 		
		 	}
		 });
		 btnNewButton_7_1_1_1.setBounds(175, 79, 156, 23);
		 panel_modification.add(btnNewButton_7_1_1_1);
        
        
        
        JPanel panel_vide = new JPanel();
        panel_vide.setLayout(null);
        panel_vide.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_vide.setBounds(361, 128, 743, 375);
        frmMenu.getContentPane().add(panel_vide);
        
        JLabel lblBienvenu = new JLabel("BIENVENUE");
        lblBienvenu.setBounds(586, 11, 245, 61);
        frmMenu.getContentPane().add(lblBienvenu);
        lblBienvenu.setFont(new Font("Tahoma", Font.BOLD, 36));
        
        JButton gestionclient = new JButton("Gestion des Clients");
        gestionclient.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_client.setVisible(true);
        		panel_compte.setVisible(false);
        		panel_oparation.setVisible(false);
        		panel_employe.setVisible(false);
        		panel_vide.setVisible(false);
        		
        	}
        });
        gestionclient.setBounds(944, 94, 160, 23);
        frmMenu.getContentPane().add(gestionclient);
        
        JButton gestioncompte = new JButton("Gestion des Comptes");
        gestioncompte.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_client.setVisible(false);
        		panel_compte.setVisible(true);
        		panel_oparation.setVisible(false);
        		panel_employe.setVisible(false);
        		panel_vide.setVisible(false);
        	}
        });
        gestioncompte.setBounds(774, 94, 160, 23);
        frmMenu.getContentPane().add(gestioncompte);
        
        JButton btnGestionDoperations = new JButton("Gestion d'Operations");
        btnGestionDoperations.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		panel_client.setVisible(false);
        		panel_compte.setVisible(false);
        		panel_oparation.setVisible(true);
        		panel_employe.setVisible(false);
        		panel_vide.setVisible(false);
        	}
        });
        btnGestionDoperations.setBounds(604, 94, 160, 23);
        frmMenu.getContentPane().add(btnGestionDoperations);
        
        JButton btnGestionDemployes = new JButton("Gestion d'employes");
        btnGestionDemployes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		panel_client.setVisible(false);
        		panel_compte.setVisible(false);
        		panel_oparation.setVisible(false);
        		panel_employe.setVisible(true);
        		panel_vide.setVisible(false);
        	}
        });
      
        btnGestionDemployes.setBounds(434, 94, 160, 23);
        frmMenu.getContentPane().add(btnGestionDemployes);
        
        JPanel panel = new JPanel();
        panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(892, 11, 212, 30);
        frmMenu.getContentPane().add(panel);
        panel.setLayout(null);
        
      
        logininfo.setVerticalAlignment(SwingConstants.TOP);
        logininfo.setBounds(0, 4, 209, 23);
        panel.add(logininfo);
        logininfo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
        logininfo.setForeground(SystemColor.textHighlight);
        logininfo.setHorizontalAlignment(SwingConstants.CENTER);
        
        // chercher compte
        
        btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection myConn = null;
		 		Statement myStmt = null;
		 		ResultSet rs = null;
		 		

		 		String choix= (String) comboBox_2.getSelectedItem();
        		if (choix.isEmpty()==false){
		 		
		 		
		 		try {
		 			
		 			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		 			
		 			
		 			java.sql.Statement stmts = null;
                String query = "select * from compte where "+choix+" ='"+textField.getText()+"'"; 
             
					
				
               stmts = myConn.createStatement();

                rs = stmts.executeQuery(query);
                int i = 0;
             
                
                int rowCounts = models.getRowCount();
            
              for (int j = rowCounts - 1; j >= 0; j--) 
               {
                 models.removeRow(0);
               }
              
                
                while(rs.next()){
                	if ( models.getRowCount() <= i) {models.addRow(row2); }
                	
                    table_compte.setValueAt(rs.getString("iD"),i,0);
                    table_compte.setValueAt(rs.getString("prenom"),i,2);
                    table_compte.setValueAt(rs.getString("nom"),i,3);
                    table_compte.setValueAt(rs.getString("numcp"),i,1);
                    table_compte.setValueAt(rs.getString("solde"),i,4);
                   
                   
                    
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
		 		}}
		 
		 });
		
        // tout les employes
        btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//-----------------------------------------------------------------------------------------------------------
				Connection myConn = null;
		 		
		 		ResultSet rs = null;
		 		Statement stmts = null;
		 	   
		 		
		 		
		 		try {
		 			
		 			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		 			
		 			
		 			
	                String query = "select * from employes "; 
                 
					
				
	               stmts = myConn.createStatement();

	                rs = stmts.executeQuery(query);
	                int i = 0;
	             
	                
	                int rowCount = model4.getRowCount();
	            
	              for (int j = rowCount - 1; j >= 0; j--) {
	                 model4.removeRow(i);
	            }
	              
	                
	                while(rs.next()){
	                	if ( model4.getRowCount() <= i) {model4.addRow(row4); }
	                	
	                	    table_2.setValueAt(rs.getString("iD"),i,0);
		                    table_2.setValueAt(rs.getString("prenom"),i,1);
		                    table_2.setValueAt(rs.getString("nom"),i,2);
		                    table_2.setValueAt(rs.getString("tel"),i,3);
		                    table_2.setValueAt(rs.getString("date_N"),i,4);
		                    table_2.setValueAt(rs.getString("sexe"),i,5);
		                    table_2.setValueAt(rs.getString("mail"),i,6);
		                    table_2.setValueAt(rs.getString("pays"),i,7);
		                    table_2.setValueAt(rs.getString("ville"),i,8);
		                    table_2.setValueAt(rs.getString("adresse"),i,9);
		                    table_2.setValueAt(rs.getString("agence"),i,10);
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
        // tout les comptes
        compte_actualier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

		 		Connection myConn = null;
		 		Statement myStmt = null;
		 		ResultSet rs = null;
		 		
		 		
		 		
		 		
		 		try {
		 			
		 			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		 			
		 			
		 			java.sql.Statement stmts = null;
	                String query = "select * from compte";
	                stmts = myConn.createStatement();

	                rs = stmts.executeQuery(query);
	                int i = 0;
	                
/*
	        		Object[] column = {"ID","Num compte","Prenom","Nom","Solde"};
	                DefaultTableModel models = new DefaultTableModel();
	                models.setColumnIdentifiers(column);
	                Object[] row = new Object[6];
	                table_compte.setModel(models) ;
	                
	        */        
	                int rowCount = models.getRowCount();
		             
		              for (int j = rowCount - 1; j >= 0; j--) { models.removeRow(i);}
		              
	                while(rs.next()){
	                	if ( models.getRowCount() <= i) {models.addRow(row2); }
	                	
	                	table_compte.setValueAt(rs.getString("iD"),i,0);
	                	table_compte.setValueAt(rs.getString("prenom"),i,2);
	                	table_compte.setValueAt(rs.getString("nom"),i,3);
	                	table_compte.setValueAt(rs.getString("numcp"),i,1);
	                	table_compte.setValueAt(rs.getString("Solde"),i,4);
	                	
	                  
	                    // "ID","numcp","prenom","nom","solde"
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
        // chercher client
        btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Connection myConn = null;
				Statement myStmt = null;
				ResultSet rs = null;
				

		 		String choix= (String) comboBox_1.getSelectedItem();
        		if (choix.isEmpty()==false){
				
				
				try {
					
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
					
					
					java.sql.Statement stmts = null;
	                String query = "select * from client where "+choix+" ='"+chercher.getText()+"'";
	                stmts = myConn.createStatement();

	                rs = stmts.executeQuery(query);
	                int i = 0;
	                int rowCount = model.getRowCount();
	            
	              for (int j = rowCount - 1; j >= 0; j--) {
	                  model.removeRow(i);
	              }
	                while(rs.next()){
	                	if ( model.getRowCount() <= i) {model.addRow(row); }
	                	
	                    table.setValueAt(rs.getString("iD"),i,0);
	                    table.setValueAt(rs.getString("prenom"),i,1);
	                    table.setValueAt(rs.getString("nom"),i,2);
	                    table.setValueAt(rs.getString("tel"),i,3);
	                    table.setValueAt(rs.getString("date_N"),i,4);
	                    table.setValueAt(rs.getString("sexe"),i,5);
	                    table.setValueAt(rs.getString("mail"),i,6);
	                    table.setValueAt(rs.getString("pays"),i,7);
	                    table.setValueAt(rs.getString("ville"),i,8);
	                    table.setValueAt(rs.getString("adresse"),i,9);
	                   
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
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}}
		
		});
        // chercher employe
        btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection myConn = null;
		 		Statement myStmt = null;
		 		ResultSet rs = null;
		 		
		 		String choix= (String) comboBox_3.getSelectedItem();
        		if (choix.isEmpty()==false){
		 		
		 		
		 		try {
		 			
		 			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		 			
		 			
		 			java.sql.Statement stmts = null;
	                String query = "select * from employes where "+choix+" ='"+chercheremp.getText()+"'"; 
                 
					
				
	               stmts = myConn.createStatement();

	                rs = stmts.executeQuery(query);
	                int i = 0;
	             
	                
	                int rowCount = model4.getRowCount();
	            
	              for (int j = rowCount - 1; j >= 0; j--) {
	                 model4.removeRow(j);
	            }
	              
	                
	                while(rs.next()){
	                	if ( model4.getRowCount() <= i) {model4.addRow(row4); }
	                	
	                	    table_2.setValueAt(rs.getString("iD"),i,0);
		                    table_2.setValueAt(rs.getString("prenom"),i,1);
		                    table_2.setValueAt(rs.getString("nom"),i,2);
		                    table_2.setValueAt(rs.getString("tel"),i,3);
		                    table_2.setValueAt(rs.getString("date_N"),i,4);
		                    table_2.setValueAt(rs.getString("sexe"),i,5);
		                    table_2.setValueAt(rs.getString("mail"),i,6);
		                    table_2.setValueAt(rs.getString("pays"),i,7);
		                    table_2.setValueAt(rs.getString("ville"),i,8);
		                    table_2.setValueAt(rs.getString("adresse"),i,9);
		                    table_2.setValueAt(rs.getString("agence"),i,10);
	                   
	                   
	                    
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
		 		}
		 
		 });
		
	}
	public static void test(String a) {
		
		
	}
	
		
		
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		if (b==true) {
			try {
				Menu window = new Menu();
				window.frmMenu.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
