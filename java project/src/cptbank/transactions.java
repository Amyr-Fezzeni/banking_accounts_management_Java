package cptbank;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class transactions extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	final LocalDateTime n = LocalDateTime.now(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					transactions frame = new transactions();
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
	public transactions() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Transaction");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ButtonGroup btn = new ButtonGroup();
		JRadioButton rdbtnretrait = new JRadioButton("Retrait d'argent");
		rdbtnretrait.setSelected(true);
		rdbtnretrait.setBounds(20, 22, 144, 23);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		
		
		JRadioButton rdbtnDeposit = new JRadioButton("Dépôt d'argent");
		rdbtnDeposit.setBounds(20, 48, 144, 23);
		btn.add(rdbtnDeposit);
		btn.add(rdbtnretrait);
		contentPane.add(rdbtnDeposit);
		contentPane.add(rdbtnretrait);
		textField = new JTextField();
		textField.setBounds(259, 22, 154, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Affectuer");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				int mentant =0;
				try {
					
				        mentant =  Integer.parseInt(textField.getText().toString());
				
				        int numcp= Integer.parseInt(Menu.getnumcp());
				        
				         
				         
					       
				        
				        Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
			 			
			 			
			 			
		                String query = "select * from compte where numcp ="+numcp+"";
		                Statement stmt = Conn.createStatement();

		                ResultSet rs = stmt.executeQuery(query);
				        
		            
						LocalDateTime now = LocalDateTime.now();  
				        
				        
				        
				    if (rdbtnretrait.isSelected()==true) {
					
					      
					       
					        while(rs.next()) {
					        	
					        	
					       
					
					       
					        
					        
					        String	query2 = "Update compte set solde=? where numcp =?";
					        PreparedStatement pst = Conn.prepareStatement(query2);
							
							pst.setInt(1,(rs.getInt("solde")-mentant));
							pst.setInt(2,numcp);		
					        pst.execute();
					      
					        
					        String	query3 = "insert into operation (numop,numcp,prenom,nom,type,numcp2,mentant,date) values (?,?,?,?,?,?,?,?)";
					        PreparedStatement pst2 = Conn.prepareStatement(query3);
							
							pst2.setString(1,null);
							pst2.setInt(2,numcp);
							pst2.setString(3,rs.getString("prenom"));
							pst2.setString(4,rs.getString("nom"));
							pst2.setString(5,"Retrait");
							pst2.setString(6,"");
							pst2.setInt(7,mentant);
							
							
						 
							
							
							
							pst2.setString(8,dtf.format(now));
							
					        pst2.execute();
					        JOptionPane.showMessageDialog(null,"Operation reussite ");
					        }
					        
					        // numop	numcp	prenom	nom	type	numcp2	mentant
					        
					
					
					
				     }else 
				    {
				    	 
				    	 
				         while(rs.next()) {
					        	
					        	
						       
								
						       
						        
						        
						        String	query2 = "Update compte set solde=? where numcp =?";
						        PreparedStatement pst = Conn.prepareStatement(query2);
								
								pst.setInt(1,(rs.getInt("solde")+mentant));
								pst.setInt(2,numcp);		
						        pst.execute();
						       
						        
						        
						        String	query3 = "insert into operation (numop,numcp,prenom,nom,type,numcp2,mentant,date) values (?,?,?,?,?,?,?,?)";
						        PreparedStatement pst2 = Conn.prepareStatement(query3);
								
								pst2.setString(1,null);
								pst2.setInt(2,numcp);
								pst2.setString(3,rs.getString("prenom"));
								pst2.setString(4,rs.getString("nom"));
								pst2.setString(5,"Depôt");
								pst2.setString(6,"");
								pst2.setInt(7,mentant);
								
								
							
								
								
								
								pst2.setString(8,dtf.format(now));
								
						        pst2.execute();
						        JOptionPane.showMessageDialog(null,"Operation reussite ");
						        
						        
						        }
					    
					     
					     
					     
					     
					     
					     
				     }
				
				
				
			}catch(Exception ex){
					
				JOptionPane.showMessageDialog(null,ex); //"Le montant saisie doit etre un entier"
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(313, 53, 100, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 414, 164);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Object[] column3 = {"Num Op","Prenom","Nom","Type","Montant"};
        DefaultTableModel model3 = new DefaultTableModel();
        model3.setColumnIdentifiers(column3);
        Object[] row3 = new Object[4];
        
        table.setModel(model3);
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Actualiser");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//****************************************
try {
		 			
		 		Connection	myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
		 			
		 			
		 			
	                String query = "select * from operation where date >='"+n+"'";
	               Statement myStmt = myConn.createStatement();

	               ResultSet rs = myStmt.executeQuery(query);
	                int i = 0;
	                
	                
	                
	                int rowCount = model3.getRowCount();
		             
		              for (int j = rowCount - 1; j >= 0; j--) { model3.removeRow(i);}
		              
	                while(rs.next()){
	                	if ( model3.getRowCount() <= i) {model3.addRow(row3); }
	                	
	                	table.setValueAt(rs.getString("numop"),i,0);
	                	
	                	table.setValueAt(rs.getString("prenom"),i,1);
	                	table.setValueAt(rs.getString("nom"),i,2);
	                	table.setValueAt(rs.getString("type"),i,3);
	             
	                	table.setValueAt(rs.getString("mentant"),i,4);
	                	
	                	
	                  
	                    // "Num Operation","Num Compte","Prenom","Nom","Type","Num Compte","mantant
	                    i++;
	                } 
		 		}
		 		catch (Exception exc) {
		 			exc.printStackTrace();
		 		}
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(209, 53, 100, 23);
		contentPane.add(btnNewButton_1);
	}
}
