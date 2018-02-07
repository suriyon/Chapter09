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
	private ShowStudentJFrame showStudentJFrame;
	private SearchStudentJFrame searchStudentJFrame;
	private UpdateStudentJFrame updateStudentJFrame;
	private DeleteStudentJFrame deleteStudentJFrame;

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
		toolBarShowStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(showStudentJFrame == null || showStudentJFrame.isClosed()) {
					showStudentJFrame = new ShowStudentJFrame();
					showStudentJFrame.setVisible(true);
					desktopPane.add(showStudentJFrame);
				}
			}
		});
		toolBar.add(toolBarShowStudent);
		
		JButton toolBarSearchStudent = new JButton("Search Student");
		toolBarSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(searchStudentJFrame == null || searchStudentJFrame.isClosed()) {
					searchStudentJFrame = new SearchStudentJFrame();
					searchStudentJFrame.setVisible(true);
					desktopPane.add(searchStudentJFrame);
				}
			}
		});
		toolBar.add(toolBarSearchStudent);
		
		JButton toolBarEditStudent = new JButton("Edit Student");
		toolBarEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(updateStudentJFrame == null || updateStudentJFrame.isClosed()) {
					updateStudentJFrame = new UpdateStudentJFrame();
					updateStudentJFrame.setVisible(true);
					desktopPane.add(updateStudentJFrame);
				}
			}
		});
		toolBar.add(toolBarEditStudent);
		
		JButton toolBarExit = new JButton("Exit");
		toolBarExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton toolBarDeleteStudent = new JButton("Delete Student");
		toolBarDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(deleteStudentJFrame == null || deleteStudentJFrame.isClosed()) {
					deleteStudentJFrame = new DeleteStudentJFrame();
					deleteStudentJFrame.setVisible(true);
					desktopPane.add(deleteStudentJFrame);
				}		
			}
		});
		toolBar.add(toolBarDeleteStudent);
		toolBar.add(toolBarExit);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

}
