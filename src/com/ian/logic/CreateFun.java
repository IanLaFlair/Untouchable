package com.ian.logic;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class CreateFun
{
	public static void CreateDB(String name, String pw) throws Exception
	{
		File db = new File(name + ".ench");
		
		FileChooser fc = new FileChooser();
		FileTypeFilter filter = new FileTypeFilter(".ench", "Untouchable database");
		fc.addChoosableFileFilter(filter);
		fc.setFileFilter(filter);
		fc.setSelectedFile(db);
		fc.setDialogTitle("Save file");
		
		if(fc.showSaveDialog(fc) == JFileChooser.APPROVE_OPTION)
		{
			byte[] hashedpw = HashFun.Hash(pw);
			OutputStream out = new FileOutputStream(fc.getSelectedFile());
			out.write(hashedpw);
			out.flush();
			out.close();
			
			JOptionPane.showConfirmDialog(null, "Database created", "🔑", JOptionPane.PLAIN_MESSAGE);
			
			System.out.println("\tName: "+ name + "\n\tPassword: " + pw);
			System.out.println("Database created");
			
			LoadFun.LoadDB(fc.getSelectedFile(), hashedpw, pw);
		}
		else
		{
			System.out.println("Create failed, operation cancelled");
		}
	}
}
