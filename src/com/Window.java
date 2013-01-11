package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblMessageImage = new JLabel("Message.png");
		contentPane.add(lblMessageImage, "16, 2, center, default");
		
		JLabel lblKey = new JLabel("Message");
		contentPane.add(lblKey, "4, 4, right, default");
		
		textField = new JTextField();
		textField.setToolTipText("The message to be put into the input file");
		contentPane.add(textField, "8, 4, 20, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblInputFile = new JLabel("Input File");
		contentPane.add(lblInputFile, "4, 6, right, default");
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Location of the input image. Use a png for best results");
		contentPane.add(textField_1, "8, 6, 20, 1, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblOutputFile = new JLabel("Output File");
		contentPane.add(lblOutputFile, "4, 8, right, default");
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("The output file location. Doesn't have to exist yet!");
		contentPane.add(textField_2, "8, 8, 20, 1, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblLength = new JLabel("Length");
		contentPane.add(lblLength, "4, 10, right, default");
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("The length of the message. You only need this to extract a message");
		contentPane.add(textField_3, "8, 10, 20, 1, fill, default");
		textField_3.setColumns(10);
		
		JButton btnExtract = new JButton("Extract");
		btnExtract.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				textField.setText(Main.extract(textField_1.getText(), Integer.parseInt(textField_3.getText())));
			}
		});
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				textField_3.setText(""+Main.insert(textField.getText(), textField_1.getText(), textField_2.getText()));
			}
		});
		contentPane.add(btnInsert, "16, 12");
		contentPane.add(btnExtract, "16, 14");
	}

}
