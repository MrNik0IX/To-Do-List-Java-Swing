package todo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
//Last Test

public class main {

	public static void main(String[] args) {

SwingUtilities.invokeLater(()-> main.createAndShowGui());
Task task = new Task("Test", "My test task", LocalDate.of(2000, 12, 17), (byte) 4);



	}
	private static void createAndShowGui() {
		//Main Window Creation
		JFrame window = new JFrame("To-Do List");
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//Visuals
		window.setSize(600, 500);
		
		
		//Dialog for task creation
		JDialog createDialog = new JDialog(window, true);
		
		createDialog.setResizable(false);
		createDialog.setSize(400, 300);
		createDialog.setUndecorated(true);
		createDialog.setOpacity(0.9999f);
		createDialog.getContentPane().setBackground(Color.gray); 
		window.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				createDialog.setLocation(window.getLocation().x+window.getWidth()/2-200, window.getLocation().y+window.getHeight()/2-150);
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				createDialog.setLocation(window.getLocation().x+window.getWidth()/2-200, window.getLocation().y+window.getHeight()/2-150);
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				
			}
		});
		
		
		//Dialog components
		JPanel dialogPanel = new JPanel(new BorderLayout());
		dialogPanel.setBackground(Color.GRAY);
		createDialog.add(dialogPanel);
		JLabel dialogHeadText = new JLabel("Create To-Do");
		JPanel dialogHead = new JPanel();
		dialogHead.setBackground(Color.LIGHT_GRAY);
		dialogHead.add(dialogHeadText);
		dialogPanel.add(dialogHead, BorderLayout.PAGE_START);
		JPanel leftSide = new JPanel();
		JPanel rightSide = new JPanel();
		leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.PAGE_AXIS));
		rightSide.setLayout(new BoxLayout(rightSide, BoxLayout.PAGE_AXIS));
	
		
		//Title field and text
		
		JPanel titleFieldPanel = new JPanel();
		dialogPanel.add(titleFieldPanel);
		JLabel getTitleText = new JLabel("Titel: ");
		JTextField getTitleField = new JTextField(10);
		titleFieldPanel.add(getTitleText);
		titleFieldPanel.add(getTitleField);
		
		
		//Description field and text
		JPanel descFieldPanel = new JPanel();
		dialogPanel.add(descFieldPanel);
		JLabel getDescText = new JLabel("Description: ");
		JTextArea getDescField = new JTextArea();
		getDescField.setLineWrap(true);
		getDescField.setPreferredSize(new Dimension(160, 80));
		descFieldPanel.add(getDescText);
		descFieldPanel.add(getDescField);
		
		
		//Date field and text
		
		JPanel dateFieldPanel = new JPanel();
		dialogPanel.add(dateFieldPanel);
		JLabel getDateText = new JLabel("Date: ");
		JDateChooser getDateField = new JDateChooser();
		getDateField.setPreferredSize(new Dimension(100, 20));
		dateFieldPanel.add(getDateText);
		dateFieldPanel.add(getDateField);
		
		//Task priority field and text
		
		JPanel priorityFieldPanel = new JPanel();
		dialogPanel.add(priorityFieldPanel);
		JLabel getPriorityText = new JLabel("Priority: ");
		JSpinner getPriorityField = new JSpinner(new SpinnerListModel(new Integer[]{1, 2, 3}));
		priorityFieldPanel.add(getPriorityText);
		priorityFieldPanel.add(getPriorityField);
		
		
		//JButtons to cancel or send in form
		JButton cancelButton = new JButton("Cancel");
		JButton submitButton = new JButton("Submit");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		
		List.of(cancelButton, submitButton).forEach(a->buttonPanel.add(a));
		cancelButton.addActionListener(e->createDialog.setVisible(false));
		dialogPanel.add(buttonPanel, BorderLayout.PAGE_END);
		
		//Adjust background color of all form field panels again
		List.of(titleFieldPanel, descFieldPanel, dateFieldPanel, priorityFieldPanel).forEach(a -> a.setBackground(Color.gray));
		
		//!!!!NEEDS CLEANUP!!!!
		List.of(titleFieldPanel, descFieldPanel).forEach(a -> leftSide.add(a));
		List.of(dateFieldPanel, priorityFieldPanel).forEach(a -> rightSide.add(a));
		dialogPanel.add(leftSide, BorderLayout.LINE_START);
		dialogPanel.add(rightSide, BorderLayout.LINE_END);
	
		
		//-----------------------------------------------------------------------------------------//
		
		//Panels
		
		//Top Panel with title and create button
		JPanel head = new JPanel();
		head.setLayout(new BoxLayout(head, BoxLayout.PAGE_AXIS));
	
		window.add(head);
		
		//-----------------------------------------------------------------------------------------//
		
		//Labels
		
		//Title
		JLabel title = new JLabel("To-Do List");
		title.setFont(new Font("Arial", Font.BOLD, 40));
		title.setForeground(Color.green);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		head.add(title);
		
		//-----------------------------------------------------------------------------------------//
		
		//Buttons
		
		//Top Button to create a new Task
		
		JButton createButton = new JButton("Create To-Do");
		createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		createButton.addActionListener(e-> {
			createDialog.setVisible(true);
		});
		head.add(createButton);
	}
}
