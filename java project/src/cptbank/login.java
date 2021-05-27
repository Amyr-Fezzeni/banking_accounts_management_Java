package cptbank;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.EtchedBorder;

public class login {

	private JFrame frame;
	private JTextField logintxt;
	private JTextField password;
	private JTextField chercher;
	private JTextField user;
	private JTextField pass;
	private JTextField passconfirm;
    private String type="";
    private static String name="Hello Boss";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					
					
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestion des compte bancaire");
		//frame.setBounds(100, 100, 686, 413);
		frame.setBounds(100, 100, 345, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton inscri = new JButton("S'inscrire");
		inscri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank","root","");
					
					if (user.getText().isEmpty()==false&&pass.getText().isEmpty()==false&&passconfirm.getText().isEmpty()==false) {
				
					String sqlid="select id from connexion where id ='"+chercher.getText()+"'";
					Statement st2 = con.createStatement();
					ResultSet rs2=st2.executeQuery(sqlid);
					
					if (rs2.next()==false) {
					
				
					
                    String sqluser="select * from connexion where user ='"+user.getText()+"'";
					Statement st1 = con.createStatement();
					ResultSet rs1=st1.executeQuery(sqluser);
					
					if (rs1.next()==false ) {
					
					
					if (pass.getText().equals(passconfirm.getText())) {
					
					
					
					String sql="insert into connexion values(?,?,?,?)";
				
				     PreparedStatement pr= con.prepareStatement(sql);
				     pr.setString(1, chercher.getText());
				     pr.setString(2, user.getText());
				     pr.setString(3, pass.getText());
				     pr.setString(4, type);
				
				     pr.execute();
				     JOptionPane.showMessageDialog(null, "Inscription reussite");
					
					
					
					}else {
						JOptionPane.showMessageDialog(null, "mot de passe n'est pas identique !");
					}
				
				
				
					}else {
						JOptionPane.showMessageDialog(null, "Nom d'utilisateur deja utilisé");
					}
				
				}
					else {
						JOptionPane.showMessageDialog(null, "Vous avez deja un compte");
					}
				}else
				{
					JOptionPane.showMessageDialog(null, "Information incorrect");
				}
					
				}
				
				
				
				
				catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
				
				
				
				
				
			}
		});
		inscri.setBounds(196, 114, 103, 23);
		
		JPanel panel_conect = new JPanel();
		panel_conect.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_conect.setBounds(10, 11, 310, 353);
		frame.getContentPane().add(panel_conect);
		panel_conect.setLayout(null);
		
		JLabel welcome = new JLabel("BIENVENUE");
		welcome.setBounds(10, 11, 321, 41);
		panel_conect.add(welcome);
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setVerticalAlignment(SwingConstants.TOP);
		welcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.setBounds(211, 319, 89, 23);
		panel_conect.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(10, 56, 288, 193);
		panel_conect.add(panel_4);
		panel_4.setLayout(null);
		
		logintxt = new JTextField();
		logintxt.setBounds(124, 28, 150, 20);
		panel_4.add(logintxt);
		logintxt.setColumns(10);
		logintxt.setText("");
		
		JLabel lblNewLabel = new JLabel("Nom d'utilisateur :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 31, 104, 14);
		panel_4.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Mot de passe  :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPassword.setBounds(10, 62, 104, 14);
		panel_4.add(lblPassword);
		lblPassword.setForeground(Color.BLACK);
		
		password = new JPasswordField();
		password.setBounds(124, 59, 150, 20);
		panel_4.add(password);
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setColumns(10);
		password.setText("");
		
		JLabel lblNewLabel_4 = new JLabel("Cr\u00E9er un compte ?");
		
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.setBounds(100, 100, 686, 413);
				//window.frame.setVisible(true);
				//window.frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				
				
				
				//*****************************************************************************************
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD,10));
				lblNewLabel_4.setForeground(Color.BLUE);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN,10));
				lblNewLabel_4.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(124, 90, 150, 14);
		panel_4.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton loginbtn = new JButton("Connexion");
		loginbtn.setBounds(156, 143, 118, 23);
		panel_4.add(loginbtn);
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank","root","");
				    Statement stmt=con.createStatement();
				    
				     //select * from connexion where user="admin" and password ="login" 
				    String sql="select * from connexion where user = '"+logintxt.getText()+"' and password = '"+password.getText()+"'";
				    ResultSet rs=stmt.executeQuery(sql);
				    
				    if (rs.next())
				    {
				    	
				    	   String id=rs.getString("id");
						    String type=rs.getString("type");
						   if (type.equals("boss")==false) {
							   
						    String sqlname="select prenom,nom from "+type+" where id ='"+id+"'";
						   // System.out.println(sqlname);
						    ResultSet rs2=stmt.executeQuery(sqlname);
						    if (rs2.next()) {
						    	
						    	name=rs2.getString("prenom").toUpperCase()+" "+rs2.getString("nom").toUpperCase();
						    	 
						    }
						    rs2.close();
						    JOptionPane.showMessageDialog(null, "bienvenue "+name+"");
						   } else {
							   JOptionPane.showMessageDialog(null,name);
						   }
							   
						    
						   
				    	Menu M = new Menu();
						M.setVisible(true);
						frame.setVisible(false);
						
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "Incorrect user name or password...");
				    }
				 
				    rs.close();
				   
				    
				    con.close();
				
				} catch(Exception c) {System.out.println(c);}
				
			}
		});
		
		
		JPanel panel_inscri = new JPanel();
		panel_inscri.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_inscri.setBounds(330, 11, 329, 353);
		frame.getContentPane().add(panel_inscri);
		panel_inscri.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 61, 309, 85);
		panel_inscri.add(panel_2);
		panel_2.setLayout(null);
		
		chercher = new JTextField();
		chercher.setBounds(10, 52, 190, 20);
		panel_2.add(chercher);
		chercher.setColumns(10);
		
		JButton chercherbtn = new JButton("chercher");
		chercherbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cptbank","root","");
					
					Statement st=con.createStatement();
					String sql="select prenom from employes where id ='"+chercher.getText()+"'";
					
					ResultSet rs=st.executeQuery(sql);
					
					
				while(true)	{
					
					if (rs.next())
					{
						JOptionPane.showMessageDialog(null, "welcome "+rs.getString("prenom")+"");
						rs.close();
						con.close();
						user.setEnabled(true);
						pass.setEnabled(true);
						passconfirm.setEnabled(true);
						inscri.setEnabled(true);
						chercher.setEnabled(false);
						type="employes";
						break;
					}
					
                    String sql2="select prenom from client where id ='"+chercher.getText()+"'";
					
					ResultSet rs2=st.executeQuery(sql2);
					
					
					if (rs2.next())
					{
						JOptionPane.showMessageDialog(null, "welcome "+rs2.getString("prenom")+" !");
						rs.close();
						rs2.close();
						con.close();
						user.setEnabled(true);
						pass.setEnabled(true);
						passconfirm.setEnabled(true);
						inscri.setEnabled(true);
						chercher.setEnabled(false);
						type="client";
						break;
						
					}
					else {
						
						
						JOptionPane.showMessageDialog(null, "compte n'existe pas !");
					rs.close();
						rs2.close();
						con.close();
						user.setEnabled(false);
						pass.setEnabled(false);
						passconfirm.setEnabled(false);
						inscri.setEnabled(false);
						type="";
						break;
					}
					
					
					
					
					
					
					
				}	
					
				}catch(Exception c) {
					JOptionPane.showMessageDialog(null, c);	
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		chercherbtn.setBounds(210, 51, 89, 23);
		panel_2.add(chercherbtn);
		
		JLabel lblNewLabel_2 = new JLabel("Saisir votre ID :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(10, 21, 190, 20);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(10, 157, 309, 150);
		panel_inscri.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setEnabled(false);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Nom d'utilisateur :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(10, 21, 123, 20);
		panel_3.add(lblNewLabel_3);
		
		user = new JTextField();
		user.setBounds(143, 21, 156, 20);
		panel_3.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setColumns(10);
		pass.setBounds(143, 52, 156, 20);
		panel_3.add(pass);
		
		passconfirm = new JPasswordField();
		passconfirm.setColumns(10);
		passconfirm.setBounds(143, 83, 156, 20);
		panel_3.add(passconfirm);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nouveu mot de passe :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3_1.setBounds(10, 52, 123, 20);
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("confirmer mot de passe :");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3_2.setBounds(10, 83, 123, 20);
		panel_3.add(lblNewLabel_3_2);
		
		
		panel_3.add(inscri);
		
		JLabel lblNewLabel_1 = new JLabel("INSCRIPTION");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 309, 44);
		panel_inscri.add(lblNewLabel_1);
		
		user.setEnabled(false);
		pass.setEnabled(false);
		passconfirm.setEnabled(false);
		inscri.setEnabled(false);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				user.setEnabled(false);
				user.setText("");
				pass.setEnabled(false);
				pass.setText("");
				passconfirm.setEnabled(false);
				passconfirm.setText("");
				inscri.setEnabled(false);
				chercher.setEnabled(true);
				chercher.setText("");
				
				
			}
		});
		btnNewButton_1.setBounds(100, 114, 89, 23);
		panel_3.add(btnNewButton_1);
		
		
		
		
		
		
		JButton btnNewButton_2 = new JButton("Retourner");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			  frame.setBounds(100, 100, 345, 413);
			 
				frame.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setBounds(206, 318, 113, 23);
		panel_inscri.add(btnNewButton_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		
		
		
		
	}
	public static String getname() {
		
		
		
		return name;
	}
	
	
	
		public void setVisible(boolean b) {
			
			
			
					login window = new login();
					window.frame.setVisible(b);
					window.frame.setLocationRelativeTo(null);
				
			
		}
	
}
