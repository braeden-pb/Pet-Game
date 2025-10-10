package petgame;


import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.KeyStroke;
import javax.swing.InputMap;
import javax.swing.ActionMap;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;
import javax.swing.event.ChangeEvent;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class GUI {

	private JFrame frame;
	private Container cards;
	private JTextField txtFeildPetName;
	private JPasswordField passwordField;
	private JTextField txtFeildPassword;
	private JLabel lblHealthValue;
	private JLabel lblFullnessValue;
	private JLabel lblHappinessValue;
	private JLabel lblSleepValue;
	private JLabel lblScoreNum;
	private JLabel lblYouChose;
	private String type;
	private JLabel lblPet;
	private JLabel lblImage_1;
	private String currentScreen;
	private BufferedImage bufferedImage;
	private JPanel inventory;
	private JButton btnReviveSave3 = new JButton("");
	int save;
	private LocalTime startWindow;
	private LocalTime endWindow;
	private Timer coolDownTimerPlay = new Timer(300, null);
	private Timer coolDownTimerExercise = new Timer(300, null);
	private Timer coolDownTimerVet = new Timer(300, null);
	private JButton btnSave1Revive = new JButton("");
	private int tick;
	private boolean healthFlag;
	private boolean hungerFlag;
	private boolean angryFlag;
	private boolean sleepFlag;
	private boolean isFlipped;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI window = new GUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	private JFormattedTextField startTimeWindow;
	private JFormattedTextField endTimeWindow;
	private JProgressBar saveProgress;
	private JPanel PetMenu;
	private JProgressBar progressBar;
	private JPanel LoadingScreen;
	private JLabel lblName;
	private JLabel appleCount;
	private JLabel pieCount;
	private JLabel cakeCount;
	private JLabel teddyCount;
	private JLabel ballCount;
	private JLabel spinnerCount;
	private JButton btnTakeToVet;
	private JButton btnExcercise;
	private JButton btnGiveGift;
	private JButton btnGoToBed;
	private JButton btnFeed;
	private JButton btnPlay;
	private JButton btnViewInventory;
	private JButton btnExit_1;
	private JButton btnSave;
	private Action saveAction;
	private Action exitAction;
	private Action inventoryAction;
	private Action excersiceAction;
	private Action vetAction;
	private Action giftAction;
	private Action bedAction;
	private Action feedAction;
	private Action playAction;
	private JLabel lblTotalHours = new JLabel("");
	private JLabel avgPlayTime = new JLabel("");
	private JLabel lblSpinner;
	private JPanel costumes;
	private JToggleButton durag;
	private JToggleButton eyepatch;
	private JToggleButton topHat;
	private JButton btnSave1;
	private JButton btnSave2;
	private JButton btnSave3;
	private JButton btnDeleteSave1;
	private AbstractButton btnDeleteSave2;
	private AbstractButton btnDeleteSave3;
	private JLabel lblSave1;
	private JLabel lblSave2;
	private JLabel lblSave3;
	private JButton btnOverwrite1;
	private JButton btnOverwrite2;
	private JButton btnOverwrite3;
	private JLabel lbloverwrite1;
	private JLabel lbloverwrite3;
	private JLabel lbloverwrite2;
	private JLabel lblOverwriteTitle;
	private JButton btnReviveSave2 = new JButton();
	private Component panel_1;
	private Component panel_3;
	private Component panel_4;
	private Component mainbackground;


	/**
	 * Create the application.
	 */
	public GUI() {
//		System.setProperty("sun.java2d.uiScale", "1.0");
//		try {
//		    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	public void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setMinimumSize(new Dimension(1000, 800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cards = frame.getContentPane();
		cards.setLayout(new CardLayout());

		frame.getRootPane().setFocusTraversalPolicyProvider(true);
		frame.getRootPane().setFocusCycleRoot(true);

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		btnSave1 = new JButton("");
		btnSave2 = new JButton("");
		btnSave3 = new JButton("");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				if (currentScreen == "PetMenu") {
					int option = JOptionPane.showConfirmDialog(frame, "are you sure you want to exit without Saving",
							"exit", JOptionPane.YES_NO_OPTION);
					if (option == 0) {
						frame.dispose();
						System.exit(0);
						try {
							Game.getInstance().getConfigFile().calculateTotalTime();
							Game.getInstance().getConfigFile().calculateAverageTime();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				} else {
					frame.dispose();
					System.exit(0);
				}
			}
		});

		JPanel MainMenu = new JPanel();
		MainMenu.setBackground(new Color(255, 190, 111));
		cards.add(MainMenu, "MainMenu");

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setForeground(new Color(255, 255, 255));
		btnNewGame.setFont(new Font("Dialog", Font.BOLD, 25));
		btnNewGame.setBackground(new Color(46, 194, 126));
		btnNewGame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnNewGame.setBounds(328, 235, 343, 45);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startWindow = Game.getInstance().getConfigFile().getStartWindow();
				endWindow = Game.getInstance().getConfigFile().getEndWindow();
				if ((LocalTime.now().isAfter(endWindow) || LocalTime.now().isBefore(startWindow))
						&& Game.getInstance().getConfigFile().getTimeLimit()) {
					JOptionPane.showMessageDialog(PetMenu, "Cant play at this time", "", JOptionPane.ERROR_MESSAGE);
				} else {
					viewScreen("PetSelect");
				}
			}
		});

		JButton btnParentalControls = new JButton("Parental Controls");
		btnParentalControls.setFont(new Font("Dialog", Font.BOLD, 25));
		btnParentalControls.setForeground(new Color(255, 255, 255));
		btnParentalControls.setBackground(new Color(53, 132, 228));
		btnParentalControls.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnParentalControls.setBounds(328, 454, 343, 45);
		btnParentalControls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				viewScreen("password");
			}
		});

		JButton btnInstructions = new JButton("Instructions");
		btnInstructions.setBackground(new Color(53, 132, 228));
		btnInstructions.setForeground(new Color(255, 255, 255));
		btnInstructions.setFont(new Font("Dialog", Font.BOLD, 25));
		btnInstructions.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnInstructions.setBounds(328, 383, 343, 45);
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewScreen("InstructionsPage");
			}
		});

		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setForeground(new Color(255, 255, 255));
		btnLoadGame.setFont(new Font("Dialog", Font.BOLD, 25));
		btnLoadGame.setBackground(new Color(53, 132, 228));
		btnLoadGame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnLoadGame.setBounds(328, 308, 343, 45);
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Game.getInstance().getConfigFile().getSaveStatus("save1")) {
					btnSave1.setEnabled(false);
					btnDeleteSave1.setEnabled(false);
					btnDeleteSave1.setVisible(false);
					lblSave1.setVisible(false);

				} else {
					btnSave1.setVisible(true);
					btnSave1.setEnabled(true);
					btnDeleteSave1.setEnabled(true);
					btnDeleteSave1.setVisible(true);
					lblSave1.setVisible(true);
					try {
						Game.getInstance().setSaveFile("save1.toml");
						bufferedImage = ImageIO
								.read(getImage(Game.getInstance().getSaveFile().getPetType() + "_save_file.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Image save1Image = bufferedImage.getScaledInstance(300, 430, Image.SCALE_DEFAULT);
					btnSave1.setIcon(new ImageIcon(save1Image));
				}
				if (!Game.getInstance().getConfigFile().getSaveStatus("save2")) {
					btnSave2.setEnabled(false);
					btnDeleteSave2.setEnabled(false);
					btnDeleteSave2.setVisible(false);
					lblSave2.setVisible(false);
				} else {
					btnDeleteSave2.setEnabled(true);
					btnDeleteSave2.setVisible(true);
					btnSave2.setVisible(true);
					btnSave2.setEnabled(true);
					lblSave2.setVisible(true);

					try {
						Game.getInstance().setSaveFile("save2.toml");
						bufferedImage = ImageIO
								.read(getImage(Game.getInstance().getSaveFile().getPetType() + "_save_file.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Image save2Image = bufferedImage.getScaledInstance(300, 430, Image.SCALE_DEFAULT);
					btnSave2.setIcon(new ImageIcon(save2Image));
				}
				if (!Game.getInstance().getConfigFile().getSaveStatus("save3")) {
					btnSave3.setEnabled(false);
					btnDeleteSave3.setEnabled(false);
					btnDeleteSave3.setVisible(false);
					lblSave3.setVisible(false);
				} else {
					btnSave3.setVisible(true);
					btnSave3.setEnabled(true);
					btnDeleteSave3.setEnabled(true);
					btnDeleteSave3.setVisible(true);
					lblSave3.setVisible(true);
					try {
						Game.getInstance().setSaveFile("save3.toml");
						bufferedImage = ImageIO
								.read(getImage(Game.getInstance().getSaveFile().getPetType() + "_save_file.png"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Image save3Image = bufferedImage.getScaledInstance(300, 430, Image.SCALE_DEFAULT);
					btnSave3.setIcon(new ImageIcon(save3Image));
				}

				viewScreen("loadSave");
			}
		});

		JButton btnExit = new JButton("Quit Game");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 25));
		btnExit.setBackground(new Color(246, 97, 81));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnExit.setBounds(328, 525, 343, 45);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		MainMenu.setLayout(null);

		JTextArea credits = new JTextArea();
		credits.setFont(new Font("Dialog", Font.BOLD, 12));
		credits.setForeground(new Color(0, 0, 0));
		credits.setBackground(new Color(154, 153, 150));
		credits.setText(
				"Created By: Team #60: Evan Salmon, Rushd Alashqar, Braeden Patierno-Barker, Micheal Pachowski, Liam Wray | Western University, CS2212B, Winter 2025");
		credits.setBounds(0, 746, 1006, 17);
		credits.setOpaque(true);
		credits.setBackground(new Color(255, 255, 255));
		MainMenu.add(credits);
		MainMenu.add(btnInstructions);
		MainMenu.add(btnParentalControls);
		MainMenu.add(btnNewGame);
		MainMenu.add(btnLoadGame);
		MainMenu.add(btnExit);

		try {
			bufferedImage = ImageIO.read(getImage("main_menu.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image menuImage = bufferedImage.getScaledInstance(1000, 770, Image.SCALE_DEFAULT);

		JLabel lblWelcome = new JLabel("Welcome To\n");
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 30));
		lblWelcome.setBounds(407, 131, 181, 42);
		MainMenu.add(lblWelcome);

		JLabel lblKirbyPetAdventure = new JLabel("Kirby Pet Adventure");
		lblKirbyPetAdventure.setFont(new Font("Dialog", Font.BOLD, 30));
		lblKirbyPetAdventure.setBounds(352, 168, 305, 42);
		MainMenu.add(lblKirbyPetAdventure);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(menuImage));

		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setBounds(-524, -457, 2048, 1680);
		MainMenu.add(background);

		LoadingScreen = new JPanel();
		LoadingScreen.setBackground(new Color(145, 65, 172));
		frame.getContentPane().add(LoadingScreen, "LoadingScreen");

		progressBar = new JProgressBar();
		progressBar.setBounds(100, 657, 799, 14);
		progressBar.setForeground(new Color(0, 0, 0));
		LoadingScreen.setLayout(null);
		LoadingScreen.add(progressBar);

		JLabel loadingBackground = new JLabel("");
		try {
			bufferedImage = ImageIO.read(getImage("loading_screen.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image loadingImage = bufferedImage.getScaledInstance(1000, 770, Image.SCALE_DEFAULT);
		loadingBackground.setIcon(new ImageIcon(loadingImage));
		loadingBackground.setBounds(0, 0, 1000, 768);
		LoadingScreen.add(loadingBackground);

		JPanel loadSave = new JPanel();
		frame.getContentPane().add(loadSave, "loadSave");
		loadSave.setLayout(null);

		JLabel lblChooseASave = new JLabel("");
		lblChooseASave.setForeground(new Color(255, 255, 255));
		lblChooseASave.setBounds(303, 31, 444, 36);
		lblChooseASave.setFont(new Font("Dialog", Font.BOLD, 26));

		try {
			bufferedImage = ImageIO.read(getImage("choose_save_file.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image chooseSaveImage = bufferedImage.getScaledInstance(400, 80, Image.SCALE_SMOOTH);
		lblChooseASave.setIcon(new ImageIcon(chooseSaveImage));

		loadSave.add(lblChooseASave);

		JButton btnReturnToMain_1 = new JButton("Return To Main Menu");
		btnReturnToMain_1.setBounds(832, 6, 162, 27);
		btnReturnToMain_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnReturnToMain_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewScreen("MainMenu");
			}
		});
		loadSave.add(btnReturnToMain_1);

		btnSave1.setBounds(12, 208, 300, 430);
		loadSave.add(btnSave1);
		btnSave1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});

		btnSave2.setBounds(354, 208, 300, 430);
		loadSave.add(btnSave2);

		btnSave3.setBounds(688, 208, 300, 430);
		loadSave.add(btnSave3);

		try {
			bufferedImage = ImageIO.read(getImage("save_background.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image loadSavelImage = bufferedImage.getScaledInstance(1000, 770, Image.SCALE_DEFAULT);

		lblSave1 = new JLabel("");
		lblSave1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblSave1.setBounds(76, 171, 150, 25);

		try {
			bufferedImage = ImageIO.read(getImage("save_file_1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image save1Image = bufferedImage.getScaledInstance(150, 25, Image.SCALE_DEFAULT);
		lblSave1.setIcon(new ImageIcon(save1Image));

		loadSave.add(lblSave1);

		lblSave2 = new JLabel("");
		lblSave2.setFont(new Font("Dialog", Font.BOLD, 17));
		lblSave2.setBounds(432, 171, 150, 25);

		try {
			bufferedImage = ImageIO.read(getImage("save_file_2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image save2Image = bufferedImage.getScaledInstance(150, 25, Image.SCALE_DEFAULT);
		lblSave2.setIcon(new ImageIcon(save2Image));

		loadSave.add(lblSave2);

		lblSave3 = new JLabel("");
		lblSave3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblSave3.setBounds(766, 171, 150, 25);

		try {
			bufferedImage = ImageIO.read(getImage("save_file_3.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image save3Image = bufferedImage.getScaledInstance(150, 25, Image.SCALE_DEFAULT);
		lblSave3.setIcon(new ImageIcon(save3Image));

		loadSave.add(lblSave3);

		btnDeleteSave1 = new JButton("Delete Save");
		btnDeleteSave1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSaveFile("save1.toml");
				try {
					Game.getInstance().getSaveFile().deleteSave();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnSave1.setVisible(false);
				btnSave1.setEnabled(false);
				lblSave1.setVisible(false);
				btnDeleteSave1.setVisible(false);
				btnDeleteSave1.setEnabled(false);
			}
		});
		btnDeleteSave1.setBounds(89, 650, 105, 27);
		loadSave.add(btnDeleteSave1);

		btnDeleteSave2 = new JButton("Delete Save");
		btnDeleteSave2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSaveFile("save2.toml");
				try {
					Game.getInstance().getSaveFile().deleteSave();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnSave2.setVisible(false);
				btnSave2.setEnabled(false);
				lblSave2.setVisible(false);
				btnDeleteSave2.setVisible(false);
				btnDeleteSave2.setEnabled(false);
			}
		});
		btnDeleteSave2.setBounds(449, 650, 105, 27);
		loadSave.add(btnDeleteSave2);

		btnDeleteSave3 = new JButton("Delete Save");
		btnDeleteSave3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSaveFile("save3.toml");
				try {
					Game.getInstance().getSaveFile().deleteSave();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnSave3.setVisible(false);
				btnSave3.setEnabled(false);
				btnDeleteSave3.setVisible(false);
				btnDeleteSave3.setEnabled(false);
				lblSave3.setVisible(false);
			}
		});
		btnDeleteSave3.setBounds(795, 650, 105, 27);
		loadSave.add(btnDeleteSave3);

		JLabel loadSaveBackground = new JLabel("");
		loadSaveBackground.setBounds(0, 0, 1000, 768);
		loadSaveBackground.setIcon(new ImageIcon(loadSavelImage));

		loadSave.add(loadSaveBackground);
		loadSave.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { btnSave1, lblChooseASave, btnReturnToMain_1, btnSave2, btnSave3, loadSaveBackground,
						lblSave1, lblSave2, lblSave3, btnDeleteSave1, btnDeleteSave2, btnDeleteSave3 }));
		btnSave3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnSave3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startWindow = Game.getInstance().getConfigFile().getStartWindow();
				endWindow = Game.getInstance().getConfigFile().getEndWindow();
				if ((LocalTime.now().isAfter(endWindow) || LocalTime.now().isBefore(startWindow))
						&& Game.getInstance().getConfigFile().getTimeLimit()) {
					JOptionPane.showMessageDialog(loadSave, "Cant play at this time", "", JOptionPane.ERROR_MESSAGE);
				} else {
					Game.getInstance().setSaveFile("save3.toml");
					Game.getInstance().setCurrentPet(Game.getInstance().getSaveFile().getName(),
							Game.getInstance().getSaveFile(), Game.getInstance().getSaveFile().getPetType());
					viewScreen("LoadingScreen");
				}
			}
		});
		btnSave2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnSave2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startWindow = Game.getInstance().getConfigFile().getStartWindow();
				endWindow = Game.getInstance().getConfigFile().getEndWindow();
				if ((LocalTime.now().isAfter(endWindow) || LocalTime.now().isBefore(startWindow))
						&& Game.getInstance().getConfigFile().getTimeLimit()) {
					JOptionPane.showMessageDialog(loadSave, "Cant play at this time", "", JOptionPane.ERROR_MESSAGE);
				} else {
					Game.getInstance().setSaveFile("save2.toml");
					Game.getInstance().setCurrentPet(Game.getInstance().getSaveFile().getName(),
							Game.getInstance().getSaveFile(), Game.getInstance().getSaveFile().getPetType());
					viewScreen("LoadingScreen");
				}
			}
		});
		btnSave1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				startWindow = Game.getInstance().getConfigFile().getStartWindow();
				endWindow = Game.getInstance().getConfigFile().getEndWindow();
				if ((LocalTime.now().isAfter(endWindow) || LocalTime.now().isBefore(startWindow))
						&& Game.getInstance().getConfigFile().getTimeLimit()) {
					JOptionPane.showMessageDialog(loadSave, "Cant play at this time", "", JOptionPane.ERROR_MESSAGE);
				} else {
					Game.getInstance().setSaveFile("save1.toml");
					Game.getInstance().setCurrentPet(Game.getInstance().getSaveFile().getName(),
							Game.getInstance().getSaveFile(), Game.getInstance().getSaveFile().getPetType());
					viewScreen("LoadingScreen");
				}
			}
		});

		JPanel Instructions = new JPanel();
		Instructions.setBackground(new Color(192, 191, 188));
		cards.add(Instructions, "InstructionsPage");

		JLabel lblIntructions = new JLabel("Instructions");
		lblIntructions.setForeground(new Color(255, 255, 255));
		lblIntructions.setFont(new Font("Dialog", Font.BOLD, 25));
		lblIntructions.setBounds(154, 33, 201, 30);
		lblIntructions.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnReturn = new JButton("Return to main menu");
		btnReturn.setBounds(801, 6, 162, 27);
		btnReturn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewScreen("MainMenu");
			}
		});
		Instructions.setLayout(null);
		Instructions.add(btnReturn);
		Instructions.add(lblIntructions);

		JLabel lblControls = new JLabel("Controls");
		lblControls.setForeground(new Color(255, 255, 255));
		lblControls.setBounds(661, 32, 162, 33);
		lblControls.setFont(new Font("Dialog", Font.BOLD, 25));
		lblControls.setHorizontalAlignment(SwingConstants.CENTER);
		Instructions.add(lblControls);

		JTextPane txtIntructions = new JTextPane();
		txtIntructions.setBounds(37, 73, 495, 472);
		txtIntructions.setFont(new Font("Dialog", Font.BOLD, 10));
		txtIntructions.setEditable(false);
		txtIntructions.setText(
				"Welcome to Pet Simulator Universe! In this game, you’ll experience the joy of raising and bonding with your very own unique pet. Whether you're feeding, playing, or customizing your companion, every interaction brings you closer together. We’re so excited for you to begin your adventure!\n\nWhen you start the game, you’ll have the option to create multiple save files, allowing you to care for more than one pet at a time. Simply choose “New Save File” from the main menu, and your progress will be saved automatically. Each time you open the game, your pet will be there waiting for you—ready for another day of fun and care.\n\nYou’ll begin by choosing one of three pets: a ghost, a robot, or a dragon. Each pet has its own unique stats and personality, meaning they’ll react differently based on your actions and attention. No matter which one you choose, you’ll build a special bond that’s truly one of a kind.\n\nOnce your pet is selected, you’ll see several options available on-screen. Using your mouse, you can choose to feed your pet, play with them, give them gifts, take them to the vet, exercise with them, or help them fall asleep. Each activity affects your pet’s stats—health, fullness, sleepiness, and happiness—in different ways. If your pet’s health or fullness drops to zero, you can click the revive button to bring them back and continue the adventure.\n\nAs you play, you’ll unlock a variety of items you can give your pet. These items not only boost specific stats, but also add a touch of style to your pet’s appearance, making them truly your own. Items are earned by completing certain tasks throughout the game, encouraging exploration and continued care.\n\nTo save your progress, simply click the “Save” button located at the top right corner of the screen. After saving, you can exit the game at any time, knowing your pet will be waiting for you next time you return.\n\nWe hope you enjoy your time in Pet Simulator Universe. Whether you're raising a ghost, a robot, or a dragon, we know you’ll create something truly special. Happy bonding!");
		Instructions.add(txtIntructions);

		JTextPane txtControls = new JTextPane();
		txtControls.setBounds(569, 73, 394, 381);
		txtControls.setText(
				"Click with Mouse: Selecting a button \n\nShortcuts: \n\nSave = Ctrl + S\n\nExit = Ctrl + X\n\nInventory = Ctrl + I\n\nTake To Vet = Ctrl + T\n\nPlay = Ctrl + P\n\nGo To Bed = Ctrl + B\n\nFeed= Ctrl + F\n\nGive Gift = Ctrl + G\n\nExercise = Ctrl + E");
		txtControls.setEditable(false);
		Instructions.add(txtControls);
		
		JLabel label_1 = new JLabel("");
		
		try {
			bufferedImage = ImageIO.read(getImage("save_background.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image instrucionsImage = bufferedImage.getScaledInstance(10000, 770, Image.SCALE_DEFAULT);
		label_1.setIcon(new ImageIcon(instrucionsImage));
		
		label_1.setBounds(0, 0, 1000, 770);
		Instructions.add(label_1);
		Instructions.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnReturn, label_1}));

		JPanel PetSelect = new JPanel();
		frame.getContentPane().add(PetSelect, "PetSelect");

		JLabel lblChooseYourPet = new JLabel("Choose Your Pet");
		lblChooseYourPet.setForeground(new Color(255, 255, 255));
		lblChooseYourPet.setBackground(new Color(255, 255, 255));
		lblChooseYourPet.setBounds(375, 29, 181, 31);
		lblChooseYourPet.setFont(new Font("Dialog", Font.BOLD, 22));

		JButton btnDragon = new JButton("");
		btnDragon.setBounds(69, 85, 200, 175);
		btnDragon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		
		btnDragon.setContentAreaFilled(false);
		btnDragon.setBackground(new Color(255, 255, 255));
		try {
			bufferedImage = ImageIO.read(getImage("kirby_dragon_normal.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image dragonNormalImage = bufferedImage.getScaledInstance(250, 175, Image.SCALE_DEFAULT);
		btnDragon.setIcon(new ImageIcon(dragonNormalImage));
		btnDragon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblYouChose.setText("You Chose Dragon");
				type = "dragon";
				viewScreen("ConfirmPet");

			}
		});

		JButton btnGhost = new JButton("");
		btnGhost.setBounds(356, 85, 200, 175);
		btnGhost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnGhost.setContentAreaFilled(false);
		btnGhost.setBackground(new Color(255, 255, 255));
		try {
			bufferedImage = ImageIO.read(getImage("kirby_ghost_normal.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image ghostNormalImage = bufferedImage.getScaledInstance(200, 175, Image.SCALE_DEFAULT);
		btnGhost.setIcon(new ImageIcon(ghostNormalImage));
		btnGhost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblYouChose.setText("You Chose Ghost");
				type = "ghost";
				viewScreen("ConfirmPet");
			}
		});

		JButton btnRobot = new JButton("");
		btnRobot.setOpaque(false);
		btnRobot.setBounds(664, 85, 200, 175);
		btnRobot.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnRobot.setBackground(new Color(255, 255, 255));
		try {
			bufferedImage = ImageIO.read(getImage("kirby_robot_normal.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image robotNormalImage = bufferedImage.getScaledInstance(250, 175, Image.SCALE_DEFAULT);
		btnRobot.setIcon(new ImageIcon(robotNormalImage));
		btnRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblYouChose.setText("You Chose Robot");
				type = "robot";
				viewScreen("ConfirmPet");
			}
		});

		JTextPane txtrPet1 = new JTextPane();
		txtrPet1.setBounds(44, 293, 251, 210);
		txtrPet1.setText(
				"The Dragon - One of the most feared creatures across the land!\n\nThe dragon has a high maximum health value, which means it will be les at risk of its health to drop to 0. However, dragons eat a lot of food, so make sure that you feed it constantly! Overall, the dragon is a fierce but loyal pet, who will be by your side throughout your journey!");

		JTextPane txtrPet2 = new JTextPane();
		txtrPet2.setBounds(325, 282, 250, 296);
		txtrPet2.setText(
				"The Ghost – A pet full of mystery!\n\nThe ghost is a whimsical and gentle companion that floats through life with a calm and curious spirit. It adores receiving thoughtful gifts, often glowing faintly with joy when you surprise it with something special. With a naturally high sleep stat, the ghost loves to nap and drift into dreamy realms, recharging often throughout the day. But beware—this spectral friend gets hungry quickly and needs regular feeding to stay content. Mysterious yet lovable, the ghost is the perfect pet for those who enjoy quiet moments and magical surprises!");

		JTextPane txtrPet3 = new JTextPane();
		txtrPet3.setBounds(607, 282, 300, 197);
		txtrPet3.setText(
				"The Robot - A pet full of wonder!\n\nThe robot is an incredibly unique pet, as it's mouth changes colour when it gets angry, letting you know it needs some companionship! This robot loves to be played with, and always wants to make new friends! With it's high health and happiness levels, this pet is incredibly energetic and is always looking to have more fun!");

		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.setBounds(811, 0, 160, 27);
		btnReturnToMain.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewScreen("MainMenu");
			}
		});
		PetSelect.setLayout(null);
		PetSelect.add(btnDragon);
		PetSelect.add(txtrPet1);
		PetSelect.add(txtrPet2);
		PetSelect.add(txtrPet3);
		PetSelect.add(btnGhost);
		PetSelect.add(btnRobot);
		PetSelect.add(lblChooseYourPet);
		PetSelect.add(btnReturnToMain);
		
		JLabel label = new JLabel("");
		try {
			bufferedImage = ImageIO.read(getImage("save_background.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image selectImage = bufferedImage.getScaledInstance(1000, 770, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(selectImage));
		label.setBounds(0, -14, 1000, 804);
		PetSelect.add(label);
		PetSelect.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnReturnToMain, btnDragon, btnGhost, btnRobot, label}));

		JPanel OverwiteSave = new JPanel();
		frame.getContentPane().add(OverwiteSave, "overwrite");

		btnOverwrite1 = new JButton("");
		btnOverwrite1.setBounds(12, 226, 300, 430);
		btnOverwrite1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnOverwrite1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSaveFile("save1.toml");
				try {
					Game.getInstance().getSaveFile().resetSaveFile(type);
					Game.getInstance().setCurrentPet(txtFeildPetName.getText(), Game.getInstance().getSaveFile(), type);
					viewScreen("LoadingScreen");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnOverwrite2 = new JButton("");
		btnOverwrite2.setBounds(350, 226, 300, 430);
		btnOverwrite2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnOverwrite2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSaveFile("save2.toml");
				try {
					Game.getInstance().getSaveFile().resetSaveFile(type);
					Game.getInstance().setCurrentPet(txtFeildPetName.getText(), Game.getInstance().getSaveFile(), type);
					viewScreen("LoadingScreen");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnExitToMain_2 = new JButton("Exit to main menu");
		btnExitToMain_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewScreen("MainMenu");
			}
		});
		btnExitToMain_2.setBounds(850, 6, 144, 27);
		btnExitToMain_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		OverwiteSave.setLayout(null);

		lblOverwriteTitle = new JLabel("");
		lblOverwriteTitle.setBounds(264, 80, 500, 75);
		try {
			bufferedImage = ImageIO.read(getImage("overwrite_text.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image overwriteTextImage = bufferedImage.getScaledInstance(500, 75, Image.SCALE_SMOOTH);
		lblOverwriteTitle.setIcon(new ImageIcon(overwriteTextImage));
		OverwiteSave.add(lblOverwriteTitle);
		OverwiteSave.add(btnExitToMain_2);

		btnOverwrite3 = new JButton("");
		btnOverwrite3.setBounds(694, 226, 300, 430);
		btnOverwrite3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnOverwrite3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSaveFile("save3.toml");
				try {
					Game.getInstance().getSaveFile().resetSaveFile(type);
					Game.getInstance().setCurrentPet(txtFeildPetName.getText(), Game.getInstance().getSaveFile(), type);
					viewScreen("LoadingScreen");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		OverwiteSave.add(btnOverwrite3);
		OverwiteSave.add(btnOverwrite2);
		OverwiteSave.add(btnOverwrite1);

		try {
			bufferedImage = ImageIO.read(getImage("save_background.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image overwriteImage = bufferedImage.getScaledInstance(1000, 800, Image.SCALE_DEFAULT);

		lbloverwrite1 = new JLabel("");
		lbloverwrite1.setFont(new Font("Dialog", Font.BOLD, 17));
		lbloverwrite1.setBounds(71, 189, 150, 25);

		try {
			bufferedImage = ImageIO.read(getImage("save_file_1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image over1Image = bufferedImage.getScaledInstance(150, 25, Image.SCALE_DEFAULT);
		lbloverwrite1.setIcon(new ImageIcon(over1Image));

		OverwiteSave.add(lbloverwrite1);

		lbloverwrite2 = new JLabel("");
		lbloverwrite2.setFont(new Font("Dialog", Font.BOLD, 17));
		lbloverwrite2.setBounds(412, 189, 150, 25);

		try {
			bufferedImage = ImageIO.read(getImage("save_file_2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image overwrite2Image = bufferedImage.getScaledInstance(150, 25, Image.SCALE_DEFAULT);
		lbloverwrite2.setIcon(new ImageIcon(overwrite2Image));

		OverwiteSave.add(lbloverwrite2);

		lbloverwrite3 = new JLabel("");
		lbloverwrite3.setFont(new Font("Dialog", Font.BOLD, 17));
		lbloverwrite3.setBounds(787, 189, 150, 25);

		try {
			bufferedImage = ImageIO.read(getImage("save_file_3.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image overwrite3Image = bufferedImage.getScaledInstance(150, 25, Image.SCALE_DEFAULT);
		lbloverwrite3.setIcon(new ImageIcon(overwrite3Image));
		OverwiteSave.add(lbloverwrite3);

		JLabel OverwriteBackground = new JLabel("");
		OverwriteBackground.setBounds(0, -19, 1026, 817);
		OverwriteBackground.setIcon(new ImageIcon(overwriteImage));

		OverwiteSave.add(OverwriteBackground);

		OverwiteSave.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { btnExitToMain_2, btnOverwrite1,
				btnOverwrite2, btnOverwrite3, OverwriteBackground, lbloverwrite1, lbloverwrite2, lbloverwrite3 }));

		JPanel SavingScreen = new JPanel();
		frame.getContentPane().add(SavingScreen, "SaveScreen");

		JLabel lblPleaseDoNot = new JLabel("Please do not turn off computer");
		lblPleaseDoNot.setBackground(new Color(253, 228, 184));
		lblPleaseDoNot.setForeground(new Color(255, 255, 255));
		lblPleaseDoNot.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPleaseDoNot.setBounds(340, 410, 319, 28);
		SavingScreen.setLayout(null);

		JLabel lblSavingGame = new JLabel("Saving game ");
		lblSavingGame.setBackground(new Color(253, 228, 184));
		lblSavingGame.setForeground(new Color(255, 255, 255));
		lblSavingGame.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSavingGame.setBounds(433, 387, 133, 28);
		SavingScreen.add(lblSavingGame);
		SavingScreen.add(lblPleaseDoNot);

		saveProgress = new JProgressBar();
		saveProgress.setBounds(162, 451, 672, 14);
		SavingScreen.add(saveProgress);

		JLabel saveScreenBackground = new JLabel("");
		try {
			bufferedImage = ImageIO.read(getImage("save_screen.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image saveImage = bufferedImage.getScaledInstance(1000, 770, Image.SCALE_DEFAULT);
		saveScreenBackground.setIcon(new ImageIcon(saveImage));
		saveScreenBackground.setBounds(0, -13, 1000, 776);
		SavingScreen.add(saveScreenBackground);

		JPanel ConfirmPet = new JPanel();
		frame.getContentPane().add(ConfirmPet, "ConfirmPet");

		lblImage_1 = new JLabel("");
		lblImage_1.setBounds(275, 204, 450, 300);

		txtFeildPetName = new JTextField();
		txtFeildPetName.setBounds(312, 483, 376, 21);
		txtFeildPetName.setColumns(10);

		JButton btnReturnToPet = new JButton("Return to Pet Select");
		btnReturnToPet.setBounds(842, 6, 152, 27);
		btnReturnToPet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnReturnToPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewScreen("PetSelect");
			}
		});
		ConfirmPet.setLayout(null);
		ConfirmPet.add(btnReturnToPet);

		JLabel lblNameYourPet = new JLabel("Name Your Pet");
		lblNameYourPet.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNameYourPet.setForeground(new Color(255, 255, 255));
		lblNameYourPet.setBounds(425, 450, 150, 28);
		ConfirmPet.add(lblNameYourPet);
		ConfirmPet.add(txtFeildPetName);
		ConfirmPet.add(lblImage_1);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(458, 516, 83, 27);
		btnConfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtFeildPetName.getText().equals("")) {
					JOptionPane.showMessageDialog(PetSelect, "Please Enter A Name", "", JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						Game.getInstance().newSaveFile(txtFeildPetName.getText(), type);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		ConfirmPet.add(btnConfirm);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setOpaque(false);
		panel_2.setBounds(364, 12, 251, 69);
		ConfirmPet.add(panel_2);

		lblYouChose = new JLabel("You chose ____");
		lblYouChose.setLocation(423, 26);
		lblYouChose.setForeground(new Color(255, 255, 255));
		lblYouChose.setFont(new Font("Dialog", Font.BOLD, 22));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(50).addComponent(lblYouChose)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(26).addComponent(lblYouChose)));
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1000, 770);
		
		try {
			bufferedImage = ImageIO.read(getImage("confirm_pet_screen.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image confirmPetImage = bufferedImage.getScaledInstance(1000, 770, Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(confirmPetImage));
		
		ConfirmPet.add(lblNewLabel_2);
		ConfirmPet.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnReturnToPet, txtFeildPetName, btnConfirm, panel_2, lblNewLabel_2}));

		PetMenu = new JPanel();
		frame.getContentPane().add(PetMenu, "PetMenu");

		playAction = new AbstractAction() {

			public void actionPerformed(ActionEvent e) {
				Game.getInstance().getPlayer().play();
				Game.getInstance().getCurrentPet().score(50);
				btnPlay.setEnabled(false);
				coolDownTimerPlay = new Timer(1000, evt -> {
					if (tick == 300) {
						btnPlay.setEnabled(true);
						coolDownTimerPlay.stop();

					}
					tick++;
				});
				coolDownTimerPlay.start();

			}
		};
		feedAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> foodOptions = new ArrayList<String>();
				Map<String, Long> map = Game.getInstance().getCurrentPet().getInventoryMap();
				if (map.get("apple") > 0) {
					foodOptions.add("Apple");
				}
				if (map.get("applepie") > 0) {
					foodOptions.add("Apple Pie");
				}
				if (map.get("cake") > 0) {
					foodOptions.add("Cake");
				}
				Object[] foodArray = foodOptions.toArray();
				if (foodArray.length != 0) {
					int option = JOptionPane.showOptionDialog(PetMenu, "Select a food!!", "feed",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, foodArray, null);
					if (option == 0) {
						Game.getInstance().getPlayer().feedPet(new Food((String) foodArray[0]));
						Game.getInstance().getCurrentPet().removeInventoryItem(new Food((String) foodArray[0]));
					} else if (option == 1) {
						Game.getInstance().getPlayer().feedPet(new Food((String) foodArray[1]));
						Game.getInstance().getCurrentPet().removeInventoryItem(new Food((String) foodArray[1]));
					} else if (option == 2) {
						Game.getInstance().getPlayer().feedPet(new Food((String) foodArray[2]));
						Game.getInstance().getCurrentPet().removeInventoryItem(new Food((String) foodArray[2]));
					}
				} else {
					JOptionPane.showMessageDialog(PetMenu, "No Food Available", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		bedAction = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().getPlayer().goToBed();

			}
		};
		giftAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> giftOptions = new ArrayList<String>();
				Map<String, Long> map = Game.getInstance().getCurrentPet().getInventoryMap();
				if (map.get("ball") > 0) {
					giftOptions.add("ball");
				}
				if (map.get("teddy") > 0) {
					giftOptions.add("teddy");
				}
				if (map.get("fidgetspinner") > 0) {
					giftOptions.add("Fidget Spinner");
				}
				Object[] giftArray = giftOptions.toArray();
				if (giftArray.length != 0) {
					int option = JOptionPane.showOptionDialog(PetMenu, "Select a gift!!", "Give Gift",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, giftArray, null);
					if (option == 0) {
						Game.getInstance().getPlayer().giveGift(new Gift((String) giftArray[0]));
						Game.getInstance().getCurrentPet().removeInventoryItem(new Gift((String) giftArray[0]));
					} else if (option == 1) {
						Game.getInstance().getPlayer().giveGift(new Gift((String) giftArray[1]));
						Game.getInstance().getCurrentPet().removeInventoryItem(new Gift((String) giftArray[1]));
					} else if (option == 2) {
						Game.getInstance().getPlayer().giveGift(new Gift((String) giftArray[2]));
						Game.getInstance().getCurrentPet().removeInventoryItem(new Gift((String) giftArray[2]));
					}
				} else {
					JOptionPane.showMessageDialog(PetMenu, "No Gifts Available", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};
		vetAction = new AbstractAction() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().getCurrentPet().score(150);
				Game.getInstance().getPlayer().takePetToVet();
				btnTakeToVet.setEnabled(false);
				coolDownTimerVet = new Timer(1000, evt -> {
					if (tick == 300) {
						btnTakeToVet.setEnabled(true);
						coolDownTimerVet.stop();

					}
					tick++;
				});
				coolDownTimerVet.start();

			}
		};
		excersiceAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().getPlayer().exercise();
				Game.getInstance().getCurrentPet().score(100);
				btnExcercise.setEnabled(false);
				coolDownTimerExercise = new Timer(1000, evt -> {
					if (tick == 300) {
						btnExcercise.setEnabled(true);
						coolDownTimerExercise.stop();

					}
					tick++;
				});
				coolDownTimerExercise.start();
			}
		};

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(895, 0, 93, 33);

		btnViewInventory = new JButton("View Inventory");
		btnViewInventory.setBounds(368, 12, 125, 27);
		btnViewInventory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});

		inventoryAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (inventory.isVisible()) {
					inventory.setVisible(false);
				} else {
					inventory.setVisible(true);
				}
			}
		};

		JButton btnViewCostumes = new JButton("View Costumes");
		btnViewCostumes.setBounds(499, 12, 125, 27);
		btnViewCostumes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bufferedImage = ImageIO.read(getImage("durag.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Image duragImage = bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				durag.setIcon(new ImageIcon(duragImage));
				try {
					bufferedImage = ImageIO.read(getImage("eye_patch.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Image eyepatchImage = bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				eyepatch.setIcon(new ImageIcon(eyepatchImage));
				try {
					bufferedImage = ImageIO.read(getImage("top_hat.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Image tophatImage = bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				topHat.setIcon(new ImageIcon(tophatImage));
				if (costumes.isVisible()) {
					costumes.setVisible(false);
				} else {
					costumes.setVisible(true);
				}

			}
		});
		btnViewCostumes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		try {
			bufferedImage = ImageIO.read(getImage("Apple.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image appleImage = bufferedImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		try {
			bufferedImage = ImageIO.read(getImage("Pie.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image applePieImage = bufferedImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);

		try {
			bufferedImage = ImageIO.read(getImage("Cake.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image cakeImage = bufferedImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		try {
			bufferedImage = ImageIO.read(getImage("teddy.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image teddyImage = bufferedImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		try {
			bufferedImage = ImageIO.read(getImage("ball.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image ballImage = bufferedImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);

		try {
			bufferedImage = ImageIO.read(getImage("spinner.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image spinnerImage = bufferedImage.getScaledInstance(40, 40, Image.SCALE_DEFAULT);

		btnExit_1 = new JButton("Exit");
		btnExit_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		exitAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int save = JOptionPane.showConfirmDialog(PetMenu, "Are you sure want to save and exit", "Save and Exit",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (save == 0) {
					try {
						Game.getInstance().getConfigFile().calculateTotalTime();
						Game.getInstance().getConfigFile().calculateAverageTime();
						Game.getInstance().getSaveFile().updateSaveFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					inventory.setVisible(false);
					viewScreen("SaveScreen");
				}
			}
		};

		toolBar.add(btnExit_1);

		btnSave = new JButton("Save");
		btnSave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});

		saveAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				save = JOptionPane.showConfirmDialog(PetMenu, "Are you Sure you want to save", "Save Game",
						JOptionPane.YES_NO_OPTION);
				if (save == 0) {
					try {
						Game.getInstance().getSaveFile().updateSaveFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(PetMenu, "Game Saved", "Save Confirmation",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};

		toolBar.add(btnSave);

		costumes = new JPanel();
		costumes.setBounds(20, 174, 166, 342);
		costumes.setVisible(false);
		costumes.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panel = new JPanel();
		panel.setBounds(708, 241, 197, 219);
		panel.setLayout(new MigLayout("", "[63px,grow][66px,grow]", "[17px,grow][17px,grow][17px,grow][23px,grow]"));

		JLabel lblHealth = new JLabel("Health:");
		panel.add(lblHealth, "cell 0 0,alignx left,aligny top");

		lblHealthValue = new JLabel("0");
		panel.add(lblHealthValue, "cell 1 0,alignx left,aligny top");
		lblHealthValue.setText(Game.getInstance().getSaveFile().getHealth().toString());

		JLabel lblHunger = new JLabel("Fullness:");
		panel.add(lblHunger, "cell 0 1,alignx left,aligny top");

		lblFullnessValue = new JLabel("0");
		panel.add(lblFullnessValue, "cell 1 1,alignx left,aligny top");

		lblFullnessValue.setText(Game.getInstance().getSaveFile().getHunger().toString());

		JLabel lblHapiness = new JLabel("Happiness");
		panel.add(lblHapiness, "cell 0 2,alignx left,aligny top");

		lblHappinessValue = new JLabel("0");
		panel.add(lblHappinessValue, "cell 1 2,alignx left,aligny top");
		lblHappinessValue.setText(Game.getInstance().getSaveFile().getHappiness().toString());

		JLabel lblSleep = new JLabel("Sleep:");
		panel.add(lblSleep, "cell 0 3,alignx left,aligny top");

		lblSleepValue = new JLabel("0");
		panel.add(lblSleepValue, "cell 1 3,alignx left,aligny top");
		lblSleepValue.setText(Game.getInstance().getSaveFile().getSleep().toString());
		costumes.setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));

		durag = new JToggleButton("");
		durag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (durag.isSelected()) {
					Game.getInstance().getCurrentPet().getPetCosmetics().equip("durag");
					eyepatch.setSelected(false);
					topHat.setSelected(false);
				} else {
					Game.getInstance().getCurrentPet().getPetCosmetics().unequip("durag");
				}
			}
		});
		costumes.add(durag, "cell 0 0,grow");

		eyepatch = new JToggleButton("");
		eyepatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (eyepatch.isSelected()) {
					Game.getInstance().getCurrentPet().getPetCosmetics().equip("eyepatch");
					durag.setSelected(false);
					topHat.setSelected(false);
				} else {
					Game.getInstance().getCurrentPet().getPetCosmetics().unequip("eyepatch");
				}
			}
		});
		costumes.add(eyepatch, "cell 0 1,grow");

		topHat = new JToggleButton("");
		topHat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (topHat.isSelected()) {
					Game.getInstance().getCurrentPet().getPetCosmetics().equip("tophat");
					eyepatch.setSelected(false);
					durag.setSelected(false);
				} else {
					Game.getInstance().getCurrentPet().getPetCosmetics().unequip("tophat");
				}
			}
		});
		costumes.add(topHat, "cell 0 2,grow");
		PetMenu.setLayout(null);
		
				inventory = new JPanel();
				inventory.setBounds(213, 57, 692, 76);
				inventory.setVisible(false);
				inventory.setBorder(new LineBorder(new Color(0, 0, 0)));
				inventory.setLayout(new MigLayout("", "[grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][grow,fill]",
						"[17px,grow,fill][grow,fill]"));
				
						JLabel apple = new JLabel("");
						apple.setIcon(new ImageIcon(appleImage));
						inventory.add(apple, "cell 0 0,alignx left,aligny top");
						
								JLabel applePie = new JLabel("");
								inventory.add(applePie, "cell 1 0");
								applePie.setIcon(new ImageIcon(applePieImage));
								
										JLabel cake = new JLabel("");
										inventory.add(cake, "cell 2 0");
										cake.setIcon(new ImageIcon(cakeImage));
										
												JLabel teddy = new JLabel("");
												inventory.add(teddy, "cell 3 0");
												teddy.setIcon(new ImageIcon(teddyImage));
												
														JLabel ball = new JLabel("");
														inventory.add(ball, "cell 4 0");
														ball.setIcon(new ImageIcon(ballImage));
														JLabel lblSpinner_1 = new JLabel("");
														lblSpinner_1.setIcon(new ImageIcon(spinnerImage));
														
																inventory.add(lblSpinner_1, "cell 5 0");
																
																		appleCount = new JLabel("0");
																		// appleCount.setText(Game.getInstance().getCurrentPet().getInventoryCount("apple").toString());
																		inventory.add(appleCount, "cell 0 1,alignx center,aligny top");
																		
																				pieCount = new JLabel("0");
																				inventory.add(pieCount, "cell 1 1");
																				
																						cakeCount = new JLabel("0");
																						inventory.add(cakeCount, "cell 2 1");
																						
																								teddyCount = new JLabel("0");
																								inventory.add(teddyCount, "cell 3 1");
																								
																										ballCount = new JLabel("0");
																										inventory.add(ballCount, "cell 4 1");
																										
																												spinnerCount = new JLabel("0");
																												inventory.add(spinnerCount, "cell 5 1");
																												PetMenu.add(inventory);
																												PetMenu.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{toolBar, btnExit_1, btnSave, btnViewInventory, btnViewCostumes, btnTakeToVet, btnPlay, btnGoToBed, btnFeed, btnGiveGift, btnExcercise, lblSpinner_1, costumes, durag, eyepatch, topHat, panel, panel_1, panel_3, panel_4, mainbackground}));
		PetMenu.add(panel);
		PetMenu.add(btnViewInventory);
		PetMenu.add(btnViewCostumes);
		PetMenu.add(toolBar);
		PetMenu.add(costumes);

		lblPet = new JLabel("");
		lblPet.setBounds(228, 216, 450, 300);
		PetMenu.add(lblPet);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(213, 509, 531, 49);
		PetMenu.add(panel_1);
		panel_1.setLayout(
				new MigLayout("", "[99px,grow][60px,grow][91px,grow][63px,grow][87px,grow][89px,grow]", "[27px]"));

		btnTakeToVet = new JButton("Take to vet");
		panel_1.add(btnTakeToVet, "cell 0 0,growx,aligny top");

		btnPlay = new JButton("Play");
		panel_1.add(btnPlay, "cell 1 0,growx,aligny top");

		btnGoToBed = new JButton("Go to bed");
		panel_1.add(btnGoToBed, "cell 2 0,growx,aligny top");

		btnFeed = new JButton("Feed");
		panel_1.add(btnFeed, "cell 3 0,growx,aligny top");

		btnGiveGift = new JButton("Give Gift");
		panel_1.add(btnGiveGift, "cell 4 0,growx,aligny top");

		btnExcercise = new JButton("Excercise");
		panel_1.add(btnExcercise, "cell 5 0,growx,aligny top");

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBounds(20, 12, 188, 49);
		PetMenu.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[75px,grow][14px,grow,fill]", "[35px]"));

		JLabel lblScore = new JLabel("Score:");
		lblScore.setForeground(new Color(255, 255, 255));
		panel_3.add(lblScore, "cell 0 0,alignx left,aligny top");
		lblScore.setFont(new Font("Dialog", Font.BOLD, 25));
		
				lblScoreNum = new JLabel("0");
				panel_3.add(lblScoreNum, "cell 1 0,growx");
				lblScoreNum.setForeground(new Color(255, 255, 255));
				
						lblScoreNum.setText(Game.getInstance().getSaveFile().getScore().toString());
						
								lblScoreNum.setFont(new Font("Dialog", Font.BOLD, 25));
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBounds(412, 211, 242, 33);
		PetMenu.add(panel_4);
				panel_4.setLayout(new MigLayout("", "[223px,grow]", "[28px]"));
		
				lblName = new JLabel("name");
				lblName.setOpaque(false);
				lblName.setForeground(new Color(94, 92, 100));
				panel_4.add(lblName, "cell 0 0,growx,aligny top");
				lblName.setFont(new Font("Dialog", Font.BOLD, 20));
				lblName.setText("");
				
				JLabel mainbackground = new JLabel("");
				
				try {
					bufferedImage = ImageIO.read(getImage("pet_menu_background.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Image mainImage = bufferedImage.getScaledInstance(1000, 770, Image.SCALE_DEFAULT);
				mainbackground.setIcon(new ImageIcon(mainImage));
				
				
				mainbackground.setBounds(0, 0, 1000, 770);
				PetMenu.add(mainbackground);
		btnExcercise.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnGiveGift.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnFeed.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnGoToBed.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnPlay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnTakeToVet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		JPanel Password = new JPanel();
		Password.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(Password, "password");
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(454, 441, 66, 27);
		btnEnter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		JLabel lblPassMessage = new JLabel("");
		lblPassMessage.setBounds(487, 439, 0, 0);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(passwordField.getPassword())
						.equals(Game.getInstance().getConfigFile().getPassword())) {
					try {
						Game.getInstance().getConfigFile().calculateTotalTime();
						Game.getInstance().getConfigFile().calculateAverageTime();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblTotalHours.setText(Game.getInstance().getConfigFile().getTotalTime());
					avgPlayTime.setText(Game.getInstance().getConfigFile().getAverageTime());
					
					Game.getInstance().setSaveFile("save1.toml");
					btnSave1Revive.setText(Game.getInstance().getSaveFile().getName());
					if (Game.getInstance().getConfigFile().getSaveStatus("save1")
							&& Game.getInstance().getSaveFile().getState().equals("dead")) {
						btnSave1Revive.setVisible(true);
						btnSave1Revive.setEnabled(true);
					} else {
						btnSave1Revive.setVisible(false);
						btnSave1Revive.setEnabled(false);
					}
					Game.getInstance().setSaveFile("save2.toml");
					btnReviveSave2.setText(Game.getInstance().getSaveFile().getName());
					if (Game.getInstance().getConfigFile().getSaveStatus("save2")
							&& Game.getInstance().getSaveFile().getState().equals("dead")) {
						btnReviveSave2.setVisible(true);
						btnReviveSave2.setEnabled(true);
					} else {
						btnReviveSave2.setVisible(false);
						btnReviveSave2.setEnabled(false);
					}
					Game.getInstance().setSaveFile("save3.toml");
					btnReviveSave3.setText(Game.getInstance().getSaveFile().getName());
					if (Game.getInstance().getConfigFile().getSaveStatus("save3")
							&& Game.getInstance().getSaveFile().getState().equals("dead")) {
						btnReviveSave3.setVisible(true);
						btnReviveSave3.setEnabled(true);
					} else {
						btnReviveSave3.setVisible(false);
						btnReviveSave3.setEnabled(false);
					}
					viewScreen("ParentalControls");
				} else {
					lblPassMessage.setText("Incorrect Password");
				}
			}
		});

		JButton btnExitToMain_1 = new JButton("Exit to main menu");
		btnExitToMain_1.setBounds(850, 6, 144, 27);
		btnExitToMain_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnExitToMain_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewScreen("MainMenu");
			}
		});
		Password.setLayout(null);
		Password.add(btnExitToMain_1);

		JLabel lblEnterDigit = new JLabel("Enter password to access Parental Controls");
		lblEnterDigit.setForeground(new Color(255, 255, 255));
		lblEnterDigit.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEnterDigit.setBounds(272, 381, 430, 28);
		Password.add(lblEnterDigit);

		passwordField = new JPasswordField();
		passwordField.setBounds(212, 414, 550, 21);
		Password.add(passwordField);
		Password.add(btnEnter);

		Password.add(lblPassMessage);

		JLabel passwordBackground = new JLabel("");
		try {
			bufferedImage = ImageIO.read(getImage("password_screen.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image passwordImage = bufferedImage.getScaledInstance(1000, 770, Image.SCALE_DEFAULT);
		passwordBackground.setIcon(new ImageIcon(passwordImage));
		passwordBackground.setBounds(0, 0, 1000, 775);
		Password.add(passwordBackground);
		Password.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { btnExitToMain_1, passwordField, btnEnter, passwordBackground }));

		JPanel ParentalControls = new JPanel();
		frame.getContentPane().add(ParentalControls, "ParentalControls");

		JButton btnExitToMain = new JButton("Exit to Main Menu");
		btnExitToMain.setBounds(820, 0, 180, 23);
		btnExitToMain.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnExitToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewScreen("MainMenu");
			}
		});

		JLabel lblNewLabel = new JLabel("Parental Controls");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(391, 0, 218, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel Stats = new JPanel();
		Stats.setBounds(33, 56, 421, 478);
		Stats.setBackground(new Color(253, 228, 184));
		Stats.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Controls",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));

		JPanel controls = new JPanel();
		controls.setBounds(493, 56, 459, 216);
		controls.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Player Stats",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		controls.setBackground(new Color(253, 228, 184));

		JLabel parentalControlsBackground = new JLabel("");
		parentalControlsBackground.setBackground(new Color(255, 255, 255));
		try {
			bufferedImage = ImageIO.read(getImage("password_screen.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image parentalImage = bufferedImage.getScaledInstance(1000, 770, Image.SCALE_DEFAULT);
		parentalControlsBackground.setIcon(new ImageIcon(parentalImage));
		parentalControlsBackground.setBounds(0, 0, 1000, 770);

		JButton btnSetNewPassword = new JButton("Set New Password");
		btnSetNewPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnSetNewPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Game.getInstance().getParent().setPassword(txtFeildPassword.getText());
					txtFeildPassword.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					txtFeildPassword.setText("Please Enter a password");
				}
			}
		});

		txtFeildPassword = new JTextField();
		txtFeildPassword.setColumns(10);

		JLabel lblSetTimeLimits = new JLabel("Set Time Limits");

		JToggleButton tglbtnEnable = new JToggleButton("Enable");
		tglbtnEnable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		if (Game.getInstance().getConfigFile().getTimeLimit()) {
			tglbtnEnable.setSelected(true);
			tglbtnEnable.setText("Disable");
		} else {
			tglbtnEnable.setSelected(false);
			tglbtnEnable.setText("Enable");
		}
		tglbtnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnEnable.isSelected()) {
					try {
						Game.getInstance().getConfigFile().setTimeLimit(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tglbtnEnable.setText("Disable");
				} else {
					try {
						Game.getInstance().getConfigFile().setTimeLimit(false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tglbtnEnable.setText("Enable");
				}
			}
		});

		JLabel lblSetNewParental = new JLabel("Set new parental password");

		JLabel lblRevivePet = new JLabel("Revive Pet");

		btnSave1Revive.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnSave1Revive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSaveFile("save1.toml");
				try {
					Game.getInstance().getSaveFile().revivePet();
					btnSave1Revive.setVisible(false);
					btnSave1Revive.setEnabled(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnReviveSave2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnReviveSave2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSaveFile("save2.toml");
				try {
					Game.getInstance().getSaveFile().revivePet();
					btnReviveSave2.setVisible(false);
					btnReviveSave2.setEnabled(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnReviveSave3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		
		btnReviveSave3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.getInstance().setSaveFile("save3.toml");
				try {
					Game.getInstance().getSaveFile().revivePet();
					btnReviveSave3.setVisible(false);
					btnReviveSave3.setEnabled(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JLabel lblStartTime = new JLabel("Start Time:");

		JLabel lblEndTime = new JLabel("End Time:");

		try {
			MaskFormatter mask = new MaskFormatter("##:##");
			mask.setPlaceholderCharacter('_');
			mask.setValidCharacters("0123456789");
			startTimeWindow = new JFormattedTextField(mask);
			startTimeWindow.setColumns(5);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			MaskFormatter mask = new MaskFormatter("##:##");
			mask.setPlaceholderCharacter('_');
			mask.setValidCharacters("0123456789");
			endTimeWindow = new JFormattedTextField(mask);
			endTimeWindow.setColumns(5);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JButton btnSetLimits = new JButton("Set Limits");
		btnSetLimits.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JButton) e.getSource()).doClick();
				}
			}
		});
		btnSetLimits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Game.getInstance().getConfigFile().setTimeLimits(startTimeWindow.getText(),
							endTimeWindow.getText());
					startTimeWindow.setText("");
					endTimeWindow.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		GroupLayout gl_Stats = new GroupLayout(Stats);
		gl_Stats.setHorizontalGroup(gl_Stats.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Stats.createSequentialGroup().addGroup(gl_Stats.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Stats.createSequentialGroup().addContainerGap().addComponent(lblSetTimeLimits))
						.addGroup(gl_Stats.createSequentialGroup().addContainerGap().addComponent(lblRevivePet))
						.addGroup(gl_Stats.createSequentialGroup().addContainerGap().addComponent(btnSave1Revive))
						.addGroup(gl_Stats.createSequentialGroup().addContainerGap().addComponent(btnReviveSave2))
						.addGroup(gl_Stats.createSequentialGroup().addContainerGap().addComponent(btnReviveSave3))
						.addGroup(gl_Stats.createSequentialGroup().addContainerGap().addComponent(lblEndTime)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(endTimeWindow,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Stats.createSequentialGroup().addContainerGap()
								.addGroup(gl_Stats.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Stats.createSequentialGroup().addComponent(lblStartTime).addGap(12)
												.addComponent(startTimeWindow, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(tglbtnEnable)))
						.addGroup(gl_Stats.createSequentialGroup().addContainerGap().addGroup(gl_Stats
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Stats.createSequentialGroup()
										.addComponent(txtFeildPassword, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnSetNewPassword))
								.addGroup(
										gl_Stats.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 2,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSetNewParental))))
						.addGroup(gl_Stats.createSequentialGroup().addContainerGap().addComponent(btnSetLimits)))
						.addContainerGap(35, Short.MAX_VALUE)));
		gl_Stats.setVerticalGroup(gl_Stats.createParallelGroup(Alignment.LEADING).addGroup(gl_Stats
				.createSequentialGroup().addGap(36).addComponent(lblSetTimeLimits)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(tglbtnEnable)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_Stats.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Stats.createSequentialGroup().addComponent(lblStartTime).addGap(9)
								.addGroup(gl_Stats.createParallelGroup(Alignment.BASELINE).addComponent(lblEndTime)
										.addComponent(endTimeWindow, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(startTimeWindow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSetLimits).addGap(7)
				.addComponent(lblSetNewParental).addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_Stats.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtFeildPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSetNewPassword))
				.addGap(18).addComponent(lblRevivePet).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnSave1Revive).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnReviveSave2)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnReviveSave3)
				.addContainerGap(60, Short.MAX_VALUE)));
		Stats.setLayout(gl_Stats);

		JLabel lblTotalHoursPlayed = new JLabel("Total Time Played:");

		JLabel lblAveragePlayTime = new JLabel("Average Play Time:");

		JButton resetTotalTime = new JButton("Reset");
		resetTotalTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Game.getInstance().getConfigFile().resetTime();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblTotalHours.setText(Game.getInstance().getConfigFile().getTotalTime());
				avgPlayTime.setText(Game.getInstance().getConfigFile().getAverageTime());
			}
		});

		GroupLayout gl_controls = new GroupLayout(controls);
		gl_controls.setHorizontalGroup(gl_controls.createParallelGroup(Alignment.LEADING).addGroup(gl_controls
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_controls.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_controls.createSequentialGroup().addComponent(lblTotalHoursPlayed)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblTotalHours, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE).addGap(79))
						.addGroup(gl_controls.createSequentialGroup().addComponent(lblAveragePlayTime)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(avgPlayTime, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE).addGap(79))
						.addComponent(resetTotalTime))
				.addContainerGap()));
		gl_controls
				.setVerticalGroup(
						gl_controls.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_controls.createSequentialGroup().addContainerGap()
										.addGroup(gl_controls.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTotalHoursPlayed).addComponent(lblTotalHours))
										.addGap(23)
										.addGroup(gl_controls.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblAveragePlayTime).addComponent(avgPlayTime))
										.addGap(18).addComponent(resetTotalTime).addContainerGap(67, Short.MAX_VALUE)));
		controls.setLayout(gl_controls);
		ParentalControls.setLayout(null);
		ParentalControls.add(lblNewLabel);
		ParentalControls.add(btnExitToMain);
		ParentalControls.add(Stats);
		ParentalControls.add(controls);
		ParentalControls.add(parentalControlsBackground);
		ParentalControls.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { btnExitToMain, tglbtnEnable, lblStartTime, lblEndTime,
						startTimeWindow, endTimeWindow, btnSetLimits, txtFeildPassword, btnSetNewPassword,
						btnSave1Revive, btnReviveSave2, btnReviveSave3, parentalControlsBackground, resetTotalTime }));
	}

	public void viewScreen(String screenID) {
		System.out.println(screenID);
		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, screenID);
		currentScreen = screenID;
		if (currentScreen.equals("PetMenu")) {
			Game.getInstance().startTimer();
			setupShortcuts();
		} else {
			Game.getInstance().endTimer();
		}
		if (currentScreen.equals("LoadingScreen")) {
			Game.getInstance().getCurrentPet().getStats(Game.getInstance().getSaveFile());
			Game.getInstance().startProgress();
		}
		if (currentScreen.equals("ConfirmPet")) {
			updatePetImage();
		}
		if (currentScreen.equals("overwrite")) {
			loadSaveImages();
		}

	}

	public String getScreen() {
		return currentScreen;
	}

	public void updateScreen() {
		lblHealthValue.setText(Game.getInstance().getCurrentPet().getHealth().toString());
		lblFullnessValue.setText(Game.getInstance().getCurrentPet().getFullness().toString());
		lblHappinessValue.setText(Game.getInstance().getCurrentPet().getHappiness().toString());
		lblSleepValue.setText(Game.getInstance().getCurrentPet().getSleep().toString());
		lblScoreNum.setText(Game.getInstance().getCurrentPet().getScore().toString());
		lblName.setText(Game.getInstance().getCurrentPet().getName());
		appleCount.setText(Game.getInstance().getCurrentPet().getInventoryCount("apple").toString());
		cakeCount.setText(Game.getInstance().getCurrentPet().getInventoryCount("cake").toString());
		pieCount.setText(Game.getInstance().getCurrentPet().getInventoryCount("applePie").toString());
		teddyCount.setText(Game.getInstance().getCurrentPet().getInventoryCount("teddy").toString());
		ballCount.setText(Game.getInstance().getCurrentPet().getInventoryCount("ball").toString());
		spinnerCount.setText(Game.getInstance().getCurrentPet().getInventoryCount("fidgetSpinner").toString());

		if (Game.getInstance().getCurrentPet().getHealth() < Game.getInstance().getCurrentPet().getMaxHealth() / 4
				&& !healthFlag) {
			JOptionPane.showMessageDialog(PetMenu, "WARNING HEALTH LOW", "WARNING", JOptionPane.WARNING_MESSAGE);
			healthFlag = true;
		} else if (Game.getInstance().getCurrentPet().getHealth() >= Game.getInstance().getCurrentPet().getMaxHealth()
				/ 4) {
			healthFlag = false;
		}

		if (Game.getInstance().getCurrentPet().getFullness() < Game.getInstance().getCurrentPet().getMaxFullness() / 4
				&& !hungerFlag) {
			JOptionPane.showMessageDialog(PetMenu, "WARNING PET HUNGRY", "WARNING", JOptionPane.WARNING_MESSAGE);
			hungerFlag = true;
		} else if (Game.getInstance().getCurrentPet()
				.getFullness() >= Game.getInstance().getCurrentPet().getMaxFullness() / 4) {
			hungerFlag = false;
		}

		if (Game.getInstance().getCurrentPet().getHappiness() < Game.getInstance().getCurrentPet().getMaxHappiness() / 4
				&& !angryFlag) {
			JOptionPane.showMessageDialog(PetMenu, "WARNING PET ANGRY", "WARNING", JOptionPane.WARNING_MESSAGE);
			angryFlag = true;
		} else if (Game.getInstance().getCurrentPet()
				.getHappiness() >= Game.getInstance().getCurrentPet().getMaxHappiness() / 4) {
			angryFlag = false;
		}

		if (Game.getInstance().getCurrentPet().getSleep() < Game.getInstance().getCurrentPet().getMaxSleep() / 4
				&& !sleepFlag) {
			JOptionPane.showMessageDialog(PetMenu, "WARNING PET TIRED", "WARNING", JOptionPane.WARNING_MESSAGE);
			sleepFlag = true;
		} else if (Game.getInstance().getCurrentPet().getSleep() >= Game.getInstance().getCurrentPet().getMaxSleep()
				/ 4) {
			sleepFlag = false;
		}

		
		if (Game.getInstance().getCurrentPet().getState().equals("sleeping")) {
			loadPetImage("sleeping");
			btnExcercise.setEnabled(false);
			btnFeed.setEnabled(false);
			btnGiveGift.setEnabled(false);
			btnGoToBed.setEnabled(false);
			btnPlay.setEnabled(false);
			btnTakeToVet.setEnabled(false);

		} else if (Game.getInstance().getCurrentPet().getState().equals("angry")) {
			loadPetImage("angry");
			btnExcercise.setEnabled(false);
			btnFeed.setEnabled(false);
			btnGoToBed.setEnabled(false);
			btnTakeToVet.setEnabled(false);
		} else if (Game.getInstance().getCurrentPet().getState().equals("hungry")) {
			loadPetImage("hungry");
			if (!coolDownTimerVet.isRunning()) {
				if (Game.getInstance().getCurrentPet().getHealth() == Game.getInstance().getCurrentPet()
						.getMaxHealth()) {
					btnTakeToVet.setEnabled(false);
				} else {
					btnTakeToVet.setEnabled(true);
				}
			}

		} else if (Game.getInstance().getCurrentPet().getState().equals("dead")) {
			loadPetImage("dead");
			btnExcercise.setEnabled(false);
			btnFeed.setEnabled(false);
			btnGiveGift.setEnabled(false);
			btnGoToBed.setEnabled(false);
			btnPlay.setEnabled(false);
			btnTakeToVet.setEnabled(false);
			if (currentScreen.equals("PetMenu")) {
				Game.getInstance().endTimer();
				JOptionPane.showMessageDialog(PetMenu, "Pet Has Died", "", JOptionPane.WARNING_MESSAGE);
				viewScreen("MainMenu");
			}
			try {
				Game.getInstance().getSaveFile().updateSaveFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else {
			loadPetImage("normal");
			if (!coolDownTimerVet.isRunning()) {
				if (Game.getInstance().getCurrentPet().getHealth() == Game.getInstance().getCurrentPet()
						.getMaxHealth()) {
					btnTakeToVet.setEnabled(false);
				} else {
					btnTakeToVet.setEnabled(true);
				}
			}
			if (!coolDownTimerExercise.isRunning()) {
				btnExcercise.setEnabled(true);
			}
			if (!coolDownTimerPlay.isRunning()) {
				btnPlay.setEnabled(true);
			}
			btnFeed.setEnabled(true);
			btnGiveGift.setEnabled(true);
			btnGoToBed.setEnabled(true);
		}
	}

	public void setFlipped(int tick) {
		if (tick % 15 == 0) {
			isFlipped = !isFlipped;
		}

	}

	public void checkTimelimit() throws IOException {
		if (currentScreen.equals("PetMenu")) {
			if ((LocalTime.now().isAfter(endWindow) || LocalTime.now().isBefore(startWindow))
					&& Game.getInstance().getConfigFile().getTimeLimit()) {
				JOptionPane.showMessageDialog(PetMenu, "Game Time is over", "", JOptionPane.ERROR_MESSAGE);
				Game.getInstance().getSaveFile().updateSaveFile();
				viewScreen("MainMenu");
			}
		}
	}

	private void setupShortcuts() {
		// Play
		InputMap inputMap = btnPlay.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = btnPlay.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK), "playAction");
		actionMap.put("playAction", playAction);
		btnPlay.addActionListener(playAction);

		// Feed
		inputMap = btnFeed.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = btnFeed.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK), "feedAction");
		actionMap.put("feedAction", feedAction);
		btnFeed.addActionListener(feedAction);

		// Bed
		inputMap = btnGoToBed.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = btnGoToBed.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK), "bedAction");
		actionMap.put("bedAction", bedAction);
		btnGoToBed.addActionListener(bedAction);

		// Gift
		inputMap = btnGiveGift.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = btnGiveGift.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK), "giftAction");
		actionMap.put("giftAction", giftAction);
		btnGiveGift.addActionListener(giftAction);

		// Vet
		inputMap = btnTakeToVet.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = btnTakeToVet.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK), "vetAction");
		actionMap.put("vetAction", vetAction);
		btnTakeToVet.addActionListener(vetAction);

		// Exercise
		inputMap = btnExcercise.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = btnExcercise.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK), "exerciseAction");
		actionMap.put("exerciseAction", excersiceAction);
		btnExcercise.addActionListener(excersiceAction);

		// Inventory
		inputMap = btnViewInventory.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = btnViewInventory.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK), "inventoryAction");
		actionMap.put("inventoryAction", inventoryAction); // Fixed typo
		btnViewInventory.addActionListener(inventoryAction);

		// Exit
		inputMap = btnExit_1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = btnExit_1.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK), "exitAction");
		actionMap.put("exitAction", exitAction);
		btnExit_1.addActionListener(exitAction);

		// Save
		inputMap = btnSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		actionMap = btnSave.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), "saveAction");
		actionMap.put("saveAction", saveAction);
		btnSave.addActionListener(saveAction);
	}

	private void loadSaveImages() {

		try {
			Game.getInstance().setSaveFile("save1.toml");
			bufferedImage = ImageIO.read(getImage(Game.getInstance().getSaveFile().getPetType() + "_save_file.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image save1Image = bufferedImage.getScaledInstance(300, 430, Image.SCALE_DEFAULT);
		btnOverwrite1.setIcon(new ImageIcon(save1Image));

		try {
			Game.getInstance().setSaveFile("save2.toml");
			bufferedImage = ImageIO.read(getImage(Game.getInstance().getSaveFile().getPetType() + "_save_file.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image save2Image = bufferedImage.getScaledInstance(300, 430, Image.SCALE_DEFAULT);
		btnOverwrite2.setIcon(new ImageIcon(save2Image));

		try {
			Game.getInstance().setSaveFile("save3.toml");
			bufferedImage = ImageIO.read(getImage(Game.getInstance().getSaveFile().getPetType() + "_save_file.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image save3Image = bufferedImage.getScaledInstance(300, 430, Image.SCALE_DEFAULT);
		btnOverwrite3.setIcon(new ImageIcon(save3Image));

	}

	public InputStream getImage(String filePath) {
		InputStream is = getClass().getResourceAsStream("/assets/" + filePath);
		return is;
	}

	public void loadPetImage(String state) {
		if (currentScreen.equals("PetMenu")) {
			try {
				if (Game.getInstance().getCurrentPet().getPetCosmetics().isEquipped("durag")) {
					bufferedImage = ImageIO.read(
							getImage(state + Game.getInstance().getCurrentPet().getType() + "_" + "durag" + ".png"));

				} else if (Game.getInstance().getCurrentPet().getPetCosmetics().isEquipped("eyepatch")) {
					bufferedImage = ImageIO.read(
							getImage(state + Game.getInstance().getCurrentPet().getType() + "_" + "eyepatch" + ".png"));

				} else if (Game.getInstance().getCurrentPet().getPetCosmetics().isEquipped("tophat")) {
					bufferedImage = ImageIO.read(
							getImage(state + Game.getInstance().getCurrentPet().getType() + "_" + "tophat" + ".png"));

				} else {
					bufferedImage = ImageIO.read(
							getImage("kirby_" + Game.getInstance().getCurrentPet().getType() + "_" + state + ".png"));

				}
				if (isFlipped) {
					Image image = flip(bufferedImage).getScaledInstance(450, 300, Image.SCALE_SMOOTH);
					lblPet.setIcon(new ImageIcon(image));
				} else {
					Image image = bufferedImage.getScaledInstance(450, 300, Image.SCALE_SMOOTH);
					lblPet.setIcon(new ImageIcon(image));
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void updatePetImage() {
		if (currentScreen.equals("ConfirmPet")) {
			try {
				bufferedImage = ImageIO.read(getImage("kirby_" + type + "_normal.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Image image = bufferedImage.getScaledInstance(450, 300, Image.SCALE_DEFAULT);
			lblImage_1.setIcon(new ImageIcon(image));
		}
	}

	public void updateProgressBar() {
		if (currentScreen.equals("SaveScreen")) {
			saveProgress.setValue(saveProgress.getValue() + 1);
			if (saveProgress.getValue() == 100) {
				viewScreen("MainMenu");
				saveProgress.setValue(0);
			}
		} else if (currentScreen.equals("LoadingScreen")) {
			progressBar.setValue(progressBar.getValue() + 1);
			if (progressBar.getValue() == 100) {
				viewScreen("PetMenu");
				progressBar.setValue(0);
			}
		}
	}

	public static BufferedImage flip(BufferedImage image) {
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		BufferedImage flipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				flipped.setRGB((width - 1) - x, y, image.getRGB(x, y));
			}
		}

		return flipped;
	}
}
