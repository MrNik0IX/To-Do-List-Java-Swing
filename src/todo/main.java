package todo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
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




	}
	private static void createAndShowGui() {
		//Main Window Creation
		JFrame window = new JFrame("To-Do List");
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//Visuals
		window.setSize(600, 500);
		
		
		//Dialog for task creation (Needs cleanup to be more structured)
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
		JSpinner getPriorityField = new JSpinner(new SpinnerListModel(new Byte[]{1, 2, 3}));
		priorityFieldPanel.add(getPriorityText);
		priorityFieldPanel.add(getPriorityField);
		
		
		//JButtons to cancel or send in form
		JButton cancelButton = new JButton("Cancel");
		JButton submitButton = new JButton("Submit");
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		
		buttonPanel.add(cancelButton, BorderLayout.LINE_START);
		buttonPanel.add(submitButton, BorderLayout.LINE_END);
		
		dialogPanel.add(buttonPanel, BorderLayout.PAGE_END);
		
		//Adjust background color of all form field panels again
		List.of(titleFieldPanel, descFieldPanel, dateFieldPanel, priorityFieldPanel).forEach(a -> a.setBackground(Color.gray));
		
		//!!!!NEEDS CLEANUP!!!!
		List.of(titleFieldPanel, descFieldPanel).forEach(a -> leftSide.add(a));
		List.of(dateFieldPanel, priorityFieldPanel).forEach(a -> rightSide.add(a));
		dialogPanel.add(leftSide, BorderLayout.LINE_START);
		dialogPanel.add(rightSide, BorderLayout.LINE_END);
		JPanel warningPanel = new JPanel();
		JLabel warningLabel = new JLabel();
		warningPanel.add(warningLabel);
		warningPanel.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(warningPanel, BorderLayout.PAGE_END);
		warningPanel.setVisible(false);
		
		cancelButton.addActionListener(e->{
			createDialog.setVisible(false);
			warningPanel.setVisible(false);
			});
		
		//-----------------------------------------------------------------------------------------//
		
		//Panels
		JPanel mainPanel = new JPanel();
		JPanel taskPanel = new JPanel();
		JPanel head = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
		
		//Top Panel with title and create button
		
		mainPanel.add(head);
		head.setLayout(new BoxLayout(head, BoxLayout.PAGE_AXIS));
		mainPanel.add(taskPanel);
		window.add(mainPanel);
		
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
	
		//-----------------------------------------------------------------------------------------//
		
		//Submitbutton event listener
		submitButton.addActionListener(e->{
			
			
			//Check if any fields are empty 
			if (getTitleField.getText().isEmpty()||getDescField.getText().isEmpty()) {
			warningLabel.setText("Either the Title or the Description is empty please fill out");
			warningPanel.setVisible(true);
			return;
			}
			try {
				if(getDateField.getDate().compareTo(new Date())==-1){
					warningPanel.setVisible(true);
					warningLabel.setText("The given Date was before today which makes no sence");
					return;
				}
			} catch(java.lang.NullPointerException e1) {
				warningPanel.setVisible(true);
				warningLabel.setText("Please enter a valid date!");
				return;
			}
			
			

			
		
			
			//formatting the description field (needs rework)
			StringBuilder taskDescription = new StringBuilder(getDescField.getText());
			taskDescription.insert(0, "<html>");
			
			int count=0;
			for(int i=0; i<taskDescription.length(); i++) {
	
				count++;
				if(count==21) {
			
					taskDescription.insert(i, "<br>");
					count=0;
					
				}
				
			}
			taskDescription.insert(taskDescription.length(), "</html>");
			
			
			//Get entered data and create Task
			new Task(getTitleField.getText(), taskDescription.toString(), getDateField.getDate(),((byte) getPriorityField.getValue()));
			//can be replaced with a stream
			taskPanel.removeAll();
			taskPanel.add(Task.readTasks());
			Task.printAllTasks();
			warningPanel.setVisible(false);
			createDialog.setVisible(false);
			window.revalidate();
			
		});
	}
}
