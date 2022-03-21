package com.ian.logic;

import com.ian.gui.EditPanel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Read
{
	public static void ReadFile(File db) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(db));
        Object[] tableLines = br.lines().toArray();
		
        if(tableLines.length > 2)
        {        	
        	EditPanel.pb.setMinimum(0);
        	EditPanel.pb.setMaximum(tableLines.length-2);
        	EditPanel.pb.setValue(0);
        	
        	for(int i = 0; i < tableLines.length-2; i++)
        	{
        		String line = tableLines[i+2].toString().trim();
        		String[] dataRow = line.split("\t");
        		EditPanel.tModel.addRow(dataRow);
        	}
        	br.close();
        }
	}
}