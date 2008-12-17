/*
 * FillDate.java
 *
 * Created on January 13, 2003, 5:36 PM
 */

package usefulClasses.generalUtilities;

/**
 *
 * @author  Administrator
 */
public class FillDate {

    /** Creates a new instance of Date */
    public FillDate() {
    }

    public static void fillDaysInCombo(javax.swing.JComboBox cbName) {
        
        for(int i=1;i<=31;i++){//DDMM for loop
            if(i<10)
                cbName.addItem("0"+i);
            
            else
                cbName.addItem(""+i);
        }//end DDMM for loop
        
    }
    
    public static void fillMonthsInCombo(javax.swing.JComboBox cbName) {
        
        for(int i=1;i<=12;i++){//DDMM for loop
            if(i<10)
                cbName.addItem("0"+i);
            
            else
                cbName.addItem(""+i);
            
        }//end DDMM for loop
        
    }
    
    public static void fillYearsInCombo(javax.swing.JComboBox cbName) {
        
        for(int i=1950;i<=2100;i++)
            cbName.addItem(""+i);
    }
    
}//end class Date
