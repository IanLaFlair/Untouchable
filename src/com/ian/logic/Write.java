package com.ian.logic;

import com.ian.gui.EditPanel;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Write
{
	public static void WriteFile(File db) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
	{
		
		
        EditPanel.pb.setValue(0);
        EditPanel.pb.setMinimum(0);
        EditPanel.pb.setMaximum(EditPanel.t.getRowCount()*EditPanel.t.getColumnCount());
        
        OutputStream out = new FileOutputStream(db);
		out.write(HashFun.Hash(LoadFun.password));
		out.flush();
		out.close();
		
		FileWriter fw = new FileWriter(db, true);
	    PrintWriter pw = new PrintWriter(fw);
	    
	    pw.print("\n\n");
	    
	    if(EditPanel.t.getRowCount() == 0)
	    {
	    	EditPanel.pb.setMaximum(1);
            EditPanel.pb.setValue(1);
	    }
	    
        for (int row = 0; row < EditPanel.t.getRowCount(); row++)
        {
            for (int col = 0; col < EditPanel.t.getColumnCount(); col++)
            {
                pw.print(EditPanel.t.getValueAt(row, col));
                if(col != EditPanel.t.getColumnCount()-1)
                {
                	pw.print('\t');                	
                }
                EditPanel.pb.setValue(EditPanel.pb.getValue() + 1);
            }
            if(row != EditPanel.t.getRowCount()-1)
            {
            	pw.print('\n');
            }
            
            EditPanel.pb.setValue(EditPanel.pb.getValue() + 1);
        }
		pw.close();
	}
}
