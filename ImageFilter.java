<<<<<<< HEAD
import java.io.*;
class ImageFilter extends javax.swing.filechooser.FileFilter
{
   public String getDescription()
   {
       return "Just Images";
    }
   
   public boolean accept(File f) {
    if (f.isDirectory()) {
	return true;
    }

    String extension = getExtension(f);
    if (extension != null) 
    {
	  if (extension.equals("gif") || extension.equals("jpeg") ||
	    extension.equals("jpg") ||
	    extension.equals("png")) 
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
String getExtension(File f)
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
=======
import java.io.*;
class ImageFilter extends javax.swing.filechooser.FileFilter
{
   public String getDescription()
   {
       return "Just Images";
    }
   
   public boolean accept(File f) {
    if (f.isDirectory()) {
	return true;
    }

    String extension = getExtension(f);
    if (extension != null) 
    {
	  if (extension.equals("gif") || extension.equals("jpeg") ||
	    extension.equals("jpg") ||
	    extension.equals("png")) 
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
String getExtension(File f)
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
>>>>>>> 1864ca7e4c28bed3c9b3029dbb362a3221f133de
}