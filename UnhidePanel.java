/**
 * Class for unhide panel
 */
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
class UnhidePanel extends JPanel implements ActionListener
{
//declaration of variables
private JButton browseButton2;
private JLabel carrierLabel2;
private JTextField fileName2;
private JScrollPane jScrollPane12;
private JTextArea messageArea2;
private JLabel messageLabel2;
private JPasswordField passwordField2;
private JLabel passwordLabel2;
private JButton previewButton2;
private JSeparator seperator;
private JButton unhide;

private JFileChooser fileChooser;
private File file;

private int browseValue=-1;
private String message;

/** Constructor to set up the panel
 *  Initializes various variables and sets up layout
 * 
 */
UnhidePanel()
{
        seperator = new JSeparator();
        carrierLabel2 = new JLabel();
        browseButton2 = new JButton();
        fileName2 = new JTextField();
        previewButton2 = new JButton();
        messageLabel2 = new JLabel();
        jScrollPane12 = new JScrollPane();
        messageArea2 = new JTextArea();
        passwordField2 = new JPasswordField();
        passwordLabel2 = new JLabel();
        unhide = new JButton();
        fileChooser = new JFileChooser();

        fileChooser.addChoosableFileFilter(new ImageFilter());

        seperator.setOrientation(SwingConstants.VERTICAL);

        carrierLabel2.setText("Specify a carrier file");

        browseButton2.setText("Browse");
        browseButton2.addActionListener(this);

        fileName2.setEditable(false);
        fileName2.setText("NO Carrier File");

        previewButton2.setText("Preview");
        previewButton2.setEnabled(false);
        previewButton2.addActionListener(this);

        messageLabel2.setText("Message");

        messageArea2.setColumns(20);
        messageArea2.setEditable(false);
        messageArea2.setRows(5);
        messageArea2.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane12.setViewportView(messageArea2);

        passwordLabel2.setText("Password");

        unhide.setIcon(new ImageIcon(getClass().getResource("/Resources/img1.png"))); // NOI18N
        unhide.setText("      Unhide");
        unhide.setHorizontalAlignment(SwingConstants.LEFT);
        unhide.addActionListener(this);
        
        // created with the help of Netbeans
        GroupLayout thisLayout = new GroupLayout(this);
        this.setLayout(thisLayout);
        thisLayout.setHorizontalGroup(
            thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(thisLayout.createSequentialGroup()
                .addComponent(seperator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(thisLayout.createSequentialGroup()
                        .addComponent(messageLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
                    .addComponent(fileName2, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addGroup(thisLayout.createSequentialGroup()
                        .addComponent(passwordLabel2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(unhide, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(carrierLabel2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(previewButton2)
                    .addComponent(browseButton2))
                .addGap(25, 25, 25))
        );
        thisLayout.setVerticalGroup(
            thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(thisLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(carrierLabel2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(previewButton2)
                    .addComponent(fileName2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(unhide, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(thisLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(messageLabel2)
                        .addGap(149, 149, 149))
                    .addGroup(thisLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane12, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(GroupLayout.Alignment.TRAILING, thisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seperator, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
        );
}
/**
 * Action listener for buttons
 */
public void actionPerformed(ActionEvent ae)
{
        // if the source is browse button  
    if(ae.getSource()==browseButton2)
    {
        browseValue=fileChooser.showDialog(this,"Select");
        if(browseValue==JFileChooser.APPROVE_OPTION)// if file is choosen successfully
        {
                file=fileChooser.getSelectedFile();
                previewButton2.setEnabled(true);
                fileName2.setText(file.getName());
        }
    }
    else if(ae.getSource()==previewButton2)
    {
                new ImagePreviewWindow(file);// setup preview of image
    }
    else if(ae.getSource()==unhide)
    {
        if(browseValue==JFileChooser.APPROVE_OPTION)// if file is choosen successfully
        {
                message=new Steganography().decode(getPath(file),getName(file));
                // if password entered is correct
                if(getPass().equals(getPassWord(message)))
                {
                    if(getPass().length()<=8)// as there is a limit on password length
                    {
                        JOptionPane.showMessageDialog(this,"Message has been decoded succesfully","",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));
                        messageArea2.setText(getMessage(message));
                    }
                    else
                        JOptionPane.showMessageDialog(this,"Password should be less than or equal to 8 characters","Error",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));
               }
               else
               {    // incorrect password
                    JOptionPane.showMessageDialog(this,"Password does not matches","Error",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));
            
                }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"No file selected","Error",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));
        }
    
    }
}
/**
 * To reset all the fields of unhide panel
 */
public void reset()
{
    browseValue=-1;
    previewButton2.setEnabled(false);
    fileName2.setText("");
    passwordField2.setText("");
    messageArea2.setText("");
}
/**Returns the path of file
 * @param f the file who path is required
 * 
 */
private String getPath(File f)
{
    String path=f.getPath();
    int index=path.lastIndexOf("\\");
    path=path.substring(0,index);
    return path;
}
/**Returns the name of file without it's extension or type
 * @param f the file which name we needs
 * 
 * example: return scenery if the file actual name is scenery.jpg 
 */
private String getName(File f)
{
    String name=f.getName();
    int index=name.lastIndexOf(".");
    name=name.substring(0,index);
    return name;
}
/**Returns the extension of  file
 * @param f the file whose extension is required
 */
private String getExtension(File f)
{
    String ext = null;
    String s = f.getName();
    int i = s.lastIndexOf('.');
    if (i > 0 &&  i < s.length() - 1) 
    {
        ext = s.substring(i+1).toLowerCase();
    }
    return ext;
}
/**
 * Returns the password entered in provided password field
 * private type so that no one get access it from outside
 */
private String getPass()
{
    char p[]=passwordField2.getPassword();
    return new String(p);
}
/**
 * Returns the actual message from the text extracted earlier from file
 * @param m the text extracted from file using steganography
 * private type so that no one get access it from outside
 */
private String getMessage(String m)
{
     String l=m.substring(0,1);// first char provides the length of password
     int length=Integer.parseInt(l);// next length characters will be password
     return m.substring(0+length+1);// skip password and the rest is message
}
/**
 * Returns the password present in the text extracted earlier from file
 * @param m the text extracted from file using steganography
 * private type so that no one get access it from outside
 */
private String getPassWord(String m)
{
       String l=m.substring(0,1);// first char provides the length of password
       int length=Integer.parseInt(l);// next length characters will be password
       return m.substring(1,(0+length+1));// the password is those many characters
}
}