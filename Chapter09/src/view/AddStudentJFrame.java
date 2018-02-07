package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.StudentController;
import model.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddStudentJFrame extends JInternalFrame {
	private JTextField textId;
	private JTextField textName;
	private JTextField textBranch;
	private JTextField textAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentJFrame frame = new AddStudentJFrame();
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
	public AddStudentJFrame() {
		setFrameIcon(new ImageIcon(AddStudentJFrame.class.getResource("/images32/add.png")));
		setTitle("Add Student JFrame");
		setClosable(true);
		setBounds(100, 100, 478, 324);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u0E01\u0E23\u0E2D\u0E01\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 442, 177);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("รหัสนักศึกษา");
		lblNewLabel.setBounds(33, 29, 77, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ชื่อ-นามสกุล");
		lblNewLabel_1.setBounds(222, 29, 77, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("สาขา");
		lblNewLabel_2.setBounds(33, 96, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("อายุ");
		lblNewLabel_3.setBounds(222, 96, 46, 14);
		panel.add(lblNewLabel_3);
		
		textId = new JTextField();
		textId.setBounds(33, 54, 144, 20);
		panel.add(textId);
		textId.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(222, 54, 177, 20);
		panel.add(textName);
		textName.setColumns(10);
		
		textBranch = new JTextField();
		textBranch.setBounds(33, 121, 144, 20);
		panel.add(textBranch);
		textBranch.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(222, 121, 86, 20);
		panel.add(textAge);
		textAge.setColumns(10);
		
		JButton btnAdd = new JButton("เพิ่มข้อมูล");
		btnAdd.setIcon(new ImageIcon(AddStudentJFrame.class.getResource("/images32/add.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textId.getText().equals("") || 
						textName.getText().equals("") ||
						textBranch.getText().equals("") ||
						textAge.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบ!");
				} else {
					String id = textId.getText().trim();
					String name = textName.getText().trim();
					String branch = textBranch.getText().trim();
					int age = Integer.parseInt(textAge.getText().trim());
					
					Student student = new Student(id, name, branch, age);
					
					StudentController studentController = new StudentController();
					
					boolean result = studentController.insert(student);
					
					if(result) {
						JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลสำเร็จ");
					}else {
						JOptionPane.showMessageDialog(null, "เกิดข้อผิดพลาดในการเพิ่มข้อมูล");
					}
					clearTextField();
				}
				
				
			}
		});
		btnAdd.setBounds(161, 215, 128, 42);
		getContentPane().add(btnAdd);

	}

	protected void clearTextField() {
		textAge.setText("");
		textBranch.setText("");
		textId.setText("");
		textName.setText("");
	}
}
