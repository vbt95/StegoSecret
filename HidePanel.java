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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.io.File;
class HidePanel extends JPanel implements ActionListener
{
private JLabel carrierLabel;
private JTextField fileName;
private JButton hide;
private JScrollPane jScrollPane1;
private JTextArea messageArea;
private JLabel messageLabel;
private JPasswordField passwordField;
private JLabel passwordLabel;
private JButton previewButton;
private JPasswordField repasswordField;
private JLabel repasswordLabel;
private JButton browseButton;
private JSeparator seperator;
private JFileChooser fileChooser;
private File file;
private int browseValue=-1;
HidePanel()
{

carrierLabel = new JLabel();
browseButton = new JButton();
fileName = new JTextField();
previewButton = new JButton();
messageLabel = new JLabel();
jScrollPane1 = new JScrollPane();
messageArea = new JTextArea();
passwordField = new JPasswordField();
repasswordField = new JPasswordField();
passwordLabel = new JLabel();
repasswordLabel = new JLabel();
hide = new JButton();
seperator = new JSeparator();
fileChooser = new JFileChooser();

fileChooser.addChoosableFileFilter(new ImageFilter());

seperator.setOrientation(SwingConstants.VERTICAL);

carrierLabel.setText("Select a carrier file");

browseButton.setText("Browse");
browseButton.addActionListener(this);

fileName.setEditable(false);
fileName.setText("NO Carrier File");

previewButton.setText("Preview");
previewButton.setEnabled(false);
previewButton.addActionListener(this);

messageLabel.setText("Add a message");

messageArea.setColumns(20);
messageArea.setRows(5);
messageArea.setBorder(new javax.swing.border.MatteBorder(null));
        
jScrollPane1.setViewportView(messageArea);

passwordLabel.setText("Password");

repasswordLabel.setText("Enter password again");

hide.setIcon(new ImageIcon(getClass().getResource("/Resources/img3.jpg")));
hide.setText("         Hide");
hide.setHorizontalAlignment(SwingConstants.LEFT);
hide.addActionListener(this);

//set layout
GroupLayout thisLayout = new GroupLayout(this);
this.setLayout(thisLayout);
thisLayout.setHorizontalGroup(
thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(thisLayout.createSequentialGroup()
    .addGap(10, 10, 10)
    .addComponent(seperator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    .addGap(92, 92, 92)
    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addComponent(messageLabel)
    .addGroup(thisLayout.createSequentialGroup()
    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
    .addComponent(carrierLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
    .addGap(47, 47, 47)
    .addComponent(browseButton))
    .addComponent(fileName, GroupLayout.Alignment.LEADING))
    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
    .addComponent(previewButton))
    .addGroup(thisLayout.createSequentialGroup()
    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addComponent(passwordLabel)
    .addComponent(repasswordLabel))
    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addComponent(hide, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
    .addGroup(GroupLayout.Alignment.TRAILING, thisLayout.createSequentialGroup()
    .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
    .addComponent(repasswordField)
    .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
    .addGap(52, 52, 52)))))
    .addGap(78, 78, 78)))
    .addContainerGap())
     );
    thisLayout.setVerticalGroup(
            thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(seperator, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
            .addGroup(thisLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(carrierLabel)
                    .addComponent(browseButton))
                .addGap(18, 18, 18)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(previewButton))
                .addGap(26, 26, 26)
                .addComponent(messageLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(32, 32, 32)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(repasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(repasswordLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(hide, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==browseButton)
        {
            browseValue=fileChooser.showDialog(this,"Select");
            if(browseValue==JFileChooser.APPROVE_OPTION)
            {
                file=fileChooser.getSelectedFile();
                previewButton.setEnabled(true);
                fileName.setText(file.getName());
            }
        }
        else if(ae.getSource()==previewButton)
        {
            new ImagePreviewWindow(file);
        }
        else if(ae.getSource()==hide)
        {
            if(browseValue==JFileChooser.APPROVE_OPTION)
            {
                if(getPass().equals(getRepass()))
                {
                    if(getPass().length()<=8)
                       {
                        if(new Steganography().encode(getPath(file),getName(file),getExtension(file),"new"+getName(file),getPass().length()+getPass()+messageArea.getText()))
                           JOptionPane.showMessageDialog(this,"Message has been hided succesfully","",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));
                       }
                     else
                      JOptionPane.showMessageDialog(this,"Password should be less than or equal to 8 characters","Error",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Password does not matches","Error",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));
            
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"No file selected","Error",1,(new ImageIcon(getClass().getResource("/Resources/img6.jpg"))));
            }
        }
            
    }
    public void reset()
    {
        browseValue=-1;
        previewButton.setEnabled(false);
        fileName.setText("");
        passwordField.setText("");
        messageArea.setText("");
    }
    private String getPath(File f)
    {
        String path=f.getPath();
        int index=path.lastIndexOf("\\");
        path=path.substring(0,index);
        return path;
    }
    private String getName(File f)
    {
        String name=f.getName();
        int index=name.lastIndexOf(".");
        name=name.substring(0,index);
        return name;
    }
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
    private String getPass()
    {
        char p[]=passwordField.getPassword();
        return new String(p);
    }
    private String getRepass()
    {
        char rep[]=repasswordField.getPassword();
        return new String(rep);
    }
}
