package com.ian.logic;

import com.ian.gui.EditPanel;

import java.io.File;

public class LoadFun
{
	public static File database;
	public static String password;
	
	public static boolean LoadDB(File db, byte[] hashedpw, String pw) throws Exception
	{
		if(HashFun.encoder(hashedpw).equals(HashFun.encoder(HashFun.Hash(pw))))
		{
			password = pw;
			buildEditMode(db);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void buildEditMode(File db) throws Exception
	{
		EditPanel.buildPanel();
		EditPanel.l.setText("Database name: " + db.getName());
		Read.ReadFile(db);
		database = db;
		
		try
		{
			File ioFile = LoadFun.database;
			String key = "cipher.enchantre";
			
			Write.WriteFile(ioFile);
			Crypt.encrypt(key, ioFile, ioFile);
			EditPanel.t.clearSelection();
			EditPanel.pb.setValue(0);
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
}