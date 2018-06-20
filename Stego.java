/**
 *
 * @author Apoorva
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Stego extends JFrame implements ActionListener
{
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Stego().setVisible(true);
            }
        });
    }
    
    private JButton aboutButton;
    private StartPanel startPanel;
    private HidePanel hidePanel;
    private UnhidePanel unhidePanel;
    private JButton exitButton;
    private JButton helpButton;
    private JButton hideButton;
    private JPanel optionPanel;
    private JButton unhideButton;
    // End of variables declaration
    
    /** Constructor */
    public Stego() {
        initComponents();
    }

    private void initComponents() 
    {

        optionPanel = new JPanel();
        hideButton = new JButton();
        unhideButton = new JButton();
        helpButton = new JButton();
        aboutButton = new JButton();
        exitButton = new JButton();
        startPanel = new StartPanel();
        hidePanel = new HidePanel();
        unhidePanel = new UnhidePanel();
        
        hidePanel();
        hidePanel.setVisible(false);
        unhidePanel(); 
        unhidePanel.setVisible(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("StegoSecret");
        setResizable(false);

        hideButton.setText("Hide");
        hideButton.addActionListener(this);
            

        unhideButton.setText("Unhide");
        unhideButton.addActionListener(this);
         
        helpButton.setText("Help");
        helpButton.addActionListener(this);

        aboutButton.setText("About");
        aboutButton.addActionListener(this);

        exitButton.setText("Exit");
        exitButton.addActionListener(this);

        //set optionPanel layout
        GroupLayout optionPanelLayout = new GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(optionPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(exitButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(aboutButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(helpButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(hideButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(unhideButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addContainerGap(61, GroupLayout.PREFERRED_SIZE))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(hideButton)
                .addGap(26, 26, 26)
                .addComponent(unhideButton)
                .addGap(28, 28, 28)
                .addComponent(helpButton)
                .addGap(28, 28, 28)
                .addComponent(aboutButton)
                .addGap(31, 31, 31)
                .addComponent(exitButton)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        //set panels background
        startPanel.setBackground(UIManager.getDefaults().getColor("window"));
        hidePanel.setBackground(UIManager.getDefaults().getColor("window"));
        unhidePanel.setBackground(UIManager.getDefaults().getColor("window"));

       
        // set frame layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(optionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(optionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(startPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==hideButton)
        {
             startPanel.setVisible(false);
             unhidePanel.setVisible(false);
             unhidePanel.reset();
             hidePanel.setVisible(true);
             hidePanel.reset();
        }
        else if(ae.getSource()==unhideButton)
        {
            startPanel.setVisible(false);
            hidePanel.setVisible(false);
            hidePanel.reset();
            unhidePanel.setVisible(true);
            unhidePanel.reset();
        }
        else if(ae.getSource()==helpButton)
        {
            help();
        }
        else if(ae.getSource()==aboutButton)
        {
           JOptionPane.showMessageDialog(this,"about","About",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));
        }
        else if(ae.getSource()==exitButton)
            System.exit(0);
        }
    
   private void hidePanel()
    {
       // set layout
       hidePanel.reset();
       GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(optionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(520, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(hidePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(optionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(hidePanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void unhidePanel()
    {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(optionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(520, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(unhidePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(optionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(unhidePanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    private void help()
    {
        JFrame help=new JFrame("Help");
        JPanel jPanel1 = new javax.swing.JPanel();
        JButton hideHelpButton = new javax.swing.JButton();
        JButton unhideHelpButton = new javax.swing.JButton();

        help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        help.setForeground(java.awt.Color.white);
        help.setResizable(false);

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("window"));

        final JFrame ob=this;
        hideHelpButton.setText("How to hide a message");
        hideHelpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              JOptionPane.showMessageDialog(ob,"1.Select a carrier file\n2.Write the secret message in the area provided\n3.Provide a password for more security\n4.Click Hide \n5.Congratulations! You successfully hided your message","Help",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));  
            }
        });
        
        unhideHelpButton.setText("how to unhide message");
        unhideHelpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              JOptionPane.showMessageDialog(ob,"1.Specify a carrier file\n2.Provide the correct password\n3.Click Unhide \n4.Congratulations! You successfully unhided your message. You can view it in the message area","Help",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));  
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(unhideHelpButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hideHelpButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(hideHelpButton)
                .addGap(18, 18, 18)
                .addComponent(unhideHelpButton)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(help.getContentPane());
        help.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        help.pack();
        help.setVisible(true);
    }
 }
