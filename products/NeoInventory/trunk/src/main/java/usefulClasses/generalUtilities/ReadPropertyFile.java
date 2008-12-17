

package usefulClasses.generalUtilities;

import controller.*;

import java.awt.*;
import java.util.*;

/**
 *
 * @author  Administrator 
 */
public class ReadPropertyFile {
    /** Creates a new instance of ReadPropertyFile */
    public ReadPropertyFile(String fileName) {
        
        propertyFile = ResourceBundle.getBundle(fileName);  
    }
    
    public ReadPropertyFile(String fileName,Locale locale) {
        
        propertyFile = ResourceBundle.getBundle(fileName,locale);    
        
    }    
    
    ResourceBundle propertyFile;
    
    public static String getVal(String fileName,Locale locale,String key){
        
        ResourceBundle propertyFile = ResourceBundle.getBundle(fileName,locale);    

        
        return propertyFile.getString(key);
    }
    
    public static String getVal(String fileName,String key){
        
        ResourceBundle propertyFile = ResourceBundle.getBundle(fileName);    

        return propertyFile.getString(key);
    }    
    
    
    public String getVal(String key){

        return propertyFile.getString(key);
    }
    

    
    
}
