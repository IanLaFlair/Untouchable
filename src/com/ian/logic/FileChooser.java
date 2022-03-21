package com.ian.logic;

import javax.swing.*;
import java.io.File;

public class FileChooser extends JFileChooser
{
	private static final long serialVersionUID = 1L;
		
	@Override
	public void approveSelection()
	{
		File f = getSelectedFile();
		if(f.exists() && getDialogType() == SAVE_DIALOG)
		{
			int result = JOptionPane.showConfirmDialog(null, "The file exists, overwrite?","⚠", JOptionPane.YES_NO_CANCEL_OPTION);
			switch(result)
			{
			case JOptionPane.YES_OPTION:
				super.approveSelection();
				return;
			case JOptionPane.NO_OPTION:
				return;
			case JOptionPane.CLOSED_OPTION:
				return;
			case JOptionPane.CANCEL_OPTION:
				cancelSelection();
				return;
			}
		}
		super.approveSelection();
	}        
}