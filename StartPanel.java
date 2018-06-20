import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
class StartPanel extends JPanel
{
private JLabel imageLabel1;
private JLabel imageLabel2;
private JSeparator seperator;
StartPanel()
{
imageLabel1 = new JLabel();
imageLabel2 = new JLabel();
imageLabel1.setIcon(new ImageIcon(getClass().getResource("/Resources/img2.jpg")));
imageLabel2.setIcon(new ImageIcon(getClass().getResource("/Resources/img5.PNG")));
//set seperator
seperator = new JSeparator();
seperator.setOrientation(SwingConstants.VERTICAL);

 //set start panel layout
 GroupLayout thisLayout = new GroupLayout(this);
        this.setLayout(thisLayout);
        thisLayout.setHorizontalGroup(
            thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(thisLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(seperator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(thisLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(imageLabel1))
                    .addGroup(thisLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(imageLabel2, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        thisLayout.setVerticalGroup(
            thisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(seperator, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
            .addGroup(thisLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imageLabel1)
                .addGap(18, 18, 18)
                .addComponent(imageLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

    }
}