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
	private final int TIMER_DELAY = 10;
	
	private boolean running;  //if the timer is on or not
	private long elapsedTimeMillis; // total elapsed time in milliseconds
	
	private JFrame frame;
	
	private JLabel timeLabel; //displays elapsed time
	
	private JButton startStopButton; 
	private JButton resetButton;
	
	private Timer timer;
	
	Stopwatch(){
		Font font = new Font("Monospace", Font.PLAIN, 20);
		running = false;
		elapsedTimeMillis = 0; 
		
		//setting up the frame
		frame = new JFrame();
		frame.setTitle("Stopwatch");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		
		//calculating margins 
		int xMargin = (SCREEN_WIDTH - 200)/2;
		int yMargin = (SCREEN_HEIGHT - 150)/2;
		
		//setting up time display label
		timeLabel = new JLabel();
		timeLabel.setText("00:00:00:00");
		timeLabel.setBounds(0 + xMargin, 0 + yMargin, 200, 50);
		timeLabel.setFont(font);
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		frame.add(timeLabel);
		
		//setting up start/stop timer button
		startStopButton = new JButton("Start");
		startStopButton.setFocusable(false);
		startStopButton.setBounds(0 + xMargin, 50 + yMargin, 100, 50);
		startStopButton.setFont(font);
		startStopButton.addActionListener(this::stop);
		frame.add(startStopButton);

		//setting up reset timer button
		resetButton = new JButton("Reset");
		resetButton.setFocusable(false);
		resetButton.setBounds(100 + xMargin, 50 + yMargin, 100, 50);
		resetButton.setFont(font);
		resetButton.addActionListener(this::reset);
		frame.add(resetButton);
		
		timer = new Timer(TIMER_DELAY, this);
		
		frame.setVisible(true);
	}
	
	/**
	 * This method is called, when the stopwatch should be started or stopped, i.e when the startStopButton is pressed.
	 * @param e is only for compatibility with ActionListener
	 */
	public void stop(ActionEvent e) {
		if (running) {	
			startStopButton.setText("Start");
			timer.stop();
		}
		else {
			startStopButton.setText("Stop");
			timer.start();
		}
		running = !running;
	}
	
	/**
	 * This method is called, when the stopwatch should be reset, i.e when the resetButton is pressed.
	 * @param e is only for compatibility with ActionListener
	 */
	public void reset(ActionEvent e) {
		timer.stop();
		timeLabel.setText("00:00:00:00");
		elapsedTimeMillis = 0; 
		running = false;
		startStopButton.setText("Start");
	}
	
	/**
	 * This method updates elapsed time.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//this is method is called every TIMER_DELAY milliseconds, so elapsed time can be calculated like this
		elapsedTimeMillis += TIMER_DELAY;
		
		//converting total milliseconds to hours, minutes, seconds
		int hours = (int)(elapsedTimeMillis / 3600000);
		int minutes = (int)((elapsedTimeMillis / 60000) % 60);
		int seconds = (int)((elapsedTimeMillis / 1000) % 60);
		int milliseconds = (int)(elapsedTimeMillis % 1000)/10;

		//displaying elapsed time
		timeLabel.setText(String.format("%02d:%02d:%02d:%02d", hours, minutes, seconds, milliseconds));
	}
}
