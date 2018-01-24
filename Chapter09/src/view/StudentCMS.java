package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentCMS extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private AddStudentJFrame addStudentJFrame;

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
					StudentCMS frame = new StudentCMS();
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
	public StudentCMS() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Student CMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton toolBarAddStudent = new JButton("Add Student");
		toolBarAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addStudentJFrame == null || addStudentJFrame.isClosed()) {
					addStudentJFrame = new AddStudentJFrame();
					addStudentJFrame.setVisible(true);
					desktopPane.add(addStudentJFrame);
				}
			}
		});
		toolBar.add(toolBarAddStudent);
		
		JButton toolBarShowStudent = new JButton("Show Student");
		toolBar.add(toolBarShowStudent);
		
		JButton toolBarEditStudent = new JButton("Edit Student");
		toolBar.add(toolBarEditStudent);
		
		JButton toolBarExit = new JButton("Exit");
		toolBarExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		toolBar.add(toolBarExit);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

}
