/*
 * ComboMnpl.java
 *
 * Created on January 14, 2003, 12:35 PM
 */

package usefulClasses.generalUtilities;

/**
 *
 * @author  Administrator
 */

public class ComboMnpl {

    /** Creates a new instance of ComboMnpl */
    public ComboMnpl() {
    }

    public static void removeComboElements(javax.swing.JComboBox combo,String firstEle) {
        
       removeAllComboElements(combo);
       combo.addItem(firstEle);    
        
    }//end remove

public static void removeAllComboElements(javax.swing.JComboBox combo){
    
        int count = combo.getItemCount();
        try{
        if(count >=0)
            for(int i=0;i<count;i++)
                combo.removeItemAt(0);

           
        }//end try
        catch(Exception e){
            System.out.println("ERROR IN removeComboElements() METHD. OF ComboMnpl CLASS\n"+e);
        }
    
}//end methd.

}//end class
