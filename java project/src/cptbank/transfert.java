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
import javax.swing.JLabel;
import java.awt.Font;

public class transfert extends JFrame {

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
				
					transfert frame = new transfert();
					frame.setVisible(true);
					
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public transfert() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Transaction");
		setBounds(100, 100, 672, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		textField = new JTextField();
		textField.setBounds(384, 53, 154, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		table = new JTable();
		Object[] column3 = {"Num Op","Prenom","Nom","Type","Num cp E.","Montant"};
        DefaultTableModel model3 = new DefaultTableModel();
        model3.setColumnIdentifiers(column3);
        Object[] row3 = new Object[4];
        
        table.setModel(model3);
		JButton btnNewButton = new JButton("Affectuer");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				int mentant =0;
				try {
					
				        mentant =  Integer.parseInt(textField.getText().toString());
				
				        int numcp1= Integer.parseInt(Menu.getnumcp1());
				        
				        int numcp2= Integer.parseInt(Menu.getnumcp2());
				         
					       
				        
				        Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank", "root" , "");
			 			
			 			
			 			
		                String query = "select * from compte where numcp ='"+numcp1+"'";
		                Statement stmt = Conn.createStatement();

		                ResultSet rs = stmt.executeQuery(query);
				        
		            
						LocalDateTime now = LocalDateTime.now();  
				        
						String	query3 = "insert into operation (numop,numcp,prenom,nom,type,numcp2,mentant,date) values (?,?,?,?,?,?,?,?)";
				        PreparedStatement pst2 = Conn.prepareStatement(query3);
				        String prenom="";
				        String nom="";
					       
					     while(rs.next()) {
					        	
					        
					        
					        String	query2 = "Update compte set solde=? where numcp =?";
					        PreparedStatement pst = Conn.prepareStatement(query2);
							
							pst.setInt(1,(rs.getInt("solde")-mentant));
							pst.setInt(2,numcp1);		
					        pst.execute();
					        pst.close();
					        prenom=rs.getString("prenom");
					        nom=rs.getString("nom");
					        
					       
					        }
					        
					        pst2.setString(1,null);
							pst2.setInt(2,numcp1);
							pst2.setString(3,prenom);
							pst2.setString(4,nom);
							pst2.setString(5,"Transfert");
							pst2.setInt(6,numcp2);
							pst2.setInt(7,mentant);
							pst2.setString(8,dtf.format(now));
							
					        pst2.execute();
					        pst2.close();
					        
					        
					        
					        String query6 = "select solde from compte where numcp ="+numcp2+"";
					        PreparedStatement pst6 = Conn.prepareStatement(query6);
					        ResultSet rs6 = pst6.executeQuery(query6); 
					        
					     while(rs6.next())
					        {
					        String	query5 = "Update compte set solde=? where numcp =?";
					        PreparedStatement pst3 = Conn.prepareStatement(query5);
							
							pst3.setInt(1,(rs6.getInt("solde")+mentant));
							pst3.setInt(2,numcp2);		
					        pst3.execute();
					        pst3.close();
					      
					        
					        }
					        // numop	numcp	prenom	nom	type	numcp2	mentant
					        
					       
					       
					       
					       
				 			
				 			
			               String query4 = "select * from operation where date >='"+n+"' and numcp='"+numcp1+"'";
			               Statement myStmt4 = Conn.createStatement();

			               ResultSet rs4 = myStmt4.executeQuery(query4);
			               
			               int i = 0;
			                
			                
			                
			                  int rowCount = model3.getRowCount();
				              for (int j = rowCount - 1; j >= 0; j--) { model3.removeRow(i);}
				              
			                while(rs4.next()){
			                	
			                	if ( model3.getRowCount() <= i) {model3.addRow(row3); }
			                	
			                	table.setValueAt(rs4.getString("numop"),i,0);
			                	table.setValueAt(rs4.getString("prenom"),i,1);
			                	table.setValueAt(rs4.getString("nom"),i,2);
			                	table.setValueAt(rs4.getString("type"),i,3);
			                	table.setValueAt(rs4.getInt("numcp2"),i,4);
			                	table.setValueAt(rs4.getString("mentant"),i,5);
			                	
			                	
			                  
			                    // "Num Operation","Num Compte","Prenom","Nom","Type","Num Compte","mantant
			                    i++;
			                } 
					
			                JOptionPane.showMessageDialog(null,"Operation reusite");
					    
					     
					     
					     
					     
					     
					     
				     
				
				
				
			}catch(Exception ex){
					
				JOptionPane.showMessageDialog(null,"Le montant saisie doit etre un entier"); 
				//ex.printStackTrace();
			}
				
				
					
				
			}
		});
		btnNewButton.setBounds(546, 52, 100, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 636, 99);
		contentPane.add(scrollPane);
		
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Transfert d'argent");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 364, 64);
		contentPane.add(lblNewLabel);
	}
}
