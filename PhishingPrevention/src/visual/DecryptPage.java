/*
Visual Cryptography Project

Copyright (c) 2015 Justin Blackmon and Joel Bush

For licensing information refer to LICENSE.md

This project is a Java application that utilizes visual cryptography techniques to encrypt and decrypt images.
*/

package visual;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.io.File;

public class DecryptPage extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecryptPage frame = new DecryptPage();
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
	public DecryptPage() {
		
		// Create the decrypt page JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{440, 0};
		gbl_contentPane.rowHeights = new int[]{49, 56, 56, 56, 56, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		// Create decrypt page title
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		JLabel lblDecrypt = new JLabel("Decryption");
		lblDecrypt.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDecrypt.setBorder(loweredetched);
		lblDecrypt.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDecrypt = new GridBagConstraints();
		gbc_lblDecrypt.fill = GridBagConstraints.BOTH;
		gbc_lblDecrypt.insets = new Insets(0, 0, 5, 0);
		gbc_lblDecrypt.gridx = 0;
		gbc_lblDecrypt.gridy = 0;
		contentPane.add(lblDecrypt, gbc_lblDecrypt);
		
		// Allows user to select first image to decrypt
		JButton btnImage1 = new JButton("Image 1");
		GridBagConstraints gbc_btnImage1 = new GridBagConstraints();
		gbc_btnImage1.fill = GridBagConstraints.BOTH;
		gbc_btnImage1.insets = new Insets(0, 50, 5, 50);
		gbc_btnImage1.gridx = 0;
		gbc_btnImage1.gridy = 1;
		contentPane.add(btnImage1, gbc_btnImage1);
		btnImage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Allow user to choose path
				VisualCall.image1_path = ImageFunctions.GetPathName();
				
				// Attempt to open file as image
				try{
					VisualCall.image1_file = new File(VisualCall.image1_path);
				} catch (NullPointerException e) {
					System.out.println("An invalid file path was returned");
					return;
				}
				
				// Display image 1
				VisualCall.image1 = ImageFunctions.Display(VisualCall.image1_file, "Image 1");

			}
		});
		
		// Allow user to select second image to decrypt
		JButton btnImage2 = new JButton("Image 2");
		GridBagConstraints gbc_btnImage2 = new GridBagConstraints();
		gbc_btnImage2.fill = GridBagConstraints.BOTH;
		gbc_btnImage2.insets = new Insets(0, 50, 5, 50);
		gbc_btnImage2.gridx = 0;
		gbc_btnImage2.gridy = 2;
		contentPane.add(btnImage2, gbc_btnImage2);
		btnImage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Allow user to choose second file
				VisualCall.image2_path = ImageFunctions.GetPathName();
				
				// Attempt to open file as image
				try{
					VisualCall.image2_file = new File(VisualCall.image2_path);
				} catch (NullPointerException e) {
					System.out.println("An invalid file path was returned");
					return;
				}
				
				// Display image 2
				VisualCall.image2 = ImageFunctions.Display(VisualCall.image2_file, "Image 2");
			}
		});
		
		// Choose a path for output to be saved
		JButton btnSaveImage = new JButton("Save Image");
		GridBagConstraints gbc_btnSaveImage = new GridBagConstraints();
		gbc_btnSaveImage.fill = GridBagConstraints.BOTH;
		gbc_btnSaveImage.insets = new Insets(0, 50, 5, 50);
		gbc_btnSaveImage.gridx = 0;
		gbc_btnSaveImage.gridy = 3;
		contentPane.add(btnSaveImage, gbc_btnSaveImage);
		btnSaveImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Allow user to choose path
				VisualCall.image_decrypt_path = ImageFunctions.GetPathName();
				VisualCall.normal_size_decrypted_path = VisualCall.image_decrypt_path;
				
				// Format save string name
				VisualCall.image_decrypt_path += ".png";
				VisualCall.normal_size_decrypted_path += "_normal_size.png";
				
				// Attempt to create an output file
				try{
					VisualCall.image_decrypt_file = new File(VisualCall.image_decrypt_path);
					VisualCall.normal_size_decrypted_file = new File(VisualCall.normal_size_decrypted_path);
				} catch (NullPointerException e) {
					System.out.println("An invalid file path was returned");
					return;
				}
				
			}
		});
		
		// Convert encrypted images into decrypted output
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Decrypt and display the encoded images
				VisualCall.decrypt_image = ImageFunctions.Decrypt(VisualCall.image1, VisualCall.image2);
				ImageFunctions.Display_Image(VisualCall.decrypt_image, "Decrypted Image");
				
				// Save the decrypted image
				ImageFunctions.Save(VisualCall.decrypt_image, VisualCall.image_decrypt_file);

				// Create, display, and save scaled image (same size as original image
				VisualCall.normal_size_decrypted_image = ImageFunctions.Shrink(VisualCall.decrypt_image);
				ImageFunctions.Display_Image(VisualCall.normal_size_decrypted_image, "Regular Sized Decrypted Image");				
				ImageFunctions.Save(VisualCall.normal_size_decrypted_image, VisualCall.normal_size_decrypted_file);
			}
		});
		GridBagConstraints gbc_btnDecrypt = new GridBagConstraints();
		gbc_btnDecrypt.fill = GridBagConstraints.BOTH;
		gbc_btnDecrypt.insets = new Insets(0, 50, 0, 50);
		gbc_btnDecrypt.gridx = 0;
		gbc_btnDecrypt.gridy = 4;
		contentPane.add(btnDecrypt, gbc_btnDecrypt);
	}
}
