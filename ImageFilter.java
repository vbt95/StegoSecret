import java.io.*;
class ImageFilter extends javax.swing.filechooser.FileFilter
{
/** The description of this filter.
 * 
 */
public String getDescription()
{
    return "Just Images";
}
/** Whether the given file is accepted by this filter.
 *  Returns true if yes otherwise false
 *  @param f the file to be checked
 */   
public boolean accept(File f)
{
    if (f.isDirectory()) 
    {
    return true;
    }

    String extension = getExtension(f);
    if (extension != null) 
    {
        if (extension.equals("gif") || extension.equals("jpeg") ||
        extension.equals("jpg") || extension.equals("png")) 
        {
                return true;
        } 
        else 
        {
            return false;
        }
    }
    return false;
}

/**Returns the extension of file
 * @param f the file whose extension is required
 */
String getExtension(File f)
{
     String ext = null;
     String s = f.getName();
     // extension begins after .
     int i = s.lastIndexOf('.');
     if (i > 0 &&  i < s.length() - 1) // if . is present in name
     {
       ext = s.substring(i+1).toLowerCase();
     }
     return ext;
}
}