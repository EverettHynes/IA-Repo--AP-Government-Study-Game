import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.*;
import javax.swing.plaf.TreeUI;

import java.util.Random;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener {
    private BufferedImage back;
    private int key;
    
    private ArrayList<SupremeCourtCase> cases = new ArrayList<>();
    private ArrayList<Facts> facts = new ArrayList<>();
    private ArrayList<Rectangle> buttons = new ArrayList<>();

    private SupremeCourtCase currentCase;

       

    private int time = 0;

    private String screen = "PlayerMenu";
   
    public Game() {
        setFocusable(true);
        requestFocusInWindow();
        new Thread(this).start();
        this.addKeyListener(this);
        this.addMouseListener(this);

        key = -1;
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
        }
    }

    public void screen(Graphics g2d) {
        switch (screen) {
            case "PlayerMenu" -> {
                g2d.clearRect(0, 0, getWidth(), getHeight());

            }

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass's method to ensure proper painting

        if (back == null) {
            back = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        }

        Graphics2D g2d = back.createGraphics();

        screen(g2d);

        g2d.dispose();
        g.drawImage(back, 0, 0, null);
    }

    public void LoadCases() {
    
    }

    public void LoadButtons() {
        for(int i = 0; i < 4; i++) {
            Rectangle button = new Rectangle(100, 100 + (i * 100), 200, 50);
            buttons.add(button);
        }
    }

    public void DrawButtons(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
            for (Rectangle button : buttons) {
                g2d.fill(button);
        }  
    }

     public static ArrayList<SupremeCourtCase> buildCases() {
        ArrayList<SupremeCourtCase> cases = new ArrayList<>();

        cases.add(new SupremeCourtCase(
            "Marbury v. Madison (1803)",
            "Can the Supreme Court declare an act of Congress unconstitutional?",
            "Was Section 13 of the Judiciary Act of 1789 consistent with Article III?",
            "Which branch has the final say on interpreting the Constitution?",
            "Judicial Review / Separation of Powers",
            "Marbury lost, but the Court established judicial review.",
            "Chief Justice Marshall ruled that Section 13 of the Judiciary Act expanded the Court's original jurisdiction beyond what Article III allows. Because it conflicted with the Constitution, it was void. This created judicial review, the power of courts to strike down unconstitutional laws.",
            new ImageIcon("images/marbury.jpg")));

        cases.add(new SupremeCourtCase(
            "McCulloch v. Maryland (1819)",
            "Does Congress have the power to create a national bank?",
            "Can a state tax a federal institution?",
            "How broadly should the Necessary and Proper Clause be read?",
            "Federal Supremacy / Necessary and Proper Clause",
            "Unanimous for McCulloch: Congress may create the bank and Maryland may not tax it.",
            "The Court held that the Necessary and Proper Clause gives Congress implied powers beyond those listed. Under the Supremacy Clause, states cannot interfere with valid federal actions, and 'the power to tax is the power to destroy.'",
            new ImageIcon("images/mcculloch.jpg")));

        cases.add(new SupremeCourtCase(
            "Schenck v. United States (1919)",
            "Does the First Amendment protect speech opposing the military draft during wartime?",
            "Can the government limit speech that poses a danger to national security?",
            "What test should courts use to decide when speech can be restricted?",
            "First Amendment: Freedom of Speech",
            "Unanimous against Schenck: his conviction under the Espionage Act was upheld.",
            "Justice Holmes created the 'clear and present danger' test. Speech that creates a clear and present danger of bringing about serious harm Congress can prevent is not protected, especially in wartime. Later cases (Brandenburg v. Ohio) narrowed this standard.",
            new ImageIcon("images/schenck.jpg")));

        cases.add(new SupremeCourtCase(
            "Brown v. Board of Education (1954)",
            "Does racial segregation in public schools violate the Equal Protection Clause?",
            "Can 'separate but equal' facilities truly be equal?",
            "How should the Court weigh psychological and social evidence in its decision?",
            "Fourteenth Amendment: Equal Protection Clause",
            "Unanimous: segregation in public schools is unconstitutional.",
            "Chief Justice Warren wrote that separate educational facilities are inherently unequal, harming students' sense of status and development. This overturned Plessy v. Ferguson (1896) in the context of public education and energized the civil rights movement.",
            new ImageIcon("images/brown.jpg")));

        cases.add(new SupremeCourtCase(
            "Baker v. Carr (1962)",
            "Can federal courts hear cases about how states draw legislative districts?",
            "Is legislative malapportionment a 'political question' courts must avoid?",
            "Do unequal districts violate the Equal Protection Clause?",
            "Fourteenth Amendment: Equal Protection / Political Question Doctrine",
            "Ruled for Baker: federal courts can hear redistricting cases.",
            "The Court held that malapportionment claims are justiciable and not political questions. This opened the door to 'one person, one vote' cases like Reynolds v. Sims and Wesberry v. Sanders, and pushed states toward more equal districts.",
            new ImageIcon("images/baker.jpg")));

        cases.add(new SupremeCourtCase(
            "Engel v. Vitale (1962)",
            "Can public schools sponsor a state-written prayer?",
            "Does voluntary participation make school-led prayer constitutional?",
            "How should the government's relationship with religion be limited?",
            "First Amendment: Establishment Clause",
            "Ruled for Engel: school-sponsored prayer is unconstitutional.",
            "The Court held that a government-composed prayer recited in public schools violates the Establishment Clause, even if it is nondenominational and students may opt out. The government may not officially sponsor religious activity.",
            new ImageIcon("images/engel.jpg")));

        cases.add(new SupremeCourtCase(
            "Gideon v. Wainwright (1963)",
            "Must states provide an attorney to defendants who cannot afford one in felony cases?",
            "Does the Sixth Amendment right to counsel apply to the states?",
            "Is a fair trial possible without legal representation?",
            "Sixth Amendment: Right to Counsel / Incorporation",
            "Unanimous for Gideon: states must provide counsel in felony cases.",
            "The Court incorporated the Sixth Amendment right to counsel through the Fourteenth Amendment's Due Process Clause. Fair trials require lawyers, so states must appoint attorneys for poor defendants facing serious charges.",
            new ImageIcon("images/gideon.jpg")));

        cases.add(new SupremeCourtCase(
            "Tinker v. Des Moines (1969)",
            "Do students have free speech rights in public schools?",
            "Is wearing an armband to protest a war a form of protected speech?",
            "When can schools limit student expression?",
            "First Amendment: Freedom of Speech (Symbolic Speech)",
            "Ruled for Tinker, 7-2: the armbands were protected.",
            "The Court held that students do not 'shed their constitutional rights at the schoolhouse gate.' Schools may restrict student speech only if it would substantially disrupt the educational environment, and no such disruption was shown.",
            new ImageIcon("images/tinker.jpg")));
        
        return cases;
        }





    // DO NOT DELETE
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    // DO NOT DELETE
    @Override
    public void keyPressed(KeyEvent e) {

    }

    // DO NOT DELETE
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
