/*
 * MonthRollPageSettingsController.java
 *
 * Created on 11 May 2004, 20:26
 */

package controller;

/**
 *
 * @author  paawak
 */
import java.text.DecimalFormat;

import  model.*;
import model.database.*;
import view.*;
import utils.general.*;

public class SettingsController implements TableListDB, ConstantsDB{
    
    /** holds the max. no. of lines in a single page in the Invoice file
     *
     */
    private int maxLines = 46;
    
    /** holds the no. of spaces to be used in tab
     *
     */
    private int tabSize = 10;
    
    /** holds the tax percentage
     *
     */
    private float taxPercent = 2;
    
    /** holds the amount, exceeding which tds is charged
     *
     */
    private float tdsApplyAmt = 10000;
    
    /** holds the tds percentage
     *
     */
    private float tdsPercent = 0;
    
    private Database constDB = new Database(constants);
    
    private DecimalFormat fm2 =  new DecimalFormat("0.00");
    
    private DecimalFormat fm0 =  new DecimalFormat("0");
    
    /** Creates a new instance of MonthRollPageSettingsController */
    public SettingsController() {
        setConstants();
    }
    
    /** sets tdspercent, tax, etc
     *
     */
    private void setConstants() {        
        try{
            taxPercent = Float.parseFloat(constDB.queryOneElement(value,"WHERE "+ConstantsDB.name+"='TaxPercent'").toString());
            tdsPercent = Float.parseFloat(constDB.queryOneElement(value,"WHERE "+ConstantsDB.name+"='TDSPercent'").toString());
            tdsApplyAmt = Float.parseFloat(constDB.queryOneElement(value,"WHERE "+ConstantsDB.name+"='TDSApplyAmt'").toString());
            tabSize = Integer.parseInt(constDB.queryOneElement(value,"WHERE "+ConstantsDB.name+"='TabSize'").toString());
            maxLines = Integer.parseInt(constDB.queryOneElement(value,"WHERE "+ConstantsDB.name+"='MaxLines'").toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public String getCols(){
        return fm0.format(tabSize);
    }
    
    public String getLines(){
        return fm0.format(maxLines);
    }    
    
    public String getTaxPercent(){
        return  fm2.format(taxPercent);
    }
    
    public String getTDSPercent(){
        return  fm2.format(tdsPercent);
    }
    
    public String getTDSApplyAmt(){
        return  fm2.format(tdsApplyAmt);
    }    
    
    public boolean updatePageSettings(Object[] obj){
        if(obj.length!=2)
            return false;
        try{
            String where = "WHERE "+ConstantsDB.name+"='TabSize'";
            boolean fl1 = constDB.updateData(new String[]{ConstantsDB.value},new Object[]{obj[0]},where);
            where = "WHERE "+ConstantsDB.name+"='MaxLines'";
            boolean fl2 = constDB.updateData(new String[]{ConstantsDB.value},new Object[]{obj[1]},where);
            return fl1&fl2;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public boolean updateTDSTaxSettings(Object[] obj){
        if(obj.length!=3)
            return false;
        try{
            String where = "WHERE "+ConstantsDB.name+"='TDSPercent'";
            boolean fl1 = constDB.updateData(new String[]{ConstantsDB.value},new Object[]{obj[0]},where);
            where = "WHERE "+ConstantsDB.name+"='TDSApplyAmt'";
            boolean fl2 = constDB.updateData(new String[]{ConstantsDB.value},new Object[]{obj[1]},where);
            where = "WHERE "+ConstantsDB.name+"='TaxPercent'";
            boolean fl3 = constDB.updateData(new String[]{ConstantsDB.value},new Object[]{obj[2]},where);            
            return fl1&fl2&fl3;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }    
    
}
