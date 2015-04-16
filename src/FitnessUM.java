import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.List;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;


public class FitnessUM {

	private JFrame frmFitnessUm;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_Nome;
	private JTextField textField_Email;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField_Desporto;
	private JTextField textPerfilNome;
	private JTextField textPerfilEmail;
	private JPasswordField passwordPerfilPass;
	private JPasswordField passwordPerfilPass_2;
	private JTextField textPerfilDesp;
	private JTextField textFieldNomeEsta;
	private JTextField textRecDur;
	private JTextField textRecInt1;
	private JTextField textRecInt2;
	private JTextField textRecInt3;
	private JTextField textRecInt4;
	private JTextField textRecEstab;
	private JTextField textRecTemp;
	private JTextField textAmEmail;
	private JTextField textAmNome;
	private JTextField textAmDesp;
	private static User uti; 
	private static RedeUser utilizadores = new RedeUser();
	int activ = 0;
	private JTextField textRecData;
	private JTextField comboRecMet;
	private JTextField textAmSex;
	private JTextField textAddEmail;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		utilizadores.loadObj();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FitnessUM window = new FitnessUM();
					window.frmFitnessUm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public FitnessUM() throws ParseException {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frmFitnessUm = new JFrame();
		frmFitnessUm.setResizable(false);
		frmFitnessUm.setTitle("Fitness UM");
		frmFitnessUm.setBounds(100, 100, 869, 470);
		frmFitnessUm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFitnessUm.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmFitnessUm.getContentPane().add(panel, "name_23922776778822");
		
		JPanel panel_Reg = new JPanel();
		frmFitnessUm.getContentPane().add(panel_Reg, "name_Registo");
		panel_Reg.setLayout(null);
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail_1.setBounds(288, 86, 46, 14);
		panel_Reg.add(lblEmail_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(243, 111, 91, 14);
		panel_Reg.add(lblPassword);
		
		JLabel lblRepetirPasword = new JLabel("Repetir Pasword:");
		lblRepetirPasword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepetirPasword.setBounds(184, 136, 150, 14);
		panel_Reg.add(lblRepetirPasword);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(288, 61, 46, 14);
		panel_Reg.add(lblNome);
		
		JLabel lblNewLabel_1 = new JLabel("Sexo:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(288, 161, 46, 14);
		panel_Reg.add(lblNewLabel_1);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setBounds(288, 186, 46, 14);
		panel_Reg.add(lblAltura);
		
		final JLabel passIncorecta = new JLabel("Email ou password incorrectas, tente novamente.");
		passIncorecta.setBounds(223, 291, 449, 14);
		passIncorecta.setForeground(new Color(255, 0, 0));
		passIncorecta.setHorizontalAlignment(SwingConstants.CENTER);
		passIncorecta.setVisible(false);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setBounds(288, 211, 46, 14);
		panel_Reg.add(lblPeso);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNascimento.setBounds(226, 236, 108, 14);
		panel_Reg.add(lblDataNascimento);
		
		JLabel lblNewLabel_2 = new JLabel("Desporto Favorito:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(214, 261, 120, 14);
		panel_Reg.add(lblNewLabel_2);
		
		textField_Nome = new JTextField();
		textField_Nome.setBounds(344, 58, 200, 20);
		panel_Reg.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(344, 86, 200, 20);
		panel_Reg.add(textField_Email);
		textField_Email.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(344, 111, 200, 20);
		panel_Reg.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(344, 136, 200, 20);
		panel_Reg.add(passwordField_2);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox.setToolTipText("Sexo");
		comboBox.setBounds(344, 158, 46, 20);
		panel_Reg.add(comboBox);
		
		final JList listActiv = new JList();
		listActiv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listActiv.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listActiv.setBounds(55, 48, 172, 274);
		
		MaskFormatter mascaraAltura = new MaskFormatter("###");
		final JFormattedTextField formattedTextField_Altura = new JFormattedTextField(mascaraAltura);
		formattedTextField_Altura.setBounds(344, 183, 62, 20);
		panel_Reg.add(formattedTextField_Altura);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(416, 186, 46, 14);
		panel_Reg.add(lblCm);
		
		JLabel lblKg = new JLabel("Kg");
		lblKg.setBounds(416, 214, 46, 14);
		panel_Reg.add(lblKg);
		
		MaskFormatter mascaraPeso = new MaskFormatter("###");
		final JFormattedTextField formattedTextField_Peso = new JFormattedTextField(mascaraPeso);
		formattedTextField_Peso.setBounds(344, 208, 62, 20);
		panel_Reg.add(formattedTextField_Peso);
		
		MaskFormatter mascaraNasc = new MaskFormatter("##/##/####");
		final JFormattedTextField formattedTextField_Nasc = new JFormattedTextField(mascaraNasc);
		formattedTextField_Nasc.setBounds(344, 233, 128, 20);
		panel_Reg.add(formattedTextField_Nasc);
		
		textField_Desporto = new JTextField();
		textField_Desporto.setBounds(344, 261, 200, 20);
		panel_Reg.add(textField_Desporto);
		textField_Desporto.setColumns(10);
		
		JLabel lblRegistarNovoUtilizador = new JLabel("Registar Novo Utilizador");
		lblRegistarNovoUtilizador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistarNovoUtilizador.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistarNovoUtilizador.setBounds(108, 11, 618, 26);
		panel_Reg.add(lblRegistarNovoUtilizador);
		
		JButton btnNewButton = new JButton("Confirmar Registo");
		btnNewButton.addActionListener(new ActionListener() {
			//BOTAO PARA FAZER O REGISTOS DE UTILIZADORES
			public void actionPerformed(ActionEvent arg0) 
			{
				String nome, email, password1, password2, favSport, data;
				GregorianCalendar datNasc; 
				int idade=0, altura=0, peso=0, dia = 0, mes = 0, ano = 0;
				char genero;				
				User novoUtilizador;
				
				nome = textField_Nome.getText();
				email = textField_Email.getText();
				genero = comboBox.getSelectedItem().toString().charAt(0);
				favSport = textField_Desporto.getText();				
				data = formattedTextField_Nasc.getText();
				password1 = passwordField_1.getText();
				password2 = passwordField_2.getText();
				
				dia = Character.getNumericValue(data.charAt(0)) * 10;
				dia = dia + Character.getNumericValue(data.charAt(1));
				
				mes = Character.getNumericValue(data.charAt(3)) * 10;
				mes = (mes + Character.getNumericValue(data.charAt(4))) - 1;
				
				ano = (Character.getNumericValue(data.charAt(6)) * 1000);
				ano = ano + (Character.getNumericValue(data.charAt(7)) * 100);
				ano = ano + (Character.getNumericValue(data.charAt(8)) * 10);
				ano = ano + Character.getNumericValue(data.charAt(9));
				
				if(nome.equals("") || email.equals("") || favSport.equals("") || ano < 1000 || mes < 1 || dia < 1
						|| formattedTextField_Altura.getText().equals("") || formattedTextField_Peso.getText().equals("")
						|| password1.equals("") || password2.equals(""))
				{					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");		
				}
				else
				{		
					altura = Integer.parseInt(formattedTextField_Altura.getText());
					peso = Integer.parseInt(formattedTextField_Peso.getText());	
					
					if(!password1.equals(password2)) JOptionPane.showMessageDialog(null, "As passwords não são equivalentes.");
					else
					{
						try
						{
								datNasc = new GregorianCalendar(ano, mes, dia);
								novoUtilizador = new User(nome, email, password1, favSport, datNasc, idade, altura, peso, genero);
								utilizadores.addUser(novoUtilizador);
								JOptionPane.showMessageDialog(null, "Registo Completo");
								
								//LIMPAR E VOLTAR AO ECRA DO LOGIN
								((CardLayout)frmFitnessUm.getContentPane().getLayout()).show(frmFitnessUm.getContentPane(), "name_23922776778822");
								passwordField.setText("");
								textField.setText("");
								passIncorecta.setVisible(false);
								
								//Limpar todo
								textField_Nome.setText("");
								textField_Email.setText("");
								passwordField_1.setText("");
								passwordField_2.setText("");
								formattedTextField_Altura.setText("");
								formattedTextField_Peso.setText("");
								formattedTextField_Nasc.setText("");
								textField_Desporto.setText("");
							}
							catch(ExistingUserException e){ JOptionPane.showMessageDialog(null, "O email inserido já está registado: " + e.getMessage()); }
						}
					}
			}
		});
		
		btnNewButton.setBounds(344, 321, 173, 23);
		panel_Reg.add(btnNewButton);
				
		textField = new JTextField();
		textField.setBounds(360, 107, 200, 20);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(360, 155, 200, 20);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox_1.setToolTipText("Sexo");
		comboBox_1.setBounds(321, 158, 46, 20);		

		final JFormattedTextField formattedAltura = new JFormattedTextField(mascaraAltura);
		formattedAltura.setEditable(false);
		formattedAltura.setBounds(321, 183, 62, 20);		

		final JFormattedTextField formattedPeso = new JFormattedTextField(mascaraPeso);
		formattedPeso.setEditable(false);
		formattedPeso.setBounds(321, 208, 62, 20);
		
		final JFormattedTextField formattedDataNasc = new JFormattedTextField(mascaraNasc);
		formattedDataNasc.setEditable(false);
		formattedDataNasc.setBounds(321, 233, 128, 20);
		
		final JList listAmigos = new JList();
		listAmigos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAmigos.setBounds(52, 86, 163, 256);
		
		final JList listPedidos = new JList();
		listPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPedidos.setBounds(528, 74, 163, 256);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(328, 217, 89, 23);
		panel.getRootPane().setDefaultButton(btnLogin);
		btnLogin.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) 
			{
				String email;				
				email = textField.getText();
				ArrayList<Actividades> actividadesUser;
				ArrayList<String> amigosUti;
				ArrayList<String> pedidosUti;
				
				try{
					uti = new User(utilizadores.getUser(email));
					
					if(uti.getPassword().equals(passwordField.getText()))
					{
						passwordField.setText("");
						textField.setText("");
						passIncorecta.setVisible(false);
						((CardLayout)frmFitnessUm.getContentPane().getLayout()).show(frmFitnessUm.getContentPane(),"name_23922807315173");
						/**
						 * CARREGAR INFORMAÇÕES 
						*/
						textPerfilEmail.setText(uti.getEmail());
						textPerfilNome.setText(uti.getNome());
						if(uti.getGenero() == 'M') comboBox_1.setSelectedIndex(0); else comboBox_1.setSelectedIndex(1);
						formattedAltura.setText("" + uti.getAltura());
						formattedPeso.setText("" + uti.getPeso());
						formattedDataNasc.setText("" + uti.getSimpleBirthdate());
						textPerfilDesp.setText(uti.getFavSport());
						
						actividadesUser = uti.getActiv();						
						DefaultListModel listModel = new DefaultListModel();						
						for(Actividades i : actividadesUser){ listModel.addElement(i.getNome());}						
						listActiv.setModel(listModel);
						
						amigosUti = uti.getAmigos();
						DefaultListModel listModelAmigos = new DefaultListModel();						
						for(String s : amigosUti){ listModelAmigos.addElement(utilizadores.getUser(s)); }						
						listAmigos.setModel(listModelAmigos);
						
						pedidosUti = uti.getRequests();
						DefaultListModel listModelRequests = new DefaultListModel();						
						for(String r : pedidosUti){ listModelRequests.addElement(utilizadores.getUser(r)); }						
						listPedidos.setModel(listModelRequests);
					}
					else passIncorecta.setVisible(true);
				}
				catch(UnexistingUserException e){ passIncorecta.setVisible(true); }					
			}			
		});
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(242, 107, 108, 20);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(230, 155, 120, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnGravar = new JButton("Gravar Utilizadores");
		btnGravar.setBounds(372, 353, 180, 23);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				utilizadores.toObjFile();
			}
		});
		panel.setLayout(null);
		panel.add(textField);
		panel.add(passwordField);
		panel.add(passIncorecta);
		panel.add(btnLogin);
		panel.add(lblEmail);
		panel.add(lblNewLabel);
		panel.add(btnGravar);
		
		JButton btnRegisto = new JButton("Registo");
		btnRegisto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				((CardLayout)frmFitnessUm.getContentPane().getLayout()).show(frmFitnessUm.getContentPane(),"name_Registo");
			}
		});
		btnRegisto.setBounds(471, 217, 89, 23);
		panel.add(btnRegisto);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(10, 43, 843, 28);
		panel.add(lblLogin);
		
		JPanel panel_1 = new JPanel();
		frmFitnessUm.getContentPane().add(panel_1, "name_23922807315173");
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 27, 863, 415);
		panel_1.add(tabbedPane);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Perfil", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel label_1 = new JLabel("Email:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(265, 49, 46, 14);
		panel_5.add(label_1);
		
		JLabel lblNovaPassword = new JLabel("Nova Password:");
		lblNovaPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaPassword.setBounds(177, 111, 134, 14);
		panel_5.add(lblNovaPassword);
		
		JLabel label_3 = new JLabel("Repetir Pasword:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(141, 136, 170, 14);
		panel_5.add(label_3);
		
		JLabel label_4 = new JLabel("Nome:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(265, 83, 46, 14);
		panel_5.add(label_4);
		
		JLabel label_5 = new JLabel("Sexo:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(265, 161, 46, 14);
		panel_5.add(label_5);
		
		JLabel label_6 = new JLabel("Altura:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(265, 186, 46, 14);
		panel_5.add(label_6);
		
		JLabel label_7 = new JLabel("Peso:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(265, 211, 46, 14);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("Data Nascimento:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(203, 236, 108, 14);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("Desporto Favorito:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(191, 261, 120, 14);
		panel_5.add(label_9);
		
		textPerfilNome = new JTextField();
		textPerfilNome.setEditable(false);
		textPerfilNome.setColumns(10);
		textPerfilNome.setBounds(321, 80, 200, 20);
		panel_5.add(textPerfilNome);
		
		textPerfilEmail = new JTextField();
		textPerfilEmail.setEditable(false);
		textPerfilEmail.setColumns(10);
		textPerfilEmail.setBounds(321, 49, 200, 20);
		panel_5.add(textPerfilEmail);
		
		passwordPerfilPass = new JPasswordField();
		passwordPerfilPass.setEditable(false);
		passwordPerfilPass.setBounds(321, 111, 200, 20);
		panel_5.add(passwordPerfilPass);
		
		passwordPerfilPass_2 = new JPasswordField();
		passwordPerfilPass_2.setEditable(false);
		passwordPerfilPass_2.setBounds(321, 136, 200, 20);
		panel_5.add(passwordPerfilPass_2);
		
		panel_5.add(comboBox_1);		
		panel_5.add(formattedAltura);
		
		JLabel label_10 = new JLabel("cm");
		label_10.setBounds(393, 186, 46, 14);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Kg");
		label_11.setBounds(393, 214, 46, 14);
		panel_5.add(label_11);
		
		panel_5.add(formattedPeso);
		panel_5.add(formattedDataNasc);
		
		textPerfilDesp = new JTextField();
		textPerfilDesp.setEditable(false);
		textPerfilDesp.setColumns(10);
		textPerfilDesp.setBounds(321, 261, 200, 20);
		panel_5.add(textPerfilDesp);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPerfil.setBounds(85, 11, 618, 26);
		panel_5.add(lblPerfil);
		
		final JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String nome, password1, password2, favSport, data;
				GregorianCalendar datNasc; 
				int idade=0, altura=0, peso=0, dia = 0, mes = 0, ano = 0;
				char genero;				
				User novoUtilizador = new User();
				
				nome = textPerfilNome.getText();
				genero = comboBox_1.getSelectedItem().toString().charAt(0);
				favSport = textPerfilDesp.getText();				
				data = formattedDataNasc.getText();
				password1 = passwordPerfilPass.getText();
				password2 = passwordPerfilPass_2.getText();
				
				dia = Character.getNumericValue(data.charAt(0)) * 10;
				dia = dia + Character.getNumericValue(data.charAt(1));
				
				mes = Character.getNumericValue(data.charAt(3)) * 10;
				mes = mes + Character.getNumericValue(data.charAt(4));
				
				ano = (Character.getNumericValue(data.charAt(6)) * 1000);
				ano = ano + (Character.getNumericValue(data.charAt(7)) * 100);
				ano = ano + (Character.getNumericValue(data.charAt(8)) * 10);
				ano = ano + Character.getNumericValue(data.charAt(9));
				
				if(nome.equals("") || favSport.equals("") || ano < 1000 || mes < 1 || dia < 1
						|| formattedAltura.getText().equals("") ||formattedPeso.getText().equals("")
						|| password1.equals("") || password2.equals(""))
				{					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");		
				}
				else
				{		
					altura = Integer.parseInt(formattedAltura.getText());
					peso = Integer.parseInt(formattedPeso.getText());	
					
					if(!password1.equals(password2)) JOptionPane.showMessageDialog(null, "As passwords não são equivalentes.");
					else
					{
							datNasc = new GregorianCalendar(ano, mes, dia);
							
							//adicionar as mudaças ao utilizadores
							JOptionPane.showMessageDialog(null, "Dados alterados");
							
							//Limpar todo
							textPerfilNome.setEditable(false); textPerfilDesp.setEditable(false);	passwordPerfilPass_2.setEditable(false);
							passwordPerfilPass.setEditable(false); formattedAltura.setEditable(false); formattedPeso.setEditable(false);
							formattedDataNasc.setEditable(false); comboBox_1.setEnabled(false); btnConfirmar.setVisible(false);						
					}
				}				
			}
		});
		
		btnConfirmar.setBounds(412, 317, 109, 23);
		panel_5.add(btnConfirmar);
		btnConfirmar.setVisible(false);
		
		JButton btnEditarPefil = new JButton("Editar Pefil");
		btnEditarPefil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textPerfilNome.setEditable(true);
				textPerfilDesp.setEditable(true);
				passwordPerfilPass_2.setEditable(true);
				passwordPerfilPass.setEditable(true);
				formattedAltura.setEditable(true);
				formattedPeso.setEditable(true);
				formattedDataNasc.setEditable(true);
				comboBox_1.setEnabled(true);
				btnConfirmar.setVisible(true);
			}
		});
		btnEditarPefil.setBounds(288, 317, 114, 23);
		panel_5.add(btnEditarPefil);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Inserir Actividade", null, panel_2, null);
		panel_2.setLayout(null);
		
		final JComboBox comboBoxActiv = new JComboBox();
		comboBoxActiv.setModel(new DefaultComboBoxModel(new String[] {"Badminton", "Basquetebol", "Ciclismo", "Futebol", "Golfing", "Running", "Sprint", "Swimming", "TableTennis", "Treadmill", "Walking", "Weightlifting"}));
		comboBoxActiv.setBounds(378, 58, 158, 20);
		panel_2.add(comboBoxActiv);
		
		JLabel lblNomeDaActividade = new JLabel("Actividade:");
		lblNomeDaActividade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDaActividade.setBounds(219, 61, 137, 14);
		panel_2.add(lblNomeDaActividade);
		
		final JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o:");
		lblDurao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDurao.setBounds(107, 109, 69, 14);
		panel_2.add(lblDurao);
		lblDurao.setVisible(false);
		
		JLabel lblNovaAtividade = new JLabel("Nova Atividade");
		lblNovaAtividade.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovaAtividade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNovaAtividade.setBounds(10, 21, 838, 26);
		panel_2.add(lblNovaAtividade);
		
		final JLabel lblInt = new JLabel("Int 1:");
		lblInt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInt.setBounds(10, 134, 166, 14);
		panel_2.add(lblInt);
		lblInt.setVisible(false);
		
		final JLabel lblInt_2 = new JLabel("Int 2:");
		lblInt_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInt_2.setBounds(10, 159, 166, 14);
		panel_2.add(lblInt_2);
		lblInt_2.setVisible(false);
		
		final JLabel lblInt_1 = new JLabel("Int 3:");
		lblInt_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInt_1.setBounds(20, 184, 156, 14);
		panel_2.add(lblInt_1);
		lblInt_1.setVisible(false);
		
		final JLabel lblIndoor = new JLabel("Indoor");
		lblIndoor.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndoor.setBounds(630, 95, 69, 14);
		panel_2.add(lblIndoor);
		lblIndoor.setVisible(false);
		
		final JLabel lblNomeEstabelecimento = new JLabel("Nome Estabelecimento:");
		lblNomeEstabelecimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeEstabelecimento.setBounds(444, 127, 158, 14);
		panel_2.add(lblNomeEstabelecimento);
		lblNomeEstabelecimento.setVisible(false);
		
		textFieldNomeEsta = new JTextField();
		textFieldNomeEsta.setBounds(608, 124, 208, 20);
		panel_2.add(textFieldNomeEsta);
		textFieldNomeEsta.setColumns(10);
		textFieldNomeEsta.setVisible(false);
		
		final JLabel lblInt_3 = new JLabel("Int 4:");
		lblInt_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInt_3.setBounds(10, 209, 166, 14);
		panel_2.add(lblInt_3);
		lblInt_3.setVisible(false);
		
		final JLabel lblOutdoor = new JLabel("Outdoor");
		lblOutdoor.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutdoor.setBounds(630, 184, 69, 14);
		panel_2.add(lblOutdoor);
		lblOutdoor.setVisible(false);
		
		final JLabel lblCondiesMeteriologicas = new JLabel("Condi\u00E7\u00F5es Meteriologicas:");
		lblCondiesMeteriologicas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCondiesMeteriologicas.setBounds(444, 225, 158, 14);
		panel_2.add(lblCondiesMeteriologicas);
		lblCondiesMeteriologicas.setVisible(false);
		
		final JLabel lblTemperatura = new JLabel("Temperatura:");
		lblTemperatura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTemperatura.setBounds(499, 254, 102, 14);
		panel_2.add(lblTemperatura);
		lblTemperatura.setVisible(false);
		
		final JComboBox comboBoxCondi = new JComboBox();
		comboBoxCondi.setModel(new DefaultComboBoxModel(new String[] {"Sol", "Nevoeiro", "Chuva", "Aguaceiros"}));
		comboBoxCondi.setBounds(608, 222, 149, 20);
		panel_2.add(comboBoxCondi);
		comboBoxCondi.setVisible(false);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Actividades Recentes", null, panel_3, null);
		panel_3.setLayout(null);		
		
		MaskFormatter mascaraIntActividades = new MaskFormatter("####");
		final JFormattedTextField textFieldDuracao = new JFormattedTextField(mascaraIntActividades);
		textFieldDuracao.setVisible(false);
		textFieldDuracao.setBounds(198, 106, 158, 20);
		panel_2.add(textFieldDuracao);
		
		final JFormattedTextField textFieldInt1 = new JFormattedTextField(mascaraIntActividades);
		textFieldInt1.setVisible(false);
		textFieldInt1.setBounds(198, 131, 158, 20);
		panel_2.add(textFieldInt1);
		
		final JLabel lblc = new JLabel("\u00BA F");
		lblc.setVisible(false);
		lblc.setBounds(671, 254, 46, 14);
		panel_2.add(lblc);
		
		final JFormattedTextField textFieldInt2 = new JFormattedTextField(mascaraIntActividades);
		textFieldInt2.setVisible(false);
		textFieldInt2.setBounds(198, 156, 158, 20);
		panel_2.add(textFieldInt2);
		
		final JFormattedTextField textFieldInt3 = new JFormattedTextField(mascaraIntActividades);
		textFieldInt3.setVisible(false);
		textFieldInt3.setBounds(198, 181, 158, 20);
		panel_2.add(textFieldInt3);
		
		final JFormattedTextField textFieldInt4 = new JFormattedTextField(mascaraIntActividades);
		textFieldInt4.setVisible(false);
		textFieldInt4.setBounds(198, 206, 158, 20);
		panel_2.add(textFieldInt4);
		
		final JFormattedTextField textFieldTemp = new JFormattedTextField(mascaraIntActividades);
		textFieldTemp.setVisible(false);
		textFieldTemp.setBounds(608, 251, 53, 20);
		panel_2.add(textFieldTemp);

		JButton btnLogout = new JButton("LogOut");
		final JButton btnInserirActividade = new JButton("Inserir Actividade");
		btnInserirActividade.setVisible(false);		
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{				
				//TuDO INVISIVEL
				lblDurao.setVisible(false); lblInt.setVisible(false); 
				lblInt_2.setVisible(false); lblInt_1.setVisible(false); lblInt_3.setVisible(false);
				textFieldDuracao.setVisible(false); textFieldInt3.setVisible(false);
				textFieldInt1.setVisible(false);	textFieldInt2.setVisible(false); textFieldInt4.setVisible(false);
				//OUTDOORPACK
				lblOutdoor.setVisible(false); lblCondiesMeteriologicas.setVisible(false); lblTemperatura.setVisible(false);
				comboBoxCondi.setVisible(false); textFieldTemp.setVisible(false);
				//INDOOR PACK
				lblIndoor.setVisible(false); lblNomeEstabelecimento.setVisible(false); textFieldNomeEsta.setVisible(false);
				
				btnInserirActividade.setVisible(true);
				
				activ = comboBoxActiv.getSelectedIndex();
				
				switch(activ)
				{
					case 0:	lblDurao.setVisible(true); lblInt.setVisible(true);
						lblInt_2.setVisible(true); textFieldDuracao.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true);
						lblInt.setText("Pontos concedidos:"); lblInt_2.setText("Pontos marcados:");
						//INDOOR PACK
						lblIndoor.setVisible(true); lblNomeEstabelecimento.setVisible(true); textFieldNomeEsta.setVisible(true);
						break;
					case 1:	lblDurao.setVisible(true); lblInt.setVisible(true); 
						lblInt_2.setVisible(true); textFieldDuracao.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true); 
						lblInt.setText("Pontos marcados:");	lblInt_2.setText("Passes:");
						//INDOOR PACK
						lblIndoor.setVisible(true); lblNomeEstabelecimento.setVisible(true); textFieldNomeEsta.setVisible(true);
					break;
					case 2:	lblDurao.setVisible(true); lblInt.setVisible(true); 
						lblInt_2.setVisible(true); lblInt_1.setVisible(true); lblInt_3.setVisible(true);
						textFieldDuracao.setVisible(true); textFieldInt3.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true); textFieldInt4.setVisible(true);
						lblInt.setText("Distancia:"); lblInt_2.setText("Altura Máxima:"); lblInt_1.setText("Altura Minima:"); lblInt_3.setText("Velocidade Media:");
						//OUTDOORPACK
						lblOutdoor.setVisible(true); lblCondiesMeteriologicas.setVisible(true); lblTemperatura.setVisible(true);
						comboBoxCondi.setVisible(true); textFieldTemp.setVisible(true); lblc.setVisible(true);
					break;
					case 3:	lblDurao.setVisible(true); lblInt.setVisible(true); 
						lblInt_2.setVisible(true); lblInt_1.setVisible(true);
						textFieldDuracao.setVisible(true); textFieldInt3.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true); 
						lblInt.setText("Golos marcados:");	lblInt_2.setText("Passes:"); lblInt_1.setText("Golos sofridos:");
						//OUTDOORPACK
						lblOutdoor.setVisible(true); lblCondiesMeteriologicas.setVisible(true); lblTemperatura.setVisible(true);
						comboBoxCondi.setVisible(true); textFieldTemp.setVisible(true); lblc.setVisible(true);
					break;
					case 4:	lblDurao.setVisible(true); lblInt.setVisible(true);
						lblInt_2.setVisible(true); textFieldDuracao.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true);
						lblInt.setText("Pontos:"); lblInt_2.setText("Número buracos:");
						//OUTDOORPACK
						lblOutdoor.setVisible(true); lblCondiesMeteriologicas.setVisible(true); lblTemperatura.setVisible(true);
						comboBoxCondi.setVisible(true); textFieldTemp.setVisible(true); lblc.setVisible(true);
					break;
					case 5:	lblDurao.setVisible(true); lblInt.setVisible(true); 
						lblInt_2.setVisible(true); lblInt_1.setVisible(true); lblInt_3.setVisible(true);
						textFieldDuracao.setVisible(true); textFieldInt3.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true); textFieldInt4.setVisible(true);
						lblInt.setText("Distancia:"); lblInt_2.setText("Altura Máxima:"); lblInt_1.setText("Altura Minima:"); lblInt_3.setText("Velocidade Media:");
						//OUTDOORPACK
						lblOutdoor.setVisible(true); lblCondiesMeteriologicas.setVisible(true); lblTemperatura.setVisible(true);
						comboBoxCondi.setVisible(true); textFieldTemp.setVisible(true); lblc.setVisible(true);
					break;
					case 6:	lblDurao.setVisible(true); lblInt.setVisible(true);
						lblInt_2.setVisible(true); textFieldDuracao.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true);
						lblInt.setText("Distancia:"); lblInt_2.setText("Velocidade Maxima:");
						//OUTDOORPACK
						lblOutdoor.setVisible(true); lblCondiesMeteriologicas.setVisible(true); lblTemperatura.setVisible(true);
						comboBoxCondi.setVisible(true); textFieldTemp.setVisible(true); lblc.setVisible(true);
					break;
					case 7:	lblDurao.setVisible(true); lblInt.setVisible(true);
						textFieldDuracao.setVisible(true); textFieldInt1.setVisible(true);
						lblInt.setText("Distancia:");
						//OUTDOORPACK
						lblOutdoor.setVisible(true); lblCondiesMeteriologicas.setVisible(true); lblTemperatura.setVisible(true);
						comboBoxCondi.setVisible(true); textFieldTemp.setVisible(true); lblc.setVisible(true);
					break;
					case 8:	lblDurao.setVisible(true); lblInt.setVisible(true);
						lblInt_2.setVisible(true); textFieldDuracao.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true);
						lblInt.setText("Pontos concedidos:"); lblInt_2.setText("Pontos marcados:");
						//INDOOR PACK
						lblIndoor.setVisible(true); lblNomeEstabelecimento.setVisible(true); textFieldNomeEsta.setVisible(true);
					break;
					case 9:	lblDurao.setVisible(true); lblInt.setVisible(true);
						lblInt_2.setVisible(true); textFieldDuracao.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true);
						lblInt.setText("Velocidade:"); lblInt_2.setText("Elevação:");
						//INDOOR PACK
						lblIndoor.setVisible(true); lblNomeEstabelecimento.setVisible(true); textFieldNomeEsta.setVisible(true);
					break;
					case 10:	lblDurao.setVisible(true); lblInt.setVisible(true); 
						lblInt_2.setVisible(true); lblInt_1.setVisible(true);
						textFieldDuracao.setVisible(true); textFieldInt3.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true); 
						lblInt.setText("Distancia:"); lblInt_2.setText("Altura maxima:"); lblInt_1.setText("Altura minima:");
						//OUTDOORPACK
						lblOutdoor.setVisible(true); lblCondiesMeteriologicas.setVisible(true); lblTemperatura.setVisible(true);
						comboBoxCondi.setVisible(true); textFieldTemp.setVisible(true); lblc.setVisible(true);
					break;
					case 11:	lblDurao.setVisible(true); lblInt.setVisible(true);
						lblInt_2.setVisible(true); textFieldDuracao.setVisible(true);
						textFieldInt1.setVisible(true);	textFieldInt2.setVisible(true);
						lblInt.setText("Peso:"); lblInt_2.setText("Repetições:");
						//INDOOR PACK
						lblIndoor.setVisible(true); lblNomeEstabelecimento.setVisible(true); textFieldNomeEsta.setVisible(true);
					break;
				}
			}
		});
		btnOk.setBounds(561, 57, 53, 23);
		panel_2.add(btnOk);
		
		
		btnInserirActividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int duracao = 0, campo2 = 0, campo3 = 0, campo4 = 0, campo5 = 0, campo6 = 0, i = 0;
				String stringInse, nomeActiv = "";
				GregorianCalendar dataHoje = new GregorianCalendar();
				DefaultListModel addNovaActiv = new DefaultListModel();	
				
				switch(activ)
				{
					case 0: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || textFieldNomeEsta.getText().equals("")) 
								JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
					else
						{
							duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
							campo3 = Integer.parseInt(textFieldInt2.getText()); stringInse = textFieldNomeEsta.getText();
							Badminton inserActiv = new Badminton(duracao, dataHoje, stringInse, campo3, campo2);
							try
							{
								utilizadores.addActivUser(uti.getEmail(), inserActiv);
								nomeActiv = inserActiv.getNome();
								addNovaActiv.addElement(nomeActiv);	
								JOptionPane.showMessageDialog(null, "Atividade Inserida.");
							}
							catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
						}
						break;
						
					case 1: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || textFieldNomeEsta.getText().equals("")) 
								JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
					else
						{
							duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
							campo3 = Integer.parseInt(textFieldInt2.getText()); stringInse = textFieldNomeEsta.getText();
							Basquetebol inserActiv = new Basquetebol(duracao, dataHoje, stringInse, campo2, campo3);
							try
							{
								utilizadores.addActivUser(uti.getEmail(), inserActiv);
								nomeActiv = inserActiv.getNome();
								addNovaActiv.addElement(nomeActiv);	
								JOptionPane.showMessageDialog(null, "Atividade Inserida.");
							}
							catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
						}
						break; 
						
					case 2: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || 
							textFieldInt3.getText().equals("") || textFieldInt4.getText().equals("") || textFieldTemp.getText().equals("")) 
								JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
					else
						{
							duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
							campo3 = Integer.parseInt(textFieldInt2.getText()); campo4 = Integer.parseInt(textFieldInt3.getText()); 
							campo5 = Integer.parseInt(textFieldInt4.getText()); 
							campo6 = Integer.parseInt(textFieldTemp.getText()); stringInse = comboBoxCondi.getSelectedItem().toString();
							Ciclismo inserActiv = new Ciclismo(duracao, dataHoje, campo6, stringInse, campo2, campo3, campo4, campo5);
							try
							{
								utilizadores.addActivUser(uti.getEmail(), inserActiv);
								nomeActiv = inserActiv.getNome();
								addNovaActiv.addElement(nomeActiv);	
								JOptionPane.showMessageDialog(null, "Atividade Inserida.");
							}
							catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
						}
						break;
						
					case 3: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || 
							textFieldInt3.getText().equals("") || textFieldTemp.getText().equals("")) 
								JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
					else
						{
							duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
							campo3 = Integer.parseInt(textFieldInt2.getText()); campo4 = Integer.parseInt(textFieldInt3.getText()); 
							campo6 = Integer.parseInt(textFieldTemp.getText()); stringInse = comboBoxCondi.getSelectedItem().toString();
							Futebol inserActiv = new Futebol(duracao, dataHoje, campo6, stringInse, campo2, campo4, campo3);
							try
							{
								utilizadores.addActivUser(uti.getEmail(), inserActiv);
								nomeActiv = inserActiv.getNome();
								addNovaActiv.addElement(nomeActiv);	
								JOptionPane.showMessageDialog(null, "Atividade Inserida.");
							}
							catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
						}
						break;
						
					case 4: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || 
							textFieldTemp.getText().equals("")) 
									JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
						else
							{
								duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
								campo3 = Integer.parseInt(textFieldInt2.getText());
								campo6 = Integer.parseInt(textFieldTemp.getText()); stringInse = comboBoxCondi.getSelectedItem().toString();
								Golfing inserActiv = new Golfing(duracao, dataHoje, campo6, stringInse, campo2, campo3);
								try
								{
									utilizadores.addActivUser(uti.getEmail(), inserActiv);
									nomeActiv = inserActiv.getNome();
									addNovaActiv.addElement(nomeActiv);	
									JOptionPane.showMessageDialog(null, "Atividade Inserida.");
								}
								catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
							}
							break;
							
					case 5: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || 
									textFieldInt3.getText().equals("") || textFieldInt4.getText().equals("") || textFieldTemp.getText().equals("")) 
								JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
							else
								{
									duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
									campo3 = Integer.parseInt(textFieldInt2.getText()); campo4 = Integer.parseInt(textFieldInt3.getText()); 
									campo5 = Integer.parseInt(textFieldInt4.getText()); 
									campo6 = Integer.parseInt(textFieldTemp.getText()); stringInse = comboBoxCondi.getSelectedItem().toString();
									Running inserActiv = new Running(duracao, dataHoje, campo6, stringInse, campo2, campo5, campo4, campo3);
									try
									{
										utilizadores.addActivUser(uti.getEmail(), inserActiv);
										nomeActiv = inserActiv.getNome();
										addNovaActiv.addElement(nomeActiv);	
										JOptionPane.showMessageDialog(null, "Atividade Inserida.");
									}
									catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
								}
							break;
							
					case 6: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || 
								textFieldTemp.getText().equals("")) 
							JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
						else
							{
								duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
								campo3 = Integer.parseInt(textFieldInt2.getText());
								campo6 = Integer.parseInt(textFieldTemp.getText()); stringInse = comboBoxCondi.getSelectedItem().toString();
								Sprint inserActiv = new Sprint(duracao, dataHoje, campo6, stringInse, campo3, campo2);
								try
								{
									utilizadores.addActivUser(uti.getEmail(), inserActiv);
									nomeActiv = inserActiv.getNome();
									addNovaActiv.addElement(nomeActiv);	
									JOptionPane.showMessageDialog(null, "Atividade Inserida.");
								}
								catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
							}
					break;
					
					case 7: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldTemp.getText().equals("")) 
							JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
						else
							{
								duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
								campo6 = Integer.parseInt(textFieldTemp.getText()); stringInse = comboBoxCondi.getSelectedItem().toString();
								Swimming inserActiv = new Swimming(duracao, dataHoje, campo6, stringInse, campo2);
								try
								{
									utilizadores.addActivUser(uti.getEmail(), inserActiv);
									nomeActiv = inserActiv.getNome();
									addNovaActiv.addElement(nomeActiv);	
									JOptionPane.showMessageDialog(null, "Atividade Inserida.");
								}
								catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
							}
					break;
					
					case 8: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || 
							textFieldNomeEsta.getText().equals("")) 
						JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
					else
						{
							duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
							campo3 = Integer.parseInt(textFieldInt2.getText()); stringInse = textFieldNomeEsta.getText();
							TableTennis inserActiv = new TableTennis(duracao, dataHoje, stringInse, campo2, campo3);
							try
							{
								utilizadores.addActivUser(uti.getEmail(), inserActiv);
								nomeActiv = inserActiv.getNome();
								addNovaActiv.addElement(nomeActiv);	
								JOptionPane.showMessageDialog(null, "Atividade Inserida.");
							}
							catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
						}
					break;
					
					case 9: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || 
							textFieldNomeEsta.getText().equals("")) 
						JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
					else
						{
							duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
							campo3 = Integer.parseInt(textFieldInt2.getText()); stringInse = textFieldNomeEsta.getText();
							Treadmill inserActiv = new Treadmill(duracao, dataHoje, stringInse, campo2, campo3);
							try
							{
								utilizadores.addActivUser(uti.getEmail(), inserActiv);
								nomeActiv = inserActiv.getNome();
								addNovaActiv.addElement(nomeActiv);	
								JOptionPane.showMessageDialog(null, "Atividade Inserida.");
							}
							catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
						}
					break;
					
					case 10: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || 
							textFieldInt3.getText().equals("") || textFieldTemp.getText().equals("")) 
						JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
					else
						{
							duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
							campo3 = Integer.parseInt(textFieldInt2.getText()); campo4 = Integer.parseInt(textFieldInt3.getText()); 
							campo6 = Integer.parseInt(textFieldTemp.getText()); stringInse = comboBoxCondi.getSelectedItem().toString();
							Walking inserActiv = new Walking(duracao, dataHoje, campo6, stringInse, campo2, campo4, campo3);
							try
							{
								utilizadores.addActivUser(uti.getEmail(), inserActiv);
								nomeActiv = inserActiv.getNome();
								addNovaActiv.addElement(nomeActiv);	
								JOptionPane.showMessageDialog(null, "Atividade Inserida.");
							}
							catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
						}
					break;
					
					case 11: if(textFieldDuracao.getText().equals("") || textFieldInt1.getText().equals("") || textFieldInt2.getText().equals("") || 
							textFieldNomeEsta.getText().equals("")) 
						JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
					else
						{
							duracao = Integer.parseInt(textFieldDuracao.getText());	campo2 = Integer.parseInt(textFieldInt1.getText());
							campo3 = Integer.parseInt(textFieldInt2.getText()); stringInse = textFieldNomeEsta.getText();
							Weightlifting inserActiv = new Weightlifting(duracao, dataHoje, stringInse, campo2, campo3);
							try
							{
								utilizadores.addActivUser(uti.getEmail(), inserActiv);
								nomeActiv = inserActiv.getNome();
								addNovaActiv.addElement(nomeActiv);	
								JOptionPane.showMessageDialog(null, "Atividade Inserida.");
							}
							catch(UnexistingUserException e){ JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
						}
					break;
				}
				
							
				for(i = 0; i < ((int)listActiv.getModel().getSize()); i++) addNovaActiv.addElement(listActiv.getModel().getElementAt(i));
							
				listActiv.setModel(addNovaActiv);
				
				//TuDO INVISIVEL
				lblDurao.setVisible(false); lblInt.setVisible(false); 
				lblInt_2.setVisible(false); lblInt_1.setVisible(false); lblInt_3.setVisible(false);
				textFieldDuracao.setVisible(false); textFieldInt3.setVisible(false);
				textFieldInt1.setVisible(false);	textFieldInt2.setVisible(false); textFieldInt4.setVisible(false);
				//OUTDOORPACK
				lblOutdoor.setVisible(false); lblCondiesMeteriologicas.setVisible(false); lblTemperatura.setVisible(false);
				comboBoxCondi.setVisible(false); textFieldTemp.setVisible(false); lblc.setVisible(false);
				//INDOOR PACK
				lblIndoor.setVisible(false); lblNomeEstabelecimento.setVisible(false); textFieldNomeEsta.setVisible(false);
				btnInserirActividade.setVisible(false);
				textFieldDuracao.setText("");; textFieldInt3.setText(""); textFieldTemp.setText(""); textFieldNomeEsta.setText("");
				textFieldInt1.setText("");	textFieldInt2.setText(""); textFieldInt4.setText("");
			}
		});
		btnInserirActividade.setBounds(387, 317, 149, 23);
		panel_2.add(btnInserirActividade);
			
		JLabel lblActividadesRecentes = new JLabel("Actividades Recentes");
		lblActividadesRecentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblActividadesRecentes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblActividadesRecentes.setBounds(10, 11, 838, 26);
		panel_3.add(lblActividadesRecentes);
		
		panel_3.add(listActiv);
		
		final JLabel lblRecDur = new JLabel("Dura\u00E7\u00E3o:");
		lblRecDur.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecDur.setBounds(329, 85, 172, 14);
		panel_3.add(lblRecDur);
		
		final JLabel lblRecInt1 = new JLabel("Int1:");
		lblRecInt1.setVisible(false);
		lblRecInt1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecInt1.setBounds(339, 110, 162, 14);
		panel_3.add(lblRecInt1);
		
		final JLabel lblRecInt2 = new JLabel("Int2:");
		lblRecInt2.setVisible(false);
		lblRecInt2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecInt2.setBounds(329, 138, 172, 14);
		panel_3.add(lblRecInt2);
		
		final JLabel lblRecInt3 = new JLabel("Int3:");
		lblRecInt3.setVisible(false);
		lblRecInt3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecInt3.setBounds(329, 164, 172, 14);
		panel_3.add(lblRecInt3);
		
		final JLabel lblRecInt4 = new JLabel("Int4:");
		lblRecInt4.setVisible(false);
		lblRecInt4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecInt4.setBounds(329, 189, 172, 14);
		panel_3.add(lblRecInt4);
		
		textRecDur = new JTextField();
		textRecDur.setEditable(false);
		textRecDur.setBounds(511, 82, 172, 20);
		panel_3.add(textRecDur);
		textRecDur.setColumns(10);
		
		textRecInt1 = new JTextField();
		textRecInt1.setVisible(false);
		textRecInt1.setEditable(false);
		textRecInt1.setColumns(10);
		textRecInt1.setBounds(511, 107, 172, 20);
		panel_3.add(textRecInt1);
		
		textRecInt2 = new JTextField();
		textRecInt2.setVisible(false);
		textRecInt2.setEditable(false);
		textRecInt2.setColumns(10);
		textRecInt2.setBounds(511, 135, 172, 20);
		panel_3.add(textRecInt2);
		
		textRecInt3 = new JTextField();
		textRecInt3.setVisible(false);
		textRecInt3.setEditable(false);
		textRecInt3.setColumns(10);
		textRecInt3.setBounds(511, 161, 172, 20);
		panel_3.add(textRecInt3);
		
		textRecInt4 = new JTextField();
		textRecInt4.setVisible(false);
		textRecInt4.setEditable(false);
		textRecInt4.setColumns(10);
		textRecInt4.setBounds(511, 186, 172, 20);
		panel_3.add(textRecInt4);
		
		final JLabel lblRecInd = new JLabel("Indoor:");
		lblRecInd.setVisible(false);
		lblRecInd.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecInd.setBounds(556, 218, 69, 14);
		panel_3.add(lblRecInd);
		
		final JLabel lblRecNoEs = new JLabel("Nome Estabelecimento:");
		lblRecNoEs.setVisible(false);
		lblRecNoEs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecNoEs.setBounds(364, 246, 137, 14);
		panel_3.add(lblRecNoEs);
		
		textRecEstab = new JTextField();
		textRecEstab.setVisible(false);
		textRecEstab.setEditable(false);
		textRecEstab.setBounds(511, 243, 172, 20);
		panel_3.add(textRecEstab);
		textRecEstab.setColumns(10);
		
		final JLabel lblRecOut = new JLabel("Outdoor:");
		lblRecOut.setVisible(false);
		lblRecOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecOut.setBounds(556, 274, 69, 14);
		panel_3.add(lblRecOut);
		
		final JLabel lblRecCondMet = new JLabel("Condi\u00E7\u00F5es metereologicas:");
		lblRecCondMet.setVisible(false);
		lblRecCondMet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecCondMet.setBounds(329, 296, 172, 14);
		panel_3.add(lblRecCondMet);
		
		textRecTemp = new JTextField();
		textRecTemp.setVisible(false);
		textRecTemp.setEditable(false);
		textRecTemp.setBounds(511, 321, 69, 20);
		panel_3.add(textRecTemp);
		textRecTemp.setColumns(10);
		
		final JLabel lblRecTemp = new JLabel("Temperatura:");
		lblRecTemp.setVisible(false);
		lblRecTemp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecTemp.setBounds(389, 324, 112, 14);
		panel_3.add(lblRecTemp);
		
		JButton btnEscolher = new JButton("Escolher");
		btnEscolher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int valorEscolhido = 0;
				valorEscolhido = listActiv.getSelectedIndex();
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				
				//HIDE EVERRYTHING
				lblRecInt1.setVisible(false); textRecInt1.setVisible(false);
				lblRecInt2.setVisible(false); textRecInt2.setVisible(false);
				lblRecInt3.setVisible(false); textRecInt3.setVisible(false);
				lblRecInt4.setVisible(false); textRecInt4.setVisible(false);
				//MUH OUTDOOR
				lblRecOut.setVisible(false); lblRecCondMet.setVisible(false); comboRecMet.setVisible(false);
				lblRecTemp.setVisible(false); textRecTemp.setVisible(false);
				//MUH INDOOR
				lblRecInd.setVisible(false); lblRecNoEs.setVisible(false); textRecEstab.setVisible(false);
				
				ArrayList<Actividades> actividadesUser = null;
				try {
					actividadesUser = (ArrayList<Actividades>) utilizadores.getActivUser(uti.getEmail());
				} catch (UnexistingUserException e) { JOptionPane.showMessageDialog(null, "Email inexistente: " + e.getMessage());}
				
				Actividades activEscolhida = actividadesUser.get(actividadesUser.size()-valorEscolhido-1);				

				if(activEscolhida instanceof Badminton)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Pontos Concedidos:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Pontos Marcados:");
					//MUH INDOOR
					lblRecInd.setVisible(true); lblRecNoEs.setVisible(true); textRecEstab.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Badminton)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Badminton)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Badminton) activEscolhida).getConceded() + ""); textRecInt2.setText(((Badminton) activEscolhida).getScored() + "");
					textRecEstab.setText(((Badminton) activEscolhida).getNome_estabelecimento() + "");
				}
				if(activEscolhida instanceof Basquetebol)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Pontos Marcados:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Passes:");
					//MUH INDOOR
					lblRecInd.setVisible(true); lblRecNoEs.setVisible(true); textRecEstab.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Basquetebol)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Basquetebol)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Basquetebol) activEscolhida).getMarcados() + ""); textRecInt2.setText(((Basquetebol) activEscolhida).getPasses() + "");
					textRecEstab.setText(((Basquetebol) activEscolhida).getNome_estabelecimento() + ""); 
				}
				if(activEscolhida instanceof Ciclismo)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Altura Maxima:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Altura Minima:");
					lblRecInt3.setVisible(true); textRecInt3.setVisible(true); lblRecInt3.setText("Velocidade Media:");
					lblRecInt4.setVisible(true); textRecInt4.setVisible(true); lblRecInt4.setText("Distancia Percorida:");
					//MUH OUTDOOR
					lblRecOut.setVisible(true); lblRecCondMet.setVisible(true); comboRecMet.setVisible(true);
					lblRecTemp.setVisible(true); textRecTemp.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Ciclismo)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Ciclismo)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Ciclismo) activEscolhida).getAltMax() + ""); textRecInt2.setText(((Ciclismo) activEscolhida).getAltMin() + "");
					textRecInt3.setText(((Ciclismo) activEscolhida).getAvgSpeed() + ""); textRecInt4.setText(((Ciclismo) activEscolhida).getDistancia() + "");
					textRecTemp.setText(((Ciclismo) activEscolhida).getTemperatura() + ""); comboRecMet.setText(((Ciclismo) activEscolhida).getCondicoes_met() + "");
				}
				if(activEscolhida instanceof Futebol)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Golos Marcados:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Golos Sofridos:");
					lblRecInt3.setVisible(true); textRecInt3.setVisible(true); lblRecInt3.setText("Passes:");
					//MUH OUTDOOR
					lblRecOut.setVisible(true); lblRecCondMet.setVisible(true); comboRecMet.setVisible(true);
					lblRecTemp.setVisible(true); textRecTemp.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Futebol)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Futebol)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Futebol) activEscolhida).getGolosMarc() + ""); textRecInt2.setText(((Futebol) activEscolhida).getGolosSofr() + "");
					textRecInt3.setText(((Futebol) activEscolhida).getPasses() + ""); 
					textRecTemp.setText(((Futebol) activEscolhida).getTemperatura() + ""); comboRecMet.setText(((Futebol) activEscolhida).getCondicoes_met() + "");
				}
				if(activEscolhida instanceof Golfing)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Altura Maxima:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Altura Minima:");
					//MUH OUTDOOR
					lblRecOut.setVisible(true); lblRecCondMet.setVisible(true); comboRecMet.setVisible(true);
					lblRecTemp.setVisible(true); textRecTemp.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Golfing)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Golfing)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Golfing) activEscolhida).getnBuracos() + ""); textRecInt2.setText(((Golfing) activEscolhida).getPontos() + "");
					textRecTemp.setText(((Golfing) activEscolhida).getTemperatura() + ""); comboRecMet.setText(((Golfing) activEscolhida).getCondicoes_met() + "");
				}
				if(activEscolhida instanceof Running)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Altura Maxima:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Altura Minima:");
					lblRecInt3.setVisible(true); textRecInt3.setVisible(true); lblRecInt3.setText("Velocidade Media:");
					lblRecInt4.setVisible(true); textRecInt4.setVisible(true); lblRecInt4.setText("Distancia Percorida:");
					//MUH OUTDOOR
					lblRecOut.setVisible(true); lblRecCondMet.setVisible(true); comboRecMet.setVisible(true);
					lblRecTemp.setVisible(true); textRecTemp.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Running)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Running)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Running) activEscolhida).getAltMax() + ""); textRecInt2.setText(((Running) activEscolhida).getAltMin() + "");
					textRecInt3.setText(((Running) activEscolhida).getAvgSpeed() + ""); textRecInt4.setText(((Running) activEscolhida).getDistancia() + "");
					textRecTemp.setText(((Running) activEscolhida).getTemperatura() + ""); comboRecMet.setText(((Running) activEscolhida).getCondicoes_met() + "");
				}
				if(activEscolhida instanceof Sprint)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Distancia:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Velocidade Maxima:");
					//MUH OUTDOOR
					lblRecOut.setVisible(true); lblRecCondMet.setVisible(true); comboRecMet.setVisible(true);
					lblRecTemp.setVisible(true); textRecTemp.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Sprint)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Sprint)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Sprint) activEscolhida).getDistancia() + ""); textRecInt2.setText(((Sprint) activEscolhida).getVelMax() + "");
					textRecTemp.setText(((Sprint) activEscolhida).getTemperatura() + ""); comboRecMet.setText(((Sprint) activEscolhida).getCondicoes_met() + "");
				}
				if(activEscolhida instanceof Swimming)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Distancia:");
					//MUH OUTDOOR
					lblRecOut.setVisible(true); lblRecCondMet.setVisible(true); comboRecMet.setVisible(true);
					lblRecTemp.setVisible(true); textRecTemp.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Swimming)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Swimming)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Swimming) activEscolhida).getDistancia() + "");
					textRecTemp.setText(((Swimming) activEscolhida).getTemperatura() + ""); comboRecMet.setText(((Swimming) activEscolhida).getCondicoes_met() + "");
				}
				if(activEscolhida instanceof TableTennis)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Pontos Concedidos:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Pontos Marcados:");
					//MUH INDOOR
					lblRecInd.setVisible(true); lblRecNoEs.setVisible(true); textRecEstab.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((TableTennis)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((TableTennis)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((TableTennis) activEscolhida).getConcededpoints() + ""); textRecInt2.setText(((TableTennis) activEscolhida).getScoredpoints() + "");
					textRecEstab.setText(((TableTennis) activEscolhida).getNome_estabelecimento() + "");
				}
				if(activEscolhida instanceof Treadmill)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Elevação:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Velocidade:");
					//MUH INDOOR
					lblRecInd.setVisible(true); lblRecNoEs.setVisible(true); textRecEstab.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Treadmill)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Treadmill)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Treadmill) activEscolhida).getElevation() + ""); textRecInt2.setText(((Treadmill) activEscolhida).getVelocidade() + "");
					textRecEstab.setText(((Treadmill) activEscolhida).getNome_estabelecimento() + "");
				}
				if(activEscolhida instanceof Walking)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Altura Maxima:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Altura Minima:");
					lblRecInt3.setVisible(true); textRecInt3.setVisible(true); lblRecInt3.setText("Distancia:");
					//MUH OUTDOOR
					lblRecOut.setVisible(true); lblRecCondMet.setVisible(true); comboRecMet.setVisible(true);
					lblRecTemp.setVisible(true); textRecTemp.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Walking)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Walking)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Walking) activEscolhida).getAltMax() + ""); textRecInt2.setText(((Walking) activEscolhida).getAltMin() + "");
					textRecInt3.setText(((Walking) activEscolhida).getDistancia() + ""); 
					textRecTemp.setText(((Walking) activEscolhida).getTemperatura() + ""); comboRecMet.setText(((Walking) activEscolhida).getCondicoes_met() + "");
				}
				if(activEscolhida instanceof Weightlifting)
				{
					lblRecInt1.setVisible(true); textRecInt1.setVisible(true); lblRecInt1.setText("Numero Repetições:");
					lblRecInt2.setVisible(true); textRecInt2.setVisible(true); lblRecInt2.setText("Peso:");
					//MUH INDOOR
					lblRecInd.setVisible(true); lblRecNoEs.setVisible(true); textRecEstab.setVisible(true);
					//Escrever INFO
			    	String d = df.format(((Weightlifting)activEscolhida).getData_atividade().getTime());
					textRecData.setText(d + ""); textRecDur.setText(((Weightlifting)activEscolhida).getDuracao() + "");
					textRecInt1.setText(((Weightlifting) activEscolhida).getNumbof_repetitions() + ""); textRecInt2.setText(((Weightlifting) activEscolhida).getPeso() + "");
					textRecEstab.setText(((Weightlifting) activEscolhida).getNome_estabelecimento() + "");
				}
				
			}
		});
		btnEscolher.setBounds(85, 333, 112, 26);
		panel_3.add(btnEscolher);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setBounds(443, 60, 58, 14);
		panel_3.add(lblData);
		
		textRecData = new JTextField();
		textRecData.setEditable(false);
		textRecData.setBounds(511, 57, 172, 20);
		panel_3.add(textRecData);
		textRecData.setColumns(10);
		
		JLabel lblF = new JLabel("\u00BA F");
		lblF.setBounds(590, 324, 46, 14);
		panel_3.add(lblF);
		
		comboRecMet = new JTextField();
		comboRecMet.setVisible(false);
		comboRecMet.setEditable(false);
		comboRecMet.setBounds(511, 293, 172, 20);
		panel_3.add(comboRecMet);
		comboRecMet.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Amigos", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblAmigos = new JLabel("Amigos");
		lblAmigos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmigos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAmigos.setBounds(10, 11, 838, 37);
		panel_4.add(lblAmigos);
		
		panel_4.add(listAmigos);
		
		textAmEmail = new JTextField();
		textAmEmail.setEditable(false);
		textAmEmail.setColumns(10);
		textAmEmail.setBounds(368, 74, 200, 20);
		panel_4.add(textAmEmail);
		
		textAmNome = new JTextField();
		textAmNome.setEditable(false);
		textAmNome.setColumns(10);
		textAmNome.setBounds(368, 105, 200, 20);
		panel_4.add(textAmNome);
		
		textAmSex = new JTextField();
		textAmSex.setEditable(false);
		textAmSex.setBounds(368, 136, 62, 20);
		panel_4.add(textAmSex);
		textAmSex.setColumns(10);
		
		textAmDesp = new JTextField();
		textAmDesp.setEditable(false);
		textAmDesp.setColumns(10);
		textAmDesp.setBounds(368, 239, 200, 20);
		panel_4.add(textAmDesp);
		
		final JTextField textAmDataNasc = new JTextField();
		textAmDataNasc.setEditable(false);
		textAmDataNasc.setBounds(368, 211, 128, 20);
		panel_4.add(textAmDataNasc);
		
		final JTextField textAmAlt = new JTextField();
		textAmAlt.setEditable(false);
		textAmAlt.setBounds(368, 161, 62, 20);
		panel_4.add(textAmAlt);
		
		final JTextField textAmPeso = new JTextField();
		textAmPeso.setEditable(false);
		textAmPeso.setBounds(368, 186, 62, 20);
		panel_4.add(textAmPeso);
		
		JButton btnEscolher_1 = new JButton("Escolher");
		btnEscolher_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int valorEscolhido = 0;
				valorEscolhido = listActiv.getSelectedIndex();
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				
				ArrayList<String> amigosUser = null;
				try {
					amigosUser = (ArrayList<String>) utilizadores.getAmigosUser(uti.getEmail());
				} catch (UnexistingUserException e) { JOptionPane.showMessageDialog(null, "Email inexistente: " + e.getMessage());}
				
				User userEscolhido = null;
				try {
					userEscolhido = utilizadores.getUser( amigosUser.get(amigosUser.size()-valorEscolhido-1) );
				} catch (UnexistingUserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				

				
			    	String d = df.format(((User)userEscolhido).getDatNasc().getTime());
			    	textAmDataNasc.setText(d + ""); textAmEmail.setText(((User)userEscolhido).getEmail() + "");
			    	textAmNome.setText(((User) userEscolhido).getNome() + ""); textAmSex.setText(((User) userEscolhido).getGenero() + "");
			    	textAmAlt.setText(((User) userEscolhido).getAltura() + ""); textAmPeso.setText(((User) userEscolhido).getPeso() + "");
			    	textAmDesp.setText(((User) userEscolhido).getFavSport() + "");
			}
		});
		btnEscolher_1.setBounds(86, 353, 89, 23);
		panel_4.add(btnEscolher_1);
		
		JLabel label = new JLabel("Email:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(312, 77, 46, 14);
		panel_4.add(label);
		
		JLabel label_2 = new JLabel("Nome:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(312, 108, 46, 14);
		panel_4.add(label_2);
		
		JLabel label_12 = new JLabel("Sexo:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setBounds(312, 139, 46, 14);
		panel_4.add(label_12);
		
		JLabel label_13 = new JLabel("Altura:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setBounds(312, 164, 46, 14);
		panel_4.add(label_13);
		
		JLabel label_14 = new JLabel("Peso:");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setBounds(312, 189, 46, 14);
		panel_4.add(label_14);
		
		JLabel label_15 = new JLabel("Data Nascimento:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setBounds(250, 214, 108, 14);
		panel_4.add(label_15);
		
		JLabel label_16 = new JLabel("Desporto Favorito:");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setBounds(238, 239, 120, 14);
		panel_4.add(label_16);
		
		JLabel lblListaDeAmigos = new JLabel("Lista de amigos:");
		lblListaDeAmigos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeAmigos.setBounds(56, 61, 159, 14);
		panel_4.add(lblListaDeAmigos);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Adicionar Amigos", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel label_17 = new JLabel("Pedidos de amizade:");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(528, 47, 163, 14);
		panel_6.add(label_17);
		
		panel_6.add(listPedidos);
		
		JButton button = new JButton("Aceitar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					utilizadores.acceptRequest("" + listPedidos.getSelectedValue(), uti.getEmail());
					JOptionPane.showMessageDialog(null, "Pedido Aceitado.");
				} catch (UnexistingUserException e) { JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
			}
		});
		button.setBounds(518, 341, 89, 23);
		panel_6.add(button);
		
		JButton button_1 = new JButton("Recusar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					utilizadores.rejectRequest(uti.getEmail(), "" + listPedidos.getSelectedValue());
					JOptionPane.showMessageDialog(null, "Pedido Rejeitado.");
				} catch (UnexistingUserException e)  { JOptionPane.showMessageDialog(null, "Utilizador inexistente: " + e.getMessage()); }
			}
		});
		button_1.setBounds(617, 341, 89, 23);
		panel_6.add(button_1);
		
		JLabel lblAdicionarAmigos = new JLabel("Adicionar Amigos");
		lblAdicionarAmigos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarAmigos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdicionarAmigos.setBounds(0, 11, 838, 37);
		panel_6.add(lblAdicionarAmigos);
		
		JLabel lblEnviarPedido = new JLabel("Enviar Pedido:");
		lblEnviarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnviarPedido.setBounds(81, 75, 185, 14);
		panel_6.add(lblEnviarPedido);
		
		JLabel lblProcurarEmail = new JLabel("Procurar E-mail:");
		lblProcurarEmail.setBounds(81, 118, 110, 14);
		panel_6.add(lblProcurarEmail);
		
		textAddEmail = new JTextField();
		textAddEmail.setColumns(10);
		textAddEmail.setBounds(81, 150, 185, 20);
		panel_6.add(textAddEmail);
		
		JButton button_2 = new JButton("Confirmar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(textAddEmail.getText().equals("")) JOptionPane.showMessageDialog(null, "Preencha todos os campos se faz favor.");
				else
				{
					try {
						utilizadores.sendRequest(uti.getEmail(), textAddEmail.getText());
						JOptionPane.showMessageDialog(null, "Pedido Enviado.");
					} catch (UnexistingUserException e) { JOptionPane.showMessageDialog(null, "Amigo ja inserido: " + e.getMessage()); } 
					catch (ExistingUserException e) { JOptionPane.showMessageDialog(null, "Amigo ja inserido: " + e.getMessage()); }
				}
			}
		});
		button_2.setBounds(130, 181, 89, 23);
		panel_6.add(button_2);
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				((CardLayout)frmFitnessUm.getContentPane().getLayout()).show(frmFitnessUm.getContentPane(), "name_23922776778822");
				passwordField.setText("");
				textField.setText("");
				passIncorecta.setVisible(false);
			}
		});
		

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				((CardLayout)frmFitnessUm.getContentPane().getLayout()).show(frmFitnessUm.getContentPane(), "name_23922776778822");
				passwordField.setText("");
				textField.setText("");
				passIncorecta.setVisible(false);
				
				//Limpar todo
				textField_Nome.setText("");
				textField_Email.setText("");
				passwordField_1.setText("");
				passwordField_2.setText("");
				formattedTextField_Altura.setText("");
				formattedTextField_Peso.setText("");
				formattedTextField_Nasc.setText("");
				textField_Desporto.setText("");
			}
		});
		btnVoltar.setBounds(743, 17, 89, 23);
		panel_Reg.add(btnVoltar);
		
		btnLogout.setBounds(764, 11, 89, 23);
		panel_1.add(btnLogout);
		frmFitnessUm.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel, textField, passwordField, passIncorecta, btnLogin, lblEmail, lblNewLabel, btnGravar, btnRegisto, panel_1, tabbedPane, panel_2, panel_3, btnLogout}));
	}
}
