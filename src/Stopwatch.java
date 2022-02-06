import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Stopwatch implements ActionListener {
	private final int SCREEN_WIDTH = 270; 
	private final int SCREEN_HEIGHT = 170;
	private final int TIMER_DELAY = 100;
	
	private JFrame frame;
	
	private JLabel timeLabel;
	
	private JButton startStopButton; 
	private JButton resetButton;
	
	private Timer timer;
	
	Stopwatch(){
		Font font = new Font("Monospace", Font.PLAIN, 20);
		
		frame = new JFrame();
		frame.setTitle("Stopwatch");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		
		int xMargin = (SCREEN_WIDTH - 200)/2;
		int yMargin = (SCREEN_HEIGHT - 150)/2;
		timeLabel = new JLabel();
		timeLabel.setText("00:00:00:00");
		timeLabel.setBounds(0 + xMargin, 0 + yMargin, 200, 50);
		timeLabel.setFont(font);
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		frame.add(timeLabel);
		
		startStopButton = new JButton("Start");
		startStopButton.setFocusable(false);
		startStopButton.setBounds(0 + xMargin, 50 + yMargin, 100, 50);
		startStopButton.setFont(font);
		frame.add(startStopButton);

		resetButton = new JButton("Reset");
		resetButton.setFocusable(false);
		resetButton.setBounds(100 + xMargin, 50 + yMargin, 100, 50);
		resetButton.setFont(font);
		frame.add(resetButton);
		
		timer = new Timer(TIMER_DELAY, this);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
