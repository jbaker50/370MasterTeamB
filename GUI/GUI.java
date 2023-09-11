import java.awt.*;
import javax.swing.*;

public class GUI extends JPanel 
{
    private JButton newGame = new JButton("New Game", null);


    //set the basics of the window
    public static void main(String[] args) 
    {
        JFrame window = new JFrame("Checkers");
        GUI content = new GUI();
        window.setContentPane(content);
        window.pack();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( (screensize.width - window.getWidth())/2, (screensize.height - window.getHeight())/2 );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setResizable(false);  
        window.setVisible(true);
    }
    
    public GUI() 
    {
        setLayout(null);
        setPreferredSize( new Dimension(550,450) );

        setBackground(Color.yellow); 

        Board board = new Board();  
        add(board);
        add(newGame);

        board.setBounds(115,65,320,320); 
        newGame.setBounds(230,400,120,30);
    } 

    private class Board extends JPanel //implements ActionListener, MouseListener 
    {
        Board() 
        {
            setBackground(Color.BLACK);
        }

        // this section sets the squares for the checkers board
        public void paintComponent(Graphics g)
        {
            
            Graphics2D g2 = (Graphics2D)g;

            g.setColor(Color.black);
            // sets size of the squares
            g.drawRect(0,0,getSize().width-1,getSize().height-1);
            g.drawRect(1,1,getSize().width-3,getSize().height-3);

            // for the 8 rows and within thatthe 8 columns,
            // if the row is divisible by 2, set the color light gray, if not set it gray.
            for (int row = 0; row < 8; row++) 
            {
                for (int col = 0; col < 8; col++) 
                {
                    if ( row % 2 == col % 2 )
                        g.setColor(Color.LIGHT_GRAY);
                    else
                        g.setColor(Color.GRAY);
                    g.fillRect(2 + col*40, 2 + row*40, 40, 40);
                }
            }
        }
    }
}